#include <string>
#include <iostream>
#include <vector>
#include <cmath>
#include "Zad4.hpp"

Square::Square() {};

double Square::calculateArea(int a)
{
    return a * a;
}

double Square::calculatePerimeter(int a)
{
    return 4 * a;
}

std::string Square::getName()
{
    return "Square";
}
Square::~Square() {};

Circle::Circle() {};

double Circle::calculateArea(int a)
{
    return a * a * M_PI;
}
double Circle::calculatePerimeter(int a)
{
    return 2 * a * M_PI;
}
std::string Circle::getName()
{
    return "Circle";
}
Circle::~Circle() {};

Pentagon::Pentagon() {};

double Pentagon::calculateArea(int a)
{
    return ((a * a) / 4.0) * (sqrt(25 + (10 * sqrt(5))));
}

double Pentagon::calculatePerimeter(int a)
{
    return 5 * a;
}

std::string Pentagon::getName()
{
    return "Pentagon";
}

Pentagon::~Pentagon() {};

Hexagon::Hexagon() {};

double Hexagon::calculateArea(int a)
{
    return a * a * sqrt(6.75);
}
double Hexagon::calculatePerimeter(int a)
{
    return 6 * a;
}
std::string Hexagon::getName()
{
    return "Hexagon";
}

Hexagon::~Hexagon() {};

Rectangle::Rectangle() {};

double Rectangle::calculateArea(int a, int b)
{
    return a * b;
}
double Rectangle::calculatePerimeter(int a, int b)
{
    return 2 * a + 2 * b;
}
std::string Rectangle::getName()
{
    return "Rectangle";
}

Rectangle::~Rectangle() {};

Diamond::Diamond() {};

double Diamond::calculateArea(int a, int b)
{
    return a * a * sin(b * (M_PI / 180));
}
double Diamond::calculatePerimeter(int a, int b)
{
    return 4 * a;
}
std::string Diamond::getName()
{
    return "Diamond";
}

Diamond::~Diamond() {};

Figure::OneParameterCalc *createOneParamFigure(OneParameter type)
{
    switch (type)
    {
    case CIRCLE:
        return new Circle();
    case SQUARE:
        return new Square();
    case PENTAGON:
        return new Pentagon();
    case HEXAGON:
        return new Hexagon();
    default:
        return nullptr;
    }
}

Figure::TwoParameterCalc *createTwoParamFigure(TwoParameter type)
{
    switch (type)
    {
    case RECTANGLE:
        return new Rectangle();
    case DIAMOND:
        return new Diamond();
    default:
        return nullptr;
    }
}

int main(int argc, char *argv[])
{
    if (argc == 1)
    {
        std::cout << "Nie podano argumentów" << "\n";
        return 1;
    }

    int i = 1;
    while (i < argc)
    {
        try
        {
            std::string figure = argv[i];
            i++;
            if (figure == "q" and std::stoi(argv[i + 1]) == 90)
            {
                int side1 = std::stoi(argv[i]);
                int side2 = std::stoi(argv[i]);
                int side3 = std::stoi(argv[i]);
                int side4 = std::stoi(argv[i]);
                int angle = std::stoi(argv[i + 1]);
                i += 2;
                if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0)
                {
                    std::cout << "Nieprawidłowy bok dla: " << figure << "\n";
                    continue;
                }
                if (side1 == side2 && side2 == side3 && side3 == side4 && angle == 90)
                {
                    OneParameter type = SQUARE;
                    Figure::OneParameterCalc *f = createOneParamFigure(type);
                    std::cout << f->getName() << "\n";
                    std::cout << "Area: " << f->calculateArea(side1) << "\n";
                    std::cout << "Perimeter: " << f->calculatePerimeter(side1) << "\n";
                    delete f;
                }
                continue;
            }
            if (figure == "q")
            {
                int side1 = std::stoi(argv[i]);
                int side2 = std::stoi(argv[i + 1]);
                int side3 = std::stoi(argv[i + 2]);
                int side4 = std::stoi(argv[i + 3]);
                int angle = std::stoi(argv[i + 4]);
                i += 5;

                if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0)
                {
                    std::cout << "Nieprawidłowy bok dla: " << figure << "\n";
                    continue;
                }
                if (side1 == side2 && side2 == side3 && side3 == side4 && angle == 90)
                {
                    OneParameter type = SQUARE;
                    Figure::OneParameterCalc *f = createOneParamFigure(type);
                    std::cout << f->getName() << "\n";
                    std::cout << "Area: " << f->calculateArea(side1) << "\n";
                    std::cout << "Perimeter: " << f->calculatePerimeter(side1) << "\n";
                    delete f;
                }
                else if (side1 == side2 && side2 == side3 && side3 == side4)
                {
                    TwoParameter type = DIAMOND;
                    Figure::TwoParameterCalc *f = createTwoParamFigure(type);
                    std::cout << f->getName() << "\n";
                    std::cout << "Area: " << f->calculateArea(side1, angle) << "\n";
                    std::cout << "Perimeter: " << f->calculatePerimeter(side1, angle) << "\n";
                    delete f;
                }
                else if (side1 == side2 && side3 == side4 && angle == 90)
                {
                    TwoParameter type = RECTANGLE;
                    Figure::TwoParameterCalc *f = createTwoParamFigure(type);
                    std::cout << f->getName() << "\n";
                    std::cout << "Area: " << f->calculateArea(side1, side3) << "\n";
                    std::cout << "Perimeter: " << f->calculatePerimeter(side1, side3) << "\n";
                    delete f;
                }
                else if (side1 == side3 && side2 == side4 && angle == 90)
                {
                    TwoParameter type = RECTANGLE;
                    Figure::TwoParameterCalc *f = createTwoParamFigure(type);
                    std::cout << f->getName() << "\n";
                    std::cout << "Area: " << f->calculateArea(side1, side2) << "\n";
                    std::cout << "Perimeter: " << f->calculatePerimeter(side1, side2) << "\n";
                    delete f;
                }
            }
            else if (figure == "c")
            {
                int radius = std::stoi(argv[i]);
                i++;
                if (radius <= 0)
                {
                    std::cout << "Nieprawidłowy promień dla: " << figure << "\n";
                    continue;
                }
                OneParameter type = CIRCLE;
                Figure::OneParameterCalc *f = createOneParamFigure(type);
                std::cout << f->getName() << "\n";
                std::cout << "Area: " << f->calculateArea(radius) << "\n";
                std::cout << "Perimeter: " << f->calculatePerimeter(radius) << "\n";
                delete f;
            }
            else if (figure == "p")
            {
                int side = std::stoi(argv[i]);
                i++;
                if (side <= 0)
                {
                    std::cout << "Nieprawidłowy bok dla: " << figure << "\n";
                    continue;
                }
                OneParameter type = PENTAGON;
                Figure::OneParameterCalc *f = createOneParamFigure(type);
                std::cout << f->getName() << "\n";
                std::cout << "Area: " << f->calculateArea(side) << "\n";
                std::cout << "Perimeter: " << f->calculatePerimeter(side) << "\n";
                delete f;
            }
            else if (figure == "h")
            {
                int side = std::stoi(argv[i]);
                i++;
                if (side <= 0)
                {
                    std::cout << "Nieprawidłowy bok dla " << figure << "\n";
                    continue;
                }
                OneParameter type = HEXAGON;
                Figure::OneParameterCalc *f = createOneParamFigure(type);
                std::cout << f->getName() << "\n";
                std::cout << "Area: " << f->calculateArea(side) << "\n";
                std::cout << "Perimeter: " << f->calculatePerimeter(side) << "\n";
                delete f;
            }
            else{
                std::cout << "Nieprawidłowa figura \n";
                continue;
            }
        }
        catch (const std::invalid_argument &ex)
        {
            std::cout << "Nieprawidłowa dana: " << ex.what() << "\n";
            continue;
        }
        catch (const std::out_of_range &ex)
        {
            std::cout << "Za mało parametrów" << "\n";
            continue;
        }
        catch (const std::logic_error &ex)
        {
            std::cout << "Błędne podanie parametrów" << "\n";
            continue;
        }
    }
}
