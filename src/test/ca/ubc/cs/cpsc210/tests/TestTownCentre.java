package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.ui.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTownCentre {

    private static final int EASY_START_POP = 15;
    private static final int MEDIUM_START_POP = 10;
    private static final int HARD_START_POP = 5;
    private static final int EASY_START_RESOURCES = 500;
    private static final int MEDIUM_START_RESOURCES = 250;
    private static final int HARD_START_RESOURCES = 125;
    private TownCentre myCentre;

    @BeforeEach
    public void TestTownCentreConstructor() {
        myCentre = new TownCentre(EASY_START_POP,EASY_START_RESOURCES,EASY_START_RESOURCES);

    }

    @Test
    public void centreSetup() {
        assertEquals(myCentre.getFood(), 500);
        assertEquals(myCentre.getGold(), 500);
        assertEquals(myCentre.getPopulation(), 15);

        // assertTrue();
    }


    @Test
    public void centreSetup2() {
        assertEquals(myCentre.getFood(), 500);
        assertEquals(myCentre.getGold(), 500);
        myCentre.procreateVillagers();
        assertEquals(myCentre.getPopulation(), 16);

        // assertTrue();
    }

    //TODO: Check all the other methods
}