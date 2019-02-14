package ca.ubc.cs.cpsc210.model.constants;

public class GameConstants {

    // CONSTANTS

        // GAME TITLE
    public static final String TITLE = "The Myth";

        // DIFFICULTY CONSTANTS

            // LEVEL1 SETTINGS
    public static final String LEVEL1 = "Easy";
    public static final int EASY_START_POP = 15;
    public static final int EASY_START_RESOURCES = 500;

            // LEVEL2 SETTING
    public static final String LEVEL2 = "Medium";
    public static final int MEDIUM_START_POP = 10;
    public static final int MEDIUM_START_RESOURCES = 250;

            // LEVEL3 SETTINGS
    public static final String LEVEL3 = "Hard";
    public static final int HARD_START_POP = 5;
    public static final int HARD_START_RESOURCES = 125;

        // PERSON CONSTANTS

            // VILLAGER
    public static final int STARTING_MAX_HEALTH_VILLAGER = 50;
    public static final int STARTING_ATTACK_VILLAGER = 1;
    public static final int STARTING_GATHER_RATHER_VILLAGER = 1;
    public static final int STARTING_VILLAGER_FOOD_PRICE = 100;
    public static final int STARTING_VILLAGER_GOLD_PRICE = 0;

            // SOLDIER
    public static final int STARTING_MAX_HEALTH_SOLDIER = 100;
    public static final int STARTING_ATTACK_SOLDIER = 5;
    public static final int STARTING_GATHER_RATHER_SOLDIER = 0;
    public static final int STARTING_SOLDIER_FOOD_PRICE = 10;
    public static final int STARTING_SOLDIER_GOLD_PRICE = 10;

        // TOWN CENTRE CONSTANTS

            // PLAYER
    public static final int PLAYER_TOWN_POS_X = 0;
    public static final int PLAYER_TOWN_POS_Y = 0;

    // TODO: Change enemy position to other end of screen
            // ENEMY
    public static final int ENEMY_TOWN_POS_X = 0;
    public static final int ENEMY_TOWN_POS_Y = 0;

}
