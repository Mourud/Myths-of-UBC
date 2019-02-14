package ca.ubc.cs.cpsc210.model.town.person;

import ca.ubc.cs.cpsc210.model.town.TownCentre;

public class Villager extends Person {


    private boolean nearReource;

    // TODO: IF I CHANGE PARAMETERS I'M HAVING TO CHANGE TO A LOT OF CODE
    public Villager(int curMaxHealth, int attack, int gatherRate, int posX, int posY, TownCentre town) {
        super(curMaxHealth, attack, gatherRate, posX, posY, town);
    }

    // TODO: Implement this method
    public void gatherResource() {
        nearReource = false;
        if (nearReource) {
            myTown.setAmountFood(6);
        }
    }

}

