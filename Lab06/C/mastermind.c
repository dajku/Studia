#include <stdio.h>
#include <stdbool.h>

#define DIGITS 6

// generowanie kodow
void start(int kody[][4], bool czy_mozliwy[])
{ // kody[][] wyrzuca bład, rozmiar wewnetrznych tablic musi być stały
    int index = 0;

    for (int i = 1; i <= DIGITS; i++)
    {
        for (int j = 1; j <= DIGITS; j++)
        {
            for (int k = 1; k <= DIGITS; k++)
            {
                for (int l = 1; l <= DIGITS; l++)
                {
                    kody[index][0] = i;
                    kody[index][1] = j;
                    kody[index][2] = k;
                    kody[index][3] = l;

                    czy_mozliwy[index] = true;

                    index++;
                }
            }
        }
    }
}

void symulacja(int kod1[], int kod2[], int *trafionych_lokalnie, int *nietrafione_lokalnie)
{

    *trafionych_lokalnie = 0;
    *nietrafione_lokalnie = 0;

    int kopia1[4];
    int kopia2[4];
    for (int i = 0; i < 4; i++)
    {
        kopia1[i] = kod1[i];
        kopia2[i] = kod2[i];
    }

    // trafione idealnie:
    for (int i = 0; i < 4; i++)
    {
        if (kopia1[i] == kopia2[i])
        {
            (*trafionych_lokalnie)++;
            // zamiana na -1 aby wiedzieć które są skreślone
            kopia1[i] = -1;
            kopia2[i] = -1;
        }
    }

    // nietrafione idealnie:
    for (int i = 0; i < 4; i++)
    {
        if (kopia1[i] == -1)
        {
            continue;
        }

        // dla kazdej z cyfr w kodzie 1 sprawdzamy czy nie występuje w kodzie 2

        for (int j = 0; j < 4; j++)
        {
            if (kopia2[j] == -1)
            {
                continue;
            }

            if (kopia1[i] == kopia2[j])
            {
                (*nietrafione_lokalnie)++;
                kopia2[j] = -1;
                break;
            }
        }
    }
}

void filtruj(int kody[][4], bool czy_mozliwy[], int aktualny_strzal[], int trafione, int nietrafione)
{

    // Mozemy przeprowadzić małą symulacje dla każdego z kodów z tablicy i porównać wartosci zwracanych trafionych i nietrafionych

    for (int i = 0; i < 1296; i++)
    {
        if (czy_mozliwy[i])
        {
            int trafione_lokalnie = 0;
            int nietrafione_lokalnie = 0; // dla kazdej z symulacji potrzebujemy zmiennej zapisującej ilosc traf i nietraf

            symulacja(kody[i], aktualny_strzal, &trafione_lokalnie, &nietrafione_lokalnie);

            if (trafione != trafione_lokalnie || nietrafione != nietrafione_lokalnie)
            {
                czy_mozliwy[i] = false;
            }
        }
    }
}

int main(int argc, char *argv[])
{
    int kody[1296][4];
    bool czy_mozliwy[1296]; // czy dany kod jest mozliwy

    start(kody, czy_mozliwy); // tworzenie wszystkich mozliwych kodów

    bool czy_koniec = false;

    int runda = 1;

    while (!czy_koniec)
    {

        int index_strzalu = -1;

        // Szukamy pierwszego wolnego kodu
        for (int i = 0; i < 1296; i++)
        {
            if (czy_mozliwy[i])
            {
                index_strzalu = i;
                break;
            }
        }

        if (index_strzalu == -1)
        {
            printf("Oszukujesz!\n");
            break;
        }

        printf("%d: %d %d %d %d ?\n", runda, kody[index_strzalu][0], kody[index_strzalu][1], kody[index_strzalu][2], kody[index_strzalu][3]);

        int trafione = 0;
        int nietrafione = 0;
        printf("Na swoim miejscu: ");
        scanf("%d", &trafione);

        if (trafione == 4)
        {
            printf("Wygrałem.\n");
            czy_koniec = true;
            break;
        }

        printf("Nie na swoim miejscu: ");
        scanf("%d", &nietrafione);

        filtruj(kody, czy_mozliwy, kody[index_strzalu], trafione, nietrafione);

        runda++;
    }
}