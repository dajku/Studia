with Ada.Text_IO; use Ada.Text_IO;

package body euler is


   type Tablica_czynnikow is array(Positive range <>) of Positive;


   function rozkladNaCzynniki(n : Positive) return Tablica_czynnikow is
      rozkladLiczby : Tablica_czynnikow(1 .. 50); -- 
      licznik : Natural := 0; -- ilosc liczb w tablicy

      kopiaN : Positive := n;
      i : Positive := 3;
      kwadrat : Positive := 9;
      roznica : Positive := 16;
      
   begin
      while kopiaN mod 2 = 0 loop
         licznik := licznik + 1;
         rozkladLiczby(licznik) := 2;
         kopiaN := kopiaN / 2;
      end loop;


      while kwadrat <= kopiaN loop
         while kopiaN rem i = 0 loop
            licznik := licznik + 1;
            rozkladLiczby(licznik) := i;
            kopiaN := kopiaN/i;
         end loop;
         kwadrat := kwadrat + roznica;
         roznica := roznica + 8;
         i := i + 2;
      end loop;
      if kopiaN > 2 then
         licznik := licznik + 1;
         rozkladLiczby(licznik) := kopiaN;
      end if;

      return rozkladLiczby(1 .. licznik);
   end rozkladNaCzynniki;

   

   function Totient(n : Positive) return Positive is
      
      czynniki : Tablica_czynnikow := rozkladNaCzynniki(n);

      wynik : Positive;
      i : Positive;
      dlugosc : Natural;

      aktualne_p : Natural;
      aktualne_k : Natural;
      wartosc_dla_p : Natural;

   begin
      wynik := 1;
      i := 1;
      dlugosc := czynniki'Length;

      while i <= dlugosc loop
         aktualne_p := czynniki(i);

         aktualne_k := 0;

         while (i <= dlugosc) and then (czynniki(i) = aktualne_p) loop
            aktualne_k := aktualne_k + 1;
            i := i + 1;
         end loop;

         wartosc_dla_p := (aktualne_p - 1) * (aktualne_p ** (aktualne_k - 1));

         wynik := wynik * wartosc_dla_p;

      end loop;

      return wynik;
      
   
   end Totient;


end euler;