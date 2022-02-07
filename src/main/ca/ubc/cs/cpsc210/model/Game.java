package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.resourcehotspot.Farm;
import ca.ubc.cs.cpsc210.model.resourcehotspot.GoldMine;
import ca.ubc.cs.cpsc210.model.resourcehotspot.ResourceHotSpot;
import org.json.JSONObject;

import java.util.Objects;

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


    //fields
    public static ResourceHotSpot goldMine;
    public static ResourceHotSpot farm;
    private TownCentre playerTown;
    private int playerTurnCount;
    private TownCentre enemyTown;
    private int enemyTurnCount;
    private boolean isPlayerTurn;

    public void setTurnsPlayed(int turnsPlayed) {
        this.turnsPlayed = turnsPlayed;
    }

    private int turnsPlayed;

    public void setPlayerTurn(boolean bool) {
        isPlayerTurn = bool;
    }


    public int getPlayerTurnCount() {
        return playerTurnCount;
    }

    public int getEnemyTurnCount() {
        return enemyTurnCount;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    // REQUIRES: valid difficulty
    // MODIFIES: this
    // EFFECTS: makes game depending on difficulty
    public Game(String difficulty) {
        switch (difficulty) {
            case LEVEL1:
                setupGame(EASY_START_POP, EASY_START_RESOURCES, EASY_START_RESOURCES);
                break;
            case LEVEL2:
                setupGame(MEDIUM_START_POP, MEDIUM_START_RESOURCES, MEDIUM_START_RESOURCES);
                break;
            case LEVEL3:
                setupGame(HARD_START_POP, HARD_START_RESOURCES, HARD_START_RESOURCES);
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    public Game(JSONObject j) {
        setupGame(j);
    }

    // REQUIRES: (pop, food, gold) >= 0
    // EFFECTS: sets game with give population, food
    private void setupGame(int pop, int food, int gold) {
        isPlayerTurn = true;
        turnsPlayed = 0;
        playerTown = new TownCentre(pop, food, gold, true);
        enemyTown = new TownCentre(pop, food, gold, false);

        goldMine = new GoldMine();
        farm = new Farm();
    }

    private void setupGame(JSONObject j) {

        isPlayerTurn = j.getBoolean("isPlayerTurn");

        turnsPlayed = j.getInt("turnsPlayed");

        JSONObject playerTownJson = j.getJSONObject("playerTown");
        playerTown = new TownCentre(playerTownJson);
        JSONObject enemyTownJson = j.getJSONObject("enemyTown");
        enemyTown = new TownCentre(enemyTownJson);

        JSONObject goldMineJson = j.getJSONObject("goldMine");
        goldMine = new GoldMine(goldMineJson);
        JSONObject farmJson = j.getJSONObject("farm");
        farm = new Farm(farmJson);

    }

    public ResourceHotSpot getFarm() {
        return farm;
    }

    public ResourceHotSpot getGoldMine() {
        return goldMine;
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

    public void initializeCounter() {
        turnsPlayed = 0;
    }

    public int getTurnsPlayed() {
        return turnsPlayed;
    }

    public void incrementCounter() {
        turnsPlayed++;
    }

    public void updateTowns() {
        getPlayerTown().getRegistry().update();
        getEnemyTown().getRegistry().update();
    }
}