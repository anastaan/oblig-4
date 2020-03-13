public class TestLegemiddel{

/*
  Endringer fra første forsøk:
    *la til tester for Vanedannende
*/


    public static void main(String[] args) {


        System.out.println("Oppretter Vanlig.");
        Vanlig v = new Vanlig("Van", 1, 2);
        System.out.println("Tester print(Vanlig):");
        System.out.println(v);
        System.out.println("----------------------------------------------");

        System.out.println("vanlig.hentNavn)() funker: "+ (v.hentNavn() == "Van"));
        System.out.println("vanlig.hentPris() funker: " + (v.hentPris() == 1));
        v.settNyPris(300);
        System.out.println("vanlig.settNyPris(300) funker: " + (v.hentPris() == 300));
        System.out.println("vanlig.hentVirkestoff() funker: " + (v.hentVirkestoff() == 2));
        System.out.println("----------------------------------------------");

        /*      
        Narkotisk n = new Narkotisk("Narko", 3, 4, 5);
        System.out.println("Tester print(Narkotisk):");
        System.out.println(n);
        System.out.println();

        System.out.println("narkotisk.hentNavn)() funker: "+ (n.hentNavn() == "Narko"));
        System.out.println("narkotisk.hentPris() funker: " + (n.hentPris() == 3));
        n.settNyPris(300);
        System.out.println("narkotisk.settNyPris(300) funker: " + (n.hentPris() == 300));
        System.out.println("narkotisk.hentVirkestoff() funker: " + (n.hentVirkestoff() == 4));
        System.out.println("narkotisk.hentStyrke() funker: " + (n.hentStyrke() == 5));
        System.out.println();
        System.out.println("Tester print(Narkotisk):");
        System.out.println(n);
        System.out.println("----------------------------------------------");
        */


        /*
        Vanedannende vd = new Vanedannende("Vane", 200, 20, 3);
        System.out.println("vanedannende.hentNavn)() funker: "+ (vd.hentNavn() == "Vane"));
        System.out.println("vanedannende.hentPris() funker: " + (vd.hentPris() == 200));
        vd.settNyPris(300);
        System.out.println("vanedannende.settNyPris(300) funker: " + (vd.hentPris() == 300));
        System.out.println("vanedannende.hentVirkestoff() funker: " + (vd.hentVirkestoff() == 20));
        System.out.println("vanedannende.hentStyrke() funker: " + (vd.hentStyrke() == 3));
        System.out.println("");
        System.out.println("Tester print(Vanedannende):");
        System.out.println(vd);
        System.out.println("----------------------------------------------");
        */

        //System.out.println();


    }
}
