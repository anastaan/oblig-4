public class PResept extends HvitResept{

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    @Override
    public String farge() {
        return super.farge();
    }

    @Override
    public double prisAaBetale(){

        if (this.hentLegemiddel().hentPris() <= 108){
            return 0;
        } else {
            return this.hentLegemiddel().hentPris() - 108;
        }
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Hvit P-resept resept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: "
            + this.hentLege().hentNavn() + "\nTil pasienten med ID: " +
            this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
    }

}
