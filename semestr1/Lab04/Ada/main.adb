with primelibrary; use primelibrary;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Command_Line; use Ada.Command_Line;

procedure main is

   n : Positive;
   x : Positive;
   b : Boolean;
begin
      if Argument_Count /= 2 then
         Put_Line ("Zła liczba argumentów");
         return;
      end if;
         n := Positive'Value(Argument(2));

      if Argument(1) = "pn" then
         x := primelibrary.PrimeNumbers(n);
         Put_Line ("Ilosc liczb pierwszych mniejszych lub równych" & n'Image & " wynosi:" & x'Image);
      elsif Argument(1) = "pr" then
         x := primelibrary.Prime(n);
         Put_Line(n'Image & " liczba pierwsza to:" & x'Image);
      elsif Argument (1) = "ip" then

         b := primelibrary.IsPrime (n);

         if b then
            Put_Line(n'Image & " jest liczbą pierwszą");
         else 
            Put_Line(n'Image & " nie jest liczbą pierwszą");

         end if;
      end if;
   exception when Constraint_Error =>
      Put_Line ("Błędne dane");
      return;

end main;