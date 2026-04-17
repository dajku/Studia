import java.util.ArrayList;

class Figure {

    interface OneParameterCalc{
        double calculateArea(int a);
        double calculatePerimeter(int a);
        String getName();
    }

    interface TwoParameterCalc{
        double calculateArea(int a, int b);
        double calculatePerimeter(int a, int b);
        String getName();
    }

    enum OneParameter implements OneParameterCalc{
        CIRCLE {
            @Override
            public double calculateArea(int a){
                return a * a * Math.PI;

            };
            @Override
            public double calculatePerimeter(int a){
                return 2 * a * Math.PI;
            }
            @Override
            public String getName(){
                return "Circle";
            }
        },
        SQUARE{
            @Override
            public double calculateArea(int a){
                return a * a;
            }
            @Override
            public double calculatePerimeter(int a){
                return 4*a;
            }
            @Override
            public String getName(){
                return "Square";
            }
        },
        PENTAGON{
            @Override
            public double calculateArea(int a){
                return ((a * a)/4.0)*(Math.sqrt(25 + (10 * Math.sqrt(5))));
            }
            @Override
            public double calculatePerimeter(int a){
                return 5*a;
            }
            @Override
            public String getName(){
                return "Pentagon";
            }
        },
        HEXAGON{
            @Override
            public double calculateArea(int a){
                return a * a * Math.sqrt(6.75);
            }
            @Override
            public double calculatePerimeter(int a){
                return 6*a;
            }
            @Override
            public String getName(){
                return "Hexagon";
            }
        },
        OCTAGON{
            @Override
            public double calculateArea(int a){
                return 2 * (1 + Math.sqrt(2)) * a * a;
            }
            @Override
            public double calculatePerimeter(int a){
                return 8 * a;
            }
            @Override
            public String getName(){
                return "Octagon";
            }
        }
    }

    enum TwoParameters implements TwoParameterCalc{
        RECTANGLE{
            @Override
            public double calculateArea(int a, int b){
                return a * b;
            }
            @Override
            public double calculatePerimeter(int a, int b){
                return 2*a + 2*b;
            }
            @Override
            public String getName(){
                return "Rectangle";
            }
        },
        DIAMOND{
            @Override
            public double calculateArea(int a, int b){
                return a*a*Math.sin(Math.toRadians(b));
            }
            @Override
            public double calculatePerimeter(int a, int b){
                return 4*a;
            }
            @Override
            public String getName(){
                return "Diamond";
            }
        }
    }
}


public class Zad3{
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Nie podano argumentów");
            return;
        }
        
        int i = 0;
        
        while (i < args.length) {
            try{
                String figure = args[i];
                i++;
                if(figure.equals("q") && Integer.parseInt(args[i+1]) == 90){
                    int side1 = Integer.parseInt(args[i]);
                    int side2 = Integer.parseInt(args[i]);
                    int side3 = Integer.parseInt(args[i]);
                    int side4 = Integer.parseInt(args[i]);
                    int angle = Integer.parseInt(args[i+1]);
                    i += 2;
                    if(side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0){
                        System.out.println("Nieprawidłowy bok dla: " + figure);
                        continue;
                    }
                    if(side1 == side2 && side2 == side3 && side3 == side4 && angle == 90){
                        String name = Figure.OneParameter.SQUARE.getName();
                        double area = Figure.OneParameter.SQUARE.calculateArea(side1);
                        double perimeter = Figure.OneParameter.SQUARE.calculatePerimeter(side1);
            
                        System.out.println(name);
                        System.out.println("Area: " + area);
                        System.out.println("Perimeter: " + perimeter + "\n");
                        
                    }
                    continue;
                }
                
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
                        String name = Figure.OneParameter.SQUARE.getName();
                        double area = Figure.OneParameter.SQUARE.calculateArea(side1);
                        double perimeter = Figure.OneParameter.SQUARE.calculatePerimeter(side1);
            
                        System.out.println(name);
                        System.out.println("Area: " + area);
                        System.out.println("Perimeter: " + perimeter + "\n");
                        
                    }
                    else if(side1 == side2 && side2 == side3 && side3 == side4){

                        String name = Figure.TwoParameters.DIAMOND.getName();
                        double area = Figure.TwoParameters.DIAMOND.calculateArea(side1, angle);
                        double perimeter = Figure.TwoParameters.DIAMOND.calculatePerimeter(side1, side1);
            
                        System.out.println(name);
                        System.out.println("Area: " + area);
                        System.out.println("Perimeter: " + perimeter + "\n");

                    }
                    else if(side1 == side2 && side3 == side4 && angle == 90){
                        String name = Figure.TwoParameters.RECTANGLE.getName();
                        double area = Figure.TwoParameters.RECTANGLE.calculateArea(side1,side3);
                        double perimeter = Figure.TwoParameters.RECTANGLE.calculatePerimeter(side1, side3);
            
                        System.out.println(name);
                        System.out.println("Area: " + area);
                        System.out.println("Perimeter: " + perimeter + "\n");

                    }
                    else if(side1 == side3 && side2 == side4 && angle == 90){
                        String name = Figure.TwoParameters.RECTANGLE.getName();
                        double area = Figure.TwoParameters.RECTANGLE.calculateArea(side1,side2);
                        double perimeter = Figure.TwoParameters.RECTANGLE.calculatePerimeter(side1, side2);
            
                        System.out.println(name);
                        System.out.println("Area: " + area);
                        System.out.println("Perimeter: " + perimeter + "\n");   

                    }


                }
                else if(figure.equals("c")){
                    int radius = Integer.parseInt(args[i]);
                    i += 1;
                    if(radius <= 0){
                        System.out.println("Nieprawidłowy promień dla: " + figure);
                        continue;
                    }
                    String name = Figure.OneParameter.CIRCLE.getName();
                    double area = Figure.OneParameter.CIRCLE.calculateArea(radius);
                    double perimeter = Figure.OneParameter.CIRCLE.calculatePerimeter(radius);
            
                    System.out.println(name);
                    System.out.println("Area: " + area);
                    System.out.println("Perimeter: " + perimeter + "\n");

                }
                else if(figure.equals("p")){
                    int side = Integer.parseInt(args[i]);
                    i += 1;
                    if(side <= 0){
                        System.out.println("Nieprawidłowy bok dla: " + figure);
                        continue;
                    }
                    String name = Figure.OneParameter.PENTAGON.getName();
                    double area = Figure.OneParameter.PENTAGON.calculateArea(side);
                    double perimeter = Figure.OneParameter.PENTAGON.calculatePerimeter(side);
            
                    System.out.println(name);
                    System.out.println("Area: " + area);
                    System.out.println("Perimeter: " + perimeter + "\n");
                    


                }
                else if(figure.equals("h")){
                    int side = Integer.parseInt(args[i]);
                    i += 1;
                    if(side <= 0){
                        System.out.println("Nieprawidłowy bok dla: " + figure);
                        continue;
                    }
                    String name = Figure.OneParameter.HEXAGON.getName();
                    double area = Figure.OneParameter.HEXAGON.calculateArea(side);
                    double perimeter = Figure.OneParameter.HEXAGON.calculatePerimeter(side);
            
                    System.out.println(name);
                    System.out.println("Area: " + area);
                    System.out.println("Perimeter: " + perimeter + "\n");                    

                }
                else if(figure.equals("o")){
                    int side = Integer.parseInt(args[i]);
                    i += 1;
                    if(side <= 0){
                        System.out.println("Nieprawidłowy bok dla: " + figure);
                        continue;
                    }
                    String name = Figure.OneParameter.OCTAGON.getName();
                    double area = Figure.OneParameter.OCTAGON.calculateArea(side);
                    double perimeter = Figure.OneParameter.OCTAGON.calculatePerimeter(side);
                    
                    System.out.println(name);
                    System.out.println("Area: " + area);
                    System.out.println("Perimeter: " + perimeter + "\n");   
                    

                }
                else{
                    System.out.println("Nieprawidłowa figura");
                    continue;
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
    }
}