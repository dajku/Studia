import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;




public class DrawingPane extends Pane{

    private double startX;
    private double startY;
    private ToolMode currentMode;
    private Rectangle currentRectangle;
    private Circle currentCircle;
    

    public DrawingPane(){

            setOnMousePressed(e ->{
                startX = e.getX();
                startY = e.getY();

                if(currentMode == ToolMode.RECTANGLE){


                    currentRectangle = new Rectangle();
                    currentRectangle.setX(startX);
                    currentRectangle.setY(startY);
                    currentRectangle.setWidth(0);
                    currentRectangle.setHeight(0);
                    currentRectangle.setFill(Color.LIGHTBLUE);
                    currentRectangle.setStroke(Color.BLACK);

                    getChildren().add(currentRectangle);
                }

                else if(currentMode == ToolMode.CIRCLE){
                    currentCircle = new Circle();
                    currentCircle.setCenterX(startX);
                    currentCircle.setCenterY(startY);
                    currentCircle.setRadius(0);
                    currentCircle.setFill(Color.LIGHTBLUE);
                    currentCircle.setStroke(Color.BLACK);
                    getChildren().add(currentCircle);
                }
            });

            setOnMouseDragged(e -> {
                if(currentMode == ToolMode.RECTANGLE && currentRectangle != null){
                    double x = Math.min(startX, e.getX());
                    double y = Math.min(startY, e.getY());
                    double width = Math.abs(e.getX() - startX);
                    double height = Math.abs(e.getY() - startY);
                    currentRectangle.setX(x);
                    currentRectangle.setY(y);
                    currentRectangle.setWidth(width);
                    currentRectangle.setHeight(height);
                }
                else if(currentMode == ToolMode.CIRCLE && currentCircle != null){
                    double radius = Math.sqrt(
                        Math.pow(e.getX() - startX, 2) + Math.pow(e.getY() - startY, 2)
                    );
                    currentCircle.setRadius(radius);
                }


            });

            setOnMouseReleased(e -> {
                currentRectangle = null;
                currentCircle = null;
            });
        
        }
    

    public void setToolMode(ToolMode mode){
        currentMode = mode;
    }
}