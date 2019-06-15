package ca.ubc.cs.cpsc210.model.resourcehotspot;

import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.scene.paint.Color;
import org.json.JSONObject;

public class GoldMine extends ResourceHotSpot {

    private static Color GOLDMINE_COLOR = GameConstants.GOLDMINE_COLOR;
    private static Color GOLDMINE_DEAD_COLOR = GameConstants.GOLDMINE_DEAD_COLOR;

    private static final Position POSITION = GameConstants.GOLD_MINE_POSITION;


    public GoldMine() {
        super();
        setPos(POSITION);
        setFill(GOLDMINE_COLOR);
    }

    public GoldMine(JSONObject j) {
        super(j.getInt("resourceRemaining"));
        setPos(POSITION);
        setFill(GOLDMINE_COLOR);
    }

//    public void depleted(){
//        setFill(GOLDMINE_DEAD_COLOR);
//    }


//todo: add dying function


//    @Override
//    public boolean decrementResourceLeft(int gatherRate) {
//        if(super.decrementResourceLeft(gatherRate))
//
//        return super.decrementResourceLeft(gatherRate);
//    }
}
