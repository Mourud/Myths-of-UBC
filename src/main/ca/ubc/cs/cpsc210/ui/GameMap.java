package ca.ubc.cs.cpsc210.ui;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameMap {

    public static final String TITLE = GameConstants.TITLE;


    public static void render() {
        Stage window = new Stage();
        window.setTitle(TITLE);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(8);
        grid.setVgap(10);
        Scene scene = new Scene(grid);
        window.setMinWidth(250);
        window.setMinHeight(250);
        window.setScene(scene);
        window.show();
    }
}
