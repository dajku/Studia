import javax.tools.Tool;

/**
 * Enum defining the available drawing tool modes.
 *
 * Used by {@link DrawingPane} to determine which shape should be drawn
 * when the user interacts with the canvas.
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
public enum ToolMode {

    /** Tool mode for drawing circles. */
    CIRCLE,

    /** Tool mode for drawing rectangles. */
    RECTANGLE,

    /** Tool mode for drawing polygons (placed vertex by vertex). */
    POLYGON,

    /** Tool mode for saving the drawing (reserved). */
    SAVE,

    /** Tool mode for importing a drawing (reserved). */
    IMPORT
}
