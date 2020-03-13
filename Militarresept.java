public class Militarresept extends HvitResept{

    public Militarresept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public double prisAaBetale(){
        return 0;
    }

    @Override
    public String toString(){//overriding the toString() method  
        return "Hvit militærresept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: " 
            + this.hentLege().hentNavn() + "\nTil pasienten med ID: " + 
            this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
    } 
    
}