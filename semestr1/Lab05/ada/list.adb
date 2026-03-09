with Ada.Text_IO; use Ada.Text_IO;

package body list is
   function isEmpty (l : ListT) return Boolean is
   begin
      return l.first = null;
   end isEmpty;

   function Pop (l : in out ListT) return Integer is
      n : NodePtr := l.first;
      e : Integer := n.elem;
   begin
      l.first := n.next;
      l.Length := l.Length - 1;
      if l.first = null then -- last element
         l.last := null;
         l.Length := 0;
      end if;
      Free (n);
      return e;
   end Pop;

   procedure Push (l : in out ListT; e : Integer) is
      n : NodePtr := new Node;
   begin
      n.elem := e;
      n.next := l.first;
      l.first := n;
      l.Length := l.Length + 1;
      if l.last = null then -- first element
         l.last := n;
      end if;
   end Push;

   procedure Append (l : in out ListT; e : Integer) is
      n : NodePtr := new Node;
   begin
      n.elem := e;
      l.Length := l.Length + 1;
      if l.first = null then -- first element
         l.first := n;
      else
         l.last.next := n;
      end if;
      l.last := n;
   end Append;

   -- FUNKCJE Z ZADANIA

   function get(l : ListT; i : Integer) return Integer is
      aktualny_Node : NodePtr := l.first;
      aktualny_Index : Integer := 1;
   begin 
      
      while aktualny_Index < i loop
         aktualny_Node := aktualny_Node.next;
         aktualny_Index := aktualny_Index + 1;

      end loop;

      return aktualny_Node.elem;
   end get;

   procedure put(l: in out ListT;i : Integer; e : Integer ) is
      aktualny_Node : NodePtr := l.first;
      aktualny_Index : Integer := 1;

   begin

      while aktualny_Index < i loop
         aktualny_Index := aktualny_Index + 1;
         aktualny_Node := aktualny_Node.next;

      end loop;

      aktualny_Node.elem := e;

   end put;   

   procedure insert(l: in out ListT; i : Integer; e : Integer) is
      aktualny_Node : NodePtr := l.first;
      nowy_Node : NodePtr := new Node;

   begin
      if i = 1 then Push(l,e);
      elsif i = Length (l) + 1 then Append (l, e);
      else
         for j in 2 .. i - 1 loop
            aktualny_Node := aktualny_Node.next;
         end loop;
         nowy_Node.elem := e;
         nowy_Node.next := aktualny_Node.next;
         aktualny_Node.next := nowy_Node;
         l.Length := l.Length + 1;
      end if;

   end insert;

   procedure delete(l: in out ListT; i : Integer) is

   tmp : NodePtr;
   prev_node : NodePtr;

   begin
      if i = 1 then
         if l.first = l.last then   
            tmp := l.first;
            l.first := null;
            l.last := null;
            Free(tmp);
            l.Length := 0;

         else
            tmp := l.first;
            l.first := l.first.next;
            l.Length := l.Length - 1;
            Free(tmp);
         end if;
      else
         prev_node := l.first;

         for j in 2 .. i - 1 loop
            prev_node := prev_node.next;
         end loop;

         tmp := prev_node.next;
         prev_node.next := tmp.next;
         Free(tmp);
         l.Length := l.Length - 1;
         if prev_node.next = null then
            l.last := prev_node;
         end if;

      end if;
   
   
   end delete;

   procedure Clean(l: in out ListT) is
      aktualny_Node : NodePtr := l.first;
      temp : NodePtr;

   begin

      while aktualny_Node /= null loop
         temp := aktualny_Node;
         aktualny_Node := aktualny_Node.next;
         Free (temp);
      end loop;
      l.first := null;
      l.last := null;
      l.Length := 0;

   end Clean;


   procedure Print (l : ListT) is
      n : NodePtr := l.first;
   begin
      while n /= null loop
         Put (n.elem'Image);
         n := n.next;
      end loop;
      Put_Line (" (" & Length(l)'Image & " )");
   end Print;


   function Length (l : ListT) return Integer is

   begin

      return l.Length;

   end Length;
end list;
