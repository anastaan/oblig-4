public class HvitResept extends Resept{

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    
    public double prisAaBetale(){
        return this.hentLegemiddel().hentPris();
        //fullpris
    }

    @Override
    public String farge(){
        return "hvit";
    }

    @Override
    public String toString(){//overriding the toString() method  
        return "Hvit resept på: \n" + this.hentLegemiddel() + "\nUtskrevet av: " 
            + this.hentLege().hentNavn() + "\nTil pasienten med ID: " + 
            this.hentPasientId() + "\nAntall gjenværende iterasjoner: " + this.hentReit() + "\nPris å betale: " + this.prisAaBetale() + " nok";
    } 
}