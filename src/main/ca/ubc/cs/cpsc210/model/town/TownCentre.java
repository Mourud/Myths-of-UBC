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
    // SOLDIER STATS
    private int soldierMaxHealth = GameConstants.STARTING_MAX_HEALTH_SOLDIER;
    private int soldierAttack = GameConstants.STARTING_ATTACK_SOLDIER;
    private int soldierGatherRate = GameConstants.STARTING_GATHER_RATHER_SOLDIER;
    private int soldierFoodPrice = GameConstants.STARTING_SOLDIER_FOOD_PRICE;
    private int soldierGoldPrice = GameConstants.STARTING_SOLDIER_GOLD_PRICE;


    private int amountFood;
    private int amountGold;
    private Registry registry = new Registry();

    // TODO: Set poplimit?
    // TODO change posX and posY
    public TownCentre(int startPop, int startFood, int startGold) {
        for (int i = 0; i < startPop; i++) {
            registry.add(new Villager(villagerMaxHealth,
                    villagerAttack,
                    0,
                    0,
                    this
            ));
        }
        amountFood = startFood;
        amountGold = startGold;
    }

    // TODO: Use exceptions
    // TODO : NOT STARTING VALUES
    public boolean procreateVillager() {
        if (amountFood >= soldierFoodPrice && amountGold >= soldierGoldPrice) {
            registry.add(new Villager(villagerMaxHealth,
                    villagerAttack,
                    0,
                    0,
                    this
            ));
            amountFood -= villagerFoodPrice;
            return true;
        } else {
            return false;
        }
    }


    public boolean procreateSoldier() {
        if (amountFood >= soldierFoodPrice && amountGold >= soldierGoldPrice) {
            registry.add(new Soldier(
                    soldierMaxHealth,
                    soldierAttack,
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
