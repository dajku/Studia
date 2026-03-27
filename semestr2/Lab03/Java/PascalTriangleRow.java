
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


class Test{
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Nie podano argumentów");
            return;
        }
        try{
            // 33 - największy mozliwy wiersz do wypisania dla int
            // for(int i = 30; i < 40; i++){
            //     PascalTriangleRow pascal = new PascalTriangleRow(i);
            //     System.out.println("############### " + i);
            //     for(int j = 0; j <= i; j++){
            //         System.out.println(j + "  " + pascal.pascalValue(j));
            //     }
            // }
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
                catch(InvalidIndex ex){
                    System.out.println(ex + ": " + args[i] + " - liczba spoza zakresu");
                }
                // catch(ArrayIndexOutOfBoundsException ex){
                //     System.out.println(args[i] + " - liczba spoza zakresu");
                // }
            }

        }
        catch(InvalidArraySize ex){
            System.out.println(ex + ": " + args[0] + " - Nieprawidłowy wiersz trójkąta Pascala");
            return;

        }
        catch(NumberFormatException ex){
            System.out.println(args[0] + " - nieprawidłowa dana");
            return;
        }





    }
}
