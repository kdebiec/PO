package agh.cs.po.lab7;

public interface MapElement {
    Vector2d getPosition();
    boolean move(MoveDirection moveDirection);
}
