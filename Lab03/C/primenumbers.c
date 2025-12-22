#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>

#include "primenumbers.h"

void compute_sieve(bool s[], unsigned n){
    unsigned i, j;
    for (i = 2; i <= n; i++){
        s[i] = true;
    }
    for (i = 2; i <= n; i++){
        if (s[i]){
            for(j = i + i; j <= n; j += i){
                s[j] = false;
            }
        }
    }
}

unsigned count_primes(bool s[], unsigned n){
    int i, c = 0;
    for (i=2; i <= n; i++){
        if(s[i]) c++;
    }
    return c;
}



int main(int argc, char *argv[]){
    unsigned long n;
    unsigned long c;
    bool *s;
    // char *endptr;


    if (argc != 2){
        printf("Zła liczba argumentów \n");
        return -1;
    }
    // strtoul zwraca 0 gdy nie powiedzie się zamiana na integer //
    if (strtol(argv[1], NULL, 10) > 0){

        n = strtol(argv[1], NULL, 10);
        // printf("n: %lu\n", n);
        
        s = malloc((n+1)*sizeof(bool));
        compute_sieve(s,n);
        c = count_primes(s, n);
        free(s);
        printf("Ilość liczb pierwszych mniejszych lub równych od %lu wynosi: %ld\n", n, c);
        return 0;
    }
    else{
        printf("Błędne dane\n");
        return -1;
    }
    

}