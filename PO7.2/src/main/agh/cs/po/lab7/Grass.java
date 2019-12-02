package agh.cs.po.lab7;

public class Grass implements MapElement {
    private Vector2d position;
    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public boolean move(MoveDirection moveDirection) {
        return false;
    }

    @Override
    public String toString() {
        return "*";
    }
}
