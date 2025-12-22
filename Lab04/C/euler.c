#include <stdlib.h>
#include <stdio.h>


typedef struct {
    unsigned czynniki[50];
    int licznik;

} Czynniki;


void inicjalizacja(Czynniki *rozklad){
    rozklad->licznik = 0;

}

void dodajCzynnik(Czynniki *rozklad, unsigned x){
    if (rozklad->licznik < 50){
        rozklad->czynniki[rozklad->licznik] = x;
        rozklad->licznik++;
        return;
    }
    printf("Za duzo liczb w tablicy\n");
    exit(1);
}


void RozkladNaCzynniki(Czynniki *rozklad, unsigned n){
    unsigned kopiaN = n;
    while (kopiaN % 2 == 0){
        dodajCzynnik(rozklad, 2);
        kopiaN /= 2;
    }
    unsigned i = 3;
    unsigned kwadrat = 9;
    unsigned roznica = 16;

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


unsigned totient(unsigned n){
    Czynniki rozklad;
    inicjalizacja(&rozklad);
    RozkladNaCzynniki(&rozklad, n);
    unsigned wynik = 1;
    int i = 0;

    while (i < rozklad.licznik){

        unsigned aktualne_p = rozklad.czynniki[i];

        int aktualne_k = 0;
        
        while (i < rozklad.licznik && rozklad.czynniki[i] == (aktualne_p)){
            aktualne_k++;
            i++;
        }
        // Pętla do obliczenia (aktualne_p ** (aktualne_k - 1))
        int wynik_potegowania = 1;
        for (int j = 0; j < aktualne_k-1; j++){
            wynik_potegowania *= aktualne_p;
        }
        //
        
        int wartosc_dla_p = (aktualne_p - 1) * wynik_potegowania;

        wynik *= wartosc_dla_p;
    }
    
    return wynik;
}