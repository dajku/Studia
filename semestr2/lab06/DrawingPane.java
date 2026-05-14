import java.util.ArrayList;

import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 * Interactive drawing canvas for creating and editing geometric shapes.
 *
 * Extends {@link javafx.scene.layout.Pane} to provide a mouse-driven canvas
 * where the user can draw, select, move, scale, rotate, and recolor shapes.
 * Supports three shape types: circles, rectangles, and polygons.
 *
 * Interaction summary:
 * - Left-click + drag on empty area: draws a new shape (depending on active {@link ToolMode}).
 * - Left-click on a shape: selects it (stroke thickens).
 * - Left-click + drag on selected shape: moves it.
 * - Scroll wheel on selected shape: scales it.
 * - Shift + scroll on selected shape: rotates it.
 * - Right-click on a shape: opens an inline {@link ColorPicker} to change fill color.
 * - Double-click: finishes drawing a polygon.
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
public class DrawingPane extends Pane {

    /** X coordinate of the mouse press start point. */
    private double startX;

    /** Y coordinate of the mouse press start point. */
    private double startY;

    /** Last recorded scene X position of the mouse, used for drag delta calculation. */
    private double lastMouseX;

    /** Last recorded scene Y position of the mouse, used for drag delta calculation. */
    private double lastMouseY;

    /** Currently active drawing tool mode. */
    private ToolMode currentMode;

    /** The rectangle currently being drawn (null when not drawing). */
    private Rectangle currentRectangle;

    /** The circle currently being drawn (null when not drawing). */
    private Circle currentCircle;

    /** The polygon currently being drawn (null when not drawing). */
    private Polygon currentPolygon;

    /** List of all completed shapes on the canvas. */
    private ArrayList<Shape> allFigures;

    /** The shape currently selected by the user (null if none). */
    private Shape currentShape;

    /** Default fill color applied to newly created shapes. */
    private Color currentFillColor = Color.WHITE;

    /** Inline color picker shown on right-click over a shape. */
    private ColorPicker colorPicker;

    /**
     * Constructs the DrawingPane and registers all mouse event handlers.
     *
     * Sets up clipping to prevent shapes from rendering outside the pane bounds,
     * and attaches handlers for mouse press, drag, release, and scroll events.
     */
    public DrawingPane() {

        allFigures = new ArrayList<Shape>();
        colorPicker = new ColorPicker();

        // Clip shapes to the pane bounds
        Rectangle clipRect = new Rectangle();
        clipRect.widthProperty().bind(this.widthProperty());
        clipRect.heightProperty().bind(this.heightProperty());
        this.setClip(clipRect);

        setOnMousePressed(e -> {
            startX = e.getX();
            startY = e.getY();
            lastMouseX = e.getSceneX();
            lastMouseY = e.getSceneY();

            // Deselect previously selected shape
            if (currentShape != null) {
                currentShape.setStrokeWidth(1);
            }

            Object target = e.getTarget();
            if (target instanceof Shape) {
                // Select the clicked shape
                currentShape = (Shape) target;
                currentShape.setStrokeWidth(3);

                // Register scroll handler for scale/rotate on selected shape
                setOnScroll(s -> {
                    if (s.isShiftDown()) {
                        currentShape.setRotate(currentShape.getRotate() + s.getDeltaY() * 0.1 + s.getDeltaX() * 0.1);
                    } else {
                        currentShape.setScaleX(currentShape.getScaleX() + s.getDeltaY() * 0.0005);
                        currentShape.setScaleY(currentShape.getScaleY() + s.getDeltaY() * 0.0005);
                    }
                });

                // Show color picker on right-click
                if (e.getButton() == MouseButton.SECONDARY && !(getChildren().contains(colorPicker))) {
                    colorPicker.setLayoutX(e.getX());
                    colorPicker.setLayoutY(e.getY());
                    getChildren().add(colorPicker);
                    colorPicker.setOnAction(ex -> {
                        currentShape.setFill(colorPicker.getValue());
                    });
                }

            } else {
                // Click on empty area: start drawing a new shape
                currentShape = null;
                if (currentMode == ToolMode.RECTANGLE) {
                    currentRectangle = new Rectangle();
                    currentRectangle.setX(startX);
                    currentRectangle.setY(startY);
                    currentRectangle.setWidth(0);
                    currentRectangle.setHeight(0);
                    currentRectangle.setFill(currentFillColor);
                    currentRectangle.setStroke(Color.BLACK);
                    getChildren().add(currentRectangle);

                } else if (currentMode == ToolMode.CIRCLE) {
                    currentCircle = new Circle();
                    currentCircle.setCenterX(startX);
                    currentCircle.setCenterY(startY);
                    currentCircle.setRadius(0);
                    currentCircle.setFill(currentFillColor);
                    currentCircle.setStroke(Color.BLACK);
                    getChildren().add(currentCircle);

                } else if (currentMode == ToolMode.POLYGON) {
                    if (currentPolygon == null) {
                        // Start a new polygon
                        currentPolygon = new Polygon();
                        currentPolygon.setFill(currentFillColor);
                        currentPolygon.setStroke(Color.BLACK);
                        currentPolygon.getPoints().addAll(startX, startY);
                        getChildren().add(currentPolygon);
                    } else {
                        // Add next vertex to existing polygon
                        currentPolygon.getPoints().addAll(e.getX(), e.getY());
                    }
                }
            }
        });

        setOnMouseDragged(e -> {
            double currentX = e.getX();
            double currentY = e.getY();

            // Resize shape being drawn
            if (currentMode == ToolMode.RECTANGLE && currentRectangle != null) {
                double x = Math.min(startX, currentX);
                double y = Math.min(startY, currentY);
                double width = Math.abs(currentX - startX);
                double height = Math.abs(currentY - startY);
                currentRectangle.setX(x);
                currentRectangle.setY(y);
                currentRectangle.setWidth(width);
                currentRectangle.setHeight(height);

            } else if (currentMode == ToolMode.CIRCLE && currentCircle != null) {
                double radius = Math.sqrt(Math.pow(currentX - startX, 2) + Math.pow(currentY - startY, 2));
                currentCircle.setRadius(radius);
            }

            // Move selected shape
            if (currentShape != null) {
                double currentSceneX = e.getSceneX();
                double currentSceneY = e.getSceneY();
                double deltaX = currentSceneX - lastMouseX;
                double deltaY = currentSceneY - lastMouseY;
                currentShape.setTranslateX(currentShape.getTranslateX() + deltaX);
                currentShape.setTranslateY(currentShape.getTranslateY() + deltaY);
                lastMouseX = currentSceneX;
                lastMouseY = currentSceneY;
            }
        });

        setOnMouseReleased(e -> {
            // Finalize rectangle
            if (currentRectangle != null) {
                if (currentRectangle.getWidth() <= 1) {
                    getChildren().remove(currentRectangle);
                }
                allFigures.add(currentRectangle);
            }

            // Finalize circle
            if (currentCircle != null) {
                if (currentCircle.getRadius() <= 1) {
                    getChildren().remove(currentCircle);
                }
                allFigures.add(currentCircle);
            }

            currentRectangle = null;
            currentCircle = null;

            // Finalize polygon on double-click
            if (e.getClickCount() == 2) {
                if (currentPolygon != null) {
                    allFigures.add(currentPolygon);
                }
                currentPolygon = null;
            }

            // Hide color picker when not right-clicking
            if (e.getButton() != MouseButton.SECONDARY) {
                getChildren().remove(colorPicker);
            }
        });
    }

    /**
     * Saves all shapes currently on the canvas to a binary file.
     *
     * Converts each {@link Shape} in the canvas into its corresponding
     * {@link ShapeData} object (preserving all transformations and colors),
     * then opens a {@link FileChooser} dialog for the user to choose the save location.
     * The file is saved with a {@code .fig} extension via {@link FileIO#saveToFile}.
     */
    public void saveDrawing() {
        ArrayList<ShapeData> listToSave = new ArrayList<>();
        for (Shape s : allFigures) {
            if (s instanceof Rectangle) {
                Rectangle rect = (Rectangle) s;
                RectangleData sData = new RectangleData(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
                sData.setTranslateX(s.getTranslateX());
                sData.setTranslateY(s.getTranslateY());
                sData.setScaleX(s.getScaleX());
                sData.setScaleY(s.getScaleY());
                sData.setRotate(s.getRotate());
                sData.setStrokeWidth(s.getStrokeWidth());
                sData.setStrokeColor(s.getStroke().toString());
                sData.setFillColor(s.getFill().toString());
                listToSave.add(sData);
            } else if (s instanceof Circle) {
                Circle circ = (Circle) s;
                CircleData sData = new CircleData(circ.getCenterX(), circ.getCenterY(), circ.getRadius());
                sData.setTranslateX(s.getTranslateX());
                sData.setTranslateY(s.getTranslateY());
                sData.setScaleX(s.getScaleX());
                sData.setScaleY(s.getScaleY());
                sData.setRotate(s.getRotate());
                sData.setStrokeWidth(s.getStrokeWidth());
                sData.setStrokeColor(s.getStroke().toString());
                sData.setFillColor(s.getFill().toString());
                listToSave.add(sData);
            } else if (s instanceof Polygon) {
                Polygon poly = (Polygon) s;
                // poly.getPoints() returns ObservableList, not ArrayList — explicit copy needed
                PolygonData sData = new PolygonData(new ArrayList<>(poly.getPoints()));
                sData.setTranslateX(s.getTranslateX());
                sData.setTranslateY(s.getTranslateY());
                sData.setScaleX(s.getScaleX());
                sData.setScaleY(s.getScaleY());
                sData.setRotate(s.getRotate());
                sData.setStrokeWidth(s.getStrokeWidth());
                sData.setStrokeColor(s.getStroke().toString());
                sData.setFillColor(s.getFill().toString());
                listToSave.add(sData);
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save figures");
        java.io.File file = fileChooser.showSaveDialog(getScene().getWindow());
        if (file != null) {
            FileIO.saveToFile(listToSave, file.getAbsolutePath());
        }
    }

    /**
     * Loads shapes from a binary file and adds them to the current canvas.
     *
     * Opens a {@link FileChooser} dialog for the user to select a {@code .fig} file,
     * then deserializes the shapes via {@link FileIO#loadFromFile} and reconstructs
     * the corresponding JavaFX {@link Shape} objects with all saved properties restored.
     * Loaded shapes are appended to the existing canvas without clearing it.
     */
    public void loadDrawing() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load figures");
        java.io.File file = fileChooser.showOpenDialog(getScene().getWindow());

        if (file == null) return;

        ArrayList<ShapeData> loadedFigures = FileIO.loadFromFile(file.getAbsolutePath());
        for (ShapeData sData : loadedFigures) {
            if (sData instanceof RectangleData) {
                Rectangle rect = new Rectangle();
                RectangleData shape = (RectangleData) sData;
                rect.setX(shape.getX());
                rect.setY(shape.getY());
                rect.setWidth(shape.getWidth());
                rect.setHeight(shape.getHeight());
                rect.setTranslateX(shape.getTranslateX());
                rect.setTranslateY(shape.getTranslateY());
                rect.setScaleX(shape.getScaleX());
                rect.setScaleY(shape.getScaleY());
                rect.setRotate(shape.getRotate());
                rect.setStrokeWidth(shape.getStrokeWidth());
                rect.setFill(Color.valueOf(shape.getFillColor()));
                rect.setStroke(Color.valueOf(shape.getStrokeColor()));
                getChildren().add(rect);
                allFigures.add(rect);
            } else if (sData instanceof CircleData) {
                Circle circ = new Circle();
                CircleData shape = (CircleData) sData;
                circ.setCenterX(shape.getCenterX());
                circ.setCenterY(shape.getCenterY());
                circ.setRadius(shape.getRadius());
                circ.setTranslateX(shape.getTranslateX());
                circ.setTranslateY(shape.getTranslateY());
                circ.setScaleX(shape.getScaleX());
                circ.setScaleY(shape.getScaleY());
                circ.setRotate(shape.getRotate());
                circ.setStrokeWidth(shape.getStrokeWidth());
                circ.setFill(Color.valueOf(shape.getFillColor()));
                circ.setStroke(Color.valueOf(shape.getStrokeColor()));
                getChildren().add(circ);
                allFigures.add(circ);
            } else if (sData instanceof PolygonData) {
                Polygon poly = new Polygon();
                PolygonData shape = (PolygonData) sData;
                poly.getPoints().addAll(shape.getPoints());
                poly.setTranslateX(shape.getTranslateX());
                poly.setTranslateY(shape.getTranslateY());
                poly.setScaleX(shape.getScaleX());
                poly.setScaleY(shape.getScaleY());
                poly.setRotate(shape.getRotate());
                poly.setStrokeWidth(shape.getStrokeWidth());
                poly.setFill(Color.valueOf(shape.getFillColor()));
                poly.setStroke(Color.valueOf(shape.getStrokeColor()));
                getChildren().add(poly);
                allFigures.add(poly);
            }
        }
    }

    /**
     * Sets the active drawing tool mode.
     * @param mode The {@link ToolMode} to activate (CIRCLE, RECTANGLE, or POLYGON).
     */
    public void setToolMode(ToolMode mode) {
        currentMode = mode;
    }

    /**
     * Sets the default fill color for newly created shapes.
     * @param c The {@link Color} to use as fill for the next drawn shape.
     */
    public void setFillColor(Color c) {
        currentFillColor = c;
    }
}
