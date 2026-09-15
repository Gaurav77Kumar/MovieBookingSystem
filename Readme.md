# CineBook — Movie Ticket Booking System (Java, Console-Based)

A console-based movie ticket booking platform built in core Java. 
---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Sample Flow](#sample-flow)

---

## Overview

CineBook models the core domain of a movie ticket booking app — browsing shows, selecting seats, locking them during checkout, and paying — using clean object-oriented design. It's console-based and database-free so the focus stays on **class design, concurrency-aware state management, and design patterns**, rather than infrastructure.

## Features

- Movie catalog and screen/seat management, with seats modeled as a static nested class scoped to their screen
- Generic `Repository<T>` for storing and querying `Movie`, `Screen`, and `Show` objects without duplicating CRUD logic per type
- Shows sortable by start time (`Comparable`) or by price (`Comparator`)
- Flexible `Booking` construction via the Builder pattern — snacks, discount codes, and other optional details never force a bloated constructor
- Seat lifecycle (`AVAILABLE → LOCKED → BOOKED`) modeled with the **State pattern**, so each state governs its own valid actions
- Thread-safe seat locking via `synchronized`, preventing two users from booking the same seat simultaneously
- Automatic seat release on payment failure, avoiding seats getting stuck permanently locked
- Domain-specific custom exception (`BookingFailedException`) for precise error handling

## Architecture

```
                 ┌───────────┐        has        ┌───────────────┐
                 │   Movie   │◄──────────────────►│     Show      │
                 │(immutable)│                    │ (Comparable)  │
                 └───────────┘                    └───────┬───────┘
                                                            │ has-a
                 ┌───────────┐        has                  ▼
                 │  Screen   │◄──────────────────────has-a─┘
                 └─────┬─────┘
                       │ contains (static nested class)
                       ▼
                ┌─────────────┐        delegates to        ┌───────────────┐
                │ Seat        │────────────────────────────►│   SeatState   │ (interface)
                └─────────────┘                             └───────┬────────┘
                                                    ┌─────────────────┼─────────────────┐
                                              ┌──────▼──────┐  ┌──────▼──────┐   ┌───────▼──────┐
                                              │AvailableState│  │ LockedState │   │ BookedState  │
                                              └─────────────┘  └─────────────┘   └──────────────┘

       ┌────────────────────┐        builds via        ┌────────────────┐
       │ Booking.Builder    │──────────────────────────►│    Booking     │
       └────────────────────┘                            └───────┬────────┘
                                                                    │ has-a
                                                                    ▼
                                                            ┌────────────────┐
                                                            │ PaymentMethod  │ (abstract)
                                                            └───────┬────────┘
                                                     ┌───────────────┴───────────────┐
                                               ┌──────▼─────┐                 ┌──────▼─────┐
                                               │ UpiPayment │                 │CardPayment │
                                               └────────────┘                 └────────────┘

                         ┌──────────────────┐
                         │  BookingService   │  orchestrates: lock seats → charge
                         │                   │  payment → confirm/release → build
                         └──────────────────┘
```

## Project Structure

```
src/
├── model/
│   ├── Movie.java
│   ├── Screen.java          (contains static nested Seat class)
│   ├── Show.java
│   ├── Booking.java         (contains static nested BookingBuilder class)
│   └── Customer.java
|   └── Seat.java
├── state/
│   ├── SeatState.java
│   ├── AvailableState.java
│   ├── LockedState.java
│   └── BookedState.java
├── payment/
│   ├── PaymentMethod.java
│   ├── UpiPayment.java
│   └── CardPayment.java
├── repository/
│   └── Repository.java
├── exception/
│   └── BookingFailedException.java
├── service/
│   └── BookingService.java
└── Main.java
```

## How to Run


```
## Sample Flow

Movie movie = new Movie("Inception", 148, "Sci-Fi");
Screen screen = new Screen("Screen 1");

Seat seatA1 = new Seat("A1");
Seat seatA2 = new Seat("A2");

screen.addSeat(seatA1);
screen.addSeat(seatA2);

Show show = new Show(movie,screen, LocalDateTime.now().plusHours(2),250);

Customer customer = new Customer("Gaurav","g@g.com","9999999999","Delhi");

PaymentMethod payment = new UpiPayment();

BookingService service = new BookingService();

Booking booking = service.bookSeats(customer,show, List.of(seatA1, seatA2),  payment);
System.out.println(booking);
```
