import java.util.ArrayList;

public class DataLoader {
    private final String filmPath = "data/filmData.txt";
    private final String SeriesPath = "data/seriesData.txt";

    FileIO fileIO = new FileIO();
    ArrayList<Media> mediaArrayList = new ArrayList<>();


    //Name; ReleaseYear; Genre; Rating
    public void loadFilm(String path) {
        ArrayList<String> data = fileIO.readData(filmPath);
        /*ArrayList<Genre> genres = ne*/
        for (String s : data) {
            String[] values = s.split(";");
            String name = values[0].trim();
            int releaseYear = Integer.parseInt(values[1].trim());
            ArrayList<Genre> genres = loadGenres(values[2]);
            double rating = Double.parseDouble(values[3].trim());

            mediaArrayList.add(new Media(name, releaseYear, genres, rating));
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

    public void startSession() {
        ui.displayMessage("Welcome to Matador");
        ArrayList<String> data = io.readData("data/playerData.csv");
        if (!data.isEmpty() && ui.promptBinary("Continue previously saved game? Y/N")) {
            for (String s : data) {

                String[] values = s.split(",");// "tess, 0". --> ["tess", "0"]
                String name = values[0];
                int balance = Integer.parseInt(values[1].trim());
                createPlayer(name, balance);
            }

        }else {
            registerPlayers();
        }
        createAssets();
    }
}
