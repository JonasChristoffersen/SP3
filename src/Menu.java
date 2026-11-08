

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final TextUI ui;
    private final String title;
    private final List<Action> actions;

    public Menu(TextUI ui, String title) {
        this.ui = ui;
        this.title = title;
        this.actions = new ArrayList<>();
    }

    public Menu add(String text, Runnable runnable) {
        actions.add(new Action(text, runnable));
        return this;
    }

    public void show() {
        ui.displayMessage(title);
        for (int i = 0; i < actions.size(); i++) {
            ui.displayMessage((i + 1) + ") " + actions.get(i).getText());
        }
        int choice = ui.readInt("Vælg:", 1, actions.size());
        actions.get(choice - 1).run();
    }
}
