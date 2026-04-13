#include "Figures.hpp"
#include <iostream>
#include <string>
#include <cmath>
#include <vector>

Quadrangle::Quadrangle(int a, int b, int c, int d, int k){
    this->side1 = a;
    this->side2 = b;
    this->side3 = c;
    this->side4 = d;
    this->angle = k;
}

double Quadrangle::calculatePerimeter(){
    return side1 + side2 + side3 + side4;
}

Square::Square(int a) : Quadrangle(a,a,a,a,90){} // odpowiednik super()

double Square::calculateArea(){
    return side1 * side1;
}

std::string Square::getName(){
    return "Square";
}

Rectangle::Rectangle(int a, int b) : Quadrangle(a,b,a,b, 90){}

double Rectangle::calculateArea(){
    return side1 * side2;
}
    
std::string Rectangle::getName(){
    return "Rectangle";
}

Diamond::Diamond(int a, int k) : Quadrangle(a, a, a, a, k){}

double Diamond::calculateArea(){
    return side1*side1*sqrt(angle*(M_PI/180));
}

std::string Diamond::getName(){
    return "Diamond";
}

Circle::Circle(int r){
    this->radius = r;
}

double Circle::calculateArea(){
    return radius * radius * M_PI;
}

double Circle::calculatePerimeter(){
    return 2 * radius * M_PI;
}

std::string Circle::getName(){
    return "Circle";
}


Pentagon::Pentagon(int a){
    this->side = a;
}

double Pentagon::calculateArea(){
    return ((side*side)/4.0)*(sqrt(25 + (10 * sqrt(5))));
}

double Pentagon::calculatePerimeter(){
    return 5 * side;
}

std::string getName(){
    return "Pentagon";
}

Hexagon::Hexagon(int a){
    this->side = a;
}

double Hexagon::calculateArea(){
    return side * side * sqrt(6.75);
}

double Hexagon::calculatePerimeter(){
    return 6*side;
}

std::string Hexagon::getName(){
    return "Hexagon";
}



void main(int argc, char* argv[]){
    if(argc == 1){
        std::cout << "Nie podano argumentów" << "\n";
        return;
    }
    std::vector<Figure*> figures;
    int i = 1;
    while (i < argc){
        try{
            std::string figure  = argv[i];
            i++;
            if(figure == "c"){
                int side1 = std::stoi(argv[i]);
                int side2 = std::stoi(argv[i+1]);
                int side3 = std::stoi(argv[i+2]);
                int side4 = std::stoi(argv[i+3]);
                int angle = std::stoi(argv[i+4]);
                i+=5;

                if(side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0){
                    std::cout << "Nieprawidłowy bok dla: " << figure << "\n";
                    continue;
                }
                if(side1 == side2 && side2 == side3 && side3 == side4 && angle == 90){
                    Square f(side1);
                    figures.push_back(&f);
                }
            }
        }
    }


}