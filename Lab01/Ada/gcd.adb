with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
procedure gcd is
   a, b, c: Integer;
begin
   Put("Podaj pierwszą liczbę: ");
   Get(a);
   Put("Podaj drugą liczbę: ");
   Get(b);
   while b > 0 loop
      c := a rem b;
      a := b;
      b := c;
   end loop;
   Put_Line ("Największy wspólny dzielnik to " & a'Image);
end gcd;