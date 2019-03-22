package ca.ubc.cs.cpsc210.ui;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

// Starts Game Application, also works as controller for MainMenu
public class TheMythsOfUBC extends Application {

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


    public static void closeProgram() {
        Boolean closeNow = ConfirmBox.display(TITLE, "Are you sure you want to exit?");
        if (closeNow) {
            window.close();
        }
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

}

