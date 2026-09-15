package src.model;

import src.state.AvailableState;
import src.state.LockedState;
import src.state.SeatState;


public class Seat {
    private String seatNumber;
    private SeatState state;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.state = new AvailableState();
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatState getState() {
        return state;
    }

    public void setState(SeatState state) {
        this.state = state;
    }

    public synchronized void lock() {
        state.lock(this);
    }

    public synchronized void book() {
        state.book(this);
    }

    public synchronized void release() {
        state.release(this);
    }

    @Override
    public String toString() {
        return seatNumber;
    }
}