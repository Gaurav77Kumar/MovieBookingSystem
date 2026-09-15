package src.model;

import java.util.ArrayList;
import java.util.List;
import src.payment.PaymentMethod;

public class Booking {

    private final Customer customer;
    private final Show show;
    private final List<Seat> seats;
    private final List<String> snacks;
    private final String discountCode;
    private final PaymentMethod paymentMethod;

    private Booking(BookingBuilder builder) {
        this.customer = builder.customer;
        this.show = builder.show;
        this.seats = builder.seats;
        this.snacks = builder.snacks;
        this.discountCode = builder.discountCode;
        this.paymentMethod = builder.paymentMethod;
    }

    public static class BookingBuilder {

        private Customer customer;
        private Show show;
        private List<Seat> seats = new ArrayList<>();
        private List<String> snacks = new ArrayList<>();
        private String discountCode;
        private PaymentMethod paymentMethod;

        public BookingBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public BookingBuilder show(Show show) {
            this.show = show;
            return this;
        }

        public BookingBuilder seats(List<Seat> seats) {
            this.seats = seats;
            return this;
        }

        public BookingBuilder snacks(List<String> snacks) {
            this.snacks = snacks;
            return this;
        }

        public BookingBuilder discountCode(String discountCode) {
            this.discountCode = discountCode;
            return this;
        }

        public BookingBuilder paymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }

        @Override
        public String toString() {
            return "Booking{" +
                    "customer=" + customer +
                    ", show=" + show +
                    ", seats=" + seats +
                    ", paymentMethod=" + paymentMethod.getClass().getSimpleName() +
                    '}';
        }
    }
}

