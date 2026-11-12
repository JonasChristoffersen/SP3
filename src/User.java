import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Media> savedMedia;
    private ArrayList<Media> watchedMedia;
    private TextUI ui;
    private boolean running = true;

    public User(String username, String password, ArrayList<Media> savedMedia, ArrayList<Media> watchedMedia, TextUI ui) {
        this.username = username;
        this.password = password;
        this.savedMedia = savedMedia;
        this.watchedMedia = watchedMedia;
        this.ui = ui;
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

    public void userInformation(AccountUI accountUI) {
        running = true;
        ui.displayMessage("\n====== User Information ======" +
                "\nUsername: " + username +
                "\nAmount of media watched: " + watchedMedia.size() +
                "\nAmount of media saved: " + savedMedia.size()
        );

        while (running) {
            Menu menu = new Menu("\nChoose a one of the options:");
            menu.add("Look at list of watched media.", () -> showWatchedList());
            menu.add("Look and edit list of saved media.", () -> displaySavedList());
            menu.add("Change your password.", () -> accountUI.changePassword());
            menu.add("Back", () -> running = false);
            menu.show();

        }
    }

    private void showWatchedList() {
        for (Media media : watchedMedia) {
            System.out.println(media.getName());
        }
    }

    private void displaySavedList() {
        Menu menu = new Menu("\nHere is a list of all your saved media (choose a media to remove from saved):");
        for (Media media : savedMedia) {
            menu.add(media.getName(), () -> {
                removeSavedMedia(media);
                ui.displayMessage(media.getName() + " has been removed from saved list");
            });
        }
        menu.add("Back", () -> {});
        menu.show();
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
