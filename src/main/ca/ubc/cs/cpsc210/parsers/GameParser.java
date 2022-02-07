package ca.ubc.cs.cpsc210.parsers;

import ca.ubc.cs.cpsc210.model.Game;
import org.json.JSONObject;

public class GameParser {


    public static Game parse(String input) {
        JSONObject savedGame = new JSONObject(input);
        return new Game(savedGame);
    }


}
