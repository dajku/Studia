package permutacje is

   type Permutations is array(Positive range <>) of Integer;


   function nextPerm(tab: in out Permutations) return Boolean;

   function isSolution(tab: in out Permutations) return Boolean;

   procedure genTab(tab: out Permutations);

end permutacje;