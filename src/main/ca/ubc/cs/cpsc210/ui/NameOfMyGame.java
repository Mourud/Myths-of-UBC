package ca.ubc.cs.cpsc210.ui;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class NameOfMyGame extends Application {

    private static final String TITLE = GameConstants.TITLE;

    private static final int HEIGHT = GameConstants.GAME_SCREEN_HEIGHT;
    private static final int WIDTH = GameConstants.GAME_SCREEN_HEIGHT;

   // private static final String TITLE = GameConstants.TITLE;
    private static final String LEVEL1 = GameConstants.LEVEL1;
    private static final String LEVEL2 = GameConstants.LEVEL2;
    private static final String LEVEL3 = GameConstants.LEVEL3;

    private Scene mainScreen;
    private Button buttonEasy;
    private Button buttonMedium;
    private Button buttonHard;



    private static Stage window;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonLoad;
    @FXML
    private Button buttonExit;
    //EFFECTS: Starts Game
    public static void main(String[] args) {
        launch(args);
    }


    //EFFECTS: Starts Game UI
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ca/ubc/cs/cpsc210/ui/MainMenu.fxml"));
        window = primaryStage;
        window.setTitle(TITLE);
        window.setScene(new Scene(root,HEIGHT, WIDTH));
        window.show();
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }

    @FXML
    public void setButtonStart(){
        //new DifficultyMenu(window);
        setupWindow(window);
       setupButton();
        setupScene();
        NameOfMyGame.setScene(mainScreen);
    }



    public static void setScene(Parent root){
        try{
            Scene scene = new Scene(root, HEIGHT, WIDTH);
            window.setTitle(TITLE);
            window.setScene(scene);
            window.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void setScene(Scene scene){
        try{
            window.setTitle(TITLE);
            window.setScene(scene);
            window.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void setupWindow(Stage window) {

        window.setOnCloseRequest(e -> {
            e.consume();
            NameOfMyGame.closeProgram();
        });
    }

    private void setupButton() {
        buttonEasy = new Button(LEVEL1);
        buttonEasy.setOnAction(e -> gameBuilder(LEVEL1));
        buttonMedium = new Button(LEVEL2);
        buttonMedium.setOnAction(e -> gameBuilder(LEVEL2));
        buttonHard = new Button(LEVEL3);
        buttonHard.setOnAction(e -> gameBuilder(LEVEL3));
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

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    private void setupScene() {
        VBox layout1 = new VBox(20);
        Label intro = new Label("Choose a difficulty: ");
        layout1.getChildren().addAll(intro, buttonEasy, buttonMedium, buttonHard);
        layout1.setAlignment(Pos.CENTER);
        mainScreen = new Scene(layout1, 200, 200);
    }


    //todo:Static?
    // what happens when game closes
    public static void closeProgram() {
        Boolean closeNow = ConfirmBox.display(TITLE, "Are you sure you want to exit?");
        if (closeNow) {
            window.close();
        }
    }



}

