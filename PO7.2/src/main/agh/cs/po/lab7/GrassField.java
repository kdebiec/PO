package agh.cs.po.lab7;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private Map<Vector2d, Grass> grasses;

    public GrassField(List<Grass> grasses) {
        this.grasses = new LinkedHashMap<>();
        for(Grass grass: grasses) {
            this.grasses.put(grass.getPosition(), grass);
            mapBoundary.addElement(grass.getPosition(), grass);
        }
    }

    public GrassField(int n_of_grasses) {
        Map<Vector2d, Grass> grasses = new LinkedHashMap<>();

        for(int i = 0; i < n_of_grasses; i++) {
            int randomIntX;
            int randomIntY;

            do {
                double randomDoubleX = Math.random();
                randomDoubleX = randomDoubleX * Math.sqrt(n_of_grasses * 10);
                randomIntX = (int) randomDoubleX;

                double randomDoubleY = Math.random();
                randomDoubleY = randomDoubleY * Math.sqrt(n_of_grasses * 10);
                randomIntY = (int) randomDoubleY;
            }
            while(isOccupiedByGrass(new Vector2d(randomIntX, randomIntY), grasses));

            Grass grass = new Grass(new Vector2d(randomIntX, randomIntY));
            grasses.put(grass.getPosition(), grass);
            mapBoundary.addElement(grass.getPosition(), grass);

        }

        this.grasses = new LinkedHashMap<>(grasses);
    }

    protected void updateMapBoundaries() {
        upperRight = mapBoundary.getTopRight();
        lowerLeft = mapBoundary.getBottomLeft();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedByAnimal(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position))
            return true;

        return grasses.containsKey(position);
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return super.isOccupied(position);
    }

    public boolean isOccupiedByGrass(Vector2d position, Map<Vector2d, Grass> grassesHashMap) {
        if(super.isOccupied(position))
            return true;

        return grassesHashMap.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object != null)
            return object;

        return grasses.get(position);
    }
}
