//package ca.ubc.cs.cpsc210.ui;
//
//import ca.ubc.cs.cpsc210.model.Game;
//import ca.ubc.cs.cpsc210.model.constants.GameConstants;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class DifficultyMenu {
//
//    private static final String TITLE = GameConstants.TITLE;
//    private static final String LEVEL1 = GameConstants.LEVEL1;
//    private static final String LEVEL2 = GameConstants.LEVEL2;
//    private static final String LEVEL3 = GameConstants.LEVEL3;
//
//    private Scene mainScreen;
//    private Button buttonEasy;
//    private Button buttonMedium;
//    private Button buttonHard;
//
//    public DifficultyMenu(Stage s){
//        setupWindow(s);
//        setupButton();
//        setupScene();
//        NameOfMyGame.setScene(mainScreen);
//    }
//    private void setupWindow(Stage window) {
//
//        window.setOnCloseRequest(e -> {
//            e.consume();
//            NameOfMyGame.closeProgram();
//        });
//    }
//
//    private void setupButton() {
//        buttonEasy = new Button(LEVEL1);
//        buttonEasy.setOnAction(e -> gameBuilder(LEVEL1));
//        buttonMedium = new Button(LEVEL2);
//        buttonMedium.setOnAction(e -> gameBuilder(LEVEL2));
//        buttonHard = new Button(LEVEL3);
//        buttonHard.setOnAction(e -> gameBuilder(LEVEL3));
//    }
//
//    private void gameBuilder(String s) {
//        Game game = new Game(s);
//        System.out.println(s + " game");
//        boolean yes = ConfirmBox.display(TITLE, "Difficulty selected: " + s + "\n        Are you sure?");
//        if (yes) {
//            window.close();
//            GameMap.render();
//        }
//    }
//
//    //REQUIRES:
//    //MODIFIES:
//    //EFFECTS:
//    private void setupScene() {
//        VBox layout1 = new VBox(20);
//        Label intro = new Label("Choose a difficulty: ");
//        layout1.getChildren().addAll(intro, buttonEasy, buttonMedium, buttonHard);
//        layout1.setAlignment(Pos.CENTER);
//        mainScreen = new Scene(layout1, 200, 200);
//    }
//
//
//}
