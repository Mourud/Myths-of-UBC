package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// TODO:(IMP) How to check coverage)

public class TestGame {

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
    private static final String LEVEL3 = GameConstants.LEVEL3;
    private static final int HARD_START_POP = GameConstants.HARD_START_POP;
    private static final int HARD_START_RESOURCES = GameConstants.HARD_START_RESOURCES;

    // Fields
    private Game game;

    // TESTS EASY GAME
    @Test
    void testGameEasy() {
        game = new Game(LEVEL1);
        assertEquals(game.getPlayerTown().getPopSize(), EASY_START_POP);
        assertEquals(game.getPlayerTown().getAmountFood(), EASY_START_RESOURCES);
        assertEquals(game.getPlayerTown().getAmountGold(), EASY_START_RESOURCES);
        assertEquals(game.getEnemyTown().getPopSize(), EASY_START_POP);
        assertEquals(game.getEnemyTown().getAmountFood(), EASY_START_RESOURCES);
        assertEquals(game.getEnemyTown().getAmountGold(), EASY_START_RESOURCES);
    }

    // TESTS MEDIUM GAME
    @Test
    void testGameMedium() {
        game = new Game(LEVEL2);
        assertEquals(game.getPlayerTown().getPopSize(), MEDIUM_START_POP);
        assertEquals(game.getPlayerTown().getAmountFood(), MEDIUM_START_RESOURCES);
        assertEquals(game.getPlayerTown().getAmountGold(), MEDIUM_START_RESOURCES);
        assertEquals(game.getEnemyTown().getPopSize(), MEDIUM_START_POP);
        assertEquals(game.getEnemyTown().getAmountFood(), MEDIUM_START_RESOURCES);
        assertEquals(game.getEnemyTown().getAmountGold(), MEDIUM_START_RESOURCES);
    }

    // TESTS HARD GAME
    @Test
    void testGameHard() {
        game = new Game(LEVEL3);
        assertEquals(game.getPlayerTown().getPopSize(), HARD_START_POP);
        assertEquals(game.getPlayerTown().getAmountFood(), HARD_START_RESOURCES);
        assertEquals(game.getPlayerTown().getAmountGold(), HARD_START_RESOURCES);
        assertEquals(game.getEnemyTown().getPopSize(), HARD_START_POP);
        assertEquals(game.getEnemyTown().getAmountFood(), HARD_START_RESOURCES);
        assertEquals(game.getEnemyTown().getAmountGold(), HARD_START_RESOURCES);
    }

    @Test
    void testSetTown(){
        game = new Game(LEVEL1);
        assertEquals(game.getPlayerTown().getPopSize(), EASY_START_POP);
        assertEquals(game.getPlayerTown().getAmountFood(), EASY_START_RESOURCES);
        assertEquals(game.getPlayerTown().getAmountGold(), EASY_START_RESOURCES);
        assertEquals(game.getEnemyTown().getPopSize(), EASY_START_POP);
        assertEquals(game.getEnemyTown().getAmountFood(), EASY_START_RESOURCES);
        assertEquals(game.getEnemyTown().getAmountGold(), EASY_START_RESOURCES);

    }
}
