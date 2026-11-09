import java.util.ArrayList;

public class StreamingPlatform {
    private String name;
    private ArrayList<User> users;

    public StreamingPlatform(String name){
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void startMenu(){
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

    public void mainMenu(){
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

}
