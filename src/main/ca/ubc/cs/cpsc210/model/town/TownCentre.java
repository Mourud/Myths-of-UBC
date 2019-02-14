package ca.ubc.cs.cpsc210.model.town;

import ca.ubc.cs.cpsc210.model.GameObjects;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.town.person.Registry;
import ca.ubc.cs.cpsc210.model.town.person.Soldier;
import ca.ubc.cs.cpsc210.model.town.person.Villager;

public class TownCentre implements GameObjects {

    // CONSTANTS

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

    // TODO: Change position of Town Centre?
    // TODO: Should Town Centre coordinates be public/ private?
        // TOWN CENTRE STATS
    public static final int posX = GameConstants.PLAYER_TOWN_POS_X;
    public static final int posY = GameConstants.PLAYER_TOWN_POS_Y;


    // FIELDS
    private int amountFood;
    private int amountGold;
    private Registry registry = new Registry();

    // REQUIRES: (startPop, startFood, startGold) > 0
    // MODIFIES: this
    // EFFECTS: constructs TownCentre with
    //  startFood amount of food,
    //  startGold amount of gold,
    //  startPop amount of Villagers
    public TownCentre(int startPop, int startFood, int startGold) {
        for (int i = 0; i < startPop; i++) {
            registry.add(new Villager(villagerMaxHealth,
                    villagerAttack,
                    villagerGatherRate,
                    0,
                    0,
                    this
            ));
        }
        amountFood = startFood;
        amountGold = startGold;
    }

    // TODO: Use exceptions
    // MODIFIES: this
    // EFFECTS: 1. adds new villager to the registry
    //          2. reduces amountFood by villagerFoodPrices
    public boolean procreateVillager() {
        if (amountFood >= villagerFoodPrice && amountGold >= villagerGoldPrice) {
            registry.add(new Villager(villagerMaxHealth,
                    villagerAttack,
                    villagerGatherRate,
                    makeNewPos(),
                    makeNewPos(),
                    this
            ));
            amountFood -= villagerFoodPrice;
            amountGold -= villagerGoldPrice;
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: 1. adds new villager to the registry
    //          2. reduces amountFood by villagerFoodPrices
    public boolean procreateSoldier() {
        if (amountFood >= soldierFoodPrice && amountGold >= soldierGoldPrice) {
            registry.add(new Soldier(
                    soldierMaxHealth,
                    soldierAttack,
                    soldierGatherRate,
                    0,
                    0,
                    this));
            amountFood -= soldierFoodPrice;
            amountGold -= soldierGoldPrice;
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: Generates random position values
    private int makeNewPos() {
        return 0;
    }


    public int getAmountFood() {
        return amountFood;
    }

    public void setAmountFood(int amountFood) {
        this.amountFood = amountFood;
    }

    public void setAmountGold(int amountGold) {
        this.amountGold = amountGold;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

//    public void decrementResounce(String resourceName) {
//
//    }

    public int getAmountGold() {
        return amountGold;
    }

    public Registry getRegistry() {
        return registry;
    }

    public int getPopSize() {
        return registry.size();
    }
}