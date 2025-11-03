#include <stdio.h>
#include <stdlib.h>
struct RozkladLiczby{
    long long* czynniki;
    long long ilosc;
    long long pojemnosc;
};

struct RozkladLiczby InicjalizacjaRozkladu(){
    struct RozkladLiczby rozklad;
    rozklad.pojemnosc = 8;
    rozklad.ilosc = 0;
    rozklad.czynniki = (long long*) malloc(rozklad.pojemnosc * sizeof(long long));

    if (rozklad.czynniki == NULL){
        printf("Błąd pamięci");
        exit(1);
    }
    return rozklad;
}

void zwolnijPamiec(struct RozkladLiczby* rozklad){
    free(rozklad->czynniki);
    rozklad->czynniki = NULL;
    rozklad->ilosc = 0;
    rozklad->pojemnosc = 0;
}
    
void czyPelna(struct RozkladLiczby* rozklad){
    if (rozklad->ilosc == rozklad->pojemnosc){
        long long nowaPojemnosc = rozklad->pojemnosc*2;

        long long* nowaTablica = (long long*)realloc(rozklad->czynniki, nowaPojemnosc * sizeof(long long));

        if (nowaTablica != NULL){
            rozklad->czynniki = nowaTablica;

            rozklad->pojemnosc = nowaPojemnosc;
        }
        else {
            printf("Błąd realloc()");
        }
    }
}

void dodajCzynnik(struct RozkladLiczby* rozklad, long long x){
    czyPelna(rozklad);
    rozklad->czynniki[rozklad->ilosc] = x;
    rozklad->ilosc += 1; 
}
void rozkladNaCzynniki(struct RozkladLiczby* rozklad, long long n){

    long long kopiaN = n;

    while (kopiaN % 2 == 0){
        dodajCzynnik(rozklad, 2);
        kopiaN /= 2;
    }
    long long i = 3;
    long long kwadrat = 9;
    long long roznica = 16;

    while (kwadrat <= kopiaN){
        while(kopiaN % i == 0){
            dodajCzynnik(rozklad, i);
            kopiaN /= i;
        }
        kwadrat += roznica;
        roznica += 8;
        i += 2;  
        
    }
    if (kopiaN > 2){
        dodajCzynnik(rozklad, kopiaN);
    }

}

int main(){
    long long x;
    printf("Podaj liczbe: ");
    scanf("%lld", &x);
    if (x < 2){
        printf("Liczba jest mniejsza niż 2\n");
        return 0;
    }
    struct RozkladLiczby liczba = InicjalizacjaRozkladu();
    rozkladNaCzynniki(&liczba, x );

    long long i = 0;
    printf("%lld=",x);
    while (i < liczba.ilosc){
        long long aktualnyCzynnik = liczba.czynniki[i];
        long long licznik = 0;


        long long j = i;
        while (j < liczba.ilosc && liczba.czynniki[j] == aktualnyCzynnik){
            licznik += 1;
            j += 1;
        }

        if (i > 0){
            printf("*");
        }
        
        printf("%lld", aktualnyCzynnik);

        if (licznik > 1){
            printf("^%lld", licznik);
        }

        i += licznik;
    }

    printf("\n");
    zwolnijPamiec(&liczba);
    return 0;

}