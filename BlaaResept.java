public class BlaaResept extends Resept{

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  public String hentType() {
    return "blaa";
  }

  @Override
  public String farge(){
    return "blaa";
  }

  @Override
  public double prisAaBetale(){
    return this.hentLegemiddel().hentPris()* 0.25;
  }

  @Override
  public String toString(){
    return "Blå resept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: "
      + this.hentLege().hentNavn() + "\nTil pasienten med ID: " +
      this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
  }

}
