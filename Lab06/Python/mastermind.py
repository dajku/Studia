def start():
    kody = []
    czy_mozliwy = []
    
    for i in range(1, 7):
        for j in range(1, 7):
            for k in range(1, 7):
                for l in range(1, 7):
                    kody.append([i, j, k, l])
                    czy_mozliwy.append(True)
    
    return kody, czy_mozliwy

def symulacja(kod1, kod2):
    trafionych_lokalnie = 0
    nietrafione_lokalnie = 0

    kopia1 = kod1[:]
    kopia2 = kod2[:]

    for i in range(4):
        if kopia1[i] == kopia2[i]:
            trafionych_lokalnie += 1
            kopia1[i] = -1
            kopia2[i] = -1

    for i in range(4):
        if kopia1[i] != -1:
            for j in range(4):
                if kopia2[j] != -1:
                    if kopia1[i] == kopia2[j]:
                        nietrafione_lokalnie += 1
                        kopia2[j] = -1
                        break

    return trafionych_lokalnie, nietrafione_lokalnie

def filtruj(kody, czy_mozliwy, aktualny_strzal, trafione, nietrafione):
    for i in range(1296):
        if czy_mozliwy[i]:
            sym_trafione, sym_nietrafione = symulacja(kody[i], aktualny_strzal)

            if trafione != sym_trafione or nietrafione != sym_nietrafione:
                czy_mozliwy[i] = False

def main():
    kody, czy_mozliwy = start()
    
    czy_koniec = False
    runda = 1

    while not czy_koniec:
        index_strzalu = -1

        for i in range(1296):
            if czy_mozliwy[i]:
                index_strzalu = i
                break
        
        if index_strzalu == -1:
            print("Oszukujesz!")
            break

        print(f"{runda}: {kody[index_strzalu][0]} {kody[index_strzalu][1]} {kody[index_strzalu][2]} {kody[index_strzalu][3]} ?")

        trafione = int(input("Na swoim miejscu: "))
        
        if trafione == 4:
            print("Wygrałem.")
            czy_koniec = True
            break

        nietrafione = int(input("Nie na swoim miejscu: "))

        filtruj(kody, czy_mozliwy, kody[index_strzalu], trafione, nietrafione)
        
        runda += 1

if __name__ == "__main__":
    main()