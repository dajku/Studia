
def _rozklad_na_czynniki(n):
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

def Totient(n):
    czynniki = _rozklad_na_czynniki(n)

    wynik = 1
    i = 0
    dlugosc = len(czynniki) 

    while i < dlugosc:
        aktualne_p = czynniki[i]
        aktualne_k = 0

        while i < dlugosc and czynniki[i] == aktualne_p:
            aktualne_k += 1
            i += 1
        
        wartosc_dla_p = (aktualne_p - 1) * (aktualne_p ** (aktualne_k - 1))

        wynik *= wartosc_dla_p
    
    return wynik