#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

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


bool nextPerm(int* tab, int n){
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

void genTab(int* tab, int n){
    for(int i = 0; i < n; i++){
        tab[i] = i+1;
    }
}

bool isSolution(int* tab, int n){


    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            // roznica wierszy jest równa roznicy kolumn to wtedy biją się po skosie.
            if(abs(tab[i] - tab[j]) == abs(i - j)){
                return false;
            }
        }
    }
    return true;

}
