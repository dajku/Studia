import findzero 


def main():
    a = 2
    b = 4
    eps = 1

    for _ in range(1, 10):
        eps = eps/10
        wynik = findzero.findzero(findzero.cos_2, a, b, eps)
        print(f"Dla eps = {eps}, wynik = {wynik}")


if __name__ == "__main__":
    main()