#include "PascalTriangleRow.hpp"

PascalTriangleRow::PascalTriangleRow(int n){
    if(n < 0){
        throw InvalidIndex();
    }
    size = n + 1;
    calcPascalRow(n);
}

void PascalTriangleRow::calcPascalRow(int n){
    factors.resize(n+1);
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


int main(int argc, char *argv[]){
    if(argc == 1){
        std::cout << "Nie podano argumentów\n";
        return 0;
    }
    try{
        int n = std::stoi(argv[0]);
        PascalTriangleRow *pascal = new PascalTriangleRow(n);
        for(int i = 2; i < argc; i++){
            try{
                int index = std::stoi(argv[i]);
                std::cout << argv[i] << " - " << pascal->pascalValue(index) << "\n";
            }
            catch(InvalidIndex ex){
                std::cout << ex.what() << "\n";
            }
        }
    }
    catch(InvalidArraySize ex){

    }
}