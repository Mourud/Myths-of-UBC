package ca.ubc.cs.cpsc210.controllers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.parsers.GameParser;
import ca.ubc.cs.cpsc210.persistence.JSonifier;
import ca.ubc.cs.cpsc210.ui.TheMythsOfUBC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import org.json.JSONObject;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameController extends SuperController {
    @FXML
    private Text goldAmount;

    //public static GameController shared = new GameController();


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

    // todo: problem creating soldiers
    @FXML
    private void makeSold() {
        game.getPlayerTown().procreateSoldier();
    }

    @FXML
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts game to JSON object
    public void saveGame() {
        super.save(game);
    }

    @FXML
    public void loadGame() throws IOException {
        super.load();
    }

//    public void makeNewGame(String s) {
////        game = new Game(s);
//////        GameObject g = new GameObject(5,5,5,5,"Something", Color.BLUE);
////        System.out.println(s + " game");
////        Parent root = null;
////        root = render();
//////            root.getChildrenUnmodifiable().add(g);
////        TheMythsOfUBC.setScene(root);
////
////        //setText();
//        super.makeNewGame(s,game);
//
//    }


    public void setText() {
        goldAmount.setValue("Gold: " + game.getPlayerTown().getAmountGold());
    }
}
