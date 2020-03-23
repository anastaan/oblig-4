public class Spesialist extends Lege implements Godkjenningsfritak{
  /*
    Endringer fra første forsøk:
      * Fjerna public static int idTeller siden id skulle være parameter
*/

    //public static int idTeller = 0;
    private int kontrollId;


    public Spesialist(String fulltNavn, int id){
        super(fulltNavn);
        //idTeller ++;
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
