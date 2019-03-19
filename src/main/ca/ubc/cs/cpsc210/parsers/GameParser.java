package ca.ubc.cs.cpsc210.parsers;

import ca.ubc.cs.cpsc210.model.Game;
import org.json.JSONObject;

public class GameParser {

    public static Game parse(String input) {
        Game game = new Game("s");
        JSONObject saveGame = new JSONObject(input);
        return game;

    }


}
