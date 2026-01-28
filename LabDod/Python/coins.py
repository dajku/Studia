import sys

def obliczanie_reszty(r, nominaly, nominaly_dlugosc):
    C = [0] * (r + 1)
    C[0] = 0

    D = [-1] * (r + 1)
    D[0] = -1

    for i in range(1, r + 1):
        C[i] = r + 1
        D[i] = -1

        for j in range(nominaly_dlugosc):
            aktualna_moneta = nominaly[j]

            if i >= aktualna_moneta:
                reszta = i - aktualna_moneta

                if C[reszta] != r + 1:
                    nowy_koszt = C[reszta] + 1

                    if nowy_koszt < C[i]:
                        C[i] = nowy_koszt
                        D[i] = aktualna_moneta

    if C[r] == r + 1:
        print(f"{r} ===> No solution!")
        return

    print(f"{r} ===> {C[r]}")

    liczniki = [0] * nominaly_dlugosc

    temp_r = r
    while temp_r > 0:
        moneta = D[temp_r]

        for i in range(nominaly_dlugosc):
            if nominaly[i] == moneta:
                liczniki[i] += 1
                break
        temp_r = temp_r - moneta

    for i in range(nominaly_dlugosc):
        if liczniki[i] > 0:
            print(f"{liczniki[i]} x {nominaly[i]}")


if __name__ == "__main__":

    if len(sys.argv) < 3:
        print("Zła ilość argumentóœ")
        sys.exit(1)

    plik = open(sys.argv[1], "r")
    tekst = plik.read()
    plik.close()

    wszystkie_dane = tekst.split()

    aktualny_index = 0

    n = int(wszystkie_dane[aktualny_index])
    aktualny_index = aktualny_index + 1

    nominaly = []
    for i in range(n):
        wartosc = int(wszystkie_dane[aktualny_index])
        nominaly.append(wartosc)
        aktualny_index = aktualny_index + 1

    for i in range(2, len(sys.argv)):
        kwota = int(sys.argv[i])
        obliczanie_reszty(kwota, nominaly, n)