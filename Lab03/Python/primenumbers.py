def primenumbers(n):
    def create_sieve(s,n):
        for _ in range(n+1):
            s.append(True)
        s[0] = False
        s[1] = False
    def compute_sieve(s):
        for i in range(2, len(s)):
            if s[i]:
                j = i + i
                while j < len(s):
                    s[j] = False
                    j = j + i
    def count_primes(s):
        c = 0
        for e in s:
            if e:
                c = c + 1
        return c
    s = []
    create_sieve(s,n)
    compute_sieve(s)

    return count_primes(s)


def main():
    n = 0
    while n < 2:
        print("Podaj n większe od 0: ")
        n = int(input(""))
        if n > 0:
            break
        print("Nieprawidłowe dane")
    print(f"Ilość liczb pierwszych nie większych od n: {primenumbers(n)}")


if __name__ == "__main__":
    main()