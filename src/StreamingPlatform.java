import java.util.ArrayList;

public class StreamingPlatform {
    private String name;
    private TextUI ui;
    private SessionService sessionService;
    private SearchService searchService;
    private AccountUI accountUI;

    public StreamingPlatform(String name, SearchService searchService, SessionService sessionService, AccountUI accountUI) {
        this.name = name;
        this.searchService = searchService;
        this.ui = new TextUI();
        this.sessionService = sessionService;
        this.accountUI = accountUI;
    }

    public void startMenu() {
        while (true) {
            Menu menu = new Menu(name);
            menu.add("Login with already existing account", () -> {
                if (accountUI.login()) {
                    mainMenu();
                }
            });
            menu.add("Create new account", () -> {
                if (accountUI.createAccount()) {
                    mainMenu();
                }
            });
            menu.add("Close/exit " + name, () -> System.exit(0));
            menu.show();
        }
    }

    public void mainMenu() {
        while (sessionService.isLoggedIn()) {
            Menu menu = new Menu("\n====== Main menu ======");
            menu.add("Your account", () -> sessionService.getCurrentUser().userInformation());
            menu.add("Search in medias", () -> searchMedia());
            menu.add("Log out", () -> sessionService.logout());
            menu.show();
        }
    }

    public void searchMedia() {
        Menu menu = new Menu("What kind of search do you want to use?");
        menu.add("Search by name", () -> chooseMediaMenu(searchService.searchByName()));
        menu.add("Search by genre", () -> chooseMediaMenu(searchService.searchByGenre()));
        menu.add("Search by rating", () -> chooseMediaMenu(searchService.searchByRating()));
        menu.add("Search by release year", () -> chooseMediaMenu(searchService.searchByReleaseYear()));
        menu.show();
    }

    private void chooseMediaMenu(ArrayList<Media> mediaArrayList) {
        Menu menu = new Menu("Choose a media from list below:");
        for (Media media : mediaArrayList) {
            menu.add(media.getName(), () -> displaySpecificMedia(media));
        }
        menu.show();
    }

    public void displaySpecificMedia (Media media) {
        ui.displayMessage("====== Specific media information ======"
                + "\n" + "Name: " + media.getName()
                + "\n" + "Rating: " + media.getRating()
                + "\n" + "Release year: " + media.getReleaseYear()
                + "\n" + "Genre(s): " + media.getGenres()
        );

        Menu menu = new Menu("You have the following options:");
        menu.add("Play media", () -> {
            if (media instanceof Series series) {
                displaySeasonMenu(series);
            } else {
                PlayableMedia playableMedia = (PlayableMedia) media;
                playableMedia.playMedia(sessionService.getCurrentUser(), media);
            }
        });
        menu.add("Save media to saved list", () -> System.out.println(media.getName() + " is now saved to saved list")); //CHECK UP ON THIS :)
        menu.show();
    }

    private void displaySeasonMenu(Series series) {
        Menu menu = new Menu("Choose a season from list below:");
        for (Season season : series.getSeasons()) {
            menu.add(season.toString(), () -> season.playMedia(sessionService.getCurrentUser(), series));
        }
        menu.show();
    }
}