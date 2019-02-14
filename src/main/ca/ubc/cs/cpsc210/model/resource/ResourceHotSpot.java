package ca.ubc.cs.cpsc210.model.resource;

import ca.ubc.cs.cpsc210.model.GameObjects;

public abstract class ResourceHotSpot implements GameObjects {
    private static final int STARTRESOURCE = 50000;
    private int resourceLeft;

    public ResourceHotSpot() {
        resourceLeft = STARTRESOURCE;
    }

    public int getResourceLeft() {
        return resourceLeft;
    }

    //TODO: SUBSTRACT WITH GATHER RATE
    protected void decrementResourceLeft() {
        resourceLeft--;
    }
}
