import java.util.ArrayList;

public class Series extends Media implements PlayableMedia{

    private ArrayList<Season> seasons;

    public Series(String name, String releaseYear, ArrayList<Genre> genre, double rating, ArrayList<Season> seasons) {
        super(name, releaseYear, genre, rating);
        this.seasons = seasons;
    }

    @Override
    public void playMedia(User user, Media media) {
        super.playMedia(user, media);
    }
}
