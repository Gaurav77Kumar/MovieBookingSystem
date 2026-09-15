package src.model;

final class Movie {
    private final String title;
    private final int duration;
    private final String genre;

    public Movie(String title, int duration, String genre){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle(){
        return title;
    }
    public int getDuration(){
        return duration;
    }
    public String getGenre(){
        return genre;
    }
}
