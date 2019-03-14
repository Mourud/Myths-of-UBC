package ca.ubc.cs.cpsc210.model.resourcehotspot;

import ca.ubc.cs.cpsc210.model.GameObject;
import ca.ubc.cs.cpsc210.model.constants.GameConstants;

import java.util.Objects;

public abstract class ResourceHotSpot implements GameObject {
    private int resourceRemaining;

    public ResourceHotSpot() {
        resourceRemaining = GameConstants.STARTING_RESOURCES;
    }

    public int getResourceRemaining() {
        return resourceRemaining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResourceHotSpot)) {
            return false;
        }
        ResourceHotSpot that = (ResourceHotSpot) o;
        return resourceRemaining == that.resourceRemaining;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceRemaining);
    }

    public boolean decrementResourceLeft(int gatherRate) {
        if (resourceRemaining > 0) {
            resourceRemaining -= gatherRate;
            return true;
        } else {
            System.out.println("Resource depleted");
            return false;
        }
    }
}
