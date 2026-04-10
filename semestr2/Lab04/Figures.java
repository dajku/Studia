import java.lang.Math;

interface Calculate{
    double calculateArea();
    double calculatePerimeter();
}
abstract class Figure implements Calculate{
    public abstract String getName();

}

abstract class Quadrangle extends Figure{
    protected int side1 = 0;
    protected int side2 = 0;
    protected int side3 = 0;
    protected int side4 = 0;
    protected int angle = 0;

    protected Quadrangle(int a, int b, int c, int d, int k){
        this.side1 = a;
        this.side2 = b;
        this.side3 = c;
        this.side4 = d;
        this.angle = k;
    }

    public double calculatePerimeter(){
        return side1 + side2 + side3 + side4;
    }


}

class Square extends Quadrangle{
    public Square(int a){
        super(a, a, a, a, 90);
    }

    public double calculateArea(){
        return side1*side1;
    }


    public String getName(){
        return "Square";
    }
    
}

class Rectangle extends Quadrangle{

    
    public Rectangle(int a, int b){
        super(a, b, a, b, 90);
    }

    public double calculateArea(){
        return side1 * side2 ;
    }

    
    public String getName(){
        return "Rectangle";
    }

}

class Diamond extends Quadrangle{

    public Diamond(int a, int k){
        super(a, a, a, a, k);
    }

    public double calculateArea(){
        return side1*side1*Math.sin(Math.toRadians(angle));
    }

    public String getName(){
        return "Diamond";
    }
}

class Circle extends Figure{
    int radius = 0;
    public Circle(int r){
        this.radius = r;
    }

    public double calculateArea(){
        return radius * radius * Math.PI;
    }
    
    public double calculatePerimeter(){
        return 2 * radius * Math.PI;
    }
    
    public String getName(){
        return "Circle";
    }
}


class Pentagon extends Figure{

    int side = 0;
    public Pentagon(int a){
        this.side = a;
    }

    public double calculateArea(){
        return ((side * side)/4)*(Math.sqrt(25 + (10 * Math.sqrt(5))));
    }

    public double calculatePerimeter(){
        return 5 * side;
    }

    public String getName(){
        return "Pentagon";
    }
}

class Hexagon extends Figure{
    int side = 0;

    public Hexagon(int a){
        this.side = a;
    }

    public double calculateArea(){
        return side * side * Math.sqrt(6.75);
    }

    public double calculatePerimeter(){
        return 6*side;
    }

    public String getName(){
        return "Hexagon";
    }
}
public class Figures{}