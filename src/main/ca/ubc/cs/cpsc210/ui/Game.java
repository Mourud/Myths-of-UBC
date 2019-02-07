package ca.ubc.cs.cpsc210.ui;

import ca.ubc.cs.cpsc210.model.resource.Farm;
import ca.ubc.cs.cpsc210.model.resource.Forrest;
import ca.ubc.cs.cpsc210.model.resource.GoldMine;
import ca.ubc.cs.cpsc210.model.resource.Resource;
import ca.ubc.cs.cpsc210.model.TownCentre;

public class Game {
    private static final int EASY_START_POP = 15;
    private static final int MEDIUM_START_POP = 10;
    private static final int HARD_START_POP = 5;
    private static final int EASY_START_RESOURCES = 500;
    private static final int MEDIUM_START_RESOURCES = 250;
    private static final int HARD_START_RESOURCES = 125;

    private TownCentre playerTown;
    private TownCentre enemyTown;
    private Resource goldMine;
    private Resource farm;
    private Resource forests;

    // Todo: redundant code? setTown?
    public Game(String difficulty) {
        if (difficulty.equals("Easy")) {
            playerTown = new TownCentre(EASY_START_POP, EASY_START_RESOURCES, EASY_START_RESOURCES);
            enemyTown = new TownCentre(EASY_START_POP, EASY_START_RESOURCES, EASY_START_RESOURCES);
        } else if (difficulty.equals("Medium")) {
            playerTown = new TownCentre(MEDIUM_START_POP, MEDIUM_START_RESOURCES, MEDIUM_START_RESOURCES);
            enemyTown = new TownCentre(MEDIUM_START_POP, MEDIUM_START_RESOURCES, MEDIUM_START_RESOURCES);
        } else if (difficulty.equals("Hard")) {
            playerTown = new TownCentre(HARD_START_POP, HARD_START_RESOURCES, HARD_START_RESOURCES);
            enemyTown = new TownCentre(HARD_START_POP, HARD_START_RESOURCES, HARD_START_RESOURCES);
        } else {
            System.out.println("Invalid Difficulty.");
        }
        farm = new Farm();
        goldMine = new GoldMine();
        forests = new Forrest();
    }

    public void setTowns() {
        playerTown = new TownCentre(EASY_START_POP, EASY_START_RESOURCES, EASY_START_RESOURCES);
        enemyTown = new TownCentre(EASY_START_POP, EASY_START_RESOURCES, EASY_START_RESOURCES);
    }

    public TownCentre getEnemyTown() {
        return enemyTown;
    }

    public TownCentre getPlayerTown() {
        return playerTown;
    }
}