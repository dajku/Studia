#include <stdio.h>

int NWD(int a, int b){
    while (b > 0){
        int c = a % b;
        a = b;
        b = c;
    }
    return a;
}

int main(){
    int a,b,c;

    printf("Podaj pierwsza liczbe: ");
    scanf("%d", &a);
    printf("Podaj druga liczbe: ");
    scanf("%d", &b);
    c = NWD(a,b);
    printf("Największy wspolny dzielnik to %d\n", c);
    
    return 0;
}