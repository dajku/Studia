import java.util.ArrayList;

import org.w3c.dom.css.Rect;

import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class DrawingPane extends Pane {

    private double startX;
    private double startY;
    private double lastMouseX;
    private double lastMouseY;
    private ToolMode currentMode;
    private Rectangle currentRectangle;
    private Circle currentCircle;
    private Polygon currentPolygon;
    private ArrayList<Shape> allFigures;
    private Shape currentShape;
    private Color currentFillColor = Color.WHITE;
    private ColorPicker colorPicker;

    public DrawingPane() {

        allFigures = new ArrayList<Shape>();
        colorPicker = new ColorPicker();

        setOnMousePressed(e -> {
            startX = e.getX();
            startY = e.getY();
            lastMouseX = e.getSceneX();
            lastMouseY = e.getSceneY();

            Object target = e.getTarget();
            if (target instanceof Shape) {
                currentShape = (Shape) target; // sprawdziłem Shape, rzutuję Shape na target
                currentShape.setStrokeWidth(3);
                setOnScroll(s -> {
                    if (s.isShiftDown()) {
                        currentShape.setRotate(currentShape.getRotate() + s.getDeltaY() * 0.1 + s.getDeltaX() * 0.1);
                    } else {
                        currentShape.setScaleX(currentShape.getScaleX() + s.getDeltaY() * 0.0005);
                        currentShape.setScaleY(currentShape.getScaleY() + s.getDeltaY() * 0.0005);
                    }
                });
                if (e.getButton() == MouseButton.SECONDARY && !(getChildren().contains(colorPicker))) {
                    colorPicker.setLayoutX(e.getX());
                    colorPicker.setLayoutY(e.getY());

                    getChildren().add(colorPicker);
                    colorPicker.setOnAction(ex -> {
                        currentShape.setFill(colorPicker.getValue());
                    });
                }

            } else {
                if (currentShape != null) {
                    currentShape.setStrokeWidth(1);
                }
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
                }

                else if (currentMode == ToolMode.CIRCLE) {
                    currentCircle = new Circle();

                    currentCircle.setCenterX(startX);
                    currentCircle.setCenterY(startY);

                    currentCircle.setRadius(0);

                    currentCircle.setFill(currentFillColor);
                    currentCircle.setStroke(Color.BLACK);

                    getChildren().add(currentCircle);
                } else if (currentMode == ToolMode.POLYGON) {
                    if (currentPolygon == null) {

                        currentPolygon = new Polygon();

                        currentPolygon.setFill(currentFillColor);
                        currentPolygon.setStroke(Color.BLACK);

                        currentPolygon.getPoints().addAll(startX, startY);

                        getChildren().add(currentPolygon);

                    } else {
                        currentPolygon.getPoints().addAll(e.getX(), e.getY());
                    }

                }
            }
        });

        setOnMouseDragged(e -> {
            double currentX = e.getX();
            double currentY = e.getY();
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
                double radius = Math.sqrt(
                        Math.pow(currentX - startX, 2) + Math.pow(currentY - startY, 2));
                currentCircle.setRadius(radius);
            }

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
            if (currentRectangle != null) {
                if (currentRectangle.getWidth() <= 1) {
                    getChildren().remove(currentRectangle);
                }
                allFigures.add(currentRectangle);

            }
            if (currentCircle != null) {
                if (currentCircle.getRadius() <= 1) {
                    getChildren().remove(currentCircle);
                }
                allFigures.add(currentCircle);

            }

            currentRectangle = null;
            currentCircle = null;

            if (e.getClickCount() == 2) {
                if (currentPolygon != null) {
                    allFigures.add(currentPolygon);
                }
                currentPolygon = null;

            }

            if (e.getButton() != MouseButton.SECONDARY) {
                getChildren().remove(colorPicker);
            }

        });

    }

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
                PolygonData sData = new PolygonData(new ArrayList<>(poly.getPoints())); // poly.getPoints() zwraca
                                                                                        // Observable list a nie
                                                                                        // ArrayList
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

    public void loadDrawing() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load figures");

        java.io.File file = fileChooser.showOpenDialog(getScene().getWindow());

        if (file == null) {
            return;
        }
        ArrayList<ShapeData> loadedFigures = FileIO.loadFromFile(file.getAbsolutePath());
        // getChildren().clear();
        // allFigures.clear();
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

    public void setToolMode(ToolMode mode) {
        currentMode = mode;
    }

    public void setFillColor(Color c) {
        currentFillColor = c;
    }
}