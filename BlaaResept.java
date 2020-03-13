public class BlaaResept extends Resept{

  /*
    * fiksa rabatten
    *innså at jeg kunne generalisere toString om jeg lagde en fargevariabel, men orka ikke gjøre det

    *torsdag 12.03 - Anastasia endret kons. til å ta inn Pasient i stedet for pasientId. Endret på denne delen av toString.

  */
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);

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
