import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Media> savedMedia; // = new ArrayList<Media>();
    private ArrayList<Media> watchedMedia; // = new ArrayList<Media>();

    public void addSavedMedia(Media media){
        savedMedia.add(0,media);
    }

    public void removeSavedMedia(Media media) {
        savedMedia.remove(media);
    }

    public void addWatchedMedia(Media media){
        watchedMedia.add(0,media);
    }

}
