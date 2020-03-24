public class Spesialist extends Lege implements Godkjenningsfritak{

    private int kontrollId;

    public Spesialist(String fulltNavn, int id){
        super(fulltNavn);
        kontrollId = id;
    }

    public int hentKontrollId(){
        return kontrollId;
    }

    @Override
    public String toString(){
        return "Spesialist " + this.hentNavn() + " | Kontroll ID: " + this.hentKontrollId();
    }

}
