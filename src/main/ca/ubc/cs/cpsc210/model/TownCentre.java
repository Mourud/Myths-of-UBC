package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import ca.ubc.cs.cpsc210.model.person.Person;
import ca.ubc.cs.cpsc210.model.person.Registry;
import ca.ubc.cs.cpsc210.model.person.Soldier;
import ca.ubc.cs.cpsc210.model.person.Villager;
import javafx.scene.paint.Color;
import org.json.JSONArray;
import org.json.JSONObject;

public class TownCentre extends GameObject {

    // CONSTANTS

    private static final int IS_IN_WAR = GameConstants.IS_IN_WAR_CODE;
    private static final int IS_IN_TOWN = GameConstants.IS_IN_TOWN_CODE;
    private static final int IS_OUT_OF_TOWN = GameConstants.IS_OUT_OF_TOWN_CODE;
    private static final int IS_IN_FARM = GameConstants.IS_IN_FARM_CODE;
    private static final int IS_IN_GOLD_MINE = GameConstants.IS_IN_GOLD_MINE_CODE;

    // TOWN CENTER
    private static final Position PLAYER_POS = GameConstants.PLAYER_TOWN_POS;
    private static final Position ENEMY_POS = GameConstants.ENEMY_TOWN_POS;
    private static final int SIZE = GameConstants.TOWN_SIZE;
    private static final Color PLAYER_COLOR = GameConstants.PLAYER_COLOR;
    private static final Color ENEMY_COLOR = GameConstants.ENEMY_COLOR;

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
    private Registry registry;
    private int personID = 0;
    private boolean isPlayer;
    private Color color;

    public boolean isPlayer() {
        return isPlayer;
    }
// REQUIRES: (startPop, startFood, startGold) > 0
    // MODIFIES: this
    // EFFECTS: constructs TownCentre with
    //  startFood amount of food,
    //  startGold amount of gold,
    //  startPop amount of Villagers

    public TownCentre(int startPop, int startFood, int startGold, boolean isPlayer) {
        super(SIZE, SIZE);
        this.isPlayer = isPlayer;
        if (isPlayer) {
            color = PLAYER_COLOR;
            setFill(PLAYER_COLOR);
            setPos(PLAYER_POS);
        } else {
            color = ENEMY_COLOR;
            setFill(ENEMY_COLOR);
            setPos(ENEMY_POS);
        }
        registry = new Registry();
        for (int i = 0; i < startPop; i++) {
            personID++;
            registry.born(new Villager(
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


    public TownCentre(JSONObject j) {
        super(SIZE, SIZE);
        isPlayer = j.getBoolean("isPlayer");
        if (isPlayer) {
            setFill(PLAYER_COLOR);
            setPos(PLAYER_POS);
        } else {
            setFill(ENEMY_COLOR);
            setPos(ENEMY_POS);
        }
        amountFood = j.getInt("amountFood");
        amountGold = j.getInt("amountGold");
        personID = j.getInt("personID");
        JSONArray registryJson = j.getJSONArray("registry");
        registry = new Registry();
        for (Object object : registryJson) {
            JSONObject personJson = (JSONObject) object;
            int idJson = personJson.getInt("id");
            int healthJson = personJson.getInt("Health");
            int curMaxHealthJson = personJson.getInt("curMaxHealth");
            int attackJson = personJson.getInt("attack");
            int gatherRateJson = personJson.getInt("gatherRate");
            int posXJson = personJson.getInt("posX");
            int posYJson = personJson.getInt("posY");
            Position positionJson = new Position(posXJson, posYJson);
            boolean nearResourceJson = personJson.getBoolean("nearResource");
            boolean isSoldierJson = personJson.getBoolean("isSoldier");
            if (!isSoldierJson) {
                registry.born(
                        new Villager(idJson,
                                healthJson,
                                curMaxHealthJson,
                                attackJson,
                                gatherRateJson,
                                positionJson,
                                nearResourceJson,
                                this));
            } else {
                registry.born(
                        new Soldier(idJson,
                                healthJson,
                                curMaxHealthJson,
                                attackJson,
                                gatherRateJson,
                                positionJson,
                                nearResourceJson,
                                this));
            }
        }
    }


    // TODO: Use exceptions
    // MODIFIES: this
    // EFFECTS: 1. adds new villager to the registry
    //          2. reduces amountFood by villagerFoodPrices
    public boolean procreateVillager() /*throws NegativeResourceException */ {
        if (amountFood >= villagerFoodPrice && amountGold >= villagerGoldPrice) {
            personID++;
            registry.born(new Villager(
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
            registry.born(new Soldier(
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

    public Person findPerson(Position position) {
        for (Person person : registry) {
            if (person.isInRange(position)) {
                return person;
            }

        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: adds resource to the current resourceAmount
    //          reduces resources in ResourceHotSpot
    public void gatherResource(String resourceName, int gatherRate) {
        if (gatherRate != 0) {
            if (resourceName.equals("G")) {
                if (Game.goldMine.decrementResourceLeft(gatherRate)) {
                    amountGold += gatherRate;
                }
            } else if (resourceName.equals("F")) {
                if (Game.farm.decrementResourceLeft(gatherRate)) {
                    amountFood += gatherRate;
                }
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
        return registry.population();
    }

    public int getPersonID() {
        return personID;
    }

    public void incrementResources() {

        for (Person p : registry) {
            int zone = p.getPersonGameZone();
            switch (zone) {
                case IS_IN_FARM:
                    p.gatherResource("F");
                    break;
                case IS_IN_GOLD_MINE:
                    p.gatherResource("G");
                    break;
                default:
                    doNothing();

            }
        }
    }

    private void doNothing() {
    }
}