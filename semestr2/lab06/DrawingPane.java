import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
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
    private ArrayList<ShapeData> listToSave;
    private Shape currentShape;


    public DrawingPane() {

        allFigures = new ArrayList<Shape>();
        listToSave = new ArrayList<ShapeData>();

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
            } 
            else{
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

                    currentRectangle.setFill(Color.LIGHTBLUE);
                    currentRectangle.setStroke(Color.BLACK);

                    getChildren().add(currentRectangle);
                }

                else if (currentMode == ToolMode.CIRCLE) {
                    currentCircle = new Circle();

                    currentCircle.setCenterX(startX);
                    currentCircle.setCenterY(startY);

                    currentCircle.setRadius(0);

                    currentCircle.setFill(Color.LIGHTBLUE);
                    currentCircle.setStroke(Color.BLACK);

                    getChildren().add(currentCircle);
                } else if (currentMode == ToolMode.POLYGON) {
                    if (currentPolygon == null) {

                        currentPolygon = new Polygon();

                        currentPolygon.setFill(Color.LIGHTBLUE);
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
        });

    }

    public void saveDrawing() {
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
                PolygonData sData = new PolygonData(new ArrayList<>(poly.getPoints())); // poly.getPoints() zwraca Observable list a nie ArrayList
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
        FileIO.saveToFile(listToSave, "Figures");
    }

    public void setToolMode(ToolMode mode) {
        currentMode = mode;
    }
}