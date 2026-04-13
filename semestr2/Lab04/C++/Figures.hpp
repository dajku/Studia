#pragma once
#include <string>



class Figure{
    public:
        virtual double calculateArea() = 0; 
        virtual double calculatePerimeter() = 0;
        virtual std::string getName() = 0;
    
        virtual ~Figure() {};
};

class Quadrangle : public Figure{
    public:
        double calculatePerimeter() override;
    protected:
        int side1, side2, side3, side4, angle;
        
        Quadrangle(int a, int b, int c, int d, int k);

        ~Quadrangle();
};

class Square : public Quadrangle{
    public:
        Square(int a);

        double calculateArea() override;

        std::string getName() override;
        ~Square();
};

class Rectangle : public Quadrangle{
    public:
        Rectangle(int a, int b);

        double calculateArea() override;

        std::string getName() override;

        ~Rectangle();
};

class Diamond : public Quadrangle{
    public:
        Diamond(int a, int k);

        double calculateArea() override;

        std::string getName() override;

        ~Diamond();
};

class Circle : public Figure{
    int radius;
    public:
        Circle(int r);

        double calculateArea() override;

        double calculatePerimeter() override;

        std::string getName() override;

        ~Circle();


};

class Pentagon : public Figure{
    int side;
    public:
        Pentagon(int a);

        double calculateArea() override;
        
        double calculatePerimeter() override;

        std::string getName() override;

        ~Pentagon();
};

class Hexagon : public Figure{
    int side;
    public:
        Hexagon(int a);

        double calculateArea() override;

        double calculatePerimeter() override;

        std::string getName() override;

        ~Hexagon();
};

