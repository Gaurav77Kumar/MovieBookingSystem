package src.state;

import src.model.Seat;

public interface SeatState{
    void lock(Seat seat);
    void book(Seat seat);
    void release(Seat seat);
}






