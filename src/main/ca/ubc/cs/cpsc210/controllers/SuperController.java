package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.parsers.GameParser;
import ca.ubc.cs.cpsc210.persistence.JSonifier;
import ca.ubc.cs.cpsc210.ui.TheMythsOfUBC;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class SuperController {

    private static Game game;

    protected void save(Game g) {
        JSONObject savedGame = JSonifier.gameToJson(g);
        Path path = Paths.get("D:\\Studies\\UBC\\Y2W2\\CPSC210\\project_p2u1b_2\\src\\main\\ca\\ubc\\cs\\cpsc210\\saveFiles\\savedGame.json");
        try {
            Files.write(path, savedGame.toString().getBytes());
            System.out.println("Saving");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    protected void load() {
        Path path = Paths.get("D:\\Studies\\UBC\\Y2W2\\CPSC210\\project_p2u1b_2\\src\\main\\ca\\ubc\\cs\\cpsc210\\saveFiles\\savedGame.json");
        try {
            String s = Files.lines(path).collect(Collectors.joining());
            System.out.println(s);
            game = GameParser.parse(s);
            Parent root = render(game);
            TheMythsOfUBC.setScene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void close(Stage window) {
//        Boolean closeNow = ConfirmBox.display("Exit", "Are you sure you want to exit?");
//        if (closeNow) {
//            window.close();
//        }
//    }

    public void makeNewGame(String s) {
        game = new Game(s);
        System.out.println(s + " game");
        Parent root = render(game);
        TheMythsOfUBC.setScene(root);
    }

    private Parent render(Game g) {
        Pane root = new HBox();
        Pane map = new Pane();
        map.getChildren().addAll(g.getPlayerTown(), g.getEnemyTown(), g.getFarm(), g.getGoldMine());
        for (Person p : g.getPlayerTown().getRegistry()) {
            map.getChildren().add(p);
        }
        for (Person p : g.getEnemyTown().getRegistry()) {
            map.getChildren().add(p);
        }
        Pane interFace = new HBox();
        interFace.getChildren().addAll(foodAmount(g), blankSpace(), goldAmount(g), makeVill(), makeSold(), setLoadButton(), saveGame(g), mainMenu());
        root.getChildren().addAll(map, interFace);
        return root;
    }

    private Button makeVill() {
        Button makeVill = new Button("Villager");
        makeVill.setOnAction(e -> game.getPlayerTown().procreateVillager());
        return makeVill;
    }
    // todo: problem creating soldiers

    private Button makeSold() {
        Button makeSold = new Button("Soldier");
        makeSold.setOnAction(e -> game.getPlayerTown().procreateSoldier());
        return makeSold;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts game to JSON object
    public Button saveGame(Game g) {
        Button save = new Button("Save");
        save.setOnAction(e -> save(g));
        return save;
    }

    public Button mainMenu() {
        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e -> {
            try {
                setMainMenu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        return mainMenu;
    }

    public void setMainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ca/ubc/cs/cpsc210/ui/MainMenu.fxml"));
        TheMythsOfUBC.setScene(root);
    }

    private Button setLoadButton() {
        Button load = new Button("Load");
        load.setOnAction(e -> load());
        return load;
    }

    private Label foodAmount(Game g) {
        Label foodAmount = new Label("Food Amount: " + g.getPlayerTown().getAmountFood());
        return foodAmount;
    }

    private Label goldAmount(Game g) {
        Label goldAmount = new Label("Gold Amount: " + g.getPlayerTown().getAmountGold());
        return goldAmount;
    }

    private Label blankSpace() {
        Label blankSpace = new Label("  ");
        return blankSpace;
    }

    // todo: Observer pattern, loading issues, saving format needs work
}
