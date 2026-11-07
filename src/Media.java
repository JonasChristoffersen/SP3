import java.util.ArrayList;

public class Media {
    String name;
    int releaseYear;
    ArrayList<Genre> genre;
    double rating;

    //Film constructor
    public Media(String name, int releaseYear, ArrayList<Genre> genre, double rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }

    //Series constructor
    public Media(String name, int releaseYear, ArrayList<Genre> genre, double rating, ArrayList<String> seasons) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }
}