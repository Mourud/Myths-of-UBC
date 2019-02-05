package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.Person.Person;
import ca.ubc.cs.cpsc210.model.Person.Soldier;
import ca.ubc.cs.cpsc210.model.Person.Villager;

import java.util.ArrayList;
import java.util.List;

public class TownCentre {

    private int food;
    private int gold;
    private List<Person> population;

    public TownCentre(int startPop, int startFood, int startGold) {
        population = new ArrayList<>();
        for (int i = 0; i < startPop; i++) {
            population.add(new Villager());
        }
        food = startFood;
        gold = startGold;
    }

    public void procreateVillagers() {
        population.add(new Villager());
    }

    public void procreateSoldiers() {
        population.add(new Soldier());
    }

    public int getFood() {
        return food;
    }

    public int getGold() {
        return gold;
    }

    public int getPopulation() {
        return population.size();
    }
}
