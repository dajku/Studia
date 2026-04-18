
class InvalidIndex extends RuntimeException{
    
    public InvalidIndex(){
        super();
    }
}

class InvalidArraySize extends RuntimeException{

    public InvalidArraySize(){
        super();
    }
}

public class PascalTriangleRow {
    

    
    private int[] factors;
    public PascalTriangleRow(int n){
        if(n < 0){
            throw new InvalidArraySize();
        }
        calcPascalRow(n);
    }

    void calcPascalRow(int n){
        factors = new int[n+1];
        factors[0] = 1;

        for (int i = 1; i < n+1; i++){
            for (int j = i; j >= 1; j--){
                factors[j] = factors[j] + factors[j-1];
            }
        }
    }

    public int pascalValue(int k){
        if( k < 0 || k >= factors.length){
            throw new InvalidIndex();
        }
        return factors[k];
    }
}   