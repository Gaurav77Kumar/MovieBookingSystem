package src.state;


import src.model.Seat;

class BookedState implements SeatState{
    public void lock(Seat seat){
        System.out.println("Already booked");
    }

    public void book(Seat seat){
        System.out.println("Already booked");
    }

    public void release(Seat seat){
        System.out.println("Cannot release a booked seat");
    }
}








