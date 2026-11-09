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
            String releaseYear = values[1].trim();
            ArrayList<Genre> genres = loadGenres(values[2]);
            double rating = loadRating(values[3].trim());
            mediaArrayList.add(new Film(name, releaseYear, genres, rating));

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
            String releaseYear = values[1].trim(); //Currently set to first release year for series!
            ArrayList<Genre> genres = loadGenres(values[2]);
            double rating = loadRating(values[3].trim());
            ArrayList<Season> seasons = loadSeasons(values[4]);
            mediaArrayList.add(new Series(name, releaseYear, genres, rating, seasons));

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

    private ArrayList<Season> loadSeasons(String seasonsString) {
        ArrayList<Season> seasons = new ArrayList<>();
        String[] seasonsArray = seasonsString.split(",");
        for (String s : seasonsArray) {
            seasons.add(new Season(s));
        }
        return seasons;
    }
}
