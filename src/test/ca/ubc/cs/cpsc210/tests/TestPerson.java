package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.model.person.Villager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPerson {
    // VILLAGER STATS
    private int villagerMaxHealth = GameConstants.STARTING_MAX_HEALTH_VILLAGER;
    private int villagerAttack = GameConstants.STARTING_ATTACK_VILLAGER;
    private int villagerGatherRate = GameConstants.STARTING_GATHER_RATHER_VILLAGER;
    private int villagerFoodPrice = GameConstants.STARTING_VILLAGER_FOOD_PRICE;
    private int villagerGoldPrice = GameConstants.STARTING_VILLAGER_GOLD_PRICE;

    // SOLDIER STATS
    private int soldierMaxHealth = GameConstants.STARTING_MAX_HEALTH_SOLDIER;
    private int soldierAttack = GameConstants.STARTING_ATTACK_SOLDIER;
    private int soldierGatherRate = GameConstants.STARTING_GATHER_RATHER_SOLDIER;
    private int soldierFoodPrice = GameConstants.STARTING_SOLDIER_FOOD_PRICE;
    private int soldierGoldPrice = GameConstants.STARTING_SOLDIER_GOLD_PRICE;
    Person p;

    @BeforeEach
    void setUp() {
        p = new Villager(
                1,
                villagerMaxHealth,
                villagerAttack,
                villagerGatherRate,
                0,
                0,
                null);
    }

    @Test
    void testConstructor() {
        assertEquals(p, new Villager(
                1,
                villagerMaxHealth,
                villagerAttack,
                villagerGatherRate,
                0,
                0,
null));    }

    void testWalk() {
        p.walk(1,2);

    }
}
