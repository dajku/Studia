import sys



    


def hetmani(n):
    
    licznik = 0

    def Ustaw(i, n, position, bije_kolumne, bije_przek1, bije_przek2):

        nonlocal licznik

        for j in range(n):
            index_przek1 = i + j

            index_przek2 = i - j + (n-1)

            if (not (bije_kolumne[j] or bije_przek1[index_przek1] or bije_przek2[index_przek2])):
                position[i] = j
                bije_kolumne[j] = True
                bije_przek1[index_przek1] = True
                bije_przek2[index_przek2] = True

                if (i < n - 1):
                    Ustaw(i+1,n, position, bije_kolumne, bije_przek1, bije_przek2)
                else:

                    for k in range(n):
                        print(f"{position[k] + 1} ", end="")
                    print("")
                    licznik += 1
                
                position[i] = 0
                bije_kolumne[j] = False
                bije_przek1[index_przek1] = False
                bije_przek2[index_przek2] = False

    position = [0] * n
    bije_kolumne = [False] * n
    bije_przek1 = [False] * (2*n)
    bije_przek2 = [False] * (2*n)

    Ustaw(0, n, position, bije_kolumne, bije_przek1, bije_przek2)
    return licznik



def main():
    if len(sys.argv) != 2:
        print("Zła liczba argumentów")
        return
    
    n = int(sys.argv[1])

    if (n < 1):
        print("Błędny argument")
        return
    
    print(f"{hetmani(n)}")


if (__name__ == "__main__"):
    main()