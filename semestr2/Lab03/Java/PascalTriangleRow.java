
public class PascalTriangleRow {
    
    
    private int[] C;
    public PascalTriangleRow(int n){
        calcPascalRow(n);
    }

    void calcPascalRow(int n){
        C = new int[n+1];
        C[0] = 1;

        for (int i = 0; i <= n+1; i++){
            for (int j = i-1; j >= 1; j--){
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
        if(args.length == 0){
            System.out.println("Nie podano argumentów");
        }
        try{

            int n = Integer.parseInt(args[0]);
            PascalTriangleRow pascal = new PascalTriangleRow(n);

            for(int i = 1; i < args.length; i++){
                try{
                    int index = Integer.parseInt(args[i]);
                    System.out.println(args[i] + " - " + pascal.pascalValue(index));
                }
                catch(NumberFormatException ex){
                    System.out.println(args[i] + " - nieprawidłowa dana");
                }
                catch(ArrayIndexOutOfBoundsException ex){
                    System.out.println(args[i] + " - liczba spoza zakresu");
                }
            }

        }
        catch(NumberFormatException ex){
            System.out.println(args[0] + " - nieprawidłowa dana");
            return;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println(args[0] + " - liczba spoza zakresu");
            return;
        }

    }
}
