#include <stdio.h>
#include <stdbool.h>
#include <math.h>
bool czy_pierwsza( unsigned long long n){
    if (n < 2){
        return false;
    }
    if (n == 2){
        return true;
    }
    if (n % 2 == 0){
        return false;
    }
    unsigned long long limit = (unsigned long long)floor(sqrt((double)n));
    for (int i = 3; i <= limit; i += 2){
        if (n % i == 0) {
            return false;
        }
    }
    return true;
    
}

int main(){

    long long x;
    printf("Podaj liczbe: ");
    scanf("%lld", &x);
    bool czyPierwsza = czy_pierwsza(x);
    if (czyPierwsza){
        printf("%lld, jest liczbą pierwsza\n", x);        
    }
    else{
        printf("%lld, nie jest liczbą pierwszą\n", x);
    }
    return 0;
}