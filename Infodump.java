public class Infodump {
  public static void main(String[] args) {

    // lager lister
    Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();
    SortertLenkeliste<Lege> leger = new SortertLenkeliste<Lege>();

    testEgneTing(legemidler, resepter, leger);



  }

  static void testEgneTing(Lenkeliste<Legemiddel> lm, Lenkeliste<Resept> lr, SortertLenkeliste<Lege> ll) {
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

    //legger inn i lenkelista legemidler
    ll.leggTil(lege);
    ll.leggTil(spes);

    /*
    lm.leggTil(n);
    lm.leggTil(vd);
    lm.leggTil(v);
    lm.leggTil(v2);

    lr.leggTil(hvit);
    lr.leggTil(pRes);
    lr.leggTil(mil);
    lr.leggTil(blaa);
    */


  }

}
