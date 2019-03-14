package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.TownCentre;

public class Soldier extends Person {

    // MODIFIES: this
    // EFFECTS: SETS GATHER RATE TO 50 BY DEFAULT
    public Soldier(int id, int curMaxHealth, int attack, int gatherRate, TownCentre town) {
        super(id, curMaxHealth, attack, gatherRate, town);

    }
}
