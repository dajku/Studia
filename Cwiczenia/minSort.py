
def minSort(tab):
    i = 0
    n = len(tab)
    while i != n - 1:
        min_temp = tab[i]
        index = i

        for j in range(i+1, n):
            if tab[j] < min_temp:
                min_temp = tab[j]
                index = j
        tab[index] = tab[i]
        tab[i] = min_temp
        i += 1
    return tab

print(minSort([15,167, 1, 321, 22, 0, 51, 14, 13, 1,12]))