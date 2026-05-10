import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class DrawingPane extends Pane{

    private double startX;
    private double startY;
    private Rectangle currentRectangle;
    private ToolMode currentMode;

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
            setOnMousePressed(e -> {
                
            })
        }
    }

    public setToolMode(ToolMode mode){
        currentMode = mode;
    }
}