#include <stdio.h>
#include <stdbool.h>

void compute_sieve(bool s[], int n){
    int i, j;
    for (i = 2; i <= n; i++){
        s[i] = true;
    }
    for (i = 2; i <= n; i++){
        if (s[i]){
            for(j = i + i; j <= n; j+=i){
                s[j] = false;
            }
        }
    }
}

int count_primes(bool s[], int n){
    int i, c = 0;
    for (i=2; i <= n; i++){
        if(s[i]) c++;
    }
    return c;
}

int primenumbers(int n) {
    bool sieve[n+1];
    compute_sieve(sieve, n);
    return count_primes(sieve, n);
}

int main(){
    int n = 0;
    while (n < 2)
    {
        printf("Podaj n większe od 0: ");
        scanf("%u", &n);
        if(n > 0){
            break;
        }
        printf("Nieprawidłowe dane\n");

    }

    printf("Ilosc liczb pierwszych nie większych od n:%u\n", primenumbers(n));

    return 0;
}