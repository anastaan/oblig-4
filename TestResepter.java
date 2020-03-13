public class TestResepter{

/*
  Endringer fra første forsøk:
    * tester legemiddel.settNyPris()
    * blaa er nå utskrevet av en Spesialist
*/

    public static void main(String[] args) {
        Lege lege = new Lege("Dr. Test Testesen");
        Spesialist spes = new Spesialist("Dr. Spes I. El", 42);

        //navn, pris, virkestoff, (styrke)
        Narkotisk n = new Narkotisk("Narko", 300, 4, 5);
        Vanedannende vd = new Vanedannende("Vane", 200, 20, 3);
        Vanlig v = new Vanlig("Vanlig", 100, 2);

        //System.out.println();

        //Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit

        HvitResept hvit = new HvitResept(n, lege, 1, 2);
        //System.out.println(hvit);

        /*
        System.out.println("hvit.hentId funker: " + (hvit.hentId() == 1));
        //System.out.println(hvit.hentLegemiddel());
        System.out.println("hvit.hentLege().hentNavn() funker: "+ (hvit.hentLege().hentNavn() == "Dr. Test Testesen"));
        System.out.println("hvit.hentPasientId() funker: " + (hvit.hentPasientId() == 1));
        System.out.println();
        System.out.println("Antall reiterasjoner: " + hvit.hentReit());
        System.out.println("hvit.bruk() funker: " + hvit.bruk());
        System.out.println("Antall reiterasjoner: " + hvit.hentReit());
        System.out.println("hvit.bruk() funker: " + hvit.bruk());
        System.out.println("Antall reiterasjoner: " + hvit.hentReit());
        System.out.println("hvit.bruk() funker: " + hvit.bruk());
        System.out.println();
        System.out.println("hvit.farge() == hvit: " + (hvit.farge() == "hvit"));
       */
        System.out.println("Hvit, fullpris: " + hvit.hentLegemiddel().hentPris());
        n.settNyPris(1000);
        System.out.println("Hvit, NY fullpris: " + hvit.hentLegemiddel().hentPris());
        System.out.println("Pris å betale: " + hvit.prisAaBetale());
        System.out.println("---------------------------------------------------");
       /* */


        PResept pRes = new PResept(vd, lege, 1);
        //System.out.println(pRes);

        /*
        System.out.println("pResept.hentId funker: "+ (pRes.hentId() == 2));
        System.out.println("pRes.hentLege().hentNavn() funker: "+ (pRes.hentLege().hentNavn() == "Dr. Test Testesen"));
        System.out.println("pRes.hentPasientId() funker: " + (pRes.hentPasientId() == 1));
        System.out.println();
        System.out.println("Antall reiterasjoner: " + pRes.hentReit());
        System.out.println("pRes.bruk() funker: " + pRes.bruk());
        System.out.println("Antall reiterasjoner: " + pRes.hentReit());
        System.out.println("pRes.bruk() funker: " + pRes.bruk());
        System.out.println("Antall reiterasjoner: " + pRes.hentReit());
        System.out.println("pRes.bruk() funker: " + pRes.bruk());
        System.out.println("Antall reiterasjoner: " + pRes.hentReit());
        System.out.println("pRes.bruk() funker: " + pRes.bruk());
        System.out.println("pRes.farge() == hvit: " + (pRes.farge() == "hvit"));
        */
        System.out.println("PRes, fullpris: " + pRes.hentLegemiddel().hentPris());
        vd.settNyPris(1000);
        System.out.println("PRes, NY fullpris: " + pRes.hentLegemiddel().hentPris());
        System.out.println("Pris å betale: " + pRes.prisAaBetale());
        System.out.println("---------------------------------------------------");
        /**/


        Militarresept mil = new Militarresept(v, lege, 626, 2);
        //System.out.println(mil);

        /*
        System.out.println("militær.hentId funker: " + (mil.hentId() == 3));
        System.out.println("mil.hentLege().hentNavn() funker: "+ (mil.hentLege().hentNavn() == "Dr. Test Testesen"));
        System.out.println("mil.hentPasientId() funker: " + (mil.hentPasientId() == 626));
        System.out.println();
        System.out.println("Antall reiterasjoner: " + mil.hentReit());
        System.out.println("mil.bruk() funker: " + mil.bruk());
        System.out.println("Antall reiterasjoner: " + mil.hentReit());
        System.out.println("mil.bruk() funker: " + mil.bruk());
        System.out.println("Antall reiterasjoner: " + mil.hentReit());
        System.out.println("mil.bruk() funker: " + mil.bruk());
        System.out.println();
        System.out.println("mil.farge() == hvit: " + (mil.farge() == "hvit"));
        */
        System.out.println("Mil, fullpris: " + mil.hentLegemiddel().hentPris());
        v.settNyPris(1000);
        System.out.println("Mil, NY fullpris: " + mil.hentLegemiddel().hentPris());
        System.out.println("Pris å betale: " + mil.prisAaBetale());
        System.out.println("---------------------------------------------------");


        HvitResept hvitmil = mil;
        //System.out.println(hvitmil);
        /*
        System.out.println("hvitmil.hentId funker: " + (hvitmil.hentId() == 3));
        System.out.println("hvitmil.hentLege().hentNavn() funker: "+ (hvitmil.hentLege().hentNavn() == "Dr. Test Testesen"));
       System.out.println("hvitmil.hentPasientId() funker: " + (hvitmil.hentPasientId() == 626));
        System.out.println();
        System.out.println("Antall reiterasjoner: " + hvitmil.hentReit());
        System.out.println("hvitmil.bruk() funker: " + hvitmil.bruk());
        System.out.println("Antall reiterasjoner: " + hvitmil.hentReit());
        System.out.println("mhvitmilil.bruk() funker: " + hvitmil.bruk());
        System.out.println("Antall reiterasjoner: " + hvitmil.hentReit());
        System.out.println("hvitmil.bruk() funker: " + hvitmil.bruk());
        System.out.println();
        System.out.println("hvitmil.farge() == hvit: " + (hvitmil.farge() == "hvit"));
        */
        System.out.println("Hvitmil, fullpris: " + hvitmil.hentLegemiddel().hentPris());
        v.settNyPris(2000);
        System.out.println("Hvitmil, NY fullpris: " + hvitmil.hentLegemiddel().hentPris());
        System.out.println("Pris å betale: " + hvitmil.prisAaBetale());
        System.out.println("---------------------------------------------------");


        BlaaResept blaa = new BlaaResept(n, spes, 626, 1);
        //System.out.println();
        /*
        System.out.println("blaa.hentId funker: " + (blaa.hentId() == 4));
        System.out.println("blaa.hentLege().hentNavn() funker: "+ (blaa.hentLege().hentNavn() == "Dr. Test Testesen"));
        System.out.println("blaa.hentPasientId() funker: " + (blaa.hentPasientId() == 626));
        System.out.println();
        System.out.println("Antall reiterasjoner: " + blaa.hentReit());
        System.out.println("blaa.bruk() funker: " + blaa.bruk());
        System.out.println("Antall reiterasjoner: " + blaa.hentReit());
        System.out.println("mblaail.bruk() funker: " + blaa.bruk());
        System.out.println();
        System.out.println("blaa.farge() == blå: " + (blaa.farge() == "blå"));
        */
        System.out.println("Blå, fullpris: " + blaa.hentLegemiddel().hentPris());
        n.settNyPris(2000);
        System.out.println("Blå, NY fullpris: " + blaa.hentLegemiddel().hentPris());
        System.out.println("Pris å betale: " + blaa.prisAaBetale());
        System.out.println("---------------------------------------------------");
        System.out.println("Henter legen som skrev ut blå: \n" + blaa.hentLege());
        System.out.println("---------------------------------------------------");
    }
}
