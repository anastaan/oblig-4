class Lege implements Comparable<Lege>{

  protected String navn;
  protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

  public Lege(String navn){
    this.navn = navn;
  }

  // Returnerer hele lista med alle reseptene.
  public Lenkeliste<Resept> hentResepter(){
    return utskrevedeResepter;
  }

  // Lager en ny HvitResept, legger det til utskrevedeResepter, og returnerer det. Bare Spesialister kan skrive ut Narkotiske legemidler.
  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    // Dersom legen ikke er Spesialist og legemiddelet er Narkotisk, skal det kastes et unntak (UlovligUtskrift).
    if (legemiddel instanceof Narkotisk && this instanceof Spesialist == false)  throw new UlovligUtskrift(this, legemiddel);

    HvitResept nyResept = new HvitResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    return nyResept;
  }

  // Lager en ny MillitaerResept, legger det til utskrevedeResepter, og returnerer det. Bare Spesialister kan skrive ut Narkotiske legemidler.
  public MillitaerResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    // Dersom legen ikke er Spesialist og legemiddelet er Narkotisk, skal det kastes et unntak (UlovligUtskrift).
    if (legemiddel instanceof Narkotisk && this instanceof Spesialist == false) throw new UlovligUtskrift(this, legemiddel);

    MillitaerResept nyResept = new MillitaerResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    return nyResept;
  }

  // Lager en ny PResept, legger det til utskrevedeResepter, og returnerer det. Bare Spesialister kan skrive ut Narkotiske legemidler.
  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
    // Dersom legen ikke er Spesialist og legemiddelet er Narkotisk, skal det kastes et unntak (UlovligUtskrift).
    if (legemiddel instanceof Narkotisk && this instanceof Spesialist == false) throw new UlovligUtskrift(this, legemiddel);

    PResept nyResept = new PResept(legemiddel, this, pasient);
    utskrevedeResepter.leggTil(nyResept);
    return nyResept;
  }

  // Lager en ny BlaaResept, legger det til utskrevedeResepter, og returnerer det. Bare Spesialister kan skrive ut Narkotiske legemidler.
  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    // Dersom legen ikke er Spesialist og legemiddelet er Narkotisk, skal det kastes et unntak (UlovligUtskrift).
    if (legemiddel instanceof Narkotisk && this instanceof Spesialist == false) throw new UlovligUtskrift(this, legemiddel);

    BlaaResept nyResept = new BlaaResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    return nyResept;
  }

  // Sammenligner denne legen sitt navn med en annent sitt navn, alfabetisk.
  @Override
  public int compareTo(Lege annenLege){
    return this.hentNavn().compareTo(annenLege.hentNavn());
  }

  // Returnerer navnet til legen
  public String hentNavn(){
    return navn;
  }

  // Returnerer navnet til legen, og en Dr. foran ;)
  @Override
  public String toString(){
    return "Dr. " + navn;
  }
}
