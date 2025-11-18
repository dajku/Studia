import sys

import packages.primenumbers


def main():
    if len(sys.argv) != 2:
        print("Zła liczba argumentów")
        return
    
    n = int(sys.argv[1])
    s = []

    packages.primenumbers.create_sieve(s, n)
    packages.primenumbers.compute_sieve(s)

    c = packages.primenumbers.count_primes(s)

    print(c)


if __name__ == "__main__":
    main()