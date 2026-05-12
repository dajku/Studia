import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.shape.Shape;

public class ObjectsData implements Serializable{
    
    
    public ObjectsData(){

    }
    abstract class ShapeData implements Serializable{
        protected double translateX;
        protected double translateY;
        protected double scaleX;
        protected double scaleY;
        protected double rotate;
        protected double StrokeWidth;
        protected String color; 
    }
    
    class RectangleData extends ShapeData{
        private double width;
        private double height;

        public RectangleData(){
            
        }
        

    }

    class CircleData extends ShapeData{
        private double radius;
        public CircleData(){

        }
    }
    
    class PolygonData extends ShapeData{
        private ArrayList<Double> points;

        public PolygonData(){
            points = new ArrayList<Double>();
        }
    }
}