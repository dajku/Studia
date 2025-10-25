#include <stdio.h>
#include <math.h>

void rozwiazania_kwadratowe(float a, float b, float c)
{
    if (a == 0)
    {
        if (b == 0)
        {
            if (c == 0)
            {
                printf("Nieskonczenie wiele rozwiazan\n");
                return;
            }
            else
            {
                printf("Brak rozwiazan\n");
                return;
            }
        }
        else
        {
            float x = -c / b;
            printf("x = %f\n", x);
            return;
        }
    }
    float delta = b * b - (4 * a * c);
    if (delta < 0)
    {
        printf("Brak rozwiazan w zbiorze liczb rzeczywistych\n");
        return;
    }
    else if (delta == 0)
    {
        float x = -b / (2 * a);
        printf("x = %f\n", x);
        return;
    }
    else
    {
        float x1 = (-b - sqrt(delta)) / (2 * a);
        float x2 = (-b + sqrt(delta)) / (2 * a);
        printf("x1 = %f, x2 = %f \n", x1, x2);
        return;
    }
}

int main()
{
    float a, b, c;

    printf("Podaj wspolczynnik a:\n");
    scanf("%f", &a);
    printf("Podaj wspolczynnik b:\n");
    scanf("%f", &b);
    printf("Podaj wspolczynnik c:\n");
    scanf("%f", &c);
    rozwiazania_kwadratowe(a, b, c);
    return 0;
}