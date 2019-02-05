package ca.ubc.cs.cpsc210.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameController extends Application implements EventHandler<ActionEvent> {
    private Stage window;
    private Scene difficultyMenu;
    private Scene gameDisplay;
    private Button buttonEasy;
    private Button buttonMedium;
    private Button buttonHard;
    private Button buttonBack;

    public static void main(String[] args) {
        launch(args);
//        System.out.println(", Medium, Hard");
//        Scanner input = new Scanner(System.in);
//        String difficulty = input.nextLine();
//        Game game = new Game(difficulty);
    }

    // TODO: Reformat UI class.
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("The Myth");
        Label intro = new Label("Choose a difficulty: ");
        buttonEasy = new Button("Easy");
        buttonEasy.setOnAction(this);
        buttonMedium = new Button("Medium");
        buttonMedium.setOnAction(this);
        buttonHard = new Button("Hard");
        buttonHard.setOnAction(this);

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(intro, buttonEasy, buttonMedium, buttonHard);
        difficultyMenu = new Scene(layout1, 200, 200);

        Label goBack = new Label("Are you sure?");
        buttonBack = new Button("Back");
        buttonBack.setOnAction(this);

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(goBack, buttonBack);
        gameDisplay = new Scene(layout2, 100, 100);

        window.setScene(difficultyMenu);
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == buttonEasy) {
            Game game = new Game("Easy");
            System.out.println("Easy game");
            window.setScene(gameDisplay);
        } else if (event.getSource() == buttonMedium) {
            Game game = new Game("Medium");
            System.out.println("Medium game");
            window.setScene(gameDisplay);
        } else if (event.getSource() == buttonHard) {
            Game game = new Game("Hard");
            System.out.println("Hard game");
            window.setScene(gameDisplay);
        } else if (event.getSource() == buttonBack) {
            Game game = new Game("Hard");
            System.out.println("Restart");
            window.setScene(difficultyMenu);
        } //else if ()
    }

}

