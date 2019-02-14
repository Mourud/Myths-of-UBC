package ca.ubc.cs.cpsc210.model.town.person;

import ca.ubc.cs.cpsc210.model.GameObjects;
import ca.ubc.cs.cpsc210.model.town.TownCentre;

public abstract class Person implements GameObjects {
    private int id;
    private int curMaxHealth;
    private int health;
    private int attack;
    private int posX;
    private int posY;
    protected TownCentre myTown;

    // TODO: Add identifier. Kill person if identifier is equal
    public Person(int curMaxHealth, int attack, int posX, int posY, TownCentre t) {
        this.curMaxHealth = curMaxHealth;
        this.health = curMaxHealth;
        this.attack = attack;
        this.posX = posX;
        this.posY = posY;
        myTown = t;
    }

    // TODO: Finish these methods

    // MODIFIES: this
    // EFFECTS: changes the position of player
    public void walk(int dx, int dy) {
        posX += dx;
        posY += dy;

    }

    // MODIFIES: param enemy
    // EFFECTS: decreases enemy health
    public void attack(Person enemy) {
        enemy.decreaseHealth(enemy.getAttack());
    }

    public void decreaseHealth(int attackRate) {
        while (health > 0) {
            health -= attackRate;
        }
        if (health < 0) {
            this.die();
        }
    }

    //TODO: remove person from population
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

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setCurMaxHealth(int curMaxHealth) {
        this.curMaxHealth = curMaxHealth;
    }

}