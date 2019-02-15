package ca.ubc.cs.cpsc210.model.resourcehotspot;

import ca.ubc.cs.cpsc210.model.GameObjects;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;

public abstract class ResourceHotSpot implements GameObjects {
    private int resourceRemaining;

    public ResourceHotSpot() {
        resourceRemaining = GameConstants.STARTING_RESOURCES;
    }

    public int getResourceRemaining() {
        return resourceRemaining;
    }

    //TODO: SUBSTRACT WITH GATHER RATE
    protected void decrementResourceLeft(int gatherRate) {
        resourceRemaining -= gatherRate;
    }
}
