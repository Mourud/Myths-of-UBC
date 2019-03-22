package ca.ubc.cs.cpsc210.parsers;

import ca.ubc.cs.cpsc210.model.Game;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import org.json.JSONObject;

public class GameParser {

    private static final String CUSTOM= GameConstants.CUSTOM;

    public static Game parse(String input) {
        Game game = new Game(CUSTOM);
        JSONObject savedGame = new JSONObject(input);


        System.out.println("This is what I print:"+savedGame);
//        saveGame.put("playerTown",townToJson(g.getPlayerTown()));
//        saveGame.put("enemyTown",townToJson(g.getEnemyTown()));
//        saveGame.put("goldMine", resourceHotSpotToJson(Game.goldMine));
//        saveGame.put("farm",resourceHotSpotToJson(Game.farm));

//        JSONObject pTownJson = (JSONObject)
        return game;
    }


}
