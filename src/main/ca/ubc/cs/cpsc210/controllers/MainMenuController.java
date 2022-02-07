package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.ui.TheMythsOfUbc;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController extends GameController {


    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonLoad;
    @FXML
    private Button buttonExit;
    @FXML
    private Text goldAmount;

    @FXML
    public void startNewGame() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ca/ubc/cs/cpsc210/ui/DifficultyMenu.fxml")));
        TheMythsOfUbc.setScene(root);

    }

    public void loadGame() {
        super.load();
    }

    public void closeGame() {
        TheMythsOfUbc.closeProgram();
    }
}
