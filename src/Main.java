package src;

import src.model.*;
import src.payment.*;
import src.repository.Repository;
import src.service.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(" MOVIE BOOKING SYSTEM STARTED ");

        Movie movie = new Movie("Inception", 148, "Sci-Fi");
        System.out.println("\nMovie Created");
        System.out.println(movie);

        Screen screen = new Screen("Screen 1");

        System.out.println("\nScreen Created");
        System.out.println(screen);

        Seat a1 = new Seat("A1");
        Seat a2 = new Seat("A2");
        Seat a3 = new Seat("A3");

        screen.addSeat(a1);
        screen.addSeat(a2);
        screen.addSeat(a3);

        System.out.println("\nSeats Added");
        System.out.println(screen.getSeats());

        Show show = new Show(movie, screen, LocalDateTime.of(2026,9,20,19,0), 250);

        System.out.println("\nShow Created");
        System.out.println(show);

        Repository<Show> repository = new Repository<>();
        repository.add(show);

        List<Show> shows = new ArrayList<>(repository.getAll());
        Collections.sort(shows);

        System.out.println("\nRepository Test");
        for (Show s : shows) {
            System.out.println(s);
        }

        Customer customer = new Customer("Gaurav", "98765432","8333333");

        System.out.println("\nCustomer Created");
        System.out.println(customer);

        List<Seat> selectedSeats = new ArrayList<>();

        selectedSeats.add(a1);
        selectedSeats.add(a2);

        System.out.println("\nSelected Seats");
        System.out.println(selectedSeats);

        PaymentMethod payment = new UpiPayment();

        System.out.println("\nPayment Method Selected");
        System.out.println(payment.getClass().getSimpleName());

        BookingService bookingService = new BookingService();

        System.out.println("\nBooking Seats...");

        Booking booking = bookingService.bookSeats(customer, show, selectedSeats, payment);

        System.out.println("\nBooking Successful");
        System.out.println(booking);

        System.out.println("\nSeat States");

        for (Seat seat : selectedSeats) {
            System.out.println(seat.getSeatNumber()+ " -> " + seat.getState().getClass().getSimpleName()
            );
        }

    }
}