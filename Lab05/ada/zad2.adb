with findzeropackage; use findzeropackage;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;

procedure zad2 is

   wynik : Long_Float;
   a: Long_Float := 2.0;
   b: Long_Float := 4.0;
   eps : Long_Float := 0.00001;
begin
   wynik := FindZero(cos_2'Access,a, b, eps);
   Put_Line(wynik'Image);

end zad2;