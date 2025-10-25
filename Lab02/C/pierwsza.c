#include <stdio.h>
#include <stdbool.h>
#include <math.h>
bool czy_pierwsza(long long int n){
    if (n < 2){
        return false;
    }
    if (n == 2){
        return true;
    }
    if (n % 2 == 0){
        return false;
    }
    long long limit = (long long int)floor(sqrt((double)n));
    for (long long int i = 3; i <= limit; i += 2){
        if (n % i == 0) {
            return false;
        }
    }
    return true;
    
}

int main(){
    printf("%d\n", czy_pierwsza(31232134567177LL));
    return 0;
}