#pragma once

#include <stdexcept>
#include <iostream>
#include <string>


class InvalidInput : public std::runtime_error{
    public:
    InvalidInput() : std::runtime_error("Nieprawidłowa dana"){};
};

class InvalidIndex : public std::runtime_error{
    public:
    InvalidIndex() : std::runtime_error("Liczba spoza zakresu"){}
};

class InvalidArraySize : public std::runtime_error{
    public:
    InvalidArraySize() : std::runtime_error("Nieprawidłowy wiersz trójkąta Pascala"){}
};

class PascalTriangleRow{
    private:
        int* factors;
        int size;
        void calcPascalRow(int n);
    
    public:
        int pascalValue(int k);

        PascalTriangleRow(int n);
        ~PascalTriangleRow();


};