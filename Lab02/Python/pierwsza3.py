import math

def czy_pierwsza(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    if n == 3:
        return True
    if n % 3 == 0:
        return False
    pierwiastek = math.sqrt(n)
    for i in range(5, int(pierwiastek) + 1, 6):
        if n % i == 0 or n % (i + 2) == 0:
            return False
    return True

if __name__ == "__main__":
    print(czy_pierwsza(1234577))