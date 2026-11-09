import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Media> savedMedia;
    private ArrayList<Media> watchedMedia;

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
