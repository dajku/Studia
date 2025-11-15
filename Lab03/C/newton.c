#include <stdio.h>
#include <math.h>

int min(int a,int b){

    if (a < b){
        return a;
    }
    else{
        return b;
    }
}
int calcNewton(int n, int k){

    int czynniki[n+1];
    czynniki[0] = 1;

    for (int i = 1; i <= n; i++){
        if (i <= k){
            czynniki[i] = 1;
            
        }
        for (int j = min(k, i-1); j >= 1; j--){
            czynniki[j] = czynniki[j] + czynniki[j-1];
        }
    }
    return czynniki[k];

}

int main(){
    int n,k;
    printf("Podaj n: ");
    scanf("%d", &n);
    printf("Podaj k: ");
    scanf("%d", &k);
    if (n < 0){
        printf("n nie może być ujemne\n");
    }
    else if (k < 0 || k > n){
        printf("k musi być w zakresie od 0 do n\n");
    }
    else{
        int wynik = calcNewton(n,k);
        printf("%d\n", wynik);
    }


    return 0;
}