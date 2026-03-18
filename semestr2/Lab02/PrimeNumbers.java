
public class PrimeNumbers {
    int length = 0;
    int[] primes;


    public PrimeNumbers(int n) {
        boolean[] sieve = new boolean[n];
        primes = new int[n];
        for (int i = 2; i < n; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (sieve[i]) {
                for (int j = i + i; j < n; j = j + i) {
                    sieve[j] = false;
                }
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (sieve[i]) {
                primes[index] = i;
                length++;
            }
            index++;
        }
    }

    public int getNumber(int m) {
        return primes[m];
    }

    public int getLength() {
        return length;
    }
}

class Test {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            if (n <= 1) {
                System.out.println(n + " - " + " Nieprawidłowy zakres");
                return;
            }
            PrimeNumbers primes = new PrimeNumbers(n);
            for (int i = 1; i < args.length; i++) {
                try {
                    int currentInteger = Integer.parseInt(args[i]);
                    if (currentInteger >= primes.getLength()) {
                        System.out.println(args[i] + " - " + " liczba spoza zakresu");
                    } else {
                        System.out.println(args[i] + " - " + primes.getNumber(currentInteger));
                    }
                } catch (NumberFormatException ex) {
                    System.out.println(args[i] + " nieprawidłowa dana");
                }

            }
        } catch (NumberFormatException ex) {
            System.out.println(args[0] + " nieprawidłowa dana");
            return;
        }

    }
}