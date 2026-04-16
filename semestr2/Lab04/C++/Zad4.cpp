#pragma once
#include <string>
#include <cmath>
#include "Zad4.hpp"



    
double Square::calculateArea(int a){
    return a * a;
}

double Square::calculatePerimeter(int a){
    return 4 * a;
}

std::string Square::getName() {
    return "Square";
}


double Circle::calculateArea(int a){
    return a * a * M_PI;
}
double Circle::calculatePerimeter(int a){
    return 2 * a * M_PI;
}
std::string Circle::getName(){
    return "Circle";
}



double Pentagon::calculateArea(int a){
    return ((a*a)/4.0)*(sqrt(25 + (10 * sqrt(5))));
}

double Pentagon::calculatePerimeter(int a){
    return 5 * a;
}

std::string Pentagon::getName(){
    return "Pentagon";
}


double Hexagon::calculateArea(int a){
    return a * a * sqrt(6.75);
}
double Hexagon::calculatePerimeter(int a){
    return 6*a;
}
std::string Hexagon::getName(){
    return "Hexagon";
}


double Rectangle::calculateArea(int a, int b){
    return a * b;
}
double Rectangle::calculatePerimeter(int a, int b){
    return 2*a + 2*b;
}
std::string Rectangle::getName(){
    return "Rectangle";
}


double Diamond::calculateArea(int a, int b){
    return a*a*sin(b*(M_PI/180));
}
double Diamond::calculatePerimeter(int a, int b){
    return 4*a;
}






