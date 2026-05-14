import java.io.Serializable;
import java.util.ArrayList;

/**
 * Abstract base class for storing serializable shape data.
 *
 * Serves as the base for all shape data classes (RectangleData, CircleData, PolygonData).
 * Stores common transformation and styling properties that can be saved to and loaded from a file.
 * Implements {@link Serializable} to support binary file I/O via {@link FileIO}.
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
abstract public class ShapeData implements Serializable {

    /** Translation offset along the X axis. */
    protected double translateX;

    /** Translation offset along the Y axis. */
    protected double translateY;

    /** Scale factor along the X axis. */
    protected double scaleX;

    /** Scale factor along the Y axis. */
    protected double scaleY;

    /** Rotation angle in degrees. */
    protected double rotate;

    /** Width of the shape's border stroke. */
    protected double strokeWidth;

    /** Fill color of the shape, stored as a JavaFX color string (e.g. {@code "0xff0000ff"}). */
    protected String fillColor;

    /** Stroke (border) color of the shape, stored as a JavaFX color string. */
    protected String strokeColor;

    /**
     * Returns the X translation offset.
     * @return Translation along the X axis.
     */
    public double getTranslateX() { return translateX; }

    /**
     * Returns the Y translation offset.
     * @return Translation along the Y axis.
     */
    public double getTranslateY() { return translateY; }

    /**
     * Returns the X scale factor.
     * @return Scale along the X axis.
     */
    public double getScaleX() { return scaleX; }

    /**
     * Returns the Y scale factor.
     * @return Scale along the Y axis.
     */
    public double getScaleY() { return scaleY; }

    /**
     * Returns the rotation angle.
     * @return Rotation in degrees.
     */
    public double getRotate() { return rotate; }

    /**
     * Returns the stroke width.
     * @return Width of the shape's border.
     */
    public double getStrokeWidth() { return strokeWidth; }

    /**
     * Returns the fill color as a string.
     * @return JavaFX color string representing the fill color.
     */
    public String getFillColor() { return fillColor; }

    /**
     * Returns the stroke color as a string.
     * @return JavaFX color string representing the border color.
     */
    public String getStrokeColor() { return strokeColor; }

    /**
     * Sets the X translation offset.
     * @param x Translation value along the X axis.
     */
    public void setTranslateX(double x) { translateX = x; }

    /**
     * Sets the Y translation offset.
     * @param y Translation value along the Y axis.
     */
    public void setTranslateY(double y) { translateY = y; }

    /**
     * Sets the X scale factor.
     * @param x Scale value along the X axis.
     */
    public void setScaleX(double x) { scaleX = x; }

    /**
     * Sets the Y scale factor.
     * @param y Scale value along the Y axis.
     */
    public void setScaleY(double y) { scaleY = y; }

    /**
     * Sets the rotation angle.
     * @param r Rotation in degrees.
     */
    public void setRotate(double r) { rotate = r; }

    /**
     * Sets the stroke width.
     * @param s Width of the shape's border.
     */
    public void setStrokeWidth(double s) { strokeWidth = s; }

    /**
     * Sets the fill color.
     * @param c JavaFX color string representing the fill color.
     */
    public void setFillColor(String c) { fillColor = c; }

    /**
     * Sets the stroke color.
     * @param c JavaFX color string representing the border color.
     */
    public void setStrokeColor(String c) { strokeColor = c; }
}
