package src.model;

import java.time.LocalDateTime;

public class Show implements Comparable<Show> {

    private Movie movie;
    private Screen screen;
    private LocalDateTime startTime;
    private double basePrice;

    public Show(Movie movie,
                Screen screen,
                LocalDateTime startTime,
                double basePrice) {

        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.basePrice = basePrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public int compareTo(Show other) {
        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public String toString() {
        return "Show{" +
                "movie=" + movie +
                ", screen=" + screen +
                ", startTime=" + startTime +
                ", basePrice=" + basePrice +
                '}';
    }
}

