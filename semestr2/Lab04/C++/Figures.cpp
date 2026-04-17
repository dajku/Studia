#include "Figures.hpp"
#include <iostream>
#include <string>
#include <cmath>
#include <vector>

Quadrangle::Quadrangle(int a, int b, int c, int d, int k) : side1(a), side2(b), side3(c), side4(d), angle(k) {}

double Quadrangle::calculatePerimeter()
{
    return side1 + side2 + side3 + side4;
}

Square::Square(int a) : Quadrangle(a, a, a, a, 90) {} // odpowiednik super()

double Square::calculateArea()
{
    return side1 * side1;
}

std::string Square::getName()
{
    return "Square";
}

Rectangle::Rectangle(int a, int b) : Quadrangle(a, b, a, b, 90) {}

double Rectangle::calculateArea()
{
    return side1 * side2;
}

std::string Rectangle::getName()
{
    return "Rectangle";
}

Diamond::Diamond(int a, int k) : Quadrangle(a, a, a, a, k) {}

double Diamond::calculateArea()
{
    return side1 * side1 * sin(angle * (M_PI / 180));
}

std::string Diamond::getName()
{
    return "Diamond";
}

Circle::Circle(int r) : radius(r) {}

double Circle::calculateArea()
{
    return radius * radius * M_PI;
}

double Circle::calculatePerimeter()
{
    return 2 * radius * M_PI;
}

std::string Circle::getName()
{
    return "Circle";
}

Pentagon::Pentagon(int a) : side(a) {}

double Pentagon::calculateArea()
{
    return ((side * side) / 4.0) * (sqrt(25 + (10 * sqrt(5))));
}

double Pentagon::calculatePerimeter()
{
    return 5 * side;
}

std::string Pentagon::getName()
{
    return "Pentagon";
}

Hexagon::Hexagon(int a) : side(a) {}

double Hexagon::calculateArea()
{
    return side * side * sqrt(6.75);
}

double Hexagon::calculatePerimeter()
{
    return 6 * side;
}

std::string Hexagon::getName()
{
    return "Hexagon";
}


Octagon::Octagon(int a) : side(a){}

double Octagon::calculateArea(){
    return side * side * (2 * (1 + sqrt(2)));
}

double Octagon::calculatePerimeter(){
    return 8 * side;
}

std::string Octagon::getName(){
    return "Octagon";
}

int main(int argc, char *argv[])
{
    if (argc == 1)
    {
        std::cout << "Nie podano argumentów" << "\n";
        return 1;
    }
    std::vector<Figure *> figures;
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
                    Square *f = new Square(side1);
                    figures.push_back(f);
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
                    Square *f = new Square(side1);
                    figures.push_back(f);
                }
                else if (side1 == side2 && side2 == side3 && side3 == side4)
                {
                    Diamond *f = new Diamond(side1, angle);
                    figures.push_back(f);
                }
                else if (side1 == side2 && side3 == side4 && angle == 90)
                {
                    Rectangle *f = new Rectangle(side1, side3);
                    figures.push_back(f);
                }
                else if (side1 == side3 && side2 == side4 && angle == 90)
                {
                    Rectangle *f = new Rectangle(side1, side2);
                    figures.push_back(f);
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
                Circle *f = new Circle(radius);
                figures.push_back(f);
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
                Pentagon *f = new Pentagon(side);
                figures.push_back(f);
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
                Hexagon *f = new Hexagon(side);
                figures.push_back(f);
            }
            else if (figure == "o"){
                int side = std::stoi(argv[i]);
                i++;
                if(side <= 0){
                    std::cout << "Nieprawidłowy bok dla " << figure << "\n";
                    continue;
                }
                Octagon *f = new Octagon(side);
                figures.push_back(f);
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
    for (Figure *f : figures)
    {
        std::cout << f->getName() << "\n";
        std::cout << "Area: " << f->calculateArea() << "\n";
        std::cout << "Perimeter: " << f->calculatePerimeter() << "\n";
        delete f;
    }
}