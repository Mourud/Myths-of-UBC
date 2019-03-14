package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.TownCentre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTownCentre {

    // CONSTANTS
    // LEVEL1 GAME SETTINGS
    private static final int EASY_START_POP = GameConstants.EASY_START_POP;
    private static final int EASY_START_RESOURCES = GameConstants.EASY_START_RESOURCES;

    // PRICES
    private static final int VILLAGER_FOOD_PRICE = GameConstants.STARTING_VILLAGER_FOOD_PRICE;
    private static final int SOLDIER_FOOD_PRICE = GameConstants.STARTING_SOLDIER_FOOD_PRICE;
    private static final int SOLDIER_GOLD_PRICE = GameConstants.STARTING_SOLDIER_GOLD_PRICE;

    private static final int NO_OF_VILLAGERS = EASY_START_RESOURCES/VILLAGER_FOOD_PRICE;
    private static final int NO_OF_SOLDIERS = EASY_START_RESOURCES/SOLDIER_FOOD_PRICE;

    private TownCentre myCentre;

    @BeforeEach
    public void TestTownCentreConstructor() {
        myCentre = new TownCentre(EASY_START_POP,EASY_START_RESOURCES,EASY_START_RESOURCES);

    }

    @Test
    public void centreSetup() {
        assertEquals(myCentre.getAmountFood(), EASY_START_RESOURCES);
        assertEquals(myCentre.getAmountGold(), EASY_START_RESOURCES);
        assertEquals(myCentre.getPopSize(), EASY_START_POP);
    }


    @Test
    public void testProcreateVillager() {
        assertTrue(myCentre.procreateVillager());
        assertEquals(myCentre.getPopSize(), EASY_START_POP + 1);
        assertEquals(myCentre.getAmountFood(), EASY_START_RESOURCES - VILLAGER_FOOD_PRICE);
    }

    @Test
    public void testProcreateMultipleVillager() {
        for (int i = 0; i < NO_OF_VILLAGERS; i++) {
            assertTrue(myCentre.procreateVillager());
//            System.out.println(i+"\t" + myCentre.getPopSize()+"\t"+myCentre.getAmountFood());

        }
        assertEquals(myCentre.getPopSize(), EASY_START_POP + NO_OF_VILLAGERS);
        assertEquals(myCentre.getAmountFood(), EASY_START_RESOURCES - NO_OF_VILLAGERS * VILLAGER_FOOD_PRICE);
    }

    @Test
    public void testProcreateMaxMultipleVillager() {
        for (int i = 0; i < (EASY_START_RESOURCES / VILLAGER_FOOD_PRICE); i++) {
            assertTrue(myCentre.procreateVillager());
//            System.out.println(i+"\t" + myCentre.getPopSize()+"\t"+myCentre.getAmountFood());
        }
        assertEquals(myCentre.getPopSize(), EASY_START_POP + (EASY_START_RESOURCES / VILLAGER_FOOD_PRICE));
        assertEquals(myCentre.getAmountFood(), 0);
    }

    @Test
    public void testProcreateMultipleVillagerNoFood() {
        for (int i = 0; i < (EASY_START_RESOURCES / VILLAGER_FOOD_PRICE); i++) {
            assertTrue(myCentre.procreateVillager());
        }
        assertFalse(myCentre.procreateVillager());
        assertEquals(myCentre.getPopSize(), EASY_START_POP + (EASY_START_RESOURCES / VILLAGER_FOOD_PRICE));
        assertEquals(myCentre.getAmountFood(), 0);
    }

    @Test
    public void testProcreateSoldier() {
        assertTrue(myCentre.procreateSoldier());
        assertEquals(myCentre.getPopSize(), EASY_START_POP + 1);
        assertEquals(myCentre.getAmountFood(), EASY_START_RESOURCES - SOLDIER_FOOD_PRICE);
        assertEquals(myCentre.getAmountGold(), EASY_START_RESOURCES - SOLDIER_GOLD_PRICE);

    }

    @Test
    public void testProcreateMultipleSoldier() {
        for (int i = 0; i < NO_OF_SOLDIERS; i++) {
            assertTrue(myCentre.procreateSoldier());
        }
        assertEquals(myCentre.getPopSize(), EASY_START_POP + NO_OF_SOLDIERS);
        assertEquals(myCentre.getAmountFood(), EASY_START_RESOURCES - NO_OF_SOLDIERS * SOLDIER_FOOD_PRICE);
        assertEquals(myCentre.getAmountGold(), EASY_START_RESOURCES - NO_OF_SOLDIERS * SOLDIER_GOLD_PRICE);

    }

    @Test
    public void testProcreateMaxMultipleSoldier() {
        for (int i = 0; i < (EASY_START_RESOURCES / SOLDIER_FOOD_PRICE); i++) {
            assertTrue(myCentre.procreateSoldier());
        }
        assertEquals(myCentre.getPopSize(), EASY_START_POP + (EASY_START_RESOURCES / SOLDIER_FOOD_PRICE));
        assertEquals(myCentre.getAmountGold(), EASY_START_RESOURCES - EASY_START_RESOURCES / SOLDIER_FOOD_PRICE * SOLDIER_GOLD_PRICE);
        assertEquals(myCentre.getAmountFood(), EASY_START_RESOURCES - EASY_START_RESOURCES / SOLDIER_FOOD_PRICE * SOLDIER_FOOD_PRICE);
    }

    @Test
    public void testProcreateMultipleSoldierNoFood() {
        for (int i = 0; i < (EASY_START_RESOURCES / SOLDIER_FOOD_PRICE); i++) {
            assertTrue(myCentre.procreateSoldier());
        }
        assertFalse(myCentre.procreateSoldier());
        assertEquals(myCentre.getPopSize(), EASY_START_POP + (EASY_START_RESOURCES / SOLDIER_FOOD_PRICE));
        assertEquals(myCentre.getAmountFood(), EASY_START_RESOURCES - EASY_START_RESOURCES / SOLDIER_FOOD_PRICE * SOLDIER_FOOD_PRICE);
        assertEquals(myCentre.getAmountGold(), EASY_START_RESOURCES - EASY_START_RESOURCES / SOLDIER_FOOD_PRICE * SOLDIER_GOLD_PRICE);
    }

    @Test
    public void getterAndSetters() {
        myCentre.getAmountFood();
        myCentre.getPopSize();
        myCentre.getAmountGold();
        myCentre.getRegistry();
        myCentre.setAmountFood(0);
        myCentre.setAmountGold(0);
    }

    @Test
    public void testGatherResource() {
        myCentre.gatherResource("G",1);
        myCentre.gatherResource("G",0);
        myCentre.gatherResource("F",1);
        myCentre.gatherResource("F",0);
    }
}