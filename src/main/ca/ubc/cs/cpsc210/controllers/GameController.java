package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.model.person.Registry;
import ca.ubc.cs.cpsc210.parsers.GameParser;
import ca.ubc.cs.cpsc210.persistence.JSonifier;
import ca.ubc.cs.cpsc210.ui.TheMythsOfUbc;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameController {


    private Person selected = null;
    public int turnLimit;
    int turnPlayed = 0;
    boolean playerTurn = true;
    boolean gameStart = false;

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

            update();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mouseHandle(MouseEvent e) {
        Position mousePos = new Position((int) e.getSceneX(), (int) e.getSceneY());
        TownCentre player = game.getPlayerTown();
        TownCentre op = game.getEnemyTown();
        if (playerTurn) {
            moveOrder(player, op, mousePos);
        } else {
            moveOrder(op, player, mousePos);
        }
        update();
    }

    private void moveOrder(TownCentre player, TownCentre op, Position mousePos) {
        if ((selected == (null))) {
            if (player.findPerson(mousePos) != null) {
                selected = player.findPerson(mousePos);
                turnPlayed++;
            }
        } else {
            selected.walkTo(mousePos.getPosX(), mousePos.getPosY());
            Person opponent = op.findPerson(mousePos);
            turnPlayed += 1;
            if (opponent != null) {
                selected.attack(opponent);
            }
            selected = null;
        }
    }

    private void update() {
        if (!gameStart) {
            setTurnLimit();
            gameStart = !gameStart;
        }
        System.out.println("TurnLimit : " + turnLimit);
        System.out.println("Turn : " + playerTurn);
        System.out.println("TurnPlaued : " + turnPlayed);
        if (turnPlayed >= turnLimit) {
            playerTurn = !playerTurn;
            turnPlayed = 0;
            setTurnLimit();
        }
        game.updateTowns();
        prepareToUpdatePlayerPosition(TheMythsOfUbc.setScene(render(game)));
        checkGameOver();
    }

    private void setTurnLimit() {
        if (playerTurn) {
            turnLimit = 2 * game.getPlayerTown().getPopSize();
        } else {
            turnLimit = 2 * game.getEnemyTown().getPopSize();
        }
    }

    private void checkGameOver() {
        if (game.getEnemyTown().getRegistry().isExtinct()) {
            TheMythsOfUbc.setScene(setGameEnd("BLUE"));
        } else if (game.getPlayerTown().getRegistry().isExtinct()) {
            TheMythsOfUbc.setScene(setGameEnd("RED"));
        }
    }

    private Parent setGameEnd(String player) {
        Pane finalScreen = new Pane();
        Label label = new Label(player + " WON");
        label.setTranslateX(GameConstants.GAME_SCREEN_WIDTH / 2);
        label.setTranslateY(GameConstants.GAME_SCREEN_HEIGHT / 2);
        Button mainMenu = mainMenu();
        mainMenu.setTranslateX(GameConstants.GAME_SCREEN_WIDTH / 2);
        mainMenu.setTranslateY(GameConstants.GAME_SCREEN_HEIGHT - 100);
        finalScreen.getChildren().addAll(label, mainMenu);
        return finalScreen;
    }


    public void makeNewGame(String s) {
        game = new Game(s);
//        Parent root = render(game);
//        Scene scene = TheMythsOfUbc.setScene(root);
//        prepareToUpdatePlayerPosition(scene);
        update();
    }

    private void prepareToUpdatePlayerPosition(Scene scene) {
        Objects.requireNonNull(scene).setOnMouseClicked(e -> mouseHandle(e));

    }


    private Parent render(Game g) {
        Pane root = new HBox();
        Pane map = new Pane();
        map.getChildren().addAll(g.getPlayerTown(), g.getEnemyTown(), g.getFarm(), g.getGoldMine());
        addPerson(g.getPlayerTown().getRegistry(), map);
        addPerson(g.getEnemyTown().getRegistry(), map);
        Pane interFace = new HBox();
        interFace.getChildren().addAll(turnDisplay(),
                foodAmount(g),
                blankSpace(),
                goldAmount(g),
                makeVill(),
                makeSold(),
                saveGame(g),
                setLoadButton(),
                mainMenu());
        root.getChildren().addAll(map, interFace);
        return root;
    }

    private Label turnDisplay() {
        Label turnDisplay;
        if (playerTurn) {
            turnDisplay = new Label("Blue" + "'s Turn ");
        } else {
            turnDisplay = new Label("Red" + "'s Turn ");
        }
        return turnDisplay;
    }

    private void addPerson(Registry r, Pane map) {
        for (Person p : r) {
            Label health = p.getHealthLabel();
            map.getChildren().addAll(p, health);
        }
    }

    private Button makeVill() {
        Button makeVill = new Button("Villager");

        makeVill.setOnAction(e -> {
            boolean personMadeSuccessful;
            if (playerTurn) {
                personMadeSuccessful = game.getPlayerTown().procreateVillager();
            } else {
                personMadeSuccessful = game.getEnemyTown().procreateVillager();
            }
            if (personMadeSuccessful) {
                turnPlayed += 2;
            }
            update();
        });
        return makeVill;
    }


    private Button makeSold() {
        Button makeSold = new Button("Soldier");
        makeSold.setOnAction(e -> {
            boolean personMadeSuccessful;
            if (playerTurn) {
                personMadeSuccessful = game.getPlayerTown().procreateSoldier();
            } else {
                personMadeSuccessful = game.getEnemyTown().procreateSoldier();
            }
            if (personMadeSuccessful) {
                turnPlayed += 2;
            }
            update();
        });
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
