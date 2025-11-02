#include <stdio.h>

long long czynniki[32];
int indeks = 0;
void rozkladLiczby(long long n){
    long long kopia_n = n;
    while (kopia_n % 2 == 0){
        czynniki[indeks] = 2;
        indeks += 1;
        kopia_n /= 2;
    }

    int i = 3;
    int kwadrat = 9;
    int roznica = 16;

    while (kwadrat <= kopia_n){
        while (kopia_n % i == 0){
            czynniki[indeks] = i;
            indeks += 1;
            kopia_n /= i;
        }
        kwadrat += roznica;
        roznica += 8;
        i += 2;
    }
    if (kopia_n > 2){
        czynniki[indeks] = kopia_n;
    }
}


int main(){
    long long x;

    printf("Podaj liczbe: ");
    scanf("%lld", &x);
    rozkladLiczby(x);
    printf("%lld", x);
    for (int i = 0; i <= indeks; i++)
    {
        printf("%lld\n", czynniki[i]);
    }
    
}