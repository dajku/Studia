with Ada . Text_IO ; use Ada . Text_IO ;
with Ada . Integer_Text_IO ; use Ada . Integer_Text_IO ;
procedure PrimeNumbers is
   function PrimeNumbers (n : Natural ) return Natural is
      type Sieve is array (2 .. n ) of Boolean ;

      procedure ComputeSieve (s : in out Sieve ) is
         j : Natural ;
      begin
         for i in s'Range loop
            s (i) := True ;
         end loop;
         for i in s'First .. s'Last loop
            if s (i) then
               j := i + i;
               while j <= n loop
                  s (j ) := False ;
                  j := j + i;
               end loop ;
            end if;
         end loop ;
      end ComputeSieve ;
   function CountPrimes (s : Sieve ) return Natural is
      c : Natural := 0;
   begin
      for i in s'First .. s'Last loop
         if s (i) then
            c := c + 1;
         end if;
      end loop ;
      return c;
   end CountPrimes ;

       s : Sieve ;
   begin
      ComputeSieve (s);
      return CountPrimes (s);
   end PrimeNumbers ;

       n : Natural := 0;
   begin
      while n < 2 loop
         Put_Line ("Podaj Liczbe n większe od 0: ");
         Get ( n );
         if n > 0 then
            exit;
         end if;
         Put_Line ("Nieprawidłowe dane");

      end loop;
      Put_Line ( "Ilość liczb pierwszych nie większych od n:" & Integer'Image ( PrimeNumbers (n )));

   end PrimeNumbers ;
