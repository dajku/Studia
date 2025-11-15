with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;



procedure newton is
   function calcNewton(n_parameter : Integer;k_parameter : Integer) return Integer is
      czynniki : array (0 .. n_parameter + 1) of Integer := (others => 0);
      n : Integer := n_parameter;
      k : Integer := k_parameter;


      function min(a,b : Integer ) return Integer is
      begin
         if a < b then
            return a;
         else 
            return b;
         end if;
      end min;

   begin
      czynniki(0) := 1;
      k := min(k, n-k);

      for i in 1 .. n  loop
         if i <= k then
            czynniki(i) := 1;
         end if;
         
         for j in reverse min(k, i-1) .. 1 loop
            czynniki(j) := czynniki(j) + czynniki(j-1);
         end loop;
      end loop;

      return czynniki(k);
   end calcNewton;

   n : Integer := 0;
   k : Integer := 0;
   wynik : Integer;
begin

   Put_Line("Podaj n: ");
   Get(n);

   Put_Line("Podaj k: ");
   Get(k);
   if n < 0 then
      Put_Line ("n nie może być ujemne");
   elsif k < 0 or k > n then
      Put_Line ("k musi być w zakresie od 0 do n");
   else
      wynik := calcNewton(n,k);
      Put_Line(n'Image & " po " & k'Image & " = " & wynik'Image);
   end if;
   

end newton;
