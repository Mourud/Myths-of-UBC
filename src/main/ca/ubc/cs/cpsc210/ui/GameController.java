package ca.ubc.cs.cpsc210.ui;

import ca.ubc.cs.cpsc210.model.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {
    @FXML
    Button startButton;

    @FXML
    void test() {
        System.out.println("Test");
    }
    private void gameBuilder(String s) {
        Game game = new Game(s);

    }
}
