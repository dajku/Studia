#include <stdio.h>
#include <stdlib.h>

#include "permutacje.h"



int main(int argc, char* argv[]){
    
    if (argc != 2){
        printf("Zła liczba argumentów\n");
        return 1;
    }

    int n = atoi(argv[1]);

    int permutacje[n];
    
    genTab(permutacje, n);
    

    for(int i = 0; i<n; i++){
        printf("%d",permutacje[i]);
        printf("\n");
    }

    while (nextPerm(permutacje, n)){
        bool wynik = isSolution(permutacje, n);
        printf("%d", wynik);
    }
}