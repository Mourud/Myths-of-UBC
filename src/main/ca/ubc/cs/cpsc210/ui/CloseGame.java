package ca.ubc.cs.cpsc210.ui;

import javafx.stage.Stage;

public class CloseGame {

    private static void closeProgram(Stage window) {
        boolean closeNow = ConfirmBox.display("", "Are you sure you want to exit?");
        if (closeNow) {
            window.close();

        }
    }
}
