class Pasient {
  //Pasient tar inn variablene navn og fodselsnummer som Strings i konstruktøren
  //hvert Pas-objekt har i tillegg en unik ID int id; denne genereres fra statisk variabel idCounter
  //Pasient har en Stabel med Resept-objekter listeResepter

  private String navn;
  private String fodselsnummer;
  //teller for unikt ID-nummer:
  private static int idCounter = 0;
  int id;
  private Stabel<Resept> listeResepter = new Stabel<Resept>();

  //konstruktør
  Pasient(String navn, String fodselsnummer) {
    this.navn = navn;
    this.fodselsnummer = fodselsnummer;
    id = idCounter;
    idCounter++;
  }

//legg til ny resept i Stabel
//kalles på leggPaa() i klasse Stabel
public void leggTilNyResept(Resept r) {
  listeResepter.leggPaa(r);
}

//returnerer listeResepter
public Stabel<Resept> hentResepter() {
  return listeResepter;
}
}
