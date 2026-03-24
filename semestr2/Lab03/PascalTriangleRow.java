
public class PascalTriangleRow {
    

    private int m;
    private int[] C;
    public PascalTriangleRow(int n, int x){
        calcPascalRow(n, m);
        m = x;
    }

    int min(int x, int y){
        if(x <= y){
            return x;
        }
        return y;
    }
    void calcPascalRow(int n, int k){
        k = min(k, n - k);
        C = new int[n+1];
        C[0] = 1;

        for (int i = 0; i <= n; i++){
            if (i <= k){
                C[i] = 1;
            }
            for (int j = min(k, i-1); j >= 1; j--){
                C[j] = C[j] + C[j-1];
            }
        }

    }

    public int pascalValue(int k){
        return C[k];
    }
}


class Test{
    public static void main(String[] args){
        PascalTriangleRow pascal = new PascalTriangleRow(4,3);
        System.out.println(pascal.pascalValue(2));
        

    }
}
