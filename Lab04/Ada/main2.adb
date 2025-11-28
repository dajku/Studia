with euler; use euler;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Command_Line; use Ada.Command_Line;


procedure main2 is
   
   wynik : Positive;

begin
   

   for i in 1 .. Argument_Count loop
      wynik := Totient(Integer'Value(Argument(i)));
      Put_Line("totient(" & Argument(i) & ") =" & wynik'Image);
      

   end loop;


end main2;