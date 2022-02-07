package ca.ubc.cs.cpsc210.model.resourcehotspot;

import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.model.Position;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class ResourceHotSpot extends GameObject {
    private static final int STARTING_RESOURCES = GameConstants.STARTING_RESOURCES;

    private static final int RESOURCE_HOTSPOT_WIDTH = GameConstants.RESOURCE_HOTSPOT_WIDTH;
    private static final int RESOURCE_HOTSPOT_HEIGHT = GameConstants.RESOURCE_HOTSPOT_HEIGHT;

    private int resourceRemaining;

    public ResourceHotSpot() {
        super(RESOURCE_HOTSPOT_WIDTH, RESOURCE_HOTSPOT_HEIGHT);
        resourceRemaining = STARTING_RESOURCES;
    }

    protected void setPos(Position resourceHotspotPosition) {
        super.setPos(resourceHotspotPosition);
    }

    public ResourceHotSpot(int resourceRemainingLoad) {
        super(RESOURCE_HOTSPOT_WIDTH, RESOURCE_HOTSPOT_HEIGHT);
        resourceRemaining = resourceRemainingLoad;
    }

    public int getResourceRemaining() {
        return resourceRemaining;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//
//            return true;
//        }
//        if (!(o instanceof ResourceHotSpot)) {
//            return false;
//        }
//        ResourceHotSpot that = (ResourceHotSpot) o;
//        return resourceRemaining == that.resourceRemaining;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(resourceRemaining);
//    }
//    isDepleted()

    public boolean decrementResourceLeft(int gatherRate) {
        if (resourceRemaining > 0) {
            resourceRemaining -= gatherRate;
            if (resourceRemaining <= 0) {
                depleted();
            }
            return true;
        } else {
            depleted();
            System.out.println("Resource depleted");
            return false;
        }
    }

    public void depleted() {
        setFill(Color.GRAY);
    }
}
