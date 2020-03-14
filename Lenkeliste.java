
import java.util.Iterator;

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

  public String toString() { //en liten bonus for å demonstrere DA POWAH of the iterator
  	  String resultat = "Lenkeliste[";
	  for (T innhold : this) {
	  	  if (resultat != "Lenkeliste[") {resultat += ", ";}
		  //hvis resultat bare er det den først deklareres som, er dette første element og skal ikke ha komma foran
		  resultat += "" + innhold + "";
	  }
	  resultat += "]";
	  return resultat;
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
  
  public Iterator<T> iterator() {
      return new LenkelisteIterator(this);
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
  
  
  protected class LenkelisteIterator implements Iterator<T>{
      private Lenkeliste<T> minListe; //listen vi itererer over
	  private Node denne; //den noden vi har "kommet til"
      
      public LenkelisteIterator(Lenkeliste<T> l){
          minListe = l;
          denne = minListe.hode; //vi starter på hodet til listen
      }
    
      public T next() {
		  T resultat = denne.innhold; //vi må hente innholdet før vi inkrementerer denne
          denne = denne.neste;
          return resultat;
      }
    
      public boolean hasNext() {
          return (denne != null);
      }
	  //hvis denne ikke lenger peker på en node, har vi nådd slutten av listen
	  //dette er ikke det samme som hvis innholdet av en node er null (det fortsetter vi forbi)
  }


}

import java.util.Iterator;

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
  
  public LenkelisteIterator<T> iterator() {
      return new LenkelisteIterator<T>(this);
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
  
  
  protected class LenkelisteIterator{
      private Lenkeliste<T> minListe;
      private int pos;
      
      public LenkelisteIterator(Lenkeliste<T> l){
          minListe = l;
          pos = 0; 
      }
    
      public T next() {
          Node hentes = hode;
          //begynner på begynnelsen
          for (int i = 1; i<pos; i++){
              hentes = hentes.neste;
          }
          //finner Noden hvis innhold skal hentes
          pos++;
          return hentes.hentInnhold();
      }
    
      public boolean hasNext() {
          return (pos < minListe.stoerrelse);
      }
    
    
  }


}

