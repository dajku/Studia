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
                public:
                    virtual double calculateArea(int a) = 0;
                    virtual double calculatePerimeter(int a) = 0;
                    virtual std::string getName() = 0;

                    virtual ~OneParameterCalc() = default;
            };

            class TwoParameterCalc{
                public:
                    virtual double calculateArea(int a, int b) = 0;
                    virtual double calculatePerimeter(int a, int b) = 0;
                    virtual std::string getName() = 0;

                    virtual ~TwoParameterCalc() = default;
            };
};

class Square : public Figure::OneParameterCalc{
    public:
        Square();
    
        double calculateArea(int a) override;

        double calculatePerimeter(int a) override;

        std::string getName() override;

        ~Square();
};

class Circle : public Figure::OneParameterCalc{
    public: 
        Circle();

        double calculateArea(int a) override; 

        double calculatePerimeter(int a) override;

        std::string getName() override;

        ~Circle();
};

class Pentagon : public Figure::OneParameterCalc{
    public:
        Pentagon();

        double calculateArea(int a) override;
        
        double calculatePerimeter(int a) override;

        std::string getName() override;

        ~Pentagon();
};

class Hexagon : public Figure::OneParameterCalc{
    public:
        Hexagon();

        double calculateArea(int a) override;

        double calculatePerimeter(int a) override;

        std::string getName() override;

        ~Hexagon();

};

class Rectangle : public Figure::TwoParameterCalc{
    public:
        Rectangle();

        double calculateArea(int a, int b) override;

        double calculatePerimeter(int a, int b) override;

        std::string getName() override;
        ~Rectangle();
};

class Diamond : public Figure::TwoParameterCalc{
    public:
        Diamond();
        
        double calculateArea(int a, int b) override;

        double calculatePerimeter(int a, int b) override;

        std::string getName() override;
        
        ~Diamond();
};


