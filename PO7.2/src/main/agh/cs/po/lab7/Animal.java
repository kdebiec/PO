package agh.cs.po.lab7;

import java.util.ArrayList;
import java.util.List;

public class Animal implements MapElement {
    private MapDirection mapDirection = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    List<IPositionChangeObserver> observers = new ArrayList<>();
    IWorldMap map;
    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this(map);
        this.position = initialPosition;
    }

    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection mapDirection) {
        this(map, initialPosition);
        this.mapDirection = mapDirection;
    }

    @Override
    public String toString() {
        switch (mapDirection) {
            case EAST:
                return "E";
            case WEST:
                return "W";
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
        }
        return null;
    }

    public MapDirection getMapDirection()
    {
        return mapDirection;
    }

    public Vector2d getPosition() {
        return position;
    }

    public boolean move(MoveDirection direction) {
        switch (direction) {
            case LEFT:
                mapDirection = mapDirection.previous();
                return false;
            case RIGHT:
                mapDirection = mapDirection.next();
                return false;
            case FORWARD:
                Vector2d newPos = position.add(mapDirection.toUnitVector());
                if(map.canMoveTo(newPos)) {
                    positionChanged(position, newPos);
                    position = newPos;
                    return true;
                }

                break;
            case BACKWARD:
                Vector2d newPos2 = position.subtract(mapDirection.toUnitVector());
                if(map.canMoveTo(newPos2)) {
                    positionChanged(position, newPos2);
                    position = newPos2;
                    return true;
                }

                break;
        }

        return false;
    }

    public boolean inMapBoundaries(Vector2d vec) {
        if(vec.getX() >= 0
                && vec.getY() >= 0
                && vec.getX() <= 4
                && vec.getY() <= 4)
            return true;

        return false;
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for(IPositionChangeObserver obs: observers) {
            obs.positionChanged(oldPosition, newPosition);
        }
    }
}
