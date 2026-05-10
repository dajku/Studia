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
        if(currentMode == ToolMode.RECTANGLE){

            setOnMousePressed(e ->{
                startX = e.getX();
                startY = e.getY();

                currentRectangle = new Rectangle();
                currentRectangle.setX(startX);
                currentRectangle.setY(startY);
                currentRectangle.setWidth(0);
                currentRectangle.setHeight(0);
                currentRectangle.setFill(Color.LIGHTBLUE);
                currentRectangle.setStroke(Color.BLACK);

                getChildren().add(currentRectangle);
            });

            setOnMouseDragged(e -> {
                double currentX = e.getX();
                double currentY = e.getY();

                double x = Math.min(startX, currentX);
                double y = Math.min(startY, currentY);
                double width = Math.abs(currentX - startX);
                double height = Math.abs(currentY - startY);

                currentRectangle.setX(x);
                currentRectangle.setY(y);
                currentRectangle.setWidth(width);
                currentRectangle.setHeight(height);
            });

            setOnMouseReleased(e -> {
                currentRectangle = null;
            });
        }
        else if(currentMode == ToolMode.CIRCLE){

            setOnMousePressed(e ->{
                startX = e.getX();
                startY = e.getY();

                currentCircle = new Circle();
                currentCircle.setCenterX(startX);
                currentCircle.setCenterY(startY);
                currentCircle.setFill(Color.LIGHTBLUE);
                currentCircle.setStroke(Color.BLACK);

                getChildren().add(currentCircle);
            });

            setOnMouseDragged(e -> {
                double currentX = e.getX();
                double currentY = e.getY();

                double x = Math.min(startX, currentX);
                double y = Math.min(startY, currentY);
                double radius = Math.abs(Math.sqrt((currentX - startX)*(currentX - startX) + (currentY - startY)*(currentY - startY)));

                currentCircle.setCenterX(x);
                currentCircle.setCenterY(y);
                currentCircle.setRadius(radius);
            });

            setOnMouseReleased(e -> {
                currentCircle = null;
            });
        }
    }

    public void setToolMode(ToolMode mode){
        currentMode = mode;
    }
}