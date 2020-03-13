public abstract class Resept{
/*
torsdag 12.03 - Anastasia endret kons. til å ta inn Pasient i stedet for pasientId.
                Endret derfor på metoden hentPasientId og denne delen av toString.
*/

    //deklarerer instansevariabler
    public static int idTeller = 0;
    private int id;
    private Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    private Pasient pasient; //endret pasientId til Pasient pasient
    private int reit; //reiterasjoner


    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        idTeller++;
        id = idTeller;
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;

    }

    public int hentId(){
        return id;
    }

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public int hentPasientId(){
        return pasient.hentId();
    }

    public int hentReit(){
        return reit;
    }

    public boolean bruk(){
        if (reit > 0){
            reit --;
            return true;
        } else {
            return false;
        }
    } //det sto ikke noe om at reit skulle minke men jeg antok

    public abstract String farge();

    public abstract double prisAaBetale();

    public abstract String toString();

}
