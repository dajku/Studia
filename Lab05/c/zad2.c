#include "findzero.h"
#include "stdio.h"

int main(int argc, char *argv[]){
    // double a,b,eps,wynik;
    // printf("Podaj a: ");
    // scanf("%lf", &a);
    // printf("Podaj b: ");
    // scanf("%lf", &b);
    // printf("Podaj epsilon: ");
    // scanf("%lf", &eps);
    // wynik = findzero(*cos_2,a,b,eps);
    // printf("%lf\n", wynik);
    double a = 2;
    double b = 4;
    double eps = 1;
    double wynik;
    
    for (int i = 1; i < 9; i++){
        eps = eps/10;
        wynik = findzero(cos_2, a,b, eps);
        printf("Dla eps = %.10lf, wynik = %.10lf\n", eps, wynik);
    }
    
}