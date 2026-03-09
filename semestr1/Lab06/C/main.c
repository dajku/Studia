#include <stdio.h>
#include <stdlib.h>

#include "permutacje.h"



int main(int argc, char* argv[]){
    
    if (argc != 2){
        printf("Zła liczba argumentów\n");
        return 1;
    }

    int n = atoi(argv[1]);
    
    if (n <= 1){
        printf("Błędny argument\n");
        return 1;
    }

    int permutacje[n];
    
    genTab(permutacje, n);
    
    int solutions = 0;
    bool wynik = isSolution(permutacje, n);

    if (wynik){
        solutions = solutions + 1;
        for(int i = 0; i < n; i++){
            printf("%d", permutacje[i]);
        }
    }

    while (nextPerm(permutacje, n)){
        wynik = isSolution(permutacje, n);
        if (wynik){
            solutions = solutions + 1;
            for(int i = 0; i < n; i++){
                printf("%d ", permutacje[i]);
            }
            printf("\n");
        }        
    }
    printf("Number of solutions: %d\n", solutions);
}