import java.util.ArrayList;

public abstract class Media {
    private String name;
    private String releaseYear;
    private ArrayList<Genre> genres;
    private double rating;

    //Film constructor
    public Media(String name, String releaseYear, ArrayList<Genre> genre, double rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genres = genre;
        this.rating = rating;
    }

/*    //Series constructor
    public Media(String name, String releaseYear, ArrayList<Genre> genre, double rating, ArrayList<String> seasons) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }*/

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        String year = releaseYear.substring(0,4);
        return Integer.parseInt(year);
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public boolean containsGenre(Genre genre){
        return genres.contains(genre);
    }

/*    @Override
    public void playMedia(User user, Media media) {
        user.addWatchedMedia(media);
        System.out.println("Now playing: " + media.getName());
    }*/

}