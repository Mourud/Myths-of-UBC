package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.TownCentre;

public abstract class Person {
    protected int curFullHealth = 50;
    protected int curAttack = 1;
    protected int health;
    protected int attack;

    public Person() {
        health = curFullHealth;
        attack = curAttack;
    }

    // TODO: Finish these methods
    public void walk() {

    }

    public void attack() {

    }

    public void decreaseHealth() {

    }

    public int getHealth() {
        return health;
    }

    public int getCurFullHealth() {
        return curFullHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getCurAttack() {
        return curAttack;
    }

    public void setCurAttack(int curAttack) {
        this.curAttack = curAttack;
    }

    public void setCurFullHealth(int curFullHealth) {
        this.curFullHealth = curFullHealth;
    }

}