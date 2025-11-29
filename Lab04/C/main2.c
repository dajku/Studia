#include "euler.h"
#include <stdlib.h>
#include <stdio.h>



int main(int argc, char *argv[]){

    for (int i = 1; i < argc; i++){
        int wynik = totient(atol(argv[i]));
        printf("totient(%u) = %u\n", (unsigned)atol(argv[i]), wynik);
    }

}