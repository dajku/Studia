#include <stdio.h>
#include <stdlib.h> 
#include <string.h> 
#include "primelibrary.h"


int main(int argc, char *argv[]){
    
    if (argc != 3   ){
        printf("Zła liczba argumentów\n");
        return 1;
    }

    char *argument = argv[1];
    int n = atoi(argv[2]);
    

    // strcmp zwraca 0 gdy TRUE
    if (strcmp(argument, "pn") == 0){
        unsigned wynik = prime_numbers(n);
        printf("%d\n", wynik);
    }
    else if(strcmp(argument, "pr") == 0){
        unsigned wynik = prime(n);
        printf("%d\n", wynik);
    }
    else if(strcmp(argument, "ip") == 0){
        bool wynik = is_prime(n);
        if (wynik){
            printf("true\n");
        }
        else{
            printf("false\n");
        }
    }
    return 0;
}