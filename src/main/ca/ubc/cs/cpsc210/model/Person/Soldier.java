package ca.ubc.cs.cpsc210.model.Person;

public class Soldier extends Person {
    private int curFullHealth = 100;
    private int curAttack = 10;
    private int health;
    private int attack;

    public Soldier() {
        health = curFullHealth;
        attack = curAttack;
    }
}
