package agh.cs.po.lab7;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        boolean success = true;

        if(!(position.getX() >= 0
                && position.getY() >= 0
                && position.getX() <= width-1
                && position.getY() <= height-1))
            success = false;

        if(isOccupied(position))
            success = false;

        return success;
    }
}
