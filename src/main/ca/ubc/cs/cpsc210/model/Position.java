package ca.ubc.cs.cpsc210.model;

import java.util.Objects;

public class Position {
    private int posX;
    private int posY;

    public Position(int x, int y) {
        posX = x;
        posY = y;
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
    // TODO: Implement this method

    public static Position random() {
        return null;
    }
}
