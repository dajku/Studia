#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// załóżmy że na początku dostajemy tablice = [1, 2, 3, ..., n]

void odwroc(int* tab, int p, int k){
    int i = p;
    int j = k-1;

    while (i < j){
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
        i = i + 1;
        j = j - 1;

    }

}

bool nextPermutation(int* tab, int n){
    int i = n-2;
    while (i >= 0 && tab[i] >= tab[i+1]){
        i = i-1;
    }
    if (i < 0){
        return false;
    }
    int j = n-1;
    while (tab[j] <= tab[i]){
        j = j-1;
    }
    int temp = tab[i];
    tab[i] = tab[j];
    tab[j] = temp;
    odwroc(tab, i+1, n);
    return true;

}


int main(int argc, char* argv[]){
    if(argc !=2){
        printf("Zła liczba argumentów");
        return 1;
    }
    int n = atoi(argv[1]);

    int tab[n];

    for (int i = 0; i < n; i++){
        tab[i] = i+1;
    }
    for(int i = 0; i < n; i++){
        printf("%d ", tab[i]);
    }
    printf("\n");
    while(nextPermutation(tab,n)){
        for(int i = 0; i < n; i++){
            printf("%d ", tab[i]);
        }
        printf("\n");
    }

}