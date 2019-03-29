package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class Person extends GameObject {
    private static final Color PLAYER_COLOR = GameConstants.PLAYER_PER_COLOR;
    private static final Color ENEMY_COLOR = GameConstants.ENEMY_PER_COLOR;

    private static final int IS_IN_BLANK = GameConstants.IS_IN_BLANK_CODE;
    private static final int IS_IN_TOWN = GameConstants.IS_IN_TOWN_CODE;
    private static final int IS_OUT_OF_TOWN = GameConstants.IS_OUT_OF_TOWN_CODE;
    private static final int IS_IN_FARM = GameConstants.IS_IN_FARM_CODE;
    private static final int IS_IN_GOLD_MINE = GameConstants.IS_IN_GOLD_MINE_CODE;
    private static final int TOWN_REGEN_VALUE = GameConstants.TOWN_REGEN_VALUE;


    private boolean isSoldier;
    private int id;
    private int curMaxHealth;
    private int health;
    private int attack;
    private Position pos;
    private int gatherRate;
    protected TownCentre myTown;
    private boolean nearResource;
    private Label healthLabel;


    public Label getHealthLabel() {
        return healthLabel;
    }

    public Person(boolean isSoldier, int size, int id, int curMaxHealth, int attack, int gatherRate, TownCentre t) {
        super(size, size);
        if (t.isPlayer()) {
            setFill(PLAYER_COLOR);
            pos = new Position(0, 0);
            pos.random(true);
        } else {
            setFill(ENEMY_COLOR);
            pos = new Position(0, 0);
            pos.random(false);
        }
        this.isSoldier = isSoldier;
        this.id = id;
        this.curMaxHealth = curMaxHealth;
        this.health = curMaxHealth;
        this.attack = attack;
        this.gatherRate = gatherRate;
        healthLabel = new Label(this.health + "");
        myTown = t;
        nearResource = false;
        setPos();

    }

    public Person(boolean isSoldier, int id, int size, int health, int curMaxHealth, int attack, int gatherRate,
                  Position position, boolean nearResource, TownCentre t) {
        super(size, size);
        if (t.isPlayer()) {
            setFill(PLAYER_COLOR);
        } else {
            setFill(ENEMY_COLOR);
        }
        this.isSoldier = isSoldier;
        this.id = id;
        this.curMaxHealth = curMaxHealth;
        this.health = health;
        this.attack = attack;
        this.gatherRate = gatherRate;
        pos = position;
        myTown = t;
        this.nearResource = nearResource;
        healthLabel = new Label(this.health + "");
        setPos();
    }

    // MODIFIES: this
    // EFFECTS: changes the position of player
    public void walkTo(int x, int y) {
        pos.changePos(x, y);
        setPos();
    }


    // TODO: Finish this Implement Hashmap
// REQUIRES:
// MODIFIES: myTown
// EFFECTS: increases amount of resource that it's in contact with
    public void gatherResource(String s) {
        myTown.gatherResource(s, gatherRate);
    }


    // MODIFIES: param enemy
// EFFECTS: decreases enemy health
    public void attack(Person enemy) {
        enemy.decreaseHealth(attack);
    }


    public void decreaseHealth(int attackRate) {
        health -= attackRate;
        setPos();
        if (health <= 0) {
            health = 0;
            this.die();
        }
    }

    private void die() {
        myTown.getRegistry().die(this);
    }


    // MODIFIES: this
    // EFFECTS: getters and setters for given field
    public int getHealth() {
        return health;
    }

    public int getCurMaxHealth() {
        return curMaxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getID() {
        return id;
    }

    public int getGatherRate() {
        return gatherRate;
    }

    public boolean isNearResource() {
        return nearResource;
    }

    public Position getPos() {
        return pos;
    }

    public boolean isSoldier() {
        return isSoldier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id
                && myTown.equals(person.myTown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, myTown);
    }


    public abstract boolean isInRange(Position position);


    public boolean isWithinPos(Position position, int size) {
        int mouseX = position.getPosX();
        int mouseY = position.getPosY();

        return withinX(mouseX, size) && withinY(mouseY, size);
    }

    private boolean isWithinPos(int place) {
        switch (place) {
            case IS_IN_TOWN:
                return isInTown();
            case IS_IN_FARM:
                return isInFarm();
            case IS_IN_GOLD_MINE:
                return isInMine();
            case IS_OUT_OF_TOWN:
                if (myTown.getTranslateX() == GameConstants.PLAYER_TOWN_POS_X) {
                    return isOutOfTownPlayer();
                } else {
                    return isOutOfTownEnemy();
                }
            default:
                return false;
        }
    }

    private boolean isOutOfTownEnemy() {
        return isWithinX(GameConstants.PLAYER_TOWN_POS_X, GameConstants.TOWN_SIZE, GameConstants.TOWN_SIZE)
                && isWithinY(GameConstants.PLAYER_TOWN_POS_Y, GameConstants.TOWN_SIZE, GameConstants.TOWN_SIZE);
    }

    private boolean isOutOfTownPlayer() {
        return isWithinX(GameConstants.ENEMY_TOWN_POS_X, GameConstants.TOWN_SIZE, GameConstants.TOWN_SIZE)
                && isWithinY(GameConstants.ENEMY_TOWN_POS_Y, GameConstants.TOWN_SIZE, GameConstants.TOWN_SIZE);
    }

    private boolean isInMine() {
        return isWithinX(GameConstants.GOLD_MINE__POS_X, GameConstants.RESOURCE_HOTSPOT_WIDTH,
                GameConstants.RESOURCE_HOTSPOT_HEIGHT)
                && isWithinY(GameConstants.GOLD_MINE__POS_Y, GameConstants.RESOURCE_HOTSPOT_WIDTH,
                GameConstants.RESOURCE_HOTSPOT_HEIGHT);
    }

    private boolean isInFarm() {
        return isWithinX(GameConstants.FARM__POS_X, GameConstants.RESOURCE_HOTSPOT_WIDTH,
                GameConstants.RESOURCE_HOTSPOT_HEIGHT)
                && isWithinY(GameConstants.FARM__POS_Y, GameConstants.RESOURCE_HOTSPOT_WIDTH,
                GameConstants.RESOURCE_HOTSPOT_HEIGHT);
    }

    private boolean isInTown() {
        return isWithinX(myTown.getTranslateX(), GameConstants.TOWN_SIZE, GameConstants.TOWN_SIZE)
                && isWithinY((int) myTown.getTranslateY(), GameConstants.TOWN_SIZE, GameConstants.TOWN_SIZE);
    }


    private boolean isWithinY(int posY, int width, int height) {

        return pos.getPosY() >= posY && pos.getPosY() <= posY + height;
    }

    private boolean isWithinX(double posX, int width, int height) {
        return pos.getPosY() >= posX && pos.getPosY() <= posX + width;
    }

    private boolean withinY(int mouseY, int size) {
        int upperY = pos.getPosY() + size;
        int lowerY = pos.getPosY();
        System.out.println(size);
        System.out.println("position Y: " + pos.getPosY()
                + "\nposition mouseY: " + mouseY
                + "\nupperY: " + upperY
                + "\nlowerY: " + lowerY
        );
        return mouseY <= upperY && mouseY >= lowerY;

    }

    private boolean withinX(int mouseX, int size) {
        int upperX = pos.getPosX() + size;
        int lowerX = pos.getPosX() - size;
        System.out.println(size);
        System.out.println("position X: " + pos.getPosX()
                + "\nposition mouseX: " + mouseX
                + "\nupperX: " + upperX
                + "\nlowerX: " + lowerX
        );
        return mouseX <= upperX && mouseX >= lowerX;
    }

    public int getPersonGameZone() {
        if (isWithinPos(IS_IN_TOWN)) {
            return IS_IN_TOWN;
        } else if (isWithinPos(IS_OUT_OF_TOWN)) {
            return IS_OUT_OF_TOWN;
        } else if (isWithinPos(IS_IN_FARM)) {
            return IS_IN_FARM;
        } else if (isWithinPos(IS_IN_GOLD_MINE)) {
            return IS_IN_GOLD_MINE;
        } else {
            return IS_IN_BLANK;
        }
    }


    protected void setPos() {
        super.setPos(pos);

        healthLabel.setTranslateX(pos.getPosX() - 1);
        healthLabel.setTranslateY(pos.getPosY() - GameConstants.VILLAGER_SIZE - 5);
    }


    public void regenerate() {
        health += TOWN_REGEN_VALUE;
    }

    public void penalty() {
        health -= TOWN_REGEN_VALUE;
    }

    public void updateLabel() {
        healthLabel.setText(health + "");
    }
}
