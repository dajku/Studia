#include <limits.h>
#include <stdio.h>

int secondMax(int arr[], int rozmiar){
    int max = INT_MIN;
    int secondMax = INT_MIN;
    

    for (int i = 0;i < rozmiar; i++){
        int aktualny = arr[i];
        if (aktualny > max){
            secondMax = max;
            max = aktualny;
        }
        if (aktualny > secondMax && aktualny != max){
            secondMax = aktualny;
        }        
    }
    return secondMax;
}



int main(){
    int tablica[] = {-5, 10, 15};
    int iloscElementow = sizeof(tablica) / sizeof(tablica[0]);

    int drugiMax = secondMax(tablica, iloscElementow);
    printf("%d\n", drugiMax);

    return 0;
}