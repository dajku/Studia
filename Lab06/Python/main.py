import permutacjelib
import sys



def main():
    if(len(sys.argv) != 2):
        print("Zła liczba argumentów")
        return
    
    n = int(sys.argv[1])

    if(n <= 1):
        print("Błędny argument")
        return

    permutacje = [i for i in range(1, n+1)]

    solutions = 0

    wynik = permutacjelib.isSolution(permutacje)

    if(wynik):
        solutions += 1
        for i in permutacje:
            print(f"{i} ", end="")
    
    while (permutacjelib.nextPerm(permutacje)):
        wynik = permutacjelib.isSolution(permutacje)

        if(wynik):
            solutions += 1
            for i in permutacje:
                print(f"{i} ", end="")
            print("")
    

    print(f"Number of solutions: {solutions}")


if __name__ == "__main__":
    main()