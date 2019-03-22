package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.resourcehotspot.Farm;
import ca.ubc.cs.cpsc210.model.resourcehotspot.GoldMine;
import ca.ubc.cs.cpsc210.model.resourcehotspot.ResourceHotSpot;
import ca.ubc.cs.cpsc210.persistence.JSonifier;
import org.json.JSONObject;

import java.util.Objects;

//TODO: Json parsers
//TODO: Complete testing and documenting
public class Game {

    // CONSTANTS

    // LEVEL1 GAME SETTINGS
    private static final String LEVEL1 = GameConstants.LEVEL1;
    private static final int EASY_START_POP = GameConstants.EASY_START_POP;
    private static final int EASY_START_RESOURCES = GameConstants.EASY_START_RESOURCES;

    // LEVEL2 GAME SETTINGS
    private static final String LEVEL2 = GameConstants.LEVEL2;
    private static final int MEDIUM_START_POP = GameConstants.MEDIUM_START_POP;
    private static final int MEDIUM_START_RESOURCES = GameConstants.MEDIUM_START_RESOURCES;

    // LEVEL3 GAME SETTINGS
    public static final String LEVEL3 = GameConstants.LEVEL3;
    private static final int HARD_START_POP = GameConstants.HARD_START_POP;
    private static final int HARD_START_RESOURCES = GameConstants.HARD_START_RESOURCES;

    // LOAD GAME
    public static final String CUSTOM = GameConstants.CUSTOM;

    //fields
    public static ResourceHotSpot goldMine = new GoldMine();
    public static ResourceHotSpot farm = new Farm();
    private  TownCentre playerTown;
    private  TownCentre enemyTown;

    //try catch
    // REQUIRES: valid difficulty
    // MODIFIES: this
    // EFFECTS: makes game depending on difficulty
    public Game(String difficulty) {
        if (difficulty.equals(LEVEL1)) {
            setTowns(EASY_START_POP, EASY_START_RESOURCES, EASY_START_RESOURCES);
        } else if (difficulty.equals(LEVEL2)) {
            setTowns(MEDIUM_START_POP, MEDIUM_START_RESOURCES, MEDIUM_START_RESOURCES);
        } else if (difficulty.equals(LEVEL3)) {
            setTowns(HARD_START_POP, HARD_START_RESOURCES, HARD_START_RESOURCES);
        } //else if (difficulty.equals(CUSTOM)) { }
        else {
            System.out.println("Invalid");
        }
        //forests = new Forest();
    }

    // REQUIRES: (pop, food, gold) >= 0
    // EFFECTS: sets game with give population, food
    private void setTowns(int pop, int food, int gold) {
        playerTown = new TownCentre(pop, food, gold);
        enemyTown = new TownCentre(pop, food, gold);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts game to JSON object
    public void saveGame(){
        JSONObject savedGame = JSonifier.gameToJson(this);
    }


    public TownCentre getEnemyTown() {
        return enemyTown;
    }

    public TownCentre getPlayerTown() {
        return playerTown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game)) {
            return false;
        }
        Game game = (Game) o;
        return Objects.equals(playerTown, game.playerTown)
                && Objects.equals(enemyTown, game.enemyTown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerTown, enemyTown);
    }
}