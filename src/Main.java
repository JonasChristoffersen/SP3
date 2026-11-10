import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        printLogo();
        DataLoader dataLoader = new DataLoader();
        dataLoader.loadFilm("data/filmData.txt");
        dataLoader.loadSeries("data/seriesData.txt");

        TextUI ui = new TextUI();
        SearchService searchService = new SearchService(ui, dataLoader);
        SessionService sessionService = new SessionService("data/userData.txt", dataLoader.getMediaArrayList());
        sessionService.loadUsers();
        AccountUI accountUI = new AccountUI(ui, sessionService);
        StreamingPlatform streamingPlatform = new StreamingPlatform("\u001B[31mN\u001B[33mE\u001B[32mT\u001B[36mF\u001B[34mL\u001B[35mU\u001B[31mX\u001B[0m", searchService, sessionService, accountUI);

        streamingPlatform.startMenu();
    }

    private static void printLogo() {
        //Claude have helped us with formatting this text
        String logo = """
███╗   ██╗███████╗████████╗███████╗██╗     ██╗   ██╗██╗  ██╗
████╗  ██║██╔════╝╚══██╔══╝██╔════╝██║     ██║   ██║╚██╗██╔╝
██╔██╗ ██║█████╗     ██║   █████╗  ██║     ██║   ██║ ╚███╔╝
██║╚██╗██║██╔══╝     ██║   ██╔══╝  ██║     ██║   ██║ ██╔██╗
██║ ╚████║███████╗   ██║   ██║     ███████╗╚██████╔╝██╔╝ ██╗
╚═╝  ╚═══╝╚══════╝   ╚═╝   ╚═╝     ╚══════╝ ╚═════╝ ╚═╝  ╚═╝
""";
        int[] cuts = {0, 10, 18, 27, 35, 43, 52, 60};

        System.out.println(logo.lines().map(line -> IntStream.range(0, 7).mapToObj(i -> "\u001B[3" + (i % 6 + 1) + "m" + line.substring(Math.min(cuts[i], line.length()), Math.min(cuts[i + 1], line.length()))).collect(Collectors.joining())).collect(Collectors.joining("\n")) + "\u001B[0m");

    }
}