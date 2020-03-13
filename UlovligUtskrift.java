public class UlovligUtskrift extends Exception{
  UlovligUtskrift(Lege lege, Legemiddel lm){
    super("Legen " + lege.hentNavn() + " har ikke lov til å skrive ut " + lm.hentNavn());
  }

}
