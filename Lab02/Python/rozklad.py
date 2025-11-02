# (i+2)^2 - i^2 = i^2 + 4i + 4 - i^2= 4i + 4 ---> Różnica między kwadratami kolejnych liczb 
# przy "przeskakiwaniu" o 2
# dla i = 0 mamy 4
# dla i = 2 mamy 12
# różnica jest stała 12 - 4 = 8
# i^2 + 4i + 4 - i^2 == 4i + 4
# dla i = 3:
# 12 + 4 = 16
# dla i = 5:
# 20 +  4 = 24
# róznica: 24 - 16 = 8




def rozklad_na_czynniki(n):
    lista_czynników = []
    kopia_n = n

    while kopia_n % 2 == 0:
        lista_czynników.append(2)
        kopia_n //= 2
    
    i = 3
    kwadrat = 9
    roznica = 16

    while kwadrat <= kopia_n:
        while kopia_n % i == 0:
            lista_czynników.append(i)
            kopia_n //= i
        kwadrat += roznica
        roznica += 8
        i += 2

    if kopia_n > 2:
        lista_czynników.append(kopia_n)
    return lista_czynników

if __name__ == "__main__":

    # DODAĆ POPRAWNE WYŚWIETLANIE WYNIKU
    x = int(input("Podaj liczbe: "))
    if (x < 2):
        print(f"{x} jest mniejsze od 2, nie ma rozkładu na czynniki pierwsze")
        exit(1)
    czynniki = rozklad_na_czynniki(x)
    print(f"{x} = ", end="")
    i = 0
    while (i < len(czynniki)):
        aktualny_czynnik = czynniki[i]
        licznik = 0

        while (i < len(czynniki) and czynniki[i] == aktualny_czynnik):
            i += 1
            licznik += 1
        
        if (i > licznik):
            print("*", end="")
        
        print(f"{aktualny_czynnik}", end="")

        if (licznik > 1):
            print(f"^{licznik}", end="")
    print("")
        

