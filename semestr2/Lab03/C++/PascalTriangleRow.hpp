#include <vector>
#include <stdexcept>
#include <iostream>
#include <string>

class InvalidIndex : public std::runtime_error{
    public:
    InvalidIndex() : std::runtime_error("liczba spoza zakresu"){}
};

class InvalidArraySize : public std::runtime_error{
    public:
    InvalidArraySize() : std::runtime_error("Nieprawidłowy wiersz trójkąta Pascala"){}
};

class PascalTriangleRow{
    private:
        std::vector<int> factors;
        int size;
        void calcPascalRow(int n);
    
    public:
        int pascalValue(int k);

        PascalTriangleRow(int n);
        ~PascalTriangleRow();


};