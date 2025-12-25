with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use  Ada.Strings.Unbounded;
with Ada.Strings.Unbounded.Text_IO; use Ada.Strings.Unbounded.Text_IO;

with list; use list;

procedure listTest is
   l : ListT;
   r : Integer;
   index: Integer;
   wynik: Integer;
   command : Unbounded_String;
   continue : Boolean := True;
begin
   while continue loop
      Put ("Command: ");
      Get_Line (command);
      if command = "Pop" then
         if not isEmpty (l) then
            r := Pop (l);
            Put_Line ("Result: " & r'Image);
         else
            Put_Line ("Error - stack is empty!");
         end if;
      elsif command = "Push" then
         Put ("Value: ");
         Get (r);
         Skip_Line;
         Push (l, r);
         Put_Line ("Result: OK");
      elsif command = "Append" then
         Put ("Value: ");
         Get (r);
         Skip_Line;
         Append (l, r);
         Put_Line ("Result: OK");
      elsif command = "Print" then
         Put ("Result: ");
         Print (l);
      --  elsif command = "Length" then
      --     r := list.Length (l);
      --     Put_Line ("Result: " & r'Image);
      elsif command = "Get" then
         Put("Value: ");
         Get(r);
         Skip_Line;
         if r > 0 and r <= Length(l) then
            Put("Result :");
            Put(get(l, r)'Image);
         else
            Put_Line ("Zły indeks");
         end if;
      elsif command = "Put" then
         Put("Index: ");
         Get(index);
         if index in 1 .. Length(l) then

            Put("Value: ");
            Get(r);
            Skip_Line;
            put(l, index, r);
            Put_Line("Result: OK");
         else
            Put_Line("Zły indeks");
            Skip_Line;
         end if;
      elsif command = "Insert" then
         Put("Index: ");
         Get(index);
         if index in 1 .. Length (l) + 1 then
            Put("Value: ");
            Get(r);
            Skip_Line;
            insert(l, index, r);
            Put_Line("Result: OK");
         else
            Put_line("Zły indeks");
            Skip_Line;
         end if;
      elsif command = "Delete" then
         Put("Index: ");
         Get(index);
         if index in 1 .. Length (l) then

            Skip_Line;
            delete(l, index);
            Put_Line("Result: OK");
         
         else
            Put_Line("Zły indeks");
            Skip_Line;

         end if;
      elsif command = "Clean" then
         Clean(l);
         Put_Line("Result: OK");
      
      elsif command = "Exit" then
         continue := False;
      else 
         Put_Line ("Unknown command!");
      end if;
   end loop;
   --  clean list
   while not isEmpty (l) loop
      r := Pop (l);
   end loop;
end listTest;

