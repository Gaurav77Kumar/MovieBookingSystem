package src.state;


import src.model.Seat;

public class AvailableState implements SeatState {
    public void lock(Seat seat){
        System.out.println("Seat locked for 5 minutes.");
        seat.setState(new LockedState());
    }

    public void book(Seat seat){
        System.out.println("Cannot book directly-lock it first");

    }

    public void release(Seat seat){
        System.out.println("Already available, nothing to release");
    }

}



