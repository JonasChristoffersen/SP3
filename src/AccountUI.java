public class AccountUI {
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    private final TextUI ui;
    private final SessionService sessionService;

    public AccountUI(TextUI ui, SessionService sessionService) {
        this.ui = ui;
        this.sessionService = sessionService;
    }

    public boolean login() {
        String username = ui.promptText("Enter username:");
        if (!sessionService.userExists(username)) {
            ui.displayMessage("There is no user with the username \"" + username + "\".");
            if (ui.promptBinary("Do you want to create a new account instead? (y/n)")) {
                return createAccount();
            }
            return false;
        }

        for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {
            String password = ui.promptText("Enter password:");
            if (sessionService.login(username, password)) {
                ui.displayMessage("Welcome back, " + sessionService.getCurrentUser().getUsername() + "!");
                return true;
            }
            int attemptsLeft = MAX_LOGIN_ATTEMPTS - attempt;
            if (attemptsLeft > 0) {
                ui.displayMessage("Wrong password. You have " + attemptsLeft + " attempt(s) left.");
            }
        }
        ui.displayMessage("Wrong password " + MAX_LOGIN_ATTEMPTS + " times. Returning to the start menu.");
        return false;
    }

    public boolean createAccount() {
        String username = promptUsername();
        if (username == null) {
            return login();
        }
        String password = promptPassword();

        sessionService.createAccount(username, password);
        ui.displayMessage("Your account has been created. You are now logged in as " + username + ".");
        return true;
    }

    private String promptUsername() {
        while (true) {
            String username = ui.promptText("Choose a username:");
            try {
                sessionService.validateCredential(username, "Username");
            } catch (IllegalArgumentException e) {
                ui.displayMessage(e.getMessage());
                continue;
            }
            if (!sessionService.userExists(username)) {
                return username;
            }
            ui.displayMessage("The username \"" + username + "\" is already taken.");
            if (ui.promptBinary("Do you want to log in with an existing account instead? (y/n)")) {
                return null;
            }
        }
    }

    private String promptPassword() {
        while (true) {
            String password = ui.promptText("Choose a password:");
            try {
                sessionService.validateCredential(password, "Password");
                return password;
            } catch (IllegalArgumentException e) {
                ui.displayMessage(e.getMessage());
            }
        }
    }
}
