import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Media> savedMedia;
    private ArrayList<Media> watchedMedia;
    private TextUI ui;

    public User(String username, String password, ArrayList<Media> savedMedia, ArrayList<Media> watchedMedia) {
        this.username = username;
        this.password = password;
        this.savedMedia = savedMedia;
        this.watchedMedia = watchedMedia;
    }

    public void addSavedMedia(Media media) {
        savedMedia.add(0, media);
    }

    public void removeSavedMedia(Media media) {
        savedMedia.remove(media);
    }

    public void addWatchedMedia(Media media) {
        watchedMedia.add(0, media);
    }

    public void userInformation() {
        ui.displayMessage("=== User Information ===" +
                "\n Username: " + username +
                "\n Amount of media watched: " + watchedMedia.size() +
                "\n Amount of media saved: " + savedMedia.size()
        );

        Menu menu = new Menu("Choose a one of the options");
/*        menu.add("Look at list of watched media.", //() -> showWatchedList());
        menu.add("Look and edit list of saved media.", //() -> /*showSavedList());
        menu.add("Change your password.", //() -> changePassword(password));
        menu.show();*/
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
