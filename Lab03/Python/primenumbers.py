import sys

import packages.primenumbers


def main():
    if len(sys.argv) != 2:
        print("Zła liczba argumentów")
        return
    try:
        n = int(sys.argv[1])
        if n <= 0:
            print(f"ilość liczb pierwszych nie większych od {n}: 0")
            sys.exit()
    except ValueError:
        print("Błędne dane")
        sys.exit()
    s = []

    packages.primenumbers.create_sieve(s, n)
    packages.primenumbers.compute_sieve(s)

    c = packages.primenumbers.count_primes(s)

    print(f"ilość liczb pierwszych nie większych od {n}: {c}")


if __name__ == "__main__":
    main()