with Ada.Text_IO;                   use Ada.Text_IO;
with Ada.Long_Long_Integer_Text_IO; use Ada.Long_Long_Integer_Text_IO;
--  with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure nprime is
   type LLI_array is array (0 .. 1000) of Long_Long_Integer;
   procedure nPierwsza (n : Long_Long_Integer; tab : in out LLI_array) is
      licznik : Long_Long_Integer;
      k       : Long_Long_Integer;
      i       : Integer;
      flag    : Boolean;
   begin
      tab (0) := 2;
      licznik := 3;
      k := 1;

      while k < n loop
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
            k := k + Long_Long_Integer (1);
         end if;

         licznik := licznik + 2;

      end loop;

   end nPierwsza;

   tablica : LLI_array;
   n       : Long_Long_Integer;

begin
   Put_Line ("Podaj n większe od 0: ");
   Get (n);
   if n > 0 then
      nPierwsza (n, tablica);
      Put (Item => n, Width => 1);
      Put (" liczba pierwsza to: ");
      Put (Item => tablica (Integer (n - 1)), Width => 1);
   else
      Put_Line ("Błędne dane! ");

   end if;

end nprime;
