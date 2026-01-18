with permutacje; use permutacje;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Command_Line; use Ada.Command_Line;

procedure main is
   n: Integer;
   solutions: Integer := 0;
   wynik : Boolean;

begin

   if(Argument_Count /= 1) then
      Put_Line("Zła liczba argumentów");
      return;
   end if;

   n := Integer'Value(Argument(1));
   
   declare -- uzycie declare po to aby tablica miała rozmiar od 1 do n
      tab : permutacje.Permutations(1 .. n);
   begin

      permutacje.genTab(tab);

      wynik := permutacje.isSolution(tab);

      if (wynik) then
         solutions := solutions + 1;
         for i in 1 .. n loop
            Put(tab(i)'Image);
            Put_Line("");
         end loop;
      end if;

      while (permutacje.nextPerm(tab)) loop
         wynik := permutacje.isSolution(tab);

         if (wynik) then
            solutions := solutions + 1;
            for i in 1 .. n loop
               Put(tab(i)'Image);
            end loop;
            Put_Line("");

         end if;


      end loop;
   end;
   Put_Line ("Number of solutions: " & solutions'Image);
      


end main;