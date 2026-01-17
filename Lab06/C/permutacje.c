#include <stdbool.h>


void odwroc(int* tablica, int p, int k){
    int i = p;
    int j = k;
    while (i < j){
        int temp = tablica[i];
        tablica[i] = tablica[j];
        tablica[j] = temp;
        i = i + 1;
        j = j - 1;
    }
}


bool nextPerm(int* tablica, int n){
    int i = n - 2;
    while (i > 0 && tablica[i] > tablica[i+1]){
        i = i - 1;
    }
    if (i == 0){
        return false;
    }
    int j = n - 1;
    while (tablica[i] > tablica[j]){
        j = j - 1;
    }
    int temp = tablica[i];
    tablica[i] = tablica[j];
    tablica[j] = temp;
    odwroc(tablica, i+1, n);
    return true;
}

void genTab(int* tablica, int n){
    for(int i = 0; i < n; i++){
        tablica[i] = i+1;
    }
}

bool isSolution(int* tablica, int n){
    while(nextPerm(tablica, n)){
        return true;
    }
    return false;
}
