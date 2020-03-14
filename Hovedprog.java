import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hovedprog{
  public static void main(String[] args) throws FileNotFoundException{
    Liste<Pasient> pasienter = new Lenkeliste<Pasient>();
    Liste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    Liste<Lege> leger = new SortertLenkeliste<Lege>();
    Liste<Resept> resepter = new Lenkeliste<Resept>();

    Scanner filLeser = new Scanner(new File("myeInndata.txt"));

    // Gaar gjennom foerste "del" av fila, som bestaar av pasienter. Lager objekter og legger de til i pasienter.
    filLeser.nextLine();
    while (filLeser.hasNextLine() && filLeser.hasNext("#") == false){
      String denneLinja = filLeser.nextLine();
      String[] info = denneLinja.split(",");
      try{
        pasienter.leggTil(new Pasient(info[0], info[1]));
      }catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Fikk ikke lagt til pasient: " + denneLinja);
      }
    }

    // Gaar gjennom neste del. Lager legemiddel objekter og legger de til i legemidler.
    filLeser.nextLine();
    while (filLeser.hasNextLine() && filLeser.hasNext("#") == false){
      String denneLinja = filLeser.nextLine();
      String[] info = denneLinja.split(",");
      try {
        if (info[1].equals("narkotisk") && info.length == 5) legemidler.leggTil(new Narkotisk(info[0], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4])));
        if (info[1].equals("vanedannende") && info.length == 5) legemidler.leggTil(new Vanedannende(info[0], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4])));
        if (info[1].equals("vanlig") && info.length == 4) legemidler.leggTil(new Vanlig(info[0], Double.parseDouble(info[2]), Double.parseDouble(info[3])));
      } catch (NumberFormatException e){
        System.out.println("Fikk ikke lagt til legemiddelet: " + denneLinja + "\n" + e + "\n");
      }
    }

    // Garr gjennom Lege-delen. Lgaer objekter og legger de til i leger.
    filLeser.nextLine();
    while (filLeser.hasNextLine() && filLeser.hasNext("#") == false){
      String denneLinja = filLeser.nextLine();
      String[] info = denneLinja.split(",");
      Boolean gyldigNavn = true;

      try{
        for (Lege lege:leger){
          if (lege.hentNavn().equals(info[0])) gyldigNavn = false;
        }

        if (gyldigNavn){
          if (info[1].equals("0")) leger.leggTil(new Lege(info[0]));
          else leger.leggTil(new Spesialist(info[0], Integer.parseInt(info[1])));
        }

      } catch (ArrayIndexOutOfBoundsException e){
          System.out.println("Fikk ikke lagt til legen: " + denneLinja + "\n" + e + "\n");
      } catch (NumberFormatException e){
          System.out.println("Fikk ikke lagt til legen: " + denneLinja + "\n" + e + "\n");
      }
    }

    // Gaar gjennom Resept-delen, lager objekter og legger de til i resepter.
    filLeser.nextLine();
    while (filLeser.hasNextLine() && filLeser.hasNext("#") == false){
      String denneLinja = filLeser.nextLine();
      String[] info = denneLinja.split(",");

      Lege denneLegen = null;
      for (Lege lege:leger){
        if (lege.hentNavn().equals(info[1]))
          denneLegen = lege;
      }

      Legemiddel denneMiddel = null;
      for (Legemiddel lm:legemidler){
        if (lm.hentId() == Integer.parseInt(info[0]))
          denneMiddel = lm;
      }

      Pasient dennePasient = null;
      for (Pasient pas:pasienter){
        if (pas.hentId() == Integer.parseInt(info[2]))
          dennePasient = pas;
      }

      try{
        if (info[3].equals("hvit")) resepter.leggTil(denneLegen.skrivHvitResept(denneMiddel, dennePasient, Integer.parseInt(info[4])));
        if (info[3].equals("blaa")) resepter.leggTil(denneLegen.skrivBlaaResept(denneMiddel, dennePasient, Integer.parseInt(info[4])));
        if (info[3].equals("millitaer")) resepter.leggTil(denneLegen.skrivMillitaerResept(denneMiddel, dennePasient, Integer.parseInt(info[4])));
        if (info[3].equals("p")) resepter.leggTil(denneLegen.skrivPResept(denneMiddel, dennePasient));
      } catch (NullPointerException e){
        System.out.println("Fikk ikke lagt til resepten: " + denneLinja + "\n" + e + "\n");
      } catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Fikk ikke lagt til resepten: " + denneLinja + "\n" + e + "\n");
      } catch (NumberFormatException e){
        System.out.println("Fikk ikke lagt til resepten: " + denneLinja + "\n" + e + "\n");
      } catch (UlovligUtskrift e){
        System.out.println(e);
      }
    }

    System.out.println();
    for (Pasient p:pasienter){
      System.out.println(p.hentNavn());
      System.out.println();
    }

    System.out.println();
    for (Legemiddel lm:legemidler){
      System.out.println(lm);
      System.out.println();
    }

    System.out.println();
    for (Lege lege:leger){
      System.out.println(lege);
      System.out.println();
    }

    System.out.println();
    for (Resept r:resepter){
      System.out.println(r);
      System.out.println();
    }

    System.out.println("legemidler:" + legemidler.stoerrelse());
    System.out.println("pasienter:" + pasienter.stoerrelse());
    System.out.println("leger:" + leger.stoerrelse());
    System.out.println("resepter:" + resepter.stoerrelse());

  }
}
