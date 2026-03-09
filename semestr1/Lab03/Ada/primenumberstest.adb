with Ada.Text_IO; use Ada.Text_IO;
with Ada.Command_Line; use Ada.Command_Line;
with Ada.Unchecked_Deallocation;
with PrimeNumbers; use PrimeNumbers;


procedure PrimeNumbersTest is
   procedure Free is
      new Standard.Ada.Unchecked_Deallocation(Sieve, Sieve_Ptr);
   n : Natural;
   c : Natural := 0;
   s : Sieve_Ptr;
   begin
      if Argument_Count /= 1 then

         Put_Line ("Zła liczba argumentów");
         return;
      end if;
      n := Natural'Value(Argument(1));
      s := New Sieve(2 .. n);
      ComputeSieve(s);
      c := CountPrimes(s);
      Free(s);
      Put("Ilość liczb pierwszych mniejszych od" & n'Image & " wynosi:" & c'Image);
   exception 
      when Constraint_Error =>
         Put_Line ("Błędne dane");
         return;

end PrimeNumbersTest;