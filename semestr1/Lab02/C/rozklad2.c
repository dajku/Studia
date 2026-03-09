#include <stdio.h>

long long czynniki[100];
int ilosc = 0;

void RozkladNaCzynniki(long long n){
    long long kopiaN = n;
    int index = 0;
    while (kopiaN % 2 == 0){
        czynniki[index] = 2;
        kopiaN /= 2;
        index += 1;
        ilosc += 1;
    }
    long long i = 3;
    long long kwadrat = 9;
    long long roznica = 16;

    while (kwadrat <= kopiaN){
        while(kopiaN % i == 0){
            czynniki[index] = i;
            index += 1;
            ilosc += 1;
            kopiaN /= i;
        }
        kwadrat += roznica;
        roznica += 8;
        i += 2;  
        
    }
    if (kopiaN > 2){
        czynniki[index] = kopiaN;
        ilosc += 1;
    }

}

int main(){
    long long x;
    printf("Podaj liczbe: ");
    scanf("%lld", &x);
    RozkladNaCzynniki(x);
    int i = 0;
    printf("%lld=", x);
    while (i < ilosc){
        long long aktualnyCzynnik = czynniki[i];
        int licznik = 0;
        int j = i;

        while(j < ilosc && aktualnyCzynnik == czynniki[j]){
            licznik += 1;
            j += 1;
        }

        if(i > 0){
            printf("*");
        }
        printf("%lld", aktualnyCzynnik);

        if(licznik > 1){
            printf("^%d", licznik);
        }
        i += licznik;

    }
    printf("\n");
    return 0;
}