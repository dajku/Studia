
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


def main():
    n = int(input("Podaj n: "))
    if n > 0:
        tablica = nPierwsza(n)

        print(f"{n} liczba pierwsza to {tablica[n-1]}")
    else:
        print("Błędne dane")
    return 0


if __name__ == "__main__":
    main()