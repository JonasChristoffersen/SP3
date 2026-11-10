import java.util.ArrayList;

public class SearchService {
    private TextUI ui;
    private ArrayList<Media> medias;

    public SearchService(TextUI ui, DataLoader dataLoader) {
        this.ui = ui;
        this.medias = dataLoader.getMediaArrayList();
    }

    public ArrayList<Media> searchByName() {
        ArrayList<Media> searchArray = new ArrayList<>();
        String input = ui.promptText("Type the title you want to search for");
        for (Media media : medias) {
            if (media.getName().toLowerCase().contains(input.toLowerCase())) {
                searchArray.add(media);
            }
        }
        return searchArray;
    }

    public ArrayList<Media> searchByGenre() {
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

    public ArrayList<Media> searchByRating() {
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

    public ArrayList<Media> searchByReleaseYear() {
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
}
