package agh.cs.po.lab7;

import java.util.*;

public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected List<Animal> animalList = new ArrayList<>();
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    protected MapBoundary mapBoundary = new MapBoundary();

    @Override
    public void run(MoveDirection[] directions) {
        if(animals.isEmpty())
            return;

        for (int i = 0; i < directions.length; i++)
            animalList.get(i % animalList.size()).move(directions[i]);
    }

    @Override
    public String toString() {
        updateMapBoundaries();
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(lowerLeft, upperRight);
    }

    protected void updateMapBoundaries() {}

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition()))
            throw new IllegalArgumentException("The item cannot be placed, because the field is already occupied.");

        animalList.add(animal);
        animals.put(animal.getPosition(), animal);
        mapBoundary.addElement(animal.getPosition(), animal);
        animal.addObserver(this);
        animal.addObserver(mapBoundary);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}
