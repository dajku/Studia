


def odwrocenie(tab):
    k = 0
    n = len(tab) - 1
    while k < len(tab)/2:
        temp = tab[k]
        tab[k] = tab[n-k]
        tab[n-k] = temp
        k += 1
    return tab

print(odwrocenie([1,2,3,4,5,6]))