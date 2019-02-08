package ca.ubc.cs.cpsc210.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GameController extends Application {
    public static final String TITLE = "The Myth";
    private Stage window;
    private Scene mainScreen;
    private Button buttonEasy;
    private Button buttonMedium;
    private Button buttonHard;
    private String level1 = "Easy";
    private String level2 = "Medium";
    private String level3 = "Hard";
    private VBox layout1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setupWindow(primaryStage);
        setupButton();
        setupScene();
        window.setScene(mainScreen);
        window.show();
    }

    private void setupScene() {
        VBox layout1 = new VBox(20);
        Label intro = new Label("Choose a difficulty: ");
        layout1.getChildren().addAll(intro, buttonEasy, buttonMedium, buttonHard);
        layout1.setAlignment(Pos.CENTER);
        mainScreen = new Scene(layout1, 200, 200);
    }

    private void setupWindow(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("The Myth");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }

    private void setupButton() {
        buttonEasy = new Button(level1);
        buttonEasy.setOnAction(e -> gameBuilder(level1));
        buttonMedium = new Button(level2);
        buttonMedium.setOnAction(e -> gameBuilder(level2));
        buttonHard = new Button(level3);
        buttonHard.setOnAction(e -> gameBuilder("Hard"));
    }

    private void gameBuilder(String s) {
        Game game = new Game(s);
        System.out.println(s + " game");
        boolean yes = ConfirmBox.display(TITLE, "Difficulty selected: " + s + "\n        Are you sure?");
        if (yes) {
            window.close();
            GameMap.render();
        }
    }

    // what happens when game closes
    private void closeProgram() {
        Boolean closeNow = ConfirmBox.display(GameController.TITLE, "Are you sure you want to exit?");
        if (closeNow) {
            window.close();
        }
    }
}

