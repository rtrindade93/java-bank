package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.MainMenuController;
import org.academiadecodigo.javabank.models.Bank;

public class MainMenuView extends AbstractView {

    private MainMenuController mainMenuController;

    public MainMenuView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {
        MenuInputScanner mainMenu = buildMainMenu();
        mainMenuController.setOption(prompt.getUserInput(mainMenu));
    }

    @Override
    public void setController(Controller Controller) {
        this.mainMenuController = (MainMenuController) Controller;
    }

    private MenuInputScanner buildMainMenu() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        return mainMenu;

    }
}
