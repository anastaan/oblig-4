import  java.util.Iterator;

public class Lenkeliste<T> implements Liste<T> {
  protected Node foerst;
  protected int stoerrelse = 0;

  class Node {
    private Node neste;
    private T innhold;

    public Node (T x) {
      innhold = x;
    }

    public void settNeste(Node n) {
      neste = n;
    }

    public Node hentNeste() {
      return neste;
    }

    public void settInnhold(T x) {
      innhold = x;
    }

    public T hentInnhold() {
      return innhold;
    }
  }

  @Override
  public String toString() {
    if (stoerrelse == 0) {return "tom";}

    String resultat = "Lenkeliste[";
    for (T innhold : this) {
      if (!resultat.equals("Lenkeliste[")) {resultat += ", ";}
      resultat += innhold.toString();
    }
    resultat += "]";
    return resultat;
  }

  public int stoerrelse() {
    return stoerrelse;
  }

  public void leggTil(int pos, T x) {
    Node ny = new Node(x);
    if (pos == 0) {
      ny.settNeste(foerst);
      foerst = ny;
    } else {
      Node denne = nodePaaPosisjon(pos - 1);
      ny.settNeste(denne.hentNeste());
      denne.settNeste(ny);
    }

    stoerrelse ++;
  }

  public void leggTil(T x) {
    Node ny = new Node(x);
    if (stoerrelse == 0) {
      foerst = ny;
    } else {
      Node sist = foerst;
      while (sist.hentNeste() != null) {sist = sist.hentNeste();}
      sist.settNeste(ny);
    }

    stoerrelse ++;
  }

  public void sett(int pos, T x) {
    Node node = nodePaaPosisjon(pos);
    node.settInnhold(x);
  }

  public T hent(int pos) {
    Node node = nodePaaPosisjon(pos);
    return node.hentInnhold();
  }

  public T fjern(int pos) {
    if (pos >= stoerrelse) {
      throw new UgyldigListeIndeks(pos);
    } else {
      if (pos == 0) {
        T resultat = foerst.hentInnhold();
        foerst = foerst.hentNeste();
        stoerrelse --;
        return resultat;
      } else {
        Node nodeFoer = nodePaaPosisjon(pos - 1);
        T resultat = nodeFoer.hentNeste().hentInnhold();
        nodeFoer.settNeste(nodeFoer.hentNeste().hentNeste());
        stoerrelse --;
        return resultat;
      }
    }
  }

  public T fjern() {
    if (stoerrelse == 0) {
      throw new UgyldigListeIndeks(0);
    } else {
      Node resultat = foerst;
      foerst = foerst.hentNeste();
      stoerrelse --;
      return resultat.hentInnhold();
    }
  }

  class LenkelisteIterator implements Iterator<T> {
    private Lenkeliste liste;
    private int indeks;

    public LenkelisteIterator(Lenkeliste l) {
      liste = l;
      indeks = 0;
    }

    public T next() {
      T innhold = nodePaaPosisjon(indeks).hentInnhold();
      indeks ++;
      return innhold;
    }

    public boolean hasNext() {
      return (indeks < stoerrelse);
    }
  }

  public LenkelisteIterator iterator() {
    return new LenkelisteIterator(this);
  }

  // Mine egne briljante oppfinnelser
  protected Node nodePaaPosisjon(int pos) {
    if (pos < 0 || pos >= stoerrelse) {
      throw new UgyldigListeIndeks(pos);
    } else {
      Node resultat = foerst;
      for (int i = 0; i < pos; i ++) {
        resultat = resultat.hentNeste();
      }
      return resultat;
    }
  }
}

class UgyldigListeIndeks extends RuntimeException {
  UgyldigListeIndeks(int indeks) {
    super("Ugyldig indeks:" + indeks);
  }
}
