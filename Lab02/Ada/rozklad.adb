with Ada.Text_IO; use Ada.Text_IO;
with Ada.Long_Long_Integer_Text_IO; use Ada.Long_Long_Integer_Text_IO;
with Ada.Containers.Vectors;





procedure rozklad is
   -- pozwalamy na użycie wektorów
   package Long_Long_Integer_Vectors is new Ada.Containers.Vectors(
      Index_type => Positive,
      Element_type => Long_Long_Integer);
   
   use Long_Long_Integer_Vectors;


   function rozkladNaCzynniki(n : Long_Long_Integer) return Vector is
      rozkladLiczby : Vector;

      kopiaN : Long_Long_Integer := n;
      i : Long_Long_Integer := 3;
      kwadrat : Long_Long_Integer := 9;
      roznica : Long_Long_Integer := 16;
      
   begin
      while kopiaN mod Long_Long_Integer(2) = 0 loop
         rozkladLiczby.Append(Long_Long_Integer(2));
         kopiaN := kopiaN / Long_Long_Integer(2);
      end loop;


      while kwadrat <= kopiaN loop
         while kopiaN rem i = 0 loop
            rozkladLiczby.Append(i);
            kopiaN := kopiaN/i;
         end loop;
         kwadrat := kwadrat + roznica;
         roznica := roznica + Long_Long_Integer(8);
         i := i + Long_Long_Integer(2);
      end loop;
      if kopiaN > Long_Long_Integer(2) then
         rozkladLiczby.Append(kopiaN);
      end if;
      return rozkladLiczby;
   end rozkladNaCzynniki;
   x : Long_Long_Integer;
   czynniki : Vector;
   i : Positive := 1;
   j : Positive;
   aktualnyCzynnik : Long_Long_Integer;
   licznik : Long_Long_Integer := 0;
begin 
   Put("Podaj liczbe: ");
   Get(x);
   czynniki := rozkladNaCzynniki(x);
   Put(Item => x, Width => 1);
   Put("=");
   while i <= Integer(czynniki.Length) loop
      aktualnyCzynnik := czynniki.Element (i);
      licznik := 0;

      j := i;
      while j <= Integer(czynniki.Length) and then aktualnyCzynnik = Long_Long_Integer(czynniki.Element(j)) loop
         licznik := licznik + Long_Long_Integer(1);
         j := j + 1;
      end loop;

      if (Long_Long_Integer(i) > 1) then
         Put("*");
      end if;

      Put (aktualnyCzynnik, Width => 1);
      
      if licznik > Long_Long_Integer(1) then
         Put("^");
         Put(Item => licznik, Width => 1);
      end if;
      i := i + Positive(licznik);
   end loop;

   --  for i in czynniki.First_Index .. czynniki.Last_Index loop
   --     Put(czynniki.Element(i)'Image);
   --  end loop;
         

end rozklad;