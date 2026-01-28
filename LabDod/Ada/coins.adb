with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Command_Line; use Ada.Command_Line;

procedure Coins is

   type Int_Array is array (Integer range <>) of Integer;
   type Int_Array_Access is access Int_Array;

   procedure Obliczanie_Reszty (R : Integer; Nominaly : Int_Array; Nominaly_Dlugosc : Integer) is
      C : array (0 .. R) of Integer;
      D : array (0 .. R) of Integer;
      Liczniki : array (0 .. Nominaly_Dlugosc - 1) of Integer;
      Aktualna_Moneta : Integer;
      Reszta : Integer;
      Nowy_Koszt : Integer;
      Temp_R : Integer;
      Moneta : Integer;
   begin
      C(0) := 0;
      D(0) := -1;

      for I in 1 .. R loop
         C(I) := R + 1;
         D(I) := -1;

         for J in 0 .. Nominaly_Dlugosc - 1 loop
            Aktualna_Moneta := Nominaly(J);

            if I >= Aktualna_Moneta then
               Reszta := I - Aktualna_Moneta;

               if C(Reszta) /= R + 1 then
                  Nowy_Koszt := C(Reszta) + 1;

                  if Nowy_Koszt < C(I) then
                     C(I) := Nowy_Koszt;
                     D(I) := Aktualna_Moneta;
                  end if;
               end if;
            end if;
         end loop;
      end loop;

      if C(R) > R then
         Put(R, 0); Put(" ==> No solution!"); New_Line;
         return;
      end if;

      Put(R, 0); Put(" ==> "); Put(C(R), 0); New_Line;

      for I in 0 .. Nominaly_Dlugosc - 1 loop
         Liczniki(I) := 0;
      end loop;

      Temp_R := R;
      while Temp_R > 0 loop
         Moneta := D(Temp_R);

         for I in 0 .. Nominaly_Dlugosc - 1 loop
            if Nominaly(I) = Moneta then
               Liczniki(I) := Liczniki(I) + 1;
               exit;
            end if;
         end loop;
         Temp_R := Temp_R - Moneta;
      end loop;

      for I in 0 .. Nominaly_Dlugosc - 1 loop
         if Liczniki(I) > 0 then
            Put("    "); Put(Liczniki(I), 0); Put(" x "); Put(Nominaly(I), 0); New_Line;
         end if;
      end loop;

   end Obliczanie_Reszty;

   Plik : File_Type;
   N : Integer;
   Nominaly : Int_Array_Access;

begin
   if Argument_Count < 2 then
      Put("Zla ilosc argumentow");
      return;
   end if;

   Open(Plik, In_File, Argument(1));
   Get(Plik, N);

   Nominaly := new Int_Array (0 .. N - 1);

   for I in 0 .. N - 1 loop
      Get(Plik, Nominaly(I));
   end loop;
   Close(Plik);

   for I in 2 .. Argument_Count loop
      Obliczanie_Reszty(Integer'Value(Argument(I)), Nominaly.all, N);
   end loop;

end Coins;