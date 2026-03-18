#include <stdio.h>

int Newton(int n, int k){
    if (k == 0 || k == n){
        return 1;
    }
    return Newton(n-1, k) + Newton(n-1, k-1);

}



int main(){
    int x, y;
    printf("Podaj n i k:\n");
    scanf("%d", &x);
    scanf("%d", &y);
    printf("%d\n", Newton(x,y));
    
    return 0;
}