#include <stdio.h>
#include <stdbool.h>

void nPierwsza(long long n, long long *tab)
{
    tab[0] = 2;
    long long licznik = 3;
    long long k = 1; // ilosc liczb juz znalezionych

    while (k < n)
    {
        bool flag = true;

        int i = 0;
        while (i < k && (long long)tab[i] * tab[i] <= licznik && flag)
        {
            if (licznik % tab[i] == 0)
            {
                flag = false;
            }

            i++;
        }
        if (flag)
        {
            tab[k] = licznik;
            k++;
        }
        licznik += 2;
    }
}

int main()
{
    const long long maxN = 10000;
    long long tablica[maxN];
    long long n = 0;
    printf("Podaj n większe od 0: ");
    scanf("%lld", &n);
    if (n > 0)
    {
        nPierwsza(n, tablica);
        printf("%lld liczba pierwsza to: %lld\n", n, tablica[n - 1]);
    }
    else
    {
        printf("Błędne dane\n");
    }

    return 0;
}