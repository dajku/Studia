with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;

package FindZeroPackage is

   type FuncType is access function (X: Long_Float) return Long_Float;

   function cos_2(X: Long_Float) return Long_Float;

   function FindZero(f : FuncType; a, b, eps: in out Long_Float) return Long_Float;


end FindZeroPackage;