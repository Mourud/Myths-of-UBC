package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.model.person.Registry;
import ca.ubc.cs.cpsc210.parsers.GameParser;
import ca.ubc.cs.cpsc210.persistence.JSonifier;
import ca.ubc.cs.cpsc210.ui.TheMythsOfUbc;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameController {

    private static final int WIDTH = GameConstants.GAME_SCREEN_WIDTH;
    private static final int HEIGHT = GameConstants.GAME_SCREEN_HEIGHT;
    private Person selected = null;

    private static Game game;

    protected void save(Game g) {
        JSONObject savedGame = JSonifier.gameToJson(g);
        Path path = Paths.get("D:\\Studies\\UBC\\Y2W2\\CPSC210\\project_p2u1b_2\\src\\main\\ca\\ubc\\cs\\cpsc210"
                + "\\saveFiles\\savedGame.json");
        try {
            Files.write(path, savedGame.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void load() {
        Path path = Paths.get("D:\\Studies\\UBC\\Y2W2\\CPSC210\\project_p2u1b_2\\src\\main\\ca\\ubc\\cs\\cpsc210"
                + "\\saveFiles\\savedGame.json");
        try {
            String s = Files.lines(path).collect(Collectors.joining());
            game = GameParser.parse(s);
            Parent root = render(game);
            Scene scene = TheMythsOfUbc.setScene(root);
            Objects.requireNonNull(scene).setOnMouseClicked(this::mouseHandle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mouseHandle(MouseEvent e) {
        TownCentre t = game.getPlayerTown();
        Position mousePos = new Position((int) e.getSceneX(), (int) e.getSceneY());
        if ((selected == (null))) {
            if (t.findPerson(mousePos) != null) {
                selected = t.findPerson(mousePos);
            }
        } else {
            selected.walkTo(mousePos.getPosX(),mousePos.getPosY());
            selected = null;
        }
    }


    public void makeNewGame(String s) {
        game = new Game(s);
        Parent root = render(game);
        Scene scene = TheMythsOfUbc.setScene(root);
        Objects.requireNonNull(scene).setOnMouseClicked(this::mouseHandle);
    }

    private Parent render(Game g) {
        Pane root = new HBox();
        Pane map = new Pane();
        map.getChildren().addAll(g.getPlayerTown(), g.getEnemyTown(), g.getFarm(), g.getGoldMine());
        addPerson(g.getPlayerTown().getRegistry(), map);
        addPerson(g.getEnemyTown().getRegistry(), map);

        Pane interFace = new HBox();
        interFace.getChildren().addAll(
                foodAmount(g),
                blankSpace(),
                goldAmount(g),
                makeVill(),
                makeSold(),
                saveGame(g),
                setLoadButton(),
                mainMenu());
        root.getChildren().addAll(map, interFace);
//        GameObject gtest = new GameObject(10,10);
//        gtest.setX(0);
//        gtest.setY(0);
//        map.getChildren().add(gtest);
        return root;
    }

    private void addPerson(Registry r, Pane map) {
        for (Person p : r) {
            map.getChildren().add(p);
        }
    }

    private Button makeVill() {
        Button makeVill = new Button("Villager");
        makeVill.setOnAction(e -> game.getPlayerTown().procreateVillager());
        return makeVill;
    }

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
        TheMythsOfUbc.setScene(root);
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

}
