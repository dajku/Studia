#include "primelibrary.h"
#include <stdlib.h>
#include <math.h>

// PRYWATNE FUNKCJE POMOCNICZE
void compute_sieve(bool s[], unsigned n)
{
    unsigned i, j;
    for (i = 2; i <= n; i++)
    {
        s[i] = true;
    }
    for (i = 2; i <= n; i++)
    {
        if (s[i])
        {
            for (j = i + i; j <= n; j += i)
            {
                s[j] = false;
            }
        }
    }
}

unsigned count_primes(bool s[], unsigned n)
{
    unsigned i, c = 0;
    for (i = 2; i <= n; i++)
    {
        if (s[i])
            c++;
    }
    return c;
}

void nPierwsza(unsigned n, unsigned *tab)
{

    tab[0] = 2;
    unsigned licznik = 3;
    unsigned k = 1; // ilosc liczb juz znalezionych

    while (k < n)
    {
        bool flag = true;

        int i = 0;
        while (i < k && (unsigned)tab[i] * tab[i] <= licznik && flag)
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

// FUNKCJE GŁÓWNE
unsigned prime_numbers(unsigned n)
{
    unsigned long c;
    bool *s;

    s = malloc((n + 1) * sizeof(bool));
    compute_sieve(s, n);
    c = count_primes(s, n);
    free(s);
    return c;
}

unsigned prime(unsigned n)
{

    unsigned *tab = malloc(n * sizeof(unsigned));
    if (tab == NULL) return 0;
    nPierwsza(n, tab);
    
    unsigned wynik = tab[n-1];
    free(tab);
    
    return wynik;
}

bool is_prime(unsigned n)
{
    if (n < 2)
    {
        return false;
    }
    if (n == 2)
    {
        return true;
    }
    if (n % 2 == 0)
    {
        return false;
    }
    unsigned limit = (unsigned)floor(sqrt((double)n));
    for (int i = 3; i <= limit; i += 2)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}
