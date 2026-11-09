import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Media> savedMedia;
    private ArrayList<Media> watchedMedia;

    public User(String username, String password, ArrayList<Media> savedMedia, ArrayList<Media> watchedMedia) {
        this.username = username;
        this.password = password;
        this.savedMedia = savedMedia;
        this.watchedMedia = watchedMedia;
    }

    public void addSavedMedia(Media media){
        savedMedia.add(0,media);
    }

    public void removeSavedMedia(Media media) {
        savedMedia.remove(media);
    }

    public void addWatchedMedia(Media media){
        watchedMedia.add(0,media);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Media> getSavedMedia() {
        return savedMedia;
    }

    public ArrayList<Media> getWatchedMedia() {
        return watchedMedia;
    }

}
