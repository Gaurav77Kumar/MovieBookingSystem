package src.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private String screenName;
    private static List<Seat> seats = new ArrayList<>();

    public Screen(String screenName) {
        this.screenName = screenName;
    }

    public static void addSeat(Seat seat) {
        seats.add(seat);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "screenName='" + screenName + '\'' +
                ", seats=" + seats +
                '}';
    }
}