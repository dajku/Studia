with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;

package body permutacje is 

   procedure odwroc(tab: in out Permutations; p: Integer; k: Integer) is
      
      i: Integer := p;
      j: Integer := k;
      temp: Integer;
   begin
      
      while (i < j) loop
         temp := tab(i);
         tab(i) := tab(j);
         tab(j) := temp;

         i := i + 1;
         j := j - 1;

      end loop;

   end odwroc;

   function nextPerm(tab: in out Permutations) return Boolean is
      
      i: Integer := tab'Length - 1;
      j: Integer := tab'Length;
      temp: Integer;

   begin
      
      while(i >= 1 and then tab(i) >= tab(i+1)) loop
         i := i - 1;
      end loop;

      if (i < 1) then
         return False;
      end if;

      while(tab(j) <= tab(i)) loop
         j := j - 1;
      end loop;

      temp := tab(i);
      tab(i) := tab(j);
      tab(j) := temp;
      odwroc(tab, i+1, tab'Length);
      return True;

   end nextPerm;
   
   
   procedure genTab(tab: out Permutations) is --  parametr out słuzy do wypełniania tablicy od zera (stara zawartość jest ignorowana) 

   begin
      for i in tab'Range loop
         tab(i) := i;
      end loop;

   end genTab;

   function isSolution(tab: in out Permutations) return Boolean is
   
   begin
      for i in 1 .. tab'Length loop
         for j in i+1 .. tab'Length loop
            if(abs(tab(i) - tab(j)) = abs(i - j)) then
               return False;
            end if;
         end loop;

      end loop;
      
      return True;

   end isSolution;

end permutacje;