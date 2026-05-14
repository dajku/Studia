/**
 * Data class representing a serializable rectangle shape.
 *
 * Stores the position (top-left corner) and dimensions of a rectangle,
 * along with inherited transformation and styling properties from {@link ShapeData}.
 * Used for saving and loading rectangle shapes via {@link FileIO}.
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
class RectangleData extends ShapeData {

    /** Width of the rectangle. */
    private double width;

    /** Height of the rectangle. */
    private double height;

    /** X coordinate of the top-left corner. */
    private double x;

    /** Y coordinate of the top-left corner. */
    private double y;

    /**
     * Constructs a RectangleData with the given position and size.
     * @param x X coordinate of the top-left corner.
     * @param y Y coordinate of the top-left corner.
     * @param width Width of the rectangle.
     * @param height Height of the rectangle.
     */
    public RectangleData(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the rectangle.
     * @return Width value.
     */
    public double getWidth() { return width; }

    /**
     * Returns the height of the rectangle.
     * @return Height value.
     */
    public double getHeight() { return height; }

    /**
     * Returns the X coordinate of the top-left corner.
     * @return X position.
     */
    public double getX() { return x; }

    /**
     * Returns the Y coordinate of the top-left corner.
     * @return Y position.
     */
    public double getY() { return y; }
}
