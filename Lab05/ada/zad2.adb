with findzeropackage; use findzeropackage;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Long_Float_Text_IO; use Ada.Long_Float_Text_IO;
procedure zad2 is

   wynik : Long_Float;
   a: Long_Float;
   b: Long_Float;
   eps : Long_Float;
begin
   Put("Podaj a: ");
   Get(a);
   Put("Podaj b: ");
   Get(b);
   Put("Podaj epsilon: ");
   Get(eps);
   wynik := FindZero(cos_2'Access,a, b, eps);
   Put_Line(wynik'Image);

end zad2;