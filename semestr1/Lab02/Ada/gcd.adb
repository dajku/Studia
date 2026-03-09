with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
procedure gcd is
   
   function NWD(a, b: in out Integer)
       return Integer is
      c : Integer;

   begin
      while b > 0 loop
         c := a rem b;
         a := b;
         b := c;
      end loop;
      return a;

   end NWD;
   a, b, x: Integer;
begin
   Put("Podaj pierwszą liczbę: ");
   Get(a);
   Put("Podaj drugą liczbę: ");
   Get(b);
   x := NWD(a,b);
   Put_Line ("Największy wspólny dzielnik to " & x'Image);
end gcd;