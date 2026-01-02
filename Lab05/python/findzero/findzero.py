import math

def cos_2(X):
    return math.cos(X/2)

def findzero(f, a, b, eps):
    srodek = (a+b)/2

    while (abs(a-b) > eps):
        if (f(a) * f(srodek) < 0.0):
            b = srodek
            srodek = (a+b)/2
        else:
            a = srodek
            srodek = (a+b)/2

    return srodek
