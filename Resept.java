public abstract class Resept{
    //deklarerer instansevariabler
    public static int idTeller = 0;
    private int id;
    private Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    private int pasientId;
    private int reit; //reiterasjoner
    

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        idTeller++;
        id = idTeller;
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
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
        return pasientId;
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