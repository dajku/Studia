import java.util.ArrayList;

/**
 * Data class representing a serializable polygon shape.
 *
 * Stores the list of vertex coordinates (alternating X and Y values) of a polygon,
 * along with inherited transformation and styling properties from {@link ShapeData}.
 * Used for saving and loading polygon shapes via {@link FileIO}.
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
class PolygonData extends ShapeData {

    /**
     * List of vertex coordinates stored as alternating X and Y values,
     * e.g. [x0, y0, x1, y1, x2, y2, ...].
     */
    private ArrayList<Double> points;

    /**
     * Constructs a PolygonData by copying the given list of vertex coordinates.
     * @param p List of alternating X and Y coordinate values.
     */
    public PolygonData(ArrayList<Double> p) {
        points = new ArrayList<Double>();
        for (Double point : p) {
            points.add(point);
        }
    }

    /**
     * Returns the list of vertex coordinates.
     * @return ArrayList of alternating X and Y values representing polygon vertices.
     */
    public ArrayList<Double> getPoints() { return points; }
}
