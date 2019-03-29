package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class Person extends GameObject {
    public static final Color PLAYER_COLOR = GameConstants.PLAYER_PER_COLOR;
    public static final Color ENEMY_COLOR = GameConstants.ENEMY_PER_COLOR;


    private boolean isSoldier;
    private int id;
    private int curMaxHealth;
    private int health;
    private int attack;
    private Position pos;
    private int gatherRate;
    protected TownCentre myTown;
    private boolean nearResource;


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

        myTown = t;
        nearResource = false;
        setPos(pos);

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
        setPos(pos);
    }

    // MODIFIES: this
    // EFFECTS: changes the position of player
    public void walkTo(int x, int y) {
        pos.changePos(x, y);
        setPos(pos);
    }


    // TODO: Finish this Implement Hashmap
// REQUIRES:
// MODIFIES: myTown
// EFFECTS: increases amount of resource that it's in contact with
    public void gatherResource() {
        myTown.gatherResource("", gatherRate);
    }


    // MODIFIES: param enemy
// EFFECTS: decreases enemy health
    public void attack(Person enemy) {
        enemy.decreaseHealth(attack);
    }


    public void decreaseHealth(int attackRate) {
        while (health > 0) {
            health -= attackRate;
        }
        if (health < 0) {
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

    private boolean withinY(int mouseY, int size) {
        int upperY = pos.getPosY() + size;
        int lowerY = pos.getPosY() - size;
        return mouseY <= upperY && mouseY >= lowerY;
    }

    private boolean withinX(int mouseX, int size) {
        int upperX = pos.getPosX() + size;
        int lowerX = pos.getPosX() - size;
        System.out.println(size);
        System.out.println("position X: " + pos.getPosX()
                + "\nposition mouseX: " + mouseX
                + "\nupperX: " + upperX
//                + "\nlowerX: " + lowerX
        );
        return mouseX <= upperX && mouseX >= lowerX;
    }
}
