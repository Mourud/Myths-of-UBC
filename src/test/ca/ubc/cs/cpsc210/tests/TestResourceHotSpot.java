package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.resourcehotspot.Farm;
import ca.ubc.cs.cpsc210.model.resourcehotspot.GoldMine;
import ca.ubc.cs.cpsc210.model.resourcehotspot.ResourceHotSpot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestResourceHotSpot {

    private static final int STARTING_GATHER_RATE_VILLAGER = GameConstants.STARTING_GATHER_RATHER_VILLAGER;
    private static final int STARTING_RESOURCES = GameConstants.STARTING_RESOURCES;
    private static final int GATHER_TIME = STARTING_RESOURCES / (2 * STARTING_GATHER_RATE_VILLAGER);
    private static final int EXCESS_GATHER_TIME = STARTING_RESOURCES / STARTING_GATHER_RATE_VILLAGER;

    private ResourceHotSpot farm;
    private ResourceHotSpot forest;
    private ResourceHotSpot goldMine;

    @BeforeEach
    public void setUp() {
        farm = new Farm();
        goldMine = new GoldMine();
        //forest=new Forest();

    }


    @Test
    public void testConstructor() {
        assertEquals(farm, new Farm());
        assertEquals(goldMine, new GoldMine());
    }

    @Test
    public void testDecrementResourceLeft() {
        for (int i = 0; i < GATHER_TIME; i++) {
            farm.decrementResourceLeft(STARTING_GATHER_RATE_VILLAGER);
            goldMine.decrementResourceLeft(STARTING_GATHER_RATE_VILLAGER);
        }
        assertEquals(STARTING_RESOURCES - GATHER_TIME * STARTING_GATHER_RATE_VILLAGER, farm.getResourceRemaining());
        assertEquals(STARTING_RESOURCES - GATHER_TIME * STARTING_GATHER_RATE_VILLAGER, goldMine.getResourceRemaining());
    }

    @Test
    public void testDecrementResourceLeftNoResource() {
        for (int i = 0; i < EXCESS_GATHER_TIME; i++) {
            assertTrue(farm.decrementResourceLeft(STARTING_GATHER_RATE_VILLAGER));
            assertTrue(goldMine.decrementResourceLeft(STARTING_GATHER_RATE_VILLAGER));
        }
        assertFalse(farm.decrementResourceLeft(STARTING_GATHER_RATE_VILLAGER));
        assertFalse(goldMine.decrementResourceLeft(STARTING_GATHER_RATE_VILLAGER));
        assertEquals(0, farm.getResourceRemaining());
        assertEquals(0, goldMine.getResourceRemaining());
    }
}