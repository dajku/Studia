#include <math.h>
#include "findzero.h"

double cos_2(double X){
    
    return cos(X/2);
}

double findzero(functype f, double a, double b, double eps){
    double srodek = (a+b)/2;

    while (fabs(a-b) > eps){
        if (f(a) * f(srodek) < 0.0){
            b = srodek;
        }
        else{
            a = srodek;
        }
        srodek = (a+b)/2;

    }
    return srodek;
}