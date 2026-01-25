#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>

// bije_wiersz -

void Ustaw(int i,int n, int* position,bool* bije_kolumne, bool* bije_przek1, bool* bije_przek2, int* licznik){

    for (int j = 0; j < n;j++){

        int index_przek1 = i + j;

        int index_przek2 = i - j + (n - 1);

        if (!(bije_kolumne[j] || bije_przek1[index_przek1] || bije_przek2[index_przek2])){
            position[i] = j;
            bije_kolumne[j] = true;
            bije_przek1[index_przek1] = true;
            bije_przek2[index_przek2] = true;

            if (i < n - 1){
                Ustaw(i+1,n, position, bije_kolumne, bije_przek1, bije_przek2, licznik);
            }
            else{
                (*licznik)++; // w nawiasach aby zwiększyć wartość zmiennej a nie adres
                for (int k = 0; k < n; k++){
                    printf("%d ", position[k] + 1);
                }
                printf("\n");
            }
            position[i] = 0;
            bije_kolumne[j] = false;
            bije_przek1[index_przek1] = false;
            bije_przek2[index_przek2] = false; 
        }
    }

}

int hetmani(int n){
    int *position = calloc(n, sizeof(int));
    bool *bije_kolumne = calloc(n, sizeof(bool));
    bool *bije_przek1 = calloc(2*n, sizeof(bool));
    bool *bije_przek2 = calloc(2*n, sizeof(bool));
    int licznik = 0;
    Ustaw(0, n, position, bije_kolumne, bije_przek1, bije_przek2, &licznik);
    free(position);
    free(bije_kolumne);
    free(bije_przek1);
    free(bije_przek2);
    return licznik;
}

int main(int argc, char* argv[]){
    if (argc != 2){
        printf("Zła liczba argumentów\n");
        return 1;
    }

    int n = atoi(argv[1]);
    
    if (n <= 1){
        printf("Błędny argument\n");
        return 1;
    }
    printf("%d", hetmani(n));
    printf("\n");
    return 0;
}