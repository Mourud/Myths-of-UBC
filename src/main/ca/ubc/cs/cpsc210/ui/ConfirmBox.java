package ca.ubc.cs.cpsc210.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    //Can't use fields if method is static
    private static Stage window;
    private static boolean answer;
    private static Scene scene;
    private static Button yesButton = new Button("Yes");
    private static Button noButton = new Button("No");
    private static Label label = new Label();


    public static boolean display(String title, String message) {
        setupWindow(title);
        setupButtons();
        setupScene(message);
        showWindow();
        return answer;
    }

    private static void showWindow() {
        window.setScene(scene);
        window.showAndWait();
    }

    private static void setupScene(String message) {
        label.setText(message);
        HBox answerLayout = new HBox(10);
        answerLayout.getChildren().addAll(yesButton, noButton);
        answerLayout.setAlignment(Pos.CENTER);
        StackPane layout = new StackPane(label);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(layout);
        borderPane.setCenter(answerLayout);
        scene = new Scene(borderPane);
    }

    private static void setupButtons() {
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
    }

    private static void setupWindow(String title) {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
    }


}
