public class Lenkeliste<T> implements Liste<T>{

  protected int stoerrelse = 0;

  Node hode;
  Node hale;
  /*siden vi skal legge til i den ene enden og
  fjerne fra den andre er det greit å ha en peker
  på det siste objektet, synes jeg.
  Så slipper man å traversere hele lista
  for å finne det siste . Jeg legger ting til i hale-
  enden og henter ut i hode-enden
  */
  public int stoerrelse(){
      return stoerrelse;
  }

  public void leggTil(T ny){

      Node nyNode = new Node(ny);

      if(stoerrelse == 0){
          hode = nyNode;
          //hvis lista er tom settes den nye forrerst
      } else{
          hale.neste = nyNode;
          //den som lå bakerst sin neste peker på nyNode
      }
      hale = nyNode;
      //hale peker nyNode
      stoerrelse++;

  }

  public void leggTil(int pos, T ny){
      if(pos > stoerrelse || pos < 0){
          throw new UgyldigListeIndeks(-1);
      }

      if (pos == stoerrelse){
          this.leggTil(ny);
          //hvis man vil legge den bakerst kjøres vanlig leggTil(ny)
          return;
          //leggTil(ny) øker størrelsen, så må returnere her for ikke å øke for mye
      } else if(pos == 0){
          Node nyNode = new Node(ny);
          nyNode.neste = hode;
          // den nye sin neste peker på det samme  som hode
          hode = nyNode;
          //hode peker nå på nyNode
      } else {

          Node temp = hode;
          //begynner på begynnelsen

          for (int i = 1; i<pos; i++){
              temp = temp.neste;
          } //finner Noden hvis neste skal bli nyNode

          Node nyNode = new Node(ny);

          nyNode.neste = temp.neste;
          //temp.neste er den nyNode skal legges etter
          temp.neste = nyNode;
          //så settes temp.neste til å peke på nyNode
      }
      stoerrelse ++;
  }

  public void sett(int pos, T ny) throws UgyldigListeIndeks{
      if(pos >= stoerrelse || pos < 0){
          throw new UgyldigListeIndeks(-1);
      }

      if (pos == 0){
          hode.innhold = ny;
      } else if (pos == (stoerrelse-1)){
          hale.innhold = ny;
      } else {

          Node temp = hode;
          //begynner på begynnelsen

          for (int i = 0; i<pos; i++){
              temp = temp.neste;
          } //finner Noden hvis innhold skal bli satt
          temp.innhold = ny;
      }

  }

  public T hent(int pos) throws UgyldigListeIndeks{
      if(pos >= stoerrelse || pos < 0){
          throw new UgyldigListeIndeks(-1);
      }

      if (stoerrelse == 1 || pos == 0){
          return hode.hentInnhold();
      } else if (pos == (stoerrelse-1)){
          return hale.hentInnhold();
      }
      //hvis man ber om første eller siste element

      Node temp = hode;

      for (int i = 0; i<pos; i++){
          //finner Noden vi skal hente fra
          temp = temp.neste;
      }
      return temp.hentInnhold();
      //returnerer innholdet i den noda
  }

  //fjerner fra hodeenden
  public T fjern(int pos) throws UgyldigListeIndeks{
      if(pos >= stoerrelse || pos < 0){
          throw new UgyldigListeIndeks(-1);
      }//kaster unntak om pos er en ugyldig indeks

      if (pos == 0){
          return this.fjern();
      }

      Node temp = hode;
      //begynner på begynnelsen
      for (int i = 1; i<pos; i++){
          temp = temp.neste;
      }
      //finner Noden hvis neste skal fjernes

      Node fjernes = temp.neste;
      temp.neste = fjernes.neste;
      //Noden før fjernes peker på Noden etter fjernes
      //ingenting peker på fjernes lenger


      stoerrelse--;
      return fjernes.hentInnhold();
  }

  public T fjern() throws UgyldigListeIndeks{
      if(stoerrelse == 0){
          throw new UgyldigListeIndeks(-1);
      }//kaster unntak om lista er tom

      Node temp = hode;
      hode = hode.neste;
      //hvis man vil fjerne eneste element blir hode.neste null

      if (stoerrelse == 1){
          hale = null;
          //hvis man vil fjerne eneste element blir hale også null
      }
      stoerrelse--;
      return temp.hentInnhold();

  }


  protected class Node{
      Node neste; // er null
      T innhold; //settes i konstruktøren

      public Node(T innhold){
          this.innhold = innhold;
      }

      public T hentInnhold(){
          return innhold;
      }

      @Override
      public String toString(){
          return "" + innhold + "";
      }


      public int compareTo(T anna){
          if(this.compareTo(anna) > 0) return 1;
          if(this.compareTo(anna) < 0) return -1;
          return 0;
      }


  }


}
