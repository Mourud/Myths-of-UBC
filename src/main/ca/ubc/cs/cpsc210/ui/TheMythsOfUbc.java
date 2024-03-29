package ca.ubc.cs.cpsc210.ui;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

// Starts Game Application, also works as controller for MainMenu
public class TheMythsOfUbc extends Application {

    private static final String TITLE = GameConstants.TITLE;
    private static final int HEIGHT = GameConstants.GAME_SCREEN_HEIGHT;
    private static final int WIDTH = GameConstants.GAME_SCREEN_WIDTH;


    private static Stage window;

    //EFFECTS: Starts Game
    public static void main(String[] args) {
        launch(args);
    }

    //EFFECTS: Starts Game UI
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ca/ubc/cs/cpsc210/ui/MainMenu.fxml")));
        window = primaryStage;
        window.setTitle(TITLE);
        window.setScene(new Scene(root, WIDTH, HEIGHT));
        window.show();
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }


    public static void closeProgram() {
        boolean closeNow = ConfirmBox.display(TITLE, "Are you sure you want to exit?");
        if (closeNow) {
            window.close();
        }
    }

    public static Scene setScene(Parent root) {
        try {
            Scene scene = new Scene(root, WIDTH, HEIGHT);
            window.setTitle(TITLE);
            window.setScene(scene);
            window.show();
            return scene;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void setScene(Scene scene) {
        try {
            window.setTitle(TITLE);
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

