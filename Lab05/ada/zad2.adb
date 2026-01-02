with findzeropackage; use findzeropackage;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Long_Float_Text_IO; use Ada.Long_Float_Text_IO;
procedure zad2 is

   wynik : Long_Float;
   a: Long_Float := 2.0;
   b: Long_Float := 4.0;
   eps : Long_Float := 1.0;
begin
   --  Put("Podaj a: ");
   --  Get(a);
   --  Put("Podaj b: ");
   --  Get(b);
   --  Put("Podaj epsilon: ");
   --  Get(eps);
   --  wynik := FindZero(cos_2'Access,a, b, eps);
   --  Put_Line(wynik'Image);

   for i in 1 .. 8 loop
      eps := eps/10.0;
      wynik := FindZero(cos_2'Access, a, b, eps);
      Put_Line("Dla eps = " & eps'Image & ", wynik = " & wynik'Image);

   end loop;
end zad2;