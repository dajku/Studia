import sys
import primelibrary

def main():

    argument = sys.argv[1]

    if(len(sys.argv) != 3):
        print("Zła liczba argumentów")
        return
    try:
        n = int(sys.argv[2])
    except ValueError:
        print("Błędne dane")
        return

    if argument == "pn":
        print(primelibrary.PrimeNumbers(n))
    elif argument == "pr":
        print(primelibrary.Prime(n))
    elif argument == "ip":
        print(primelibrary.IsPrime(n))


if __name__ == "__main__":
    main()