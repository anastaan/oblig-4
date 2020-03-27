public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

    @Override
    public void leggTil(T ny){

        if (stoerrelse == 0 || ny.compareTo(hale.innhold) > 0) {
            super.leggTil(ny);

        } else if (ny.compareTo(hode.innhold) < 0){
            super.leggTil(0, ny);

        } else {
            Node temp = hode;
            Node nyNode = new Node(ny);

            for (int i = 0; i < stoerrelse; i++){
                if(nyNode.innhold.compareTo(temp.neste.innhold) <= 0){
                    super.leggTil(i+1, ny);
                    return;
                } else{
                    temp = temp.neste;
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

    @Override
    public void sett(int pos, T ny) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T ny) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }


}
