import java.io.Serializable;
import java.util.ArrayList;


abstract public class ShapeData implements Serializable {
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




