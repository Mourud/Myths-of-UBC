package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;

import java.util.Objects;

public class Position {
    private static final int BIRTH_RADIUS = GameConstants.BIRTH_RADIUS;
    private int posX;
    private int posY;

    public Position(int x, int y) {
        posX = x;
        posY = y;
    }

    public void changePos(int x, int y) {
        posX = x;
        posY = y;
    }

    public void random() {
        posX = (int) (Math.random() * BIRTH_RADIUS + 1);
        posY = (int) (Math.random() * BIRTH_RADIUS + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return posX == position.posX && posY == position.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }
}
