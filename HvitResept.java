public class HvitResept extends Resept{

//torsdag 12.03 - Anastasia endret kons. til å ta inn Pasient i stedet for pasientId. Endret på denne delen av toString.

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
    }


    public double prisAaBetale(){
        return this.hentLegemiddel().hentPris();
        //fullpris
    }

    @Override
    public String farge(){
        return "hvit";
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Hvit resept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: "
            + this.hentLege().hentNavn() + "\nTil pasienten med ID: " +
            this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
    }
}
