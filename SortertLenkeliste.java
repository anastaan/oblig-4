public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

@Override
public void leggTil(T ny){
    if (stoerrelse == 0){
        super.leggTil(ny);
    }
}


}
