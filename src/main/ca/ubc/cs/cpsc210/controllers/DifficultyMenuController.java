package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.ui.ConfirmBox;
import ca.ubc.cs.cpsc210.ui.TheMythsOfUBC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DifficultyMenuController extends SuperController {
    private static final String TITLE = GameConstants.TITLE;
    private static final String LEVEL1 = GameConstants.LEVEL1;
    private static final String LEVEL2 = GameConstants.LEVEL2;
    private static final String LEVEL3 = GameConstants.LEVEL3;


    private Scene mainScreen;
    @FXML
    private Button buttonEasy;
    @FXML
    private Button buttonMedium;
    @FXML
    private Button buttonHard;
    @FXML
    private Button mainMenu;
    @FXML
    private Button loadGame;

    @FXML
    public void easyGame() {
        boolean confirmed = ConfirmBox.display(TITLE, "Difficulty selected: " + LEVEL1 + "\n        Are you sure?");
        gameBuilder(LEVEL1, confirmed);
    }

    @FXML
    public void mediumGame() {
        boolean confirmed = ConfirmBox.display(TITLE, "Difficulty selected: " + LEVEL2 + "\n        Are you sure?");
        gameBuilder(LEVEL2, confirmed);
    }

    @FXML
    public void hardGame() {
        boolean confirmed = ConfirmBox.display(TITLE, "Difficulty selected: " + LEVEL3 + "\n        Are you sure?");
        gameBuilder(LEVEL3, confirmed);
    }

    public void goMainMenu() throws IOException {
        setMainMenu();
    }

    public void loadGame() {
        load();
    }

    private void gameBuilder(String s, Boolean yes) {
        if (yes) {
            super.makeNewGame(s);
        }
    }

}
