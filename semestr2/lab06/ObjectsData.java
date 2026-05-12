import java.io.Serializable;
import java.util.ArrayList;

public class ObjectsData implements Serializable {

    public ObjectsData() {

    }

}

abstract class ShapeData implements Serializable {
    protected double translateX;
    protected double translateY;
    protected double scaleX;
    protected double scaleY;
    protected double rotate;
    protected double strokeWidth;
    protected String fillColor;
    protected String strokeColor;


    public double getTranslateX(){
        return translateX;
    }

    public double getTranslateY(){
        return translateY;
    }

    public double getScaleX(){
        return scaleX;
    }
    
    public double getScaleY(){
        return scaleY;
    }

    public double getRotate(){
        return rotate;
    }

    public double getStrokeWidth(){
        return strokeWidth;
    }

    public String getFillColor(){
        return fillColor;
    }

    public String getStrokeColor(){
        return strokeColor;
    }

    public void setTranslateX(double x){
        translateX = x;
    }

    public void setTranslateY(double y){
        translateY = y;
    }

    public void setScaleX(double x){
        scaleX = x;
    }
    
    public void setScaleY(double y){
        scaleY = y;
    }
    
    public void setRotate(double r){
        rotate = r;
    }

    public void setStrokeWidth(double s){
        strokeWidth = s;
    }

    public void setFillColor(String c){
        fillColor = c;
    }

    public void setStrokeColor(String c){
        strokeColor = c;
    }
}

class RectangleData extends ShapeData {
    private double width;
    private double height;
    private double x;
    private double y;

    public RectangleData(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }
    
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


}

class CircleData extends ShapeData {
    private double radius;
    private double centerX;
    private double centerY;

    public CircleData(double x, double y, double r) {
        radius = r;
        centerX = x;
        centerY = y;
    }

    public double getRadius(){
        return radius;
    }

    public double getCenterX(){
        return centerX;
    }
    
    public double getCenterY(){
        return centerY;
    }
    
}

class PolygonData extends ShapeData {
    private ArrayList<Double> points;

    public PolygonData(ArrayList<Double> p){
        points = new ArrayList<Double>();
        for (Double point : p) {
            points.add(point);
        }
    }

    public ArrayList<Double> getPoints(){
        return points;
    }
}