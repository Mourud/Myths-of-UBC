package ca.ubc.cs.cpsc210.ui;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.resourcehotspot.Farm;
import ca.ubc.cs.cpsc210.model.resourcehotspot.Forest;
import ca.ubc.cs.cpsc210.model.resourcehotspot.GoldMine;
import ca.ubc.cs.cpsc210.model.resourcehotspot.ResourceHotSpot;
import ca.ubc.cs.cpsc210.model.town.TownCentre;

public class Game {

    // CONSTANTS

    // LEVEL1 GAME SETTINGS
    public static final String LEVEL1 = GameConstants.LEVEL1;
    private static final int EASY_START_POP = GameConstants.EASY_START_POP;
    private static final int EASY_START_RESOURCES = GameConstants.EASY_START_RESOURCES;

    // LEVEL2 GAME SETTINGS
    public static final String LEVEL2 = GameConstants.LEVEL2;
    private static final int MEDIUM_START_POP = GameConstants.MEDIUM_START_POP;
    private static final int MEDIUM_START_RESOURCES = GameConstants.MEDIUM_START_RESOURCES;

    // LEVEL3 GAME SETTINGS
    public static final String LEVEL3 = GameConstants.LEVEL3;
    private static final int HARD_START_POP = GameConstants.HARD_START_POP;
    private static final int HARD_START_RESOURCES = GameConstants.HARD_START_RESOURCES;

    private TownCentre playerTown;
    private TownCentre enemyTown;
    private ResourceHotSpot goldMine;
    private ResourceHotSpot farm;
    private ResourceHotSpot forests;

    // REQUIRES:
    public Game(String difficulty) {
        if (difficulty.equals(LEVEL1)) {
            setTowns(EASY_START_POP, EASY_START_RESOURCES, EASY_START_RESOURCES);
        } else if (difficulty.equals(LEVEL2)) {
            setTowns(MEDIUM_START_POP, MEDIUM_START_RESOURCES, MEDIUM_START_RESOURCES);
        } else if (difficulty.equals(LEVEL3)) {
            setTowns(HARD_START_POP, HARD_START_RESOURCES, HARD_START_RESOURCES);
        }
        farm = new Farm();
        goldMine = new GoldMine();
        forests = new Forest();
    }

    public void setTowns(int pop, int food, int gold) {
        playerTown = new TownCentre(pop, food, gold);
        enemyTown = new TownCentre(pop, food, gold);
    }

    public TownCentre getEnemyTown() {
        return enemyTown;
    }

    public TownCentre getPlayerTown() {
        return playerTown;
    }
}