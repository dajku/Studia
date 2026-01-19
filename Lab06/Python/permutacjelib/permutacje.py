

def odwroc(tab, p, k):
    i = p
    j = k - 1

    while i < j:
        tab[i], tab[j] = tab[j], tab[i]
        i += 1
        j -= 1
    

def nextPerm(tab):
    i = len(tab) - 2

    while(i >= 0 and tab[i] >= tab[i+1]):
        i -= 1
    
    if i < 0:
        return False
    
    j = len(tab) - 1
    while(tab[j] <= tab[i]):
        j = j-1
    
    tab[i], tab[j] = tab[j], tab[i]

    odwroc(tab, i+1, len(tab))
    return True


# def genTab(tab):
#     for i in range(len(tab)):
#         tab[i] = i + 1


def isSolution(tab):

    for i in range(len(tab)):
        for j in range(i+1, len(tab)):
            if(abs(tab[i] - tab[j]) == abs(i - j)):
                return False
    
    return True