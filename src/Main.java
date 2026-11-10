public class Main {
    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        dataLoader.loadFilm("data/filmData.txt");
        dataLoader.loadSeries("data/seriesData.txt");

        TextUI ui = new TextUI();
        SearchService searchService = new SearchService(ui, dataLoader);
        SessionService sessionService = new SessionService("data/userData.txt", dataLoader.getMediaArrayList());
        sessionService.loadUsers();
        AccountUI accountUI = new AccountUI(ui, sessionService);
        StreamingPlatform streamingPlatform = new StreamingPlatform("Netflux", searchService, sessionService, accountUI);

        streamingPlatform.startMenu();
    }
}