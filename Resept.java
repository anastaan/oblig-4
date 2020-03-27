public abstract class Resept{

    public static int idTeller = 0;
    private int id;
    private Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    private Pasient pasient;
    private int reit;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) throws NullPointerException{
      if (legemiddel == null || utskrivendeLege == null || pasient == null) throw new NullPointerException();

      id = idTeller;
      idTeller++;

      this.legemiddel = legemiddel;
      this.utskrivendeLege = utskrivendeLege;
      this.pasient = pasient;
      this.reit = reit;
    }

    public int hentId(){
      return id;
    }

    public Legemiddel hentLegemiddel(){
      return legemiddel;
    }

    public Lege hentLege(){
      return utskrivendeLege;
    }

    public int hentPasientId(){
      return pasient.hentId();
    }

    public int hentReit(){
      return reit;
    }

    public boolean bruk(){
      if (reit > 0){
          reit --;
          return true;
      }
      return false;
    }

    public abstract String farge();

    public abstract double prisAaBetale();

    public abstract String toString();

    public abstract String hentType();
}
