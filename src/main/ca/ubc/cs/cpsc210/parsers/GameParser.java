package ca.ubc.cs.cpsc210.parsers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import org.json.JSONObject;

public class GameParser {


    public static Game parse(String input) {
        JSONObject savedGame = new JSONObject(input);
        Game game = new Game(savedGame);
        return game;
    }


}
