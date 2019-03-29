package ca.ubc.cs.cpsc210.model;

import javafx.scene.shape.Rectangle;

public class GameObject extends Rectangle {

    private boolean dead = false;

    public GameObject(int width, int height) {
        super(width, height);
    }

    protected void setPos(Position pos) {
        setTranslateX(pos.getPosX());
        setTranslateY(pos.getPosY());
    }

}
