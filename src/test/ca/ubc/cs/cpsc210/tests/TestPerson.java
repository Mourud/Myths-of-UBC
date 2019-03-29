package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.model.person.Soldier;
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

    private TownCentre town = new TownCentre(0, 0, 0, true);
    Person v;
    Person s;

    @BeforeEach
    void setUp() {
        v = new Villager(
                1,
                villagerMaxHealth,
                villagerAttack,
                villagerGatherRate,
                town);
        s = new Soldier(2,
                soldierMaxHealth,
                soldierAttack,
                soldierGatherRate,
                town);
    }

    @Test
    void testConstructor() {
        assertEquals(v, new Villager(
                1,
                villagerMaxHealth,
                villagerAttack,
                villagerGatherRate,
                town));
    }

    @Test
    void testWalk() {
        v.walkTo(1, 2);

    }

    @Test
    void getHealthLabel() {
        v.getHealthLabel();

    }


    @Test
    void gatherResource() {
        v.gatherResource("G");
        v.gatherResource("F");
        v.gatherResource("A");
    }

    @Test
    void attack() {
        v.attack(s);
    }

    @Test
    void decreaseHealth() {
        s.decreaseHealth(villagerAttack);
    }

    @Test
    void getHealth() {
        s.getHealth();
    }

    @Test
    void getCurMaxHealth() {
        s.getCurMaxHealth();
    }

    @Test
    void getAttack() {
        s.getAttack();
    }


    @Test
    void getID() {
        s.getID();
    }

    @Test
    void getGatherRate() {
        s.getGatherRate();
    }

    @Test
    void isNearResource() {
        s.isNearResource();
    }

    @Test
    void getPos() {
        s.getPos();
    }

    @Test
    void isSoldier() {
        s.isSoldier();
    }

//    @Test
//    void isWithinPos() {
//        s.isWithinPos(s.getPos(), 1,2);
//    }
//
//    @Test
//    void getPersonGameZone() {
//        s.getPersonGameZone();
//    }
//

    @Test
    void regenerate() {
        v.regenerate();
    }

//    @Test
//    void penalty() {
//        v.
//    }

    @Test
    void updateLabel() {
    }
}
