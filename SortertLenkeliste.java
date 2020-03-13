public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

    @Override
    public void leggTil(T ny){

        if (stoerrelse == 0 || (new Node(ny).compareTo(hale) > 0)) {
            super.leggTil(ny);
            /*hvis lista er tom eller den nye verdien 
                er større enn den største som allerede 
                er i lista (halen), legg den bakerst
            */
        } else if (new Node(ny).compareTo(hode) < 0){
            super.leggTil(0, ny);
            /*hvis den nye er mindre enn den minste,
                (hodet) legg den forrerst
            */
        } else {
            //i alle andre tilfeller
            Node temp = hode;
            Node nyNode = new Node(ny);

            for (int i = 0; i < stoerrelse; i++){
                /*går gjennom nesten hele lista om nødvendig
                    (ikke hode & hale)
                i = indeksen til temp
                */
                if(nyNode.compareTo(temp.neste) <= 0){
                    super.leggTil(i+1, ny);
                    /*nyNode > temp && <= temp.neste
                        legger nyNode mellom temp og temp.neste
                    */
                    return;
                } else{
                    temp = temp.neste;
                    //hvis nyNode > temp går temp videre
                }
                
            }
        }
        
    }

    @Override
    public T fjern(){

        if (stoerrelse() == 1){
            return super.fjern();
        } else{
            return super.fjern(stoerrelse-1);
        }
    }
    /* 
        Fjerner og returnerer fra haleenden, siden
        den vil være størst. Samme som taAv i Stabel,
        bare med if sjekk på om størrelse == 1 så fjernes
        "vanlig" (Lenkeliste.fjern())
        Skjønner ikke hvordan det er nødvendig, siden
        fjern(pos) i Lenkeliste gjør akkurat det, men 
        hvis jeg ikke hadde det med fikk jeg sånne for alltid:
        (...)
        at SortertLenkeliste.fjern(SortertLenkeliste.java:1)
        at Lenkeliste.fjern(Lenkeliste.java:121)
        at SortertLenkeliste.fjern(SortertLenkeliste.java:47)
        at SortertLenkeliste.fjern(SortertLenkeliste.java:1)
        at Lenkeliste.fjern(Lenkeliste.java:121)
        (...)

        Overskriver disse så de kaster unntak fordi de ellers
        ville kødda til den pent sorterte lista og det er ikke greit
    */
    @Override
    public void sett(int pos, T ny) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T ny) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
}
