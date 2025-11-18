with Ada . Text_IO ; use Ada . Text_IO ;
with Ada . Integer_Text_IO ; use Ada . Integer_Text_IO ;

package body PrimeNumbers is
   procedure ComputeSieve (s : Sieve_Ptr) is
      j : Natural ;
   begin
      s.all := (others => True);
      for i in s'Range loop
         if s (i) then
            j := i + i;
            while j <= s'Last loop
               s (j) := False ;
               j := j + i;
            end loop ;
         end if;
      end loop;

   end ComputeSieve;

   function CountPrimes (s : Sieve_Ptr) return Natural is
      c : Natural := 0;
   begin
      for i in s'Range loop
         if s (i) then
            c := c + 1;
         end if;
      end loop ;
      return c;
   end CountPrimes;
end PrimeNumbers;


