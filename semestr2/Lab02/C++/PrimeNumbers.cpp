#include "PrimeNumbers.hpp"
#include <iostream>

PrimeNumbers::PrimeNumbers(int n)
{
    bool *sieve = new bool[n + 1];
    primes = new int[n + 1];
    for (int i = 0; i <= n; i++)
    {
        sieve[i] = true;
    }
    sieve[0] = sieve[1] = false;

    // sprawdzanie do sqrt(n)
    for (int i = 2; i * i <= n; i++)
    {
        if (sieve[i])
        {
            // zaczynamy od i*i bo wszystkie i+i przed i*i zostały już sprawdzone przez mniejsze dzielniki  
            for (int j = i * i; j <= n; j = j + i)
            {
                sieve[j] = false;
            }
        }
    }

    for (int i = 0; i <= n; i++)
    {
        if (sieve[i])
        {

            primes[length] = i;
            length++;
        }
    }
    delete[] sieve;
}

int PrimeNumbers::getNumber(int m)
{
    return primes[m];
}

int PrimeNumbers::getLength()
{
    return length;
}

PrimeNumbers::~PrimeNumbers()
{
    delete[] primes;
}

int main(int argc, char *argv[])
{
    if (argc == 1)
    {
        std::cout << "Nie podano argumentów";
        return 0;
    }
    try
    {
        int n = std::stoi(argv[1]);
        if (n <= 1)
        {
            std::cout << n << " - " << " nieprawidłowy zakres\n";
            return 0;
        }
        // PrimeNumbers primes(n);
        PrimeNumbers *primes = new PrimeNumbers(n);
        for (int i = 2; i < argc; i++)
        {
            try
            {
                int currentInteger = std::stoi(argv[i]);
                if (currentInteger >= primes->getLength() || currentInteger < 0)
                {
                    std::cout << argv[i] << " - " << " liczba spoza zakresu\n";
                }
                else
                {
                    std::cout << argv[i] << " - " << primes->getNumber(currentInteger) << "\n";
                }
            }
            catch (...)
            {
                std::cout << argv[i] << " nieprawidłowa dana\n";
            }
        }
        delete primes;
    }
    catch (...)
    {
        std::cout << argv[1] << " nieprawidłowa dana\n";
        return 0;
    }
}