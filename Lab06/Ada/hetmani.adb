with Ada.Command_Line; use Ada.Command_Line;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Text_IO; use Ada.Text_IO;

procedure hetmani is
   
   n: Integer;

begin

   if Argument_Count /= 1 then
      Put_Line("Zła liczba argumentów");
      return;  
   end if; 

   n := Integer'Value(Argument(1));

   declare
      position : array (1 .. n) of Integer := (others => 0);
      bije_kolumne : array (1 .. n) of Boolean := (others => False);
      bije_przek1 : array(2 .. 2*n) of Boolean := (others => False);
      bije_przek2 : array(-n + 1 .. n - 1) of Boolean := (others => False);
      licznik : Integer := 0;

      procedure Ustaw(i : Integer) is

      begin
         for j in 1 .. n loop
            if not (bije_kolumne(j) or else bije_przek1(i + j) or else bije_przek2(i-j)) then

               position(i) := j;
               bije_kolumne(j) := True;
               bije_przek1(i+j) := True;
               bije_przek2(i-j) := True;

               if i < n then

                  Ustaw (i+1);

               else 

                  for k in 1 .. n loop

                     Put(position(k)'Image & " ");

                  end loop;

                  licznik := licznik + 1;
                  Put_Line("");

               end if;

               position(i) := 0;
               bije_kolumne(j) := False;
               bije_przek1(i + j) := False;
               bije_przek2(i - j) := False;

            end if;

         end loop;
      end Ustaw;
   begin

      Ustaw (1);
      Put_Line (licznik'Image);


   end;
   
   



end hetmani;