#include <stdio.h>

int czy_palindrom(int n, int p){
    int odwrocona = 0;
    int oryginalna_liczba = n;
    while (n > 0){
        int ostatnia_cyfra = n % p;
        odwrocona = (odwrocona * p) + ostatnia_cyfra;
        n = n/p;
    }
    if (odwrocona == oryginalna_liczba){
        return 1;
    }
    return 0;
}

int main(){
    int n, p;
    printf("Podaj liczbe n: ");
    scanf("%d", &n);
    printf("Podaj system liczby: ");
    scanf("%d", &p);
    printf("%i\n", czy_palindrom(n,p));
    return 0;
}