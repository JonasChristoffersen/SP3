import java.util.ArrayList;

public class StreamingPlatform {
    private String name;
    private User user;
    private ArrayList<Media> medias;
    private TextUI ui;

    public StreamingPlatform(String name, DataLoader dataLoader) {
        this.name = name;
        this.medias = dataLoader.getMediaArrayList();
        this.ui = new TextUI();
        /*this.user = new ArrayList<>();*/
    }

    public void startMenu() {
       /*
        String[] options = {"Log ind", "Create account"};
        ArrayList<String> choice = ui.promptChoice(options);

        switch (choice) {
            case "Log ind" -> { User user = login();
                if (user != null) mainMenu(user); } break;
            case "Opret bruger" -> createUser(); break;
            default -> startMenu();
        }
        */
    }

    public void mainMenu() {
        /*
        String[] options = {"User","Search bar","Log out"};
        ArrayList<String> choice = ui.promptChoice(options);
        switch (choice) {
            case "User" -> userInformation(); break;
            case "Search bar" -> seachMedia(); break;
            case "Log out" -> logOut(); break;
            default -> mainMenu();
        }
         */
    }

    public void searchMedia() {
        Menu menu = new Menu("What kind of search do you want to use?");
        menu.add("Search by name", () -> chooseMediaMenu(searchByName()));
        menu.add("Search by genre", () -> chooseMediaMenu(searchByGenre()));
        menu.add("Search by rating", () -> chooseMediaMenu(searchByRating()));
        menu.add("Search by release year", () -> chooseMediaMenu(searchByReleaseYear()));
        menu.show();
    }

    private ArrayList<Media> searchByName() {
        ArrayList<Media> searchArray = new ArrayList<>();
        String input = ui.promptText("Type the title you want to search for");
        for (Media media : medias) {
            if (media.getName().toLowerCase().contains(input.toLowerCase())) {
                searchArray.add(media);
            }
        }
        return searchArray;
    }

    private ArrayList<Media> searchByGenre() {
        ArrayList<Media> searchArray = new ArrayList<>();
        Genre[] input = new Genre[1];
        Menu menu = new Menu("Choose a genre from list below: ");
        for (Genre genre : Genre.values()) {
            menu.add(genre.name(), () -> input[0] = genre);
        }
        menu.show();
        for (Media media : medias) {
            if (media.containsGenre(input[0])) {
                searchArray.add(media);
            }
        }
        return searchArray;
    }

    private ArrayList<Media> searchByRating() {
        ArrayList<Media> searchArray = new ArrayList<>();
        double ratingMin = ui.promptDoubleNumeric("Type a minimum rating: ");
        double ratingMax = ui.promptDoubleNumeric("Type a maximum rating: ");
        for (Media media : medias) {
            if (media.getRating() >= ratingMin && media.getRating() <= ratingMax) {
                searchArray.add(media);
            }
        }
        return searchArray;
    }

    private ArrayList<Media> searchByReleaseYear() {
        ArrayList<Media> searchArray = new ArrayList<>();
        int min = ui.promptNumeric("Type a min release year: ");
        int max = ui.promptNumeric("Type a max release year: ");
        for (Media media : medias) {
            if (media.getReleaseYear() >= min && media.getReleaseYear() <= max) {
                searchArray.add(media);
            }
        }
        return searchArray;
    }

    private void chooseMediaMenu(ArrayList<Media> mediaArrayList) {
        Menu menu = new Menu("Choose a media from list below:");
        for (Media media : mediaArrayList) {
            menu.add(media.getName(), () -> System.out.println("showing " + media.getName()));
        }
        menu.show();
    }


}
