import math

def PrimeNumbers(n):
    s = []
    def create_sieve(s,n):
        for _ in range(n+1):
            s.append(True)
        s[0] = False
        s[1] = False

    def compute_sieve(s):
        for i in range(2, len(s)):
            if s[i]:
                j = i + i
                while j < len(s):
                    s[j] = False
                    j = j + i

    create_sieve(s,n)
    compute_sieve(s)
    c = 0
    for e in s:
        if e:
            c = c + 1
    return c

def Prime(n):
    def nPierwsza(n):
        tab = []
        tab.append(2)
        licznik = 3
        k = 1

        while(k < n):
            flag = True
            i = 0
            while(i < k and tab[i] * tab[i] <= licznik and flag):
                if(licznik % tab[i] == 0):
                    flag = False
                i += 1
            
            if flag:
                tab.append(licznik)
                k += 1
            licznik += 2

        return tab
    tablica = nPierwsza(n)
    return tablica[n-1]

def IsPrime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    pierwiastek = math.sqrt(n)
    for i in range(3, int(pierwiastek) + 1, 2):
        if n % i == 0:
            return False
    return True
    
    