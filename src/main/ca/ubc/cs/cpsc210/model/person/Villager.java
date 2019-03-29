package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.scene.paint.Color;

public class Villager extends Person {

    private Color color;
    private static final int SIZE = GameConstants.VILLAGER_SIZE;


    public Villager(int id, int curMaxHealth, int attack, int gatherRate, TownCentre town) {
        super(false, SIZE, id, curMaxHealth, attack, gatherRate, town);
    }

    public Villager(int id, int health, int curMaxHealth, int attack, int gatherRate, Position position,
                    boolean nearResource, TownCentre town) {
        super(false, id, SIZE, health, curMaxHealth, attack, gatherRate, position, nearResource, town);
    }

    @Override
    public boolean isInRange(Position position) {
        return isWithinPos(position, SIZE);
    }
}
