
public class PascalTriangleRow {
    

    // private int _n;

    public PascalTriangleRow(int n, int m){
        calcPascalRow(n, m);
    }

    int min(int x, int y){
        if(x <= y){
            return x;
        }
        return y;
    }
    int calcPascalRow(int n, int k){
        k = min(k, n - k);
        int[] C = new int[n+1];
        C[0] = 1;

        for (int i = 0; i <= n; i++){
            if (i <= k){
                C[i] = 1;
            }
            for (int j = min(k, i-1); j >= 1; j--){
                C[j] = C[j] + C[j-1];
            }
        }

        return C[k];
    }
}


class Test{
    public static void main(String[] args){
        PascalTriangleRow pascal = new PascalTriangleRow(4,3);
        System.out.println(pascal);
        

    }
}
