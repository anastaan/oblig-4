public class BlaaResept extends Resept{

  /*
    * fiksa rabatten
    *innså at jeg kunne generalisere toString om jeg lagde en fargevariabel, men orka ikke gjøre det

  */
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);

    }

    public String farge(){
        return "blå";
    }

    public double prisAaBetale(){
        return this.hentLegemiddel().hentPris()* 0.25;
    }

    public String toString(){
        return "Blå resept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: "
            + this.hentLege().hentNavn() + "\nTil pasienten med ID: " +
            this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
    }

}
