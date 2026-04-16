#pragma once
#include <string>
#include <cmath>

enum OneParameter{
    CIRCLE,
    SQUARE,
    PENTAGON,
    HEXAGON
};

enum TwoParameter{
    RECTANGLE,
    DIAMOND
};
class Figure{

        public:
            class OneParameterCalc{
                virtual double calculateArea(int a);
                virtual double calculatePerimeter(int a);
                virtual std::string getName();
            };

            class TwoParameterCalc{
                virtual double calculateArea(int a, int b);
                virtual double calculatePerimeter(int a, int b);
                virtual std::string getName();
            };
};

class Square : public Figure::OneParameterCalc{
    public:
        Square();
    
        double calculateArea(int a);

        double calculatePerimeter(int a);

        std::string getName();

        ~Square();
};

class Circle : public Figure::OneParameterCalc{
    public: 
        Circle();

        double calculateArea(int a);

        double calculatePerimeter(int a);

        std::string getName();

        ~Circle();
};

class Pentagon : public Figure::OneParameterCalc{
    public:
        Pentagon();

        double calculateArea(int a);
        
        double calculatePerimeter(int a);

        std::string getName();

        ~Pentagon();
};

class Hexagon : public Figure::OneParameterCalc{
    public:
        Hexagon();

        double calculateArea(int a);

        double calculatePerimeter(int a);

        std::string getName();

        ~Hexagon();

};

class Rectangle : public Figure::TwoParameterCalc{
    public:
        Rectangle();

        double calculateArea(int a, int b);

        double calculatePerimeter(int a, int b);

        std::string getName();
        ~Rectangle();
};

class Diamond : public Figure::TwoParameterCalc{
    public:
        Diamond();
        
        double calculateArea(int a, int b);

        double calculatePerimeter(int a, int b);

        std::string getName();
        
        ~Diamond();
};


