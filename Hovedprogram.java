public class Hovedprogram{

  /*
  Endringer fra første forsøk:
    * Spesialist har kontrollId som parameter
    * forenkla testene
    * tester legemiddel.settNyPris()
    * tester resept.prisAaBetale

  */

    public static void main(String[] args) {
        Lege lege = new Lege("Dr. Leg A. To");
        Spesialist spes = new Spesialist("Dr. Spes I. El", 42);
        //navn, pris, virkestoff, (styrke)
        Narkotisk n = new Narkotisk("Narko", 300, 4, 5);
        Vanedannende vd = new Vanedannende("Vane", 200, 20, 3);
        Vanlig v = new Vanlig("Vanlig", 200, 3);
        Vanlig v2 = new Vanlig("V2", 100, 2);


        //Legemiddel, Lege, pasientId, reiterasjoner
        HvitResept hvit = new HvitResept(n, lege, 623, 2);
        PResept pRes = new PResept(vd, spes, 624);
        Militarresept mil = new Militarresept(v, lege, 625, 2);
        BlaaResept blaa = new BlaaResept(v2, spes, 626, 1);


//---------------------------------------------------------------------
//prisAaBetale, settNyPris, prisAaBetale
        //TEST 1
        int teller = 1;
        if(hvit.prisAaBetale() == 300){}
        else {System.out.println("Feil i test: " + teller); }

        n.settNyPris(1000);

        //TEST 2
        teller++;
        if(hvit.prisAaBetale() == 1000){}
        else {System.out.println("Feil i test: " + teller); }

        //TEST 3
        teller++;
        if(pRes.prisAaBetale() == (200-108)){}
        else {System.out.println("Feil i test: " + teller); }

        vd.settNyPris(1000);

        //TEST 4
        teller++;
        if(pRes.prisAaBetale() == (1000-108)){}
        else {System.out.println("Feil i test: " + teller); }

       //TEST 5
       teller++;
       if(mil.prisAaBetale() == 0){}
       else {System.out.println("Feil i test: " + teller); }

       vd.settNyPris(1000);

       //TEST 6
       teller++;
       if(mil.prisAaBetale() == 0){}
       else {System.out.println("Feil i test: " + teller); }

        //TEST 7
        teller++;
        if(blaa.prisAaBetale() == 100*0.25){}
        else {System.out.println("Feil i test: " + teller); }

        v2.settNyPris(1000);

        //TEST 8
        teller++;
        if(blaa.prisAaBetale() == 1000*0.25){}
        else {System.out.println("Feil i test: " + teller); }
//---------------------------------------------------------------------
//hentLege (på Spesialist)
        //TEST 9
        teller++;
        if(blaa.hentLege().hentNavn() == "Dr. Spes I. El"){}
        else {System.out.println("Feil i test: " + teller); }
//---------------------------------------------------------------------
//bruk()
        //blaa har 2 reiterasjoner, så første bruk() skal returnere true og den andre false

        //TEST 10
        teller++;
        if(blaa.bruk()){}
        else {System.out.println("Feil i test: " + teller); }

        //TEST 11
        teller++;
        if(!blaa.bruk()){}
        else {System.out.println("Feil i test: " + teller); }
//---------------------------------------------------------------------
//farge()

        //TEST 12
        teller++;
        if(hvit.farge() == "hvit"){}
        else {System.out.println("Feil i test: " + teller); }

        //TEST 13
        teller++;
        if(pRes.farge()  == "hvit"){}
        else {System.out.println("Feil i test: " + teller); }

        //TEST 14
        teller++;
        if(mil.farge() == "hvit"){}
        else {System.out.println("Feil i test: " + teller); }

        //TEST 15
        teller++;
        if(blaa.farge() == "blå"){}
        else {System.out.println("Feil i test: " + teller); }


        /*
        System.out.println(lege);
        System.out.println("---------------------------------------------------");

        System.out.println(spes);
        System.out.println("---------------------------------------------------");
        System.out.println(n);
        System.out.println("---------------------------------------------------");

        System.out.println(vd);
        System.out.println("---------------------------------------------------");

        System.out.println(v);
        System.out.println("---------------------------------------------------");

        System.out.println(hvit);
        System.out.println("---------------------------------------------------");

        System.out.println(pRes);
        System.out.println("---------------------------------------------------");

        System.out.println(mil);
        System.out.println("---------------------------------------------------");

        System.out.println(blaa);
        System.out.println("---------------------------------------------------");
        */
    }
}
