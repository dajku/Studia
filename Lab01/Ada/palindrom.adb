with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure palindrom is

   function czy_palindrom(
      n :  in Integer;
      p : in Integer
   ) return Boolean is
   odwrocona : Integer := 0;
   kopia_n : Integer := n;
   ostatnia_cyfra : Integer;

   begin
      while kopia_n > 0 loop
         ostatnia_cyfra := kopia_n rem p;
         odwrocona := (odwrocona * p) + ostatnia_cyfra;
         kopia_n := kopia_n/p;
      end loop;
      return (odwrocona = n);

   end czy_palindrom;

   liczba : Integer;
   system: Integer;
   wynik : Boolean;
begin
   Put_Line("Podaj liczbe: ");
   Get(liczba);
   Put_Line ("Podaj system liczby: ");
   Get(system);
   wynik := czy_palindrom(liczba,system);
   Put_Line ("Czy liczba" & liczba'Image & " jest palindromem w systemie " & system'Image & ": " & wynik'Image);
end palindrom;   