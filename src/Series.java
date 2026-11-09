import java.util.ArrayList;

public class Series extends Media{

    private ArrayList<Season> seasons;

    public Series(String name, int releaseYear, ArrayList<Genre> genre, double rating, ArrayList<String> seasons) {
        super(name, releaseYear, genre, rating, seasons);
    }
}
