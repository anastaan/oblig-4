public class Narkotisk extends Legemiddel implements VaneFace{

    private int styrke;

    public Narkotisk (String navn, double pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public String hentType() {
      return "narkotisk";
    }

    public int hentStyrke() {
        return styrke;
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Narkotisk legemiddel:\n    navn: " + this.hentNavn() +
        "\n    fullpris: " + this.hentPris() + " nok\n    virkestoff: " +
        this.hentVirkestoff() + " mg\n    styrke: " + this.hentStyrke();
    }
}
