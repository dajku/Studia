import eulerlibrary
import sys

def main():
    
    for i in range(1, len(sys.argv)):
        wynik = eulerlibrary.Totient(int(sys.argv[i]))
        print(f"totient({sys.argv[i]}) = {wynik}")

main()