
def Euklides(a,b):
    while b:
        c = a % b
        a = b
        b = c
    return a
if __name__ == "__main__":
    a = int(input("Podaj pierwsza liczbe: "))
    b = int(input("Podaj druga liczbe: "))
    print(f"Największy wspólny dzielnik: {Euklides(a,b)}")