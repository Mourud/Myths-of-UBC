package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;

import java.util.Objects;

public abstract class Person implements GameObject {
    private int id;
    private int curMaxHealth;
    private int health;
    private int attack;
    private Position pos;
    private int gatherRate;
    protected TownCentre myTown;
    private boolean nearResource;


    public Person(int id, int curMaxHealth, int attack, int gatherRate, TownCentre t) {
        this.id = id;
        this.curMaxHealth = curMaxHealth;
        this.health = curMaxHealth;
        this.attack = attack;
        this.gatherRate = gatherRate;
        pos = new Position(0, 0);
        pos.random();
        myTown = t;
    }

    // MODIFIES: this
    // EFFECTS: changes the position of player
    public void walkTo(int x, int y) {
        pos.changePos(x,y);
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
        // TODO: Is if statement redundant
        if (health < 0) {
            health = 0;
            this.die();
        }
    }

    private void die() {
        myTown.getRegistry().remove(this);
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

    public Position getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
