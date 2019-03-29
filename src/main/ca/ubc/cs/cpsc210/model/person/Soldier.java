package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.scene.paint.Color;

public class Soldier extends Person {
    private Color color;
    private static final int SIZE = GameConstants.SOLDIER_SIZE;


    // MODIFIES: this
    // EFFECTS: SETS GATHER RATE TO 50 BY DEFAULT
    public Soldier(int id, int curMaxHealth, int attack, int gatherRate, TownCentre town) {
        super(true, SIZE, id, curMaxHealth, attack, gatherRate, town);
    }

    public Soldier(int id, int health, int curMaxHealth, int attack, int gatherRate, Position position,
                   boolean nearResource, TownCentre town) {
        super(true, id, SIZE, health, curMaxHealth, attack, gatherRate, position, nearResource, town);
    }

    @Override
    public boolean isInRange(Position position) {
        return isWithinPos(position, SIZE);
    }
}
