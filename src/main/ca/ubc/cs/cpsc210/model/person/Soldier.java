package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import javafx.scene.paint.Color;

public class Soldier extends Person {
    private Color color;

    // MODIFIES: this
    // EFFECTS: SETS GATHER RATE TO 50 BY DEFAULT
    public Soldier(int id, int curMaxHealth, int attack, int gatherRate, TownCentre town) {
        super(true, id, curMaxHealth, attack, gatherRate, town);
        color = town.getColor();
        setFill(color);
    }

    public Soldier(int id, int health, int curMaxHealth, int attack, int gatherRate, Position position, boolean nearResource, TownCentre town) {
        super(true, id, health, curMaxHealth, attack, gatherRate, position, nearResource, town);
        color = town.getColor();
        setFill(color);
    }
}
