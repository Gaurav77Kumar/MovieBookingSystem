package src.state;

import src.model.Screen;
import src.model.Seat;

public class LockedState implements SeatState{
    public void lock(Seat seat){
        System.out.println("Already locked by someone else");
    }

    public void book(Seat seat){
        System.out.println("Booking confirmed");
        seat.setState(new BookedState());
    }

    public void release(Seat seat){
        System.out.println("Locked released, seat available again");
    }
}
