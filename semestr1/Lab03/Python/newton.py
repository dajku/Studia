

def calcNewton(n, k):
    czynniki = []
    czynniki.append(1)
    
    for i in range(1,n+1):
        if i <= k:
            czynniki.append(1)
        
        for j in range(min(k, i-1), 0, -1):
            czynniki[j] = (czynniki[j] + czynniki[j-1])
    
    return czynniki[k]

def main():
    n = int(input("Podaj n: "))
    k = int(input("Podaj k: "))
    if n < 0:
        print("n nie może być ujemne")
    elif k < 0 or k > n:
        print("k musi być w zakresie od 0 do n")
    else:
        print(calcNewton(n,k))

    return 0


if __name__ == "__main__":
    main()