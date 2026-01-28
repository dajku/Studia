#include <stdio.h>
#include <stdlib.h>

// int* C, int C_len, int* D, int D_len,
void obliczanie_reszty(int r, int *nominaly, int nominaly_dlugosc)
{
    int C[r + 1];
    C[0] = 0;

    int D[r + 1];
    D[0] = -1;

    for (int i = 1; i <= r; i++)
    {
        C[i] = r + 1;
        D[i] = -1;

        for (int j = 0; j < nominaly_dlugosc; j++)
        {
            int aktualna_moneta = nominaly[j];

            if (i >= aktualna_moneta)
            {

                int reszta = i - aktualna_moneta;

                if (C[reszta] != r + 1)
                {

                    int nowy_koszt = C[reszta] + 1;

                    if (nowy_koszt < C[i])
                    {
                        C[i] = nowy_koszt;
                        D[i] = aktualna_moneta;
                    }
                }
            }
        }
    }

    if (C[r] == r + 1)
    {
        printf("%d ===> No solution!\n", r);
        return;
    }

    printf("%d ===> %d\n", r, C[r]);

    int liczniki[nominaly_dlugosc];

    for (int i = 0; i < nominaly_dlugosc; i++)
    {
        liczniki[i] = 0;
    }

    int temp_r = r;
    while (temp_r > 0)
    {
        int moneta = D[temp_r];

        for (int i = 0; i < nominaly_dlugosc; i++)
        {
            if (nominaly[i] == moneta)
            {
                liczniki[i]++;
                break;
            }
        }
        temp_r = temp_r - moneta;
    }

    for (int i = 0; i < nominaly_dlugosc; i++)
    {
        if (liczniki[i] > 0)
        {
            printf("%d x %d\n", liczniki[i], nominaly[i]);
        }
    }
}

int main(int argc, char *argv[])
{

    if (argc < 3)
    {
        printf("Zła ilość argumentóœ");
        return 1;
    }

    FILE *plik = fopen(argv[1], "r");

    int n;
    fscanf(plik, "%d", &n);

    int *nominaly = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
    {
        fscanf(plik, "%d", &nominaly[i]);
    }
    fclose(plik);

    for (int i = 2; i < argc; i++)
    {
        obliczanie_reszty(atoi(argv[i]), nominaly, n);
    }

    free(nominaly);

    return 0;
}