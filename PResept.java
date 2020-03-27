public class PResept extends HvitResept{

  //torsdag 12.03 - Anastasia endret kons. til å ta inn Pasient i stedet for pasientId. Endret på denne delen av toString.

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient){
        super(legemiddel, utskrivendeLege, pasient, 3);
    }

    @Override
    public String hentType(){
      return "p";
    }

    @Override
    public String farge() {
        return super.farge();
    }

    @Override
    public double prisAaBetale(){

        if (this.hentLegemiddel().hentPris() <= 108){
            return 0;
        }
        return this.hentLegemiddel().hentPris() - 108;
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Hvit P-resept resept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: "
            + this.hentLege().hentNavn() + "\nTil pasienten med ID: " +
            this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
    }

}
