import math

def czy_pierwsza(n):
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

if __name__ == "__main__":
    print(czy_pierwsza(9))