#pragma once

class PrimeNumbers{
    private:
        int length = 0;
        int* primes;
    public:
    int getNumber(int m);
    int getLength();

    PrimeNumbers(int n);
    ~PrimeNumbers();
};