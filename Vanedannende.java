public class Vanedannende extends Legemiddel implements VaneFace{

    //lagde et interface siden Vanedannende hadde så mye til felles med Narkotisk
    private int styrke;

    public Vanedannende (String navn, double pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentStyrke() {
        return styrke;
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Vanedannende legemiddel:\n    navn: " + this.hentNavn() +
        "\n    fullpris: " + this.hentPris() + " nok\n    virkestoff: " +
        this.hentVirkestoff() + " mg\n    styrke: " + this.hentStyrke();
    }

}
