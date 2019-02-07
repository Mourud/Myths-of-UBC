package ca.ubc.cs.cpsc210.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameMap {

    public static void render() {
        Stage window = new Stage();
        window.setTitle(GameController.TITLE);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(8);
        grid.setVgap(10);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }
}
