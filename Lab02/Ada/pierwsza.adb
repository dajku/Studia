with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Numerics; use Ada.Numerics;
procedure pierwsza is
   function czy_pierwsza(
      n : Integer
   ) return Boolean is
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


   end czy_pierwsza;
   x : Integer ;
   wynik : Boolean;
begin
   Put_Line ("Podaj liczbe: ");
   Get(x);
   wynik := czy_pierwsza(x);
   if wynik then
      Put_Line(x'Image & " jest liczbą pierwszą");
   else 
      Put_Line(x'Image & " nie jest liczbą pierwszą");

   end if;

end pierwsza;