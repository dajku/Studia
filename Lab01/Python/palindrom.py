def czy_palindrom(n, p):
    odwrocona = 0
    oryginalna_liczba = n
    while (n > 0):
        ostatnia_cyfra = n % p
        odwrocona = (odwrocona * p) + ostatnia_cyfra
        n //= p
    if odwrocona == oryginalna_liczba:
        return True
    return False


if __name__ == "__main__":
    n = int(input("Podaj liczbe n: "))
    p = int(input("Podaj system liczby: "))
    print(czy_palindrom(n,p))