

public class Vanlig extends Legemiddel{

    public Vanlig(String navn, double pris, double virkestoff){
        super(navn, pris, virkestoff);
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Vanlig legemiddel:\n    navn: " + this.hentNavn() +
        "\n    fullpris: " + this.hentPris() + " nok\n    virkestoff: " +
        this.hentVirkestoff() + " mg";
    }
}
