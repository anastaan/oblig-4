import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hovedprog{
  static Liste<Pasient> pasienter = new Lenkeliste<Pasient>();
  static Liste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
  static Liste<Lege> leger = new SortertLenkeliste<Lege>();
  static Liste<Resept> resepter = new Lenkeliste<Resept>();
  static Scanner inputScanner;
  static String brukerInput;

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println("\nVelkommen til karantene!");
    kommandoLoekke();
  }

  public static void kommandoLoekke() throws FileNotFoundException{
    System.out.println("\n\n1. Legg til...\n2. Skriv ut informasjon\n3. Les fra fil\n4. Avslutt");
    inputScanner = new Scanner(System.in);
    brukerInput = inputScanner.nextLine();

    if (brukerInput.equals("1")){
      System.out.println("\n1. ...lege\n2. ...pasient\n3. ...resept\n4. ...legemiddel");
      brukerInput = inputScanner.nextLine();
      if (brukerInput.equals("1")){
        leggTilLege();
      }
      else System.out.println("\nUgyldig input!");
    }

    else if (brukerInput.equals("2")){

    }

    else if (brukerInput.equals("3")){
      System.out.println("\nHvilken fil vil du lese fra?\n");
      brukerInput = inputScanner.nextLine();
      try{
        lesFraFil(brukerInput);
        System.out.println("La til informasjonen inn i systemet :)");
      } catch (FileNotFoundException e){
        System.out.println("Fant ikke filnavnet. Husk aa skrive .txt");
      }
    }

    else if (brukerInput.equals ("4")){
      System.exit(0);
    }

    kommandoLoekke();
  }

  public static void leggTilLege() throws FileNotFoundException{
    System.out.println("\n1. Lag ny lege\n2. Lag ny spesialist\n3. Tilbake");
    brukerInput = inputScanner.nextLine();

    if (brukerInput.equals("1")){
      System.out.println("Skriv inn navn:");
      brukerInput = inputScanner.nextLine();
      Boolean gyldigNavn = true;
      for (Lege lege:leger){
        if (lege.hentNavn().equals(brukerInput)) gyldigNavn = false;
      }

      if (gyldigNavn){
        leger.leggTil(new Lege(brukerInput));
        System.out.println("La til " + brukerInput);
      }

      else System.out.println("Fikk ikke lagt til " + brukerInput + ", noen heter det allerede!");
      kommandoLoekke();
    }

    else if (brukerInput.equals("2")){
      System.out.println("Skriv inn navn:");
      String navn = inputScanner.nextLine();
      int id = 0;

      Boolean okNr = false;
      while (!okNr){
        System.out.println("Skriv inn kontroll id:");
        brukerInput = inputScanner.nextLine();
        try{
          id = Integer.parseInt(brukerInput);
          okNr = true;
        } catch (NumberFormatException e){
          System.out.println("\nUgyldig kontroll id!\n");
        }
      }

      Boolean gyldigNavn = true;
      for (Lege lege:leger){
        if (lege.hentNavn().equals(navn)) gyldigNavn = false;
      }

      if (gyldigNavn){
        leger.leggTil(new Spesialist(navn, id));
        System.out.println("La til " + navn);
      }

      else System.out.println("Fikk ikke lagt til " + brukerInput + ", noen heter det allerede!");
      kommandoLoekke();
    }

    else if(brukerInput.equals("3")) kommandoLoekke();

    else{
      System.out.println("\nUgyldig input!");
      leggTilLege();
    }

  }

  public static void lesFraFil(String filnavn) throws FileNotFoundException{

    Scanner filLeser = new Scanner(new File(filnavn));

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
  }
}
