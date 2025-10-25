import math

def rozwiazania_kwadratowe(a,b,c):
    if a == 0:
        if b == 0:
            if c == 0:
                return "Nieskonczenie wiele rozwiazan (tozsamosc)"
            else:
                return "Brak rozwiazan"
        else:
            return -c/b
    delta = b*b - (4*a*c)
    if delta < 0:
        return "Brak rozwiazan w zbiorze liczb rzeczywistych"
    elif delta == 0:
        return -b/(2*a)
    else:
        x1 = (-b-math.sqrt(delta))/(2*a)
        x2 = (-b+math.sqrt(delta))/(2*a)
        return x1, x2




if __name__ == "__main__":
    a = float(input("Podaj wspolczynnik a\n"))
    b = float(input("Podaj wspolczynnik b\n"))
    c = float(input("Podaj wspolczynnik c\n"))
    print(f"{rozwiazania_kwadratowe(a,b,c)}")