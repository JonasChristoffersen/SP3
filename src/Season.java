public class Season implements PlayableMedia {

    private String season;
    private String episodes;


    public Season(String season) {
        String[] array = season.trim().split("-");
        this.season = array[0];
        this.episodes = array[1];
    }

    @Override
    public void playMedia() {

    }

    @Override
    public String toString() {
        return "S" + season + "-E" + episodes;
    }
}
