package ca.ubc.cs.cpsc210.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameObject extends Rectangle {

    private boolean dead = false;

    public GameObject(int width, int height) {
        super(width, height);
    }

    protected void setPos(Position Pos) {
        setTranslateX(Pos.getPosX());
        setTranslateY(Pos.getPosY());
    }

    void moveLeft() {
        setTranslateX(getTranslateX() - 5);
    }

    void moveRight() {
        setTranslateX(getTranslateX() + 5);
    }

    void moveUp() {
        setTranslateY(getTranslateY() - 5);
    }

    void moveDown() {
        setTranslateY(getTranslateY() + 5);
    }
}
