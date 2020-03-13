

public abstract class Legemiddel{
    //deklarerer instansevariabler
    public static int idTeller = 0;
    private int id;
    private String navn;
    private double pris;
    private double virkestoff;

    /**/
    public Legemiddel(String n, double p, double v){
        id = idTeller;
        //den første er 0
        idTeller++;
        //øker telleren
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

    protected void settNyPris(int nyPris){
        //System.out.println("Gammel pris: " + pris);
        pris = nyPris;
        //System.out.println("Ny pris: " + pris);
    }

    public abstract String toString();

}
