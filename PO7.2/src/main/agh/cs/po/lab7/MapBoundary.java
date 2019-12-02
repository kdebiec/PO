package agh.cs.po.lab7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapBoundary implements IPositionChangeObserver {
    private TreeMap<Vector2d, MapElement> elementsByX = new TreeMap<>(MapBoundary::compareByX);
    private TreeMap<Vector2d, MapElement> elementsByY = new TreeMap<>(MapBoundary::compareByY);
    protected Map<Vector2d, MapElement> mapElements = new LinkedHashMap<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!oldPosition.equals(newPosition)) {
            MapElement element = mapElements.get(oldPosition);
            this.removeElement(oldPosition);
            this.addElement(newPosition, element);
        }
    }

    public void addElement(Vector2d position, MapElement element) {
        mapElements.put(position, element);
        elementsByX.put(position, element);
        elementsByY.put(position, element);
    }

    public void removeElement(Vector2d position) {
        mapElements.remove(position);
        elementsByX.remove(position);
        elementsByY.remove(position);
    }

    public Vector2d getBottomLeft() {
        return new Vector2d(elementsByX.firstKey().x, elementsByY.firstKey().y);
    }

    public Vector2d getTopRight() {
        return new Vector2d(elementsByX.lastKey().x, elementsByY.lastKey().y);
    }

    private static int compareByX(Vector2d v1, Vector2d v2) {
        if (v1.x > v2.x)
            return 1;
        else if (v1.x < v2.x)
            return -1;
        else if (v1.y > v2.y)
            return 1;
        else if (v1.y < v2.y)
            return -1;

        return 0;
    }

    private static int compareByY(Vector2d v1, Vector2d v2) {
        if (v1.y > v2.y)
            return 1;
        else if (v1.y < v2.y)
            return -1;
        else if (v1.x > v2.x)
            return 1;
        else if (v1.x < v2.x)
            return -1;

        return 0;
    }
}
