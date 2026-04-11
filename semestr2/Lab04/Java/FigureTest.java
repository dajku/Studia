package Java;
import java.lang.Math;
import java.util.ArrayList;

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
public class FigureTest{
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Nie podano argumentów");
            return;
        }
        ArrayList<Figure> figures = new ArrayList<>();
        int i = 0;
        while(i < args.length){
            try{
                String figure = args[i];
                i++;
                if(figure.equals("q")){

                    int side1 = Integer.parseInt(args[i]);
                    int side2 = Integer.parseInt(args[i+1]);
                    int side3 = Integer.parseInt(args[i+2]);
                    int side4 = Integer.parseInt(args[i+3]);
                    int angle = Integer.parseInt(args[i+4]);
                    i += 5;

                    if(side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0){
                        System.out.println("Nieprawidłowy bok dla: " + figure);
                        continue;
                    }
                    if(side1 == side2 && side2 == side3 && side3 == side4 && angle == 90){
                        Square f = new Square(side1);
                        figures.add(f);
                    }
                    else if(side1 == side2 && side2 == side3 && side3 == side4){
                        Diamond f = new Diamond(side1, angle);
                        figures.add(f);
                    }
                    else if(side1 == side2 && side3 == side4){
                        Rectangle f = new Rectangle(side1, side3);
                        figures.add(f);
                    }


                }
                else if(figure.equals("c")){
                    int radius = Integer.parseInt(args[i]);
                    i += 1;
                    if(radius <= 0){
                        System.out.println("Nieprawidłowy promień dla: " + figure);
                        continue;
                    }
                    Circle f = new Circle(radius);
                    figures.add(f);
                }
                else if(figure.equals("p")){
                    int side = Integer.parseInt(args[i]);
                    i += 1;
                    if(side <= 0){
                        System.out.println("Nieprawidłowy bok dla: " + figure);
                        continue;
                    }
                    Pentagon f = new Pentagon(side);
                    figures.add(f);

                }
                else if(figure.equals("h")){
                    int side = Integer.parseInt(args[i]);
                    i += 1;
                    if(side <= 0){
                        System.out.println("Nieprawidłowy bok dla: " + figure);
                        continue;
                    }
                    Hexagon f = new Hexagon(side);
                    figures.add(f);
                }
            } 
            catch(NumberFormatException ex){
                System.out.println(" Nieprawidłowa dana: " + ex.getMessage());
                continue;
            }
            catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Za mało parametrów");
                continue;
            }
        }

        for (Figure f : figures) {
            System.out.println(f.getName());
            System.out.println("Area: " + f.calculateArea());
            System.out.println("Perimeter: " + f.calculatePerimeter() + "\n");
        }


    }
}