package ca.ubc.cs.cpsc210.model.town.person;

import ca.ubc.cs.cpsc210.model.town.TownCentre;

public class Soldier extends Person {

    // MODIFIES: this
    // EFFECTS: SETS GATHER RATE TO 50 BY DEFAULT
    public Soldier(int curMaxHealth, int attack, int posX, int posY, TownCentre town) {
        super(curMaxHealth, attack, posX, posY,town);

    }
}
