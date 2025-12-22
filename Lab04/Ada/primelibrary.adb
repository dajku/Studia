with Ada.Text_IO; use Ada.Text_IO;
with Ada . Integer_Text_IO ; use Ada . Integer_Text_IO;
with Ada.Command_Line; use Ada.Command_Line;
with Ada.Numerics; use Ada.Numerics;
with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;
with Ada.Unchecked_Deallocation;

package body primelibrary is

   
   type Sieve is array(Positive range <>) of Boolean;
   type Sieve_Ptr is access Sieve;

   function PrimeNumbers (n : Positive) return Positive is 

      procedure ComputeSieve (s : Sieve_Ptr) is

         j : Natural;

      begin
         s.all := (others => True);
         for i in s'Range loop
            if s (i) then
               j := i + i;
               while j <= s'Last loop
                  s (j) := False;
                  j := j + i;
               end loop;
            end if;
         end loop;

      end ComputeSieve;

      function CountPrimes (s : Sieve_Ptr) return Positive is
         c : Natural := 0;
      begin
         for i in s'Range loop
            if s (i) then
               c := c + 1;
            end if;
         end loop;
         return c;
      end CountPrimes;

      procedure Free is new
        Standard.Ada.Unchecked_Deallocation (Sieve, Sieve_Ptr);

      c : Natural := 0;
      s : Sieve_Ptr;

   begin

      s := new Sieve (2 .. n);
      ComputeSieve (s);
      c := CountPrimes (s);
      Free (s);
      return c;

   end PrimeNumbers;

   function Prime(n : Positive) return Positive is

         type LLI_array is array (0 .. 1000) of Positive;

      procedure nPierwsza (x : Positive; tab : in out LLI_array) is
         licznik : Positive;
         k       : Positive;
         i       : Integer;
         flag    : Boolean;
      begin
         tab (0) := 2;
         licznik := 3;
         k := 1;

         while k < x loop
            flag := True;

            i := 0;

            while (i < Integer (k) and (tab (i) * tab (i) <= licznik) and flag)
            loop
               if licznik mod tab (i) = 0 then
                  flag := False;
               end if;
               i := i + 1;
            end loop;


            if flag then
               tab (Integer (k)) := licznik;
               k := k + Positive (1);
            end if;

            licznik := licznik + 2;

         end loop;

      end nPierwsza;

      tablica : LLI_array;
   begin

   nPierwsza (n, tablica);
   return tablica(Integer(n-1));

   end Prime;

   function IsPrime(n: Positive) return Boolean is

      limit : Integer;
      i : integer := 3;

   begin
      if n < 2 then
         return False;
      end if;
      if n = 2 then
         return True;
      end if;
      if n rem 2  = 0 then
         return False;
      end if;
      limit := Integer(Float'Floor(Elementary_Functions.Sqrt(Float(n))));
      while i <= limit loop
         if n rem i = 0 then
            return False;
         end if;
         i := i + 2;
      
      end loop;
      return True;
   end IsPrime;
end primelibrary;
