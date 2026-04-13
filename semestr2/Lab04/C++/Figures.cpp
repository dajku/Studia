#include "Figures.hpp"


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

    
