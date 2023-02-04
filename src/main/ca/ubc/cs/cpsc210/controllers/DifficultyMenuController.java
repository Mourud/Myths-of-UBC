package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.ui.ConfirmBox;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * The controller for the difficulty menu of the game.
 * Allows the user to select the difficulty level, load a saved game, or go back to the main menu.
 */
public class DifficultyMenuController extends GameController {
    // constant strings for title and different levels
    private static final String TITLE = GameConstants.TITLE;
    private static final String LEVEL1 = GameConstants.LEVEL1;
    private static final String LEVEL2 = GameConstants.LEVEL2;
    private static final String LEVEL3 = GameConstants.LEVEL3;

    // main screen scene
    private Scene mainScreen;
    // buttons for difficulty levels and load/main menu
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

    /**
     * Method called when the user selects the easy difficulty level.
     * Displays a confirmation box to confirm the user's selection, and builds a new game if confirmed.
     */
    @FXML
    public void easyGame() {
        // display confirmation box and get confirmation result
        boolean confirmed = ConfirmBox.display(TITLE, "Difficulty selected: " + LEVEL1 + "\n        Are you sure?");
        // build game based on difficulty level and confirmation
        gameBuilder(LEVEL1, confirmed);
    }

    /**
     * Method called when the user selects the medium difficulty level.
     * Displays a confirmation box to confirm the user's selection, and builds a new game if confirmed.
     */
    @FXML
    public void mediumGame() {
        // display confirmation box and get confirmation result
        boolean confirmed = ConfirmBox.display(TITLE, "Difficulty selected: " + LEVEL2 + "\n        Are you sure?");
        // build game based on difficulty level and confirmation
        gameBuilder(LEVEL2, confirmed);
    }

    /**
     * Method called when the user selects the hard difficulty level.
     * Displays a confirmation box to confirm the user's selection, and builds a new game if confirmed.
     */
    @FXML
    public void hardGame() {
        // display confirmation box and get confirmation result
        boolean confirmed = ConfirmBox.display(TITLE, "Difficulty selected: " + LEVEL3 + "\n        Are you sure?");
        // build game based on difficulty level and confirmation
        gameBuilder(LEVEL3, confirmed);
    }

    /**
     * Method called when the user presses the main menu button.
     * Switches to the main menu screen.
     *
     * @throws IOException if the main menu fxml file cannot be loaded
     */
    public void goMainMenu() throws IOException {
        // switch to main menu
        setMainMenu();
    }
    /**

     Method called when load game button is pressed.
     Loads the saved game.
     */
    public void loadGame() {
        load();
    }
    /**
     Helper method to build game based on difficulty level and confirmation.
     Makes a new game if the user confirms.
     @param s the difficulty level
     @param yes the confirmation status
     */
    private void gameBuilder(String s, Boolean yes) {
        if (yes) {
            super.makeNewGame(s);
        }
    }
}



