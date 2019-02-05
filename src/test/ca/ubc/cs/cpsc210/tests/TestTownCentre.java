package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.ui.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTownCentre {
    Game game;

    @BeforeEach
    public void gameSetup() {
        game = new Game("Easy");

    }

    @Test
    public void centreSetup() {
        assertEquals(game.getPlayerTown().getFood(), 500);
        assertEquals(game.getPlayerTown().getGold(), 500);
        assertEquals(game.getPlayerTown().getPopulation(), 15);

        // assertTrue();
    }


    @Test
    public void centreSetup2() {
        assertEquals(game.getPlayerTown().getFood(), 500);
        assertEquals(game.getPlayerTown().getGold(), 500);
        game.getPlayerTown().procreateVillagers();
        assertEquals(game.getPlayerTown().getPopulation(), 16);

        // assertTrue();
    }

    //TODO: Check all the other methods
}