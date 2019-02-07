package ca.ubc.cs.cpsc210.model.resource;

public abstract class Resource  {
    private static final int STARTRESOURCE = 50000;
    private int resourceLeft;

    public Resource() {
        resourceLeft = STARTRESOURCE;
    }

    public int getResourceLeft() {
        return resourceLeft;
    }
}
