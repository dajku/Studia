package PrimeNumbers is
   type Sieve is array(Positive range <>) of Boolean;
   type Sieve_Ptr is access Sieve;

   procedure ComputeSieve(s: Sieve_Ptr);

   function CountPrimes(s: Sieve_Ptr) return Natural;

end PrimeNumbers;