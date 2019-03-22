package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.parsers.GameParser;
import ca.ubc.cs.cpsc210.persistence.JSonifier;
import ca.ubc.cs.cpsc210.ui.TheMythsOfUBC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.json.JSONObject;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameController {
    @FXML
    private Text goldAmount;

    //public static GameController shared = new GameController();
    public GameController(){ }
    @FXML
    Button villagerButton;
    @FXML
    Button soldierButton;
    @FXML
    Button saveButton;
    private static Game game;
    @FXML
    Button loadButton;

    @FXML
    private void makeVill() {
        game.getPlayerTown().procreateVillager();
    }

    @FXML
    private void makeSold() {
        game.getPlayerTown().procreateSoldier();
    }

    @FXML
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts game to JSON object
    public void saveGame() {
        JSONObject savedGame = JSonifier.gameToJson(game);
        Path path = Paths.get("D:\\Studies\\UBC\\Y2W2\\CPSC210\\project_p2u1b_2\\src\\main\\ca\\ubc\\cs\\cpsc210\\saveFiles\\savedGame.json");
        try {
            Files.write(path, savedGame.toString().getBytes());
            System.out.println("Saving");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadGame() throws IOException {
        System.out.println("Loading");
        load();
    }

    public static void load(){
        Path path = Paths.get("D:\\Studies\\UBC\\Y2W2\\CPSC210\\project_p2u1b_2\\src\\main\\ca\\ubc\\cs\\cpsc210\\saveFiles\\savedGame.json");
        try {
            String s=Files.readAllLines(path).get(0);
            Game g = GameParser.parse(s);
            Parent root = FXMLLoader.load(GameController.class.getResource("/ca/ubc/cs/cpsc210/ui/Map1.fxml"));
            TheMythsOfUBC.setScene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void makeNewGame(String s)  {
        game = new Game(s);
        System.out.println(s + " game");
        Parent root = null;
        try {
            root = FXMLLoader.load(Paths.get("src/main/ca/ubc/cs/cpsc210/ui/Map1.fxml").toUri().toURL());
            TheMythsOfUBC.setScene(root);

            //setText();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setText(){
        goldAmount.setValue("Gold: "+game.getPlayerTown().getAmountGold());
    }
}
