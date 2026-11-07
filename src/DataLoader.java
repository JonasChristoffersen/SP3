import java.util.ArrayList;

public class DataLoader {
    private final FileIO fileIO = new FileIO();
    ArrayList<Media> mediaArrayList = new ArrayList<>(); //This should be reworked when media class is made abstract!

    //Name; ReleaseYear; Genre; Rating
    public void loadFilm(String path) {
        ArrayList<String> data = fileIO.readData(path);
        for (String s : data) {
            String[] values = s.split(";");
            String name = values[0].trim();
            int releaseYear = Integer.parseInt(values[1].trim());
            ArrayList<Genre> genres = loadGenres(values[2]);
            double rating = loadRating(values[3].trim());
            mediaArrayList.add(new Media(name, releaseYear, genres, rating));

            //Used sout for checking values are assigned correctly as actual solution is currently missing (can be out-commented)
            System.out.println("Name: " + values[0].trim() + " | releaseYear: " + releaseYear + " | genre: " + genres + " | rating: " + rating);
        }
    }

    //Name; ReleaseYear; genre; Rating; Seasons
    public void loadSeries(String path) {
        ArrayList<String> data = fileIO.readData(path);
        for (String s : data) {
            String[] values = s.split(";");
            String name = values[0].trim();
            int releaseYear = Integer.parseInt(values[1].substring(0, 5).trim()); //Currently set to first release year for series!
            ArrayList<Genre> genres = loadGenres(values[2]);
            double rating = loadRating(values[3].trim());
            ArrayList<String> seasons = loadSeasons(values[4]);
            mediaArrayList.add(new Media(name, releaseYear, genres, rating, seasons));

            //Used sout for checking values are assigned correctly as actual solution is currently missing (can be out-commented)
            System.out.println("Name: " + values[0].trim() + " | releaseYear: " + releaseYear + " | genre: " + genres + " | rating: " + rating + " | seasons: " + seasons);
        }
    }

    private ArrayList<Genre> loadGenres(String genreString) {
        ArrayList<Genre> genres = new ArrayList<>();
        String[] genreArray = genreString.split(",");
        for (String g : genreArray) {
            genres.add(Genre.valueOf(g.trim()));
        }
        return genres;
    }

    private double loadRating(String ratingString) {
        String[] values = ratingString.split(",");
        double firstNumber = Double.parseDouble(values[0]);
        double decimalNumber = Double.parseDouble(values[1]);
        return firstNumber + (decimalNumber / 10);
    }

    private ArrayList<String> loadSeasons(String seasonsString) {
        ArrayList<String> seasons = new ArrayList<>();
        String[] seasonsArray = seasonsString.split(",");
        for (String s : seasonsArray) {
            seasons.add(s.trim());
        }
        return seasons;
    }
}
