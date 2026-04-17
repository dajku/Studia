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
        Quadrangle(int a, int b, int c, int d, int k);

    protected:
        int side1, side2, side3, side4, angle;
        
};

class Square : public Quadrangle{
    public:
        Square(int a);

        double calculateArea() override;

        std::string getName() override;
};

class Rectangle : public Quadrangle{
    public:
        Rectangle(int a, int b);

        double calculateArea() override;

        std::string getName() override;

};

class Diamond : public Quadrangle{
    public:
        Diamond(int a, int k);

        double calculateArea() override;

        std::string getName() override;

};

class Circle : public Figure{
    protected:
        int radius;
    public:
        Circle(int r);

        double calculateArea() override;

        double calculatePerimeter() override;

        std::string getName() override;



};

class Pentagon : public Figure{
    protected:
        int side;
    public:
        Pentagon(int a);

        double calculateArea() override;
        
        double calculatePerimeter() override;

        std::string getName() override;

};

class Hexagon : public Figure{
    protected:
        int side;
    public:
        Hexagon(int a);

        double calculateArea() override;

        double calculatePerimeter() override;

        std::string getName() override;

};

class Octagon : public Figure{
    protected:
        int side;
    public:
        Octagon(int a);

        double calculateArea() override;

        double calculatePerimeter() override;

        std::string getName() override;
};

