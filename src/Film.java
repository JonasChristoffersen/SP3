import java.util.ArrayList;

public class Film extends Media implements PlayableMedia{


    public Film(String name, String releaseYear, ArrayList<Genre> genre, double rating) {
        super(name, releaseYear, genre, rating);
    }

    @Override
    public void playMedia(User user, Media media) {
        user.addWatchedMedia(media);
        System.out.println("Now playing: " + media.getName());
    }
}
