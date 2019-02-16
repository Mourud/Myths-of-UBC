package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.model.TownCentre;

import java.util.Objects;

public abstract class Person implements GameObject {
    private int id;
    private int curMaxHealth;
    private int health;
    private int attack;
    private int posX;
    private int posY;
    private int gatherRate;
    protected TownCentre myTown;
    private boolean nearResource;


    // TODO: Add identifier. Kill person if identifier is equal
    public Person(int id, int curMaxHealth, int attack, int gatherRate, int posX, int posY, TownCentre t) {
        this.id = id;
        this.curMaxHealth = curMaxHealth;
        this.health = curMaxHealth;
        this.attack = attack;
        this.gatherRate = gatherRate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id
                && curMaxHealth == person.curMaxHealth &&
                health == person.health &&
                attack == person.attack &&
                posX == person.posX &&
                posY == person.posY &&
                gatherRate == person.gatherRate &&
                nearResource == person.nearResource &&
                myTown.equals(person.myTown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curMaxHealth, health, attack, posX, posY, gatherRate, myTown, nearResource);
    }
}
// TODO: Finish this
// REQUIRES:
// MODIFIES: myTown
// EFFECTS: increases amount of resource that it's in contact with
//    public void gatherResource(){
//        //myTown.gatherResource();
//    }


// MODIFIES: param enemy
// EFFECTS: decreases enemy health
//    public void attack(Person enemy) {
//        enemy.decreaseHealth(enemy.getAttack());
//    }

//    public void decreaseHealth(int attackRate) {
//        while (health > 0) {
//            health -= attackRate;
//        }
//        if (health < 0) {
//            this.die();
//        }
//    }

//    //TODO: remove person from population
//    private void die() {
//        myTown.getRegistry().remove(this);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: getters and setters for given field
//    public int getHealth() {
//        return health;
//    }
//
//    public int getCurMaxHealth() {
//        return curMaxHealth;
//    }
//
//    public int getAttack() {
//        return attack;
//    }
//
//    public void setAttack(int attack) {
//        this.attack = attack;
//    }
//
//    public void setCurMaxHealth(int curMaxHealth) {
//        this.curMaxHealth = curMaxHealth;
//    }

//    // TODO: Implement this method
//    public void gatherResource() {
//        nearResource = false;
//        if (nearResource) {
//            myTown.setAmountFood(6);
//        }
//    }
//
//}