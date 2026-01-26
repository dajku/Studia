with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Mastermind is

   type Kod_Array is array (1 .. 4) of Integer;
   type Kody_Matrix is array (1 .. 1296) of Kod_Array;
   type Mozliwy_Array is array (1 .. 1296) of Boolean;

   procedure start (kody : out Kody_Matrix; czy_mozliwy : out Mozliwy_Array) is
      index : Integer := 1;
   begin
      for i in 1 .. 6 loop
         for j in 1 .. 6 loop
            for k in 1 .. 6 loop
               for l in 1 .. 6 loop
                  kody(index)(1) := i;
                  kody(index)(2) := j;
                  kody(index)(3) := k;
                  kody(index)(4) := l;
                  czy_mozliwy(index) := True;
                  index := index + 1;
               end loop;
            end loop;
         end loop;
      end loop;
   end start;

   procedure symulacja (kod1, kod2 : in Kod_Array; trafionych_lokalnie, nietrafione_lokalnie : out Integer) is
   
      kopia1 : Kod_Array := kod1;
      kopia2 : Kod_Array := kod2;

   begin
      trafionych_lokalnie := 0;
      nietrafione_lokalnie := 0;

      for i in 1 .. 4 loop
         if kopia1(i) = kopia2(i) then
            trafionych_lokalnie := trafionych_lokalnie + 1;
            kopia1(i) := -1;
            kopia2(i) := -1;
         end if;
      end loop;

      for i in 1 .. 4 loop
         if kopia1(i) /= -1 then
            for j in 1 .. 4 loop
               if kopia2(j) /= -1 then
                  if kopia1(i) = kopia2(j) then
                     nietrafione_lokalnie := nietrafione_lokalnie + 1;
                     kopia2(j) := -1;
                     exit;
                  end if;
               end if;
            end loop;
         end if;
      end loop;
   end symulacja;

   procedure filtruj (kody : in Kody_Matrix; czy_mozliwy : in out Mozliwy_Array; aktualny_strzal : in Kod_Array; trafione, nietrafione : in Integer) is
      trafione_lokalnie    : Integer;
      nietrafione_lokalnie : Integer;
   begin
      for i in 1 .. 1296 loop
         if czy_mozliwy(i) then
            symulacja(kody(i), aktualny_strzal, trafione_lokalnie, nietrafione_lokalnie);

            if trafione /= trafione_lokalnie or else nietrafione /= nietrafione_lokalnie then
               czy_mozliwy(i) := False;
            end if;
         end if;
      end loop;
   end filtruj;

   kody          : Kody_Matrix;
   czy_mozliwy   : Mozliwy_Array;
   czy_koniec    : Boolean := False;
   runda         : Integer := 1;
   index_strzalu : Integer;
   trafione      : Integer;
   nietrafione   : Integer;

begin
   start(kody, czy_mozliwy);

   while not czy_koniec loop
      index_strzalu := -1;

      for i in 1 .. 1296 loop
         if czy_mozliwy(i) then
            index_strzalu := i;
            exit;
         end if;
      end loop;

      if index_strzalu = -1 then
         Put_Line("Oszukujesz!");
         exit;
      end if;

      Put(runda, 1);
      Put(":");
      Put(kody(index_strzalu)(1), 2);
      Put(kody(index_strzalu)(2), 2);
      Put(kody(index_strzalu)(3), 2);
      Put(kody(index_strzalu)(4), 2);
      Put(" ?");
      New_Line;

      Put("Na swoim miejscu: ");
      Get(trafione);

      if trafione = 4 then
         Put_Line("Wygrałem.");
         czy_koniec := True;
         exit;
      end if;

      Put("Nie na swoim miejscu: ");
      Get(nietrafione);

      filtruj(kody, czy_mozliwy, kody(index_strzalu), trafione, nietrafione);

      runda := runda + 1;
   end loop;

end Mastermind;