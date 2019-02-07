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
    private Stage window;
    private static boolean answer;


    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);


        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });



        HBox answerLayout = new HBox();
        answerLayout.getChildren().addAll(yesButton, noButton);
        answerLayout.setAlignment(Pos.CENTER);
        StackPane layout = new StackPane(label);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(layout);
        borderPane.setCenter(answerLayout);
        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }

}
