with Ada.Text_IO; use Ada.Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;

procedure kwadratowe is
   
   procedure rozwiazania_kwadratowe(
      a : in Float;
      b : in Float;
      c : in Float
   ) is
   delta_row : Float; 
   x : Float;
   x_0 : Float;
   x_1 : Float;
   x_2 : Float;
   begin
      if a = 0.0 then
         if b = 0.0 then
            if c = 0.0 then
               Put_Line("Nieskonczenie wiele rozwiazan");
               return;
            else
               Put_Line("Brak rozwiazan");
               return;
            end if;
         else
            x := -c/b;
            Put_Line("x = " & x'Image);
            return;
         end if;
      end if;

      delta_row := (b*b)-(4.0*a*c);
      if delta_row < 0.0 then
         Put_Line("Brak rozwiazan w zbiorze liczb rzeczywistych");
         return;
      elsif delta_row = 0.0 then
         x_0 := -b/(2.0*a);
         Put_Line("x = " & x_0'Image);
         return;
      else
         x_1 := (-b - Sqrt(delta_row))/(2.0*a);
         x_2 := (-b + Sqrt(delta_row))/(2.0*a);
         Put_Line("x1 = " & x_1'Image & " x2 = " & x_2'Image);
         return;
      end if;
   end rozwiazania_kwadratowe;
   
a, b, c: Float;

begin
   Put_Line("Podaj wspolczynnik a: ");
   Get(a);
   Put_Line("Podaj wspolczynnik b: ");
   Get(b);
   Put_Line("Podaj wspolczynnik c: ");
   Get(c);
   rozwiazania_kwadratowe (a, b, c);

end kwadratowe;