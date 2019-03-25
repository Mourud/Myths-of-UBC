package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.TownCentre;
import javafx.scene.paint.Color;

public class Villager extends Person {

    private Color color;


    public Villager(int id, int curMaxHealth, int attack, int gatherRate, TownCentre town) {
        super(false, id, curMaxHealth, attack, gatherRate, town);
        color = town.getColor();
        setFill(color);
    }

    public Villager(int id, int health, int curMaxHealth, int attack, int gatherRate, Position position, boolean nearResource, TownCentre town){
        super(false, id, health,curMaxHealth,attack,gatherRate,position,nearResource,town);
        color = town.getColor();
        setFill(color);
    }


}
