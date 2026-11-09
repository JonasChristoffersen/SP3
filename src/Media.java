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

    public boolean containsGenre(Genre genre){
        return genres.contains(genre);
    }

}