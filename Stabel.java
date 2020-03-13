public class Stabel<T> extends Lenkeliste<T>{

    public void leggPaa(T ny){
        leggTil(ny);
        //legger til i haleenden
    }

    public T taAv(){
        return fjern(stoerrelse-1);
        //fjerner og returnerer fra haleenden
    }
}
