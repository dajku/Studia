
package body findzeropackage is

   function cos_2(X: Long_Float) return Long_Float is
   begin
      return Long_Float(Cos(Float(X) / 2.0));
   end cos_2;

   function FindZero(f: FuncType;a,b,eps: in out Long_Float) return Long_Float is
      srodek : Long_Float := (a+b)/2.0;

   begin
      while abs(a-b) > eps loop
         if f(a) * f(srodek) < 0.0 then
            b := srodek;
            srodek := (a+b)/2.0;
         else
            a := srodek;
            srodek := (a+b)/2.0;
         
         end if;

      end loop;
      return srodek;
   end FindZero;

end FindZeroPackage;