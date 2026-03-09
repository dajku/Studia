with Ada.Unchecked_Deallocation;

package list is
   type ListT is private;

   function isEmpty (l : ListT) return Boolean;

   function Pop (l : in out ListT) return Integer;
   procedure Push (l : in out ListT; e : Integer);
   procedure Append (l : in out ListT; e : Integer);

   function get(l : ListT; i : Integer) return Integer; 
   procedure put(l : in out ListT; i : Integer; e : Integer); 
   procedure insert(l : in out ListT; i : Integer; e : Integer); 
   procedure delete (l : in out ListT; i : Integer); 

   procedure Print (l : ListT);
   procedure Clean (l : in out ListT); --


   function Length (l : ListT) return Integer; 
private
   type Node;
   type NodePtr is access Node;
   type Node is record
      elem : Integer := 0;
      next : NodePtr := null;
   end record;

   type ListT is record
      first : NodePtr := null;
      Length : Integer := 0;
      last  : NodePtr := null;
   end record;

   procedure Free is
      new Standard.Ada.Unchecked_Deallocation (Node, NodePtr);
end list;
