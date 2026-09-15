package src.service;

import src.model.Booking;
import src.model.Customer;
import src.model.Seat;
import src.model.Show;
import src.payment.PaymentMethod;
import src.exception.BookingFailedException;

import java.util.List;

public class BookingService {
    public Booking bookSeats(Customer customer,Show show, List<Seat> seats, PaymentMethod method) {
        for (Seat seat : seats) {
            seat.lock();
        }

        double total = show.getBasePrice() * seats.size();

        boolean paid = method.pay(total);

        if (!paid) {

            for (Seat seat : seats) {
                seat.release();
            }

            throw new BookingFailedException(
                    "Payment failed, booking not completed."
            );
        }

        for (Seat seat : seats) {
            seat.book();
        }

        method.printReceipt(total);

        return new Booking.BookingBuilder()
                .customer(customer)
                .show(show)
                .seats(seats)
                .paymentMethod(method)
                .build();
    }
}

