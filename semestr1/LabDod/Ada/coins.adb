with Ada.Text_iO; use Ada.Text_iO;
with Ada.integer_Text_iO; use Ada.integer_Text_iO;
with Ada.Command_Line; use Ada.Command_Line;

procedure Coins is

   type int_Array is array (integer range <>) of integer;
   type int_Array_Access is access int_Array;

   procedure Obliczanie_reszty (r : integer; Nominaly : int_Array; Nominaly_Dlugosc : integer) is
      C : array (0 .. r) of integer;
      D : array (0 .. r) of integer;
      liczniki : array (0 .. Nominaly_Dlugosc - 1) of integer;
      aktualna_moneta : integer;
      reszta : integer;
      nowy_koszt : integer;
      temp_r : integer;
      moneta : integer;
   begin
      C(0) := 0;
      D(0) := -1;

      for i in 1 .. r loop
         C(i) := r + 1;
         D(i) := -1;

         for J in 0 .. Nominaly_Dlugosc - 1 loop
            aktualna_moneta := Nominaly(J);

            if i >= aktualna_moneta then
               reszta := i - aktualna_moneta;

               if C(reszta) /= r + 1 then
                  nowy_koszt := C(reszta) + 1;

                  if nowy_koszt < C(i) then
                     C(i) := nowy_koszt;
                     D(i) := aktualna_moneta;
                  end if;
               end if;
            end if;
         end loop;
      end loop;

      if C(r) > r then
         Put(r, 0); Put(" ==> No solution!"); New_Line;
         return;
      end if;

      Put(r, 0); Put(" ==> "); Put(C(r), 0); New_Line;

      for i in 0 .. Nominaly_Dlugosc - 1 loop
         liczniki(i) := 0;
      end loop;

      temp_r := r;
      while temp_r > 0 loop
         moneta := D(temp_r);

         for i in 0 .. Nominaly_Dlugosc - 1 loop
            if Nominaly(i) = moneta then
               liczniki(i) := liczniki(i) + 1;
               exit;
            end if;
         end loop;
         temp_r := temp_r - moneta;
      end loop;

      for i in 0 .. Nominaly_Dlugosc - 1 loop
         if liczniki(i) > 0 then
            Put("    "); Put(liczniki(i), 0); Put(" x "); Put(Nominaly(i), 0); New_Line;
         end if;
      end loop;

   end Obliczanie_reszty;

   Plik : File_Type;
   N : integer;
   Nominaly : int_Array_Access;

begin
   if Argument_Count < 2 then
      Put("Zla ilosc argumentow");
      return;
   end if;

   Open(Plik, in_File, Argument(1));
   Get(Plik, N);

   Nominaly := new int_Array (0 .. N - 1);

   for i in 0 .. N - 1 loop
      Get(Plik, Nominaly(i));
   end loop;
   Close(Plik);

   for i in 2 .. Argument_Count loop
      Obliczanie_reszty(integer'Value(Argument(i)), Nominaly.all, N);
   end loop;

end Coins;