import java.util.ArrayList;

public class SessionService {
    private static final String HEADER = "Username; Password; SavedMedia; WatchedMedia";

    private final String path;
    private final ArrayList<Media> medias;
    private final ArrayList<User> users = new ArrayList<>();
    private final FileIO fileIO = new FileIO();
    private User currentUser;
    private TextUI ui = new TextUI();

    public SessionService(String path, ArrayList<Media> medias) {
        this.path = path;
        this.medias = medias;
    }

    public void loadUsers() {
        users.clear();
        for (String line : fileIO.readData(path)) {
            if (line.isBlank()) {
                continue;
            }
            String[] values = line.split(";");
            if (values.length < 2) {
                System.out.println("Skipping invalid line in " + path + ": " + line);
                continue;
            }
            String username = values[0].trim();
            String password = values[1].trim();
            ArrayList<Media> savedMedia = values.length > 2 ? findMediaByNames(values[2]) : new ArrayList<>();
            ArrayList<Media> watchedMedia = values.length > 3 ? findMediaByNames(values[3]) : new ArrayList<>();
            users.add(new User(username, password, savedMedia, watchedMedia, ui));
        }
    }

    public void saveUser() {
        ArrayList<String> data = new ArrayList<>();
        for (User user : users) {
            data.add(user.getUsername() + "; " + user.getPassword() + "; "
                    + joinMediaNames(user.getSavedMedia()) + "; "
                    + joinMediaNames(user.getWatchedMedia()));
        }
        fileIO.saveData(data, path, HEADER);
    }

    public boolean login(String username, String password) {
        User user = findUser(username);
        if (user != null && user.checkPassword(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public void createAccount(String username, String password) {
        validateCredential(username, "Username");
        validateCredential(password, "Password");
        if (userExists(username)) {
            throw new IllegalArgumentException("The username \"" + username + "\" is already taken.");
        }
        User user = new User(username, password, new ArrayList<>(), new ArrayList<>(), ui);
        users.add(user);
        saveUser();
        currentUser = user;
    }


    public void changePassword(String currentPassword, String newPassword) {
        if (currentUser == null) {
            throw new IllegalStateException("You have to be logged in to change your password.");
        }
        if (!currentUser.checkPassword(currentPassword)) {
            throw new IllegalArgumentException("Your current password is wrong.");
        }
        validateCredential(newPassword, "Password");
        if (newPassword.equals(currentPassword)) {
            throw new IllegalArgumentException("The new password must be different from your current password.");
        }
        currentUser.setPassword(newPassword);
        saveUser();
    }

    public void logout() {
        saveUser();
        currentUser = null;
    }

    public boolean userExists(String username) {
        return findUser(username) != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username.trim())) {
                return user;
            }
        }
        return null;
    }

    public void validateCredential(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " can not be empty.");
        }
        if (value.contains(",") || value.contains(";") || value.contains(":") || value.contains(" ")) {
            throw new IllegalArgumentException(fieldName + " can not contain \",\", \";\", \":\" or spaces.");
        }
    }

    private ArrayList<Media> findMediaByNames(String namesString) {
        ArrayList<Media> result = new ArrayList<>();
        for (String name : namesString.split(":")) {
            String trimmed = name.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            Media media = findMedia(trimmed);
            if (media != null) {
                result.add(media);
            }
        }
        return result;
    }

    private Media findMedia(String name) {
        for (Media media : medias) {
            if (media.getName().equalsIgnoreCase(name)) {
                return media;
            }
        }
        return null;
    }

    private String joinMediaNames(ArrayList<Media> mediaList) {
        ArrayList<String> names = new ArrayList<>();
        for (Media media : mediaList) {
            names.add(media.getName());
        }
        return String.join(":", names);
    }
}