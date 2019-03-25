package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.parsers.GameParser;
import ca.ubc.cs.cpsc210.ui.TheMythsOfUBC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainMenuController extends SuperController {


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
        Parent root = FXMLLoader.load(getClass().getResource("/ca/ubc/cs/cpsc210/ui/DifficultyMenu.fxml"));
        TheMythsOfUBC.setScene(root);

    }

    public void loadGame() {
        super.load();
    }

    public void closeGame() {
        TheMythsOfUBC.closeProgram();
    }
}
