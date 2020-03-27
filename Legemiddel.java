

public abstract class Legemiddel{

    public static int idTeller = 0;
    private int id;
    private String navn;
    private double pris;
    private double virkestoff;


    public Legemiddel(String n, double p, double v){
        id = idTeller;
        idTeller++;

        navn = n;
        pris = p;
        virkestoff = v;
    }

    protected String hentNavn(){
        return navn;
    }

    protected double hentPris(){
        return pris;
    }

    protected double hentVirkestoff(){
        return virkestoff;
    }

    protected double hentId(){
        return id;
    }

    protected  abstract String hentType();

    
    protected void settNyPris(int nyPris){
        pris = nyPris;
    }

    public abstract String toString();

}
