package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.model.person.Registry;
import ca.ubc.cs.cpsc210.model.person.Soldier;
import ca.ubc.cs.cpsc210.model.person.Villager;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TownCentre implements GameObject {

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

    // FIELDS
    private int amountFood;
    private int amountGold;
    //TODO: Map for ID?
    private Registry registry = new Registry();
    private int personID = 0;

    // REQUIRES: (startPop, startFood, startGold) > 0
    // MODIFIES: this
    // EFFECTS: constructs TownCentre with
    //  startFood amount of food,
    //  startGold amount of gold,
    //  startPop amount of Villagers

    public TownCentre(int startPop, int startFood, int startGold) {
        for (int i = 0; i < startPop; i++) {
            personID++;
            registry.add(new Villager(
                    personID,
                    villagerMaxHealth,
                    villagerAttack,
                    villagerGatherRate,
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
    public boolean procreateVillager() /*throws NegativeResourceException */ {
        if (amountFood >= villagerFoodPrice && amountGold >= villagerGoldPrice) {
            personID++;
            registry.add(new Villager(
                    personID,
                    villagerMaxHealth,
                    villagerAttack,
                    villagerGatherRate,
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
    // EFFECTS: 1. adds new soldier to the registry
    //          2. reduces amountFood by soldierFoodPrices
    public boolean procreateSoldier() {
        if (amountFood >= soldierFoodPrice && amountGold >= soldierGoldPrice) {
            personID++;
            registry.add(new Soldier(
                    personID,
                    soldierMaxHealth,
                    soldierAttack,
                    soldierGatherRate,
                    this));
            amountFood -= soldierFoodPrice;
            amountGold -= soldierGoldPrice;
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds resource to the current resourceAmount
    //          reduces resources in ResourceHotSpot
    public void gatherResource(String resourceName, int gatherRate) {
        if (gatherRate != 0) {
            if (resourceName.equals("G")) {
                amountGold += gatherRate;
                Game.goldMine.decrementResourceLeft(gatherRate);
            } else if (resourceName.equals("F")) {
                amountFood += gatherRate;
                Game.farm.decrementResourceLeft(gatherRate);
            } else {
                System.out.println("INVALID");
            }
        } else {
            System.out.println("Can't gather");
        }
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

    public int getAmountGold() {
        return amountGold;
    }

    public Registry getRegistry() {
        return registry;
    }

    public int getPopSize() {
        return registry.size();
    }

    public int getPersonID() {
        return personID;
    }

//    public List getPersons() {
//        return (List) Collections.unmodifiableList(registry);
//    }

}
