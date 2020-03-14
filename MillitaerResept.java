public class MillitaerResept extends HvitResept{

//torsdag 12.03 - Anastasia endret kons. til å ta inn Pasient i stedet for pasientId. Endret på denne delen av toString.

    public MillitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public double prisAaBetale(){
        return 0;
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Hvit militærresept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: "
            + this.hentLege().hentNavn() + "\nTil pasienten med ID: " +
            this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
    }

}
