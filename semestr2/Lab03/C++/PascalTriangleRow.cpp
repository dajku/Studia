#include "PascalTriangleRow.hpp"
#include <iostream>

PascalTriangleRow::PascalTriangleRow(int n){
    if(n < 0){
        throw InvalidArraySize();
    }
    
    size = n + 1;
    calcPascalRow(n);
}

void PascalTriangleRow::calcPascalRow(int n){
    if(n < 0){
        throw InvalidArraySize();
    }
    factors = new int[n + 1](); // puste nawiasy na koncu aby wyzerowac tablice
    factors[0] = 1;
    
    for (int i = 1; i < n+1; i++){
        for (int j = i; j >= 1; j--){
            factors[j] = factors[j] + factors[j-1];
        }
    }
}

int PascalTriangleRow::pascalValue(int k){
    if( k < 0 || k >= size){
        throw InvalidIndex();
    }
    return factors[k];
}

PascalTriangleRow::~PascalTriangleRow(){
    delete[] factors;
}

int main(int argc, char *argv[]){
    if(argc == 1){
        std::cout << "Nie podano argumentów\n";
        return 0;
    }
    try{
        int n = std::stoi(argv[1]);
        PascalTriangleRow pascal(n);
        for(int i = 2; i < argc; i++){
            try{
                int index = std::stoi(argv[i]);
                std::cout << argv[i] << " - " << pascal.pascalValue(index) << "\n";
            }
            catch(const InvalidIndex& ex){
                std::cout << argv[i] << ex.what() << "\n";
            }
            catch(const std::invalid_argument& ex){
                std::cout << argv[i] << " - " << "Nieprawidłowa dana" << "\n";
            }
            catch(const std::out_of_range& ex){
               std::cout << argv[i] << " - " << "Za duża liczba" << "\n";
            }
        }
        
    }
    catch(const InvalidArraySize& ex){
        std::cout << argv[1] << " - " << ex.what() << "\n";
        return 0;
    }
    catch(const std::invalid_argument& ex){
        std::cout << argv[1] << " - " << "Nieprawidłowa dana" << "\n";
        return 0;
    }
    catch(const std::out_of_range& ex){
        std::cout << argv[1] << " - " << "Za duża liczba" << "\n";
    }

}