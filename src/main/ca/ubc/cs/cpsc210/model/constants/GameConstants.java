package ca.ubc.cs.cpsc210.model.constants;


import ca.ubc.cs.cpsc210.model.Position;
import javafx.scene.paint.Color;

public class GameConstants {

    // CONSTANTS

        // GAME TITLE
    public static final String TITLE = "The Myths of UBC";
    // DISPLAY
    public static final int GAME_SCREEN_WIDTH = 1000;
    public static final int GAME_SCREEN_HEIGHT = 500;
    public static final Color PLAYER_COLOR = Color.BLUE;
    public static final Color ENEMY_COLOR = Color.RED;

    // TOWN CENTRE
    public static final int TOWN_SIZE = 150;
    // PLAYER
    public static final int PLAYER_TOWN_POS_X = 0;
    public static final int PLAYER_TOWN_POS_Y = GAME_SCREEN_HEIGHT - TOWN_SIZE;
    public static final Position PLAYER_TOWN_POS = new Position(PLAYER_TOWN_POS_X, PLAYER_TOWN_POS_Y);

    // ENEMY
    public static final int ENEMY_TOWN_POS_X = GAME_SCREEN_WIDTH - TOWN_SIZE;
    public static final int ENEMY_TOWN_POS_Y = 0;
    public static final Position ENEMY_TOWN_POS = new Position(ENEMY_TOWN_POS_X, ENEMY_TOWN_POS_Y);

    // ResourceHotSpot
    public static final int STARTING_RESOURCES = 500;
    public static final int RESOURCE_HOTSPOT_WIDTH = 150;
    public static final int RESOURCE_HOTSPOT_HEIGHT = 100;

    public static final Color FARM_COLOR = Color.GREEN;
    public static final Color GOLDMINE_COLOR = Color.YELLOW;
    public static final Color FARM_DEAD_COLOR = Color.SADDLEBROWN;
    public static final Color GOLDMINE_DEAD_COLOR = Color.GOLD;

    public static final int GOLD_MINE__POS_X = 0;
    public static final int GOLD_MINE__POS_Y = 0;
    public static final Position GOLD_MINE_POSITION =  new Position(GOLD_MINE__POS_X,GOLD_MINE__POS_Y);

    public static final int FARM__POS_X = GAME_SCREEN_WIDTH - RESOURCE_HOTSPOT_WIDTH;
    public static final int FARM__POS_Y = GAME_SCREEN_HEIGHT - RESOURCE_HOTSPOT_HEIGHT;
    public static final Position FARM_POSITION =  new Position(FARM__POS_X,FARM__POS_Y);


    // DIFFICULTY CONSTANTS

            // LEVEL1 SETTINGS
    public static final String LEVEL1 = "Easy";
    public static final int EASY_START_POP = 5;
    public static final int EASY_START_RESOURCES = 20;

            // LEVEL2 SETTING
    public static final String LEVEL2 = "Medium";
    public static final int MEDIUM_START_POP = 3;
    public static final int MEDIUM_START_RESOURCES = 10;

            // LEVEL3 SETTINGS
    public static final String LEVEL3 = "Hard";
    public static final int HARD_START_POP = 1;
    public static final int HARD_START_RESOURCES = 0;

        // PERSON CONSTANTS
    public static final int BIRTH_RADIUS = TOWN_SIZE;
    public static final Color PLAYER_PER_COLOR = Color.BLUEVIOLET;
    public static final Color ENEMY_PER_COLOR = Color.DARKRED;
            // VILLAGER
    public static final int VILLAGER_SIZE = 10;
    public static final int STARTING_MAX_HEALTH_VILLAGER = 50;
    public static final int STARTING_ATTACK_VILLAGER = 1;
    public static final int STARTING_GATHER_RATHER_VILLAGER = 5;
    public static final int STARTING_VILLAGER_FOOD_PRICE = 10;
    public static final int STARTING_VILLAGER_GOLD_PRICE = 0;

            // SOLDIER
    public static final int SOLDIER_SIZE = 20;
    public static final int STARTING_MAX_HEALTH_SOLDIER = 100;
    public static final int STARTING_ATTACK_SOLDIER = 10;
    public static final int STARTING_GATHER_RATHER_SOLDIER = 0;
    public static final int STARTING_SOLDIER_FOOD_PRICE = 10;
    public static final int STARTING_SOLDIER_GOLD_PRICE = 10;

    public static final int IS_IN_BLANK_CODE = 0;
    public static final int IS_IN_TOWN_CODE = 1;
    public static final int IS_OUT_OF_TOWN_CODE = 2;
    public static final int IS_IN_FARM_CODE = 3;
    public static final int IS_IN_GOLD_MINE_CODE = 4;
    public static final int IS_IN_WAR_CODE = 5;
    public static final int TOWN_REGEN_VALUE = 10;
}
