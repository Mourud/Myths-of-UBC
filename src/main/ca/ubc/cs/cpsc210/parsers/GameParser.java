package ca.ubc.cs.cpsc210.parsers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import org.json.JSONObject;

public class GameParser {

    private static final String CUSTOM= GameConstants.CUSTOM;

    public static Game parse(String input) {
        Game game = new Game(CUSTOM);
        JSONObject saveGame = new JSONObject(input);
        return game;
    }


}
