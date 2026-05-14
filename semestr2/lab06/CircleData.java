/**
 * Data class representing a serializable circle shape.
 *
 * Stores the center coordinates and radius of a circle,
 * along with inherited transformation and styling properties from {@link ShapeData}.
 * Used for saving and loading circle shapes via {@link FileIO}.
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
class CircleData extends ShapeData {

    /** Radius of the circle. */
    private double radius;

    /** X coordinate of the circle's center. */
    private double centerX;

    /** Y coordinate of the circle's center. */
    private double centerY;

    /**
     * Constructs a CircleData with the given center and radius.
     * @param x X coordinate of the center.
     * @param y Y coordinate of the center.
     * @param r Radius of the circle.
     */
    public CircleData(double x, double y, double r) {
        radius = r;
        centerX = x;
        centerY = y;
    }

    /**
     * Returns the radius of the circle.
     * @return Radius value.
     */
    public double getRadius() { return radius; }

    /**
     * Returns the X coordinate of the circle's center.
     * @return Center X value.
     */
    public double getCenterX() { return centerX; }

    /**
     * Returns the Y coordinate of the circle's center.
     * @return Center Y value.
     */
    public double getCenterY() { return centerY; }
}
