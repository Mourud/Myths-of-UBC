package ca.ubc.cs.cpsc210.model.resourcehotspot;

import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.scene.paint.Color;
import org.json.JSONObject;

public class Farm extends ResourceHotSpot {

    private static final Position POSITION = GameConstants.FARM_POSITION;

    private static Color FARM_COLOR = GameConstants.FARM_COLOR;
    private static Color FARM_DEAD_COLOR = GameConstants.FARM_DEAD_COLOR;

    public Farm() {
        super();
        setPos(POSITION);
        setFill(FARM_COLOR);
    }

    public Farm(JSONObject j) {
        super(j.getInt("resourceRemaining"));
        setPos(POSITION);
        setFill(FARM_COLOR);
    }
}
