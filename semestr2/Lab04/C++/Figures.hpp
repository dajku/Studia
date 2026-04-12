#include <string>


class Figure{
    public:
        virtual double calculateArea() = 0;
        virtual double calculatePerimeter() = 0;
        virtual std::string getName() = 0;
    
        virtual ~Figure() {};
};

class Quadrangle : Figure{
    public:
        double calculatePerimeter();
    protected:
        Quadrangle(int a, int b, int c, int d, int k);

        ~Quadrangle();
};

class Square : public Quadrangle{
    public:
        Square(int a);

        double calculateArea();

        std::string getName();
        ~Square();
};

class Rectangle : public Quadrangle{
    public:
        Rectangle(int a, int b);

        double calculateArea();

        std::string getName();

        ~Rectangle();
};

class Diamond : public Quadrangle{
    public:
        Diamond(int a, int k);

        double calculateArea();

        std::string getName();

        ~Diamond();
};

class Circle : public Figure{
    public:
        Circle(int r);

        double calculateArea();

        double calculatePerimeter();

        std::string getName();

        ~Circle();


};

class Pentagon : public Figure{
    public:
        Pentagon(int a);

        double calculateArea();
        
        double calculatePerimeter();

        std::string getName();

        ~Pentagon();
};

class Hexagon : public Figure{
    public:
        Hexagon(int a);

        double calculateArea();

        double calculatePerimeter();

        std::string getName();

        ~Hexagon();
};

