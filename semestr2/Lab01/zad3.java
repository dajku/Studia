

public class zad3{
    
    public static int div(int n){
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return -1;
        }
        if(n % 2 == 0){
            return n/2;
        }
        for(int i = 3; i*i <= n; i = i+2){
            if(n % i == 0){
                return n/i;
            }

        }

        return 1;
    }
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++){
            try {
                int n = Integer.parseInt(args[i]); 
                int wynik = div(n);
                if(n < 0){
                    System.out.println("Liczba ujemna");
                }
                else if(wynik == -1){
                    System.out.println("Brak największego dzielnika");
                }
                else{
                    System.out.println("Najwiekszy dzielnik " + n + " to " + wynik);
                }
            }
            catch (NumberFormatException ex){
                System.out.println(args[i] + " nie jest liczba calkowita");
            }
        }
    }
}