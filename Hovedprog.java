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
      System.out.println("\n1. ...lege\n2. ...pasient\n3. ...legemiddel\n4. ...resept");
      brukerInput = inputScanner.nextLine();
      if (brukerInput.equals("1"))
        leggTilLege();
      else if (brukerInput.equals("2"))
        leggTilPasient();
      else if (brukerInput.equals("3"))
        leggTilLegemiddel();
      else if (brukerInput.equals("4")){
        if (pasienter.stoerrelse() < 1 || legemidler.stoerrelse() < 1 || leger.stoerrelse() < 1)
          System.out.println("Mangler elemtener for aa lage resept.");
        else
          leggTilResept();
      }
      else System.out.println("\nUgyldig input!");
    }

    else if (brukerInput.equals("2")){
      for (Lege lege:leger){
        System.out.println(lege);
      }

      for(Legemiddel lm:legemidler){
        System.out.println(lm);
      }

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

  public static void leggTilResept(){
    String type = "0";
    while (type.equals("0")){
      System.out.println("\nVelg hvilken type resept:\n1. Blaa\n2. Hvit\n3. Millitaer\n4. P");
      type = inputScanner.nextLine();
      if (!type.equals("1") && !type.equals("2") && !type.equals("3") && !type.equals("4")){
        type = "0";
        System.out.println("Ugydig input!");
      }
    }

    Legemiddel lm = null;
    while (lm == null){
      int i = 0;
      for (Legemiddel legeMid:legemidler)
        System.out.println(i++ +". " + legeMid);
      System.out.println("\nVelg et legemiddel");
      try{
        i = Integer.parseInt(inputScanner.nextLine());
        lm = legemidler.hent(i);
      } catch (UgyldigListeIndeks e){
        System.out.println("Ugyldig nummer!");
      } catch (NumberFormatException e){
        System.out.println("Ugyldig nummer!");
      }
    }

    Lege lege = null;
    while (lege == null){
      int i = 0;
      for (Lege le:leger)
        System.out.println(i++ +". " + le);
      System.out.println("\nVelg en lege");
      try{
        i = Integer.parseInt(inputScanner.nextLine());
        lege = leger.hent(i);
      } catch (UgyldigListeIndeks e){
        System.out.println("Ugyldig nummer!");
      } catch (NumberFormatException e){
        System.out.println("Ugyldig nummer!");
      }
    }

    Pasient pasient = null;
    while (pasient == null){
      int i = 0;
      for (Pasient pas:pasienter)
        System.out.println(i++ +". " + pas);
      System.out.println("\nVelg en pasient");
      try{
        i = Integer.parseInt(inputScanner.nextLine());
        pasient = pasienter.hent(i);
      } catch (UgyldigListeIndeks e){
        System.out.println("Ugyldig nummer!");
      } catch (NumberFormatException e){
        System.out.println("Ugyldig nummer!");
      }
    }

    if (type.equals("4")){
      try{
        resepter.leggTil(lege.skrivPResept(lm, pasient));
        System.out.println("La til resepten for " + lm.hentNavn() + " til " + pasient.hentNavn());
      } catch (UlovligUtskrift e){
        System.out.println(e);
      }
    }

    else{
      int reit = 0;
      while (reit == 0){
        System.out.println("\nVelg antall reit");
        try{
          reit = Integer.parseInt(inputScanner.nextLine());
        } catch (NumberFormatException e){
          System.out.println("Ugyldig nummer!");
        }
      }

      if (type.equals("1")){
        try{
          resepter.leggTil(lege.skrivBlaaResept(lm, pasient, reit));
          System.out.println("La til resepten for " + lm.hentNavn() + " til " + pasient.hentNavn());
        } catch (UlovligUtskrift e){
          System.out.println(e);
        }
      }

      else if (type.equals("2")){
        try{
          resepter.leggTil(lege.skrivHvitResept(lm, pasient, reit));
          System.out.println("La til resepten for " + lm.hentNavn() + " til " + pasient.hentNavn());
        } catch (UlovligUtskrift e){
          System.out.println(e);
        }
      }

      else if (type.equals("3")){
        try{
          resepter.leggTil(lege.skrivMillitaerResept(lm, pasient, reit));
          System.out.println("La til resepten for " + lm.hentNavn() + " til " + pasient.hentNavn());
        } catch (UlovligUtskrift e){
          System.out.println(e);
        }
      }

    }
  }

  public static void leggTilLegemiddel(){
    String type = "0";
    while (type.equals("0")){
      System.out.println("\nVelg hvilken type legemiddel:\n1. Vanlig\n2. Narkotisk\n3. Vanedannende");
      type = inputScanner.nextLine();
      if (!type.equals("1") && !type.equals("2") && !type.equals("3")){
        type = "0";
        System.out.println("Ugydig input!");
      }
    }

    System.out.println("Skriv inn navnet paa legemiddelet:");
    String navn = inputScanner.nextLine();

    double pris = 0;
    Boolean okNr = false;
    while (!okNr){
      System.out.println("Skriv inn prisen paa legemiddelet:");
      brukerInput = inputScanner.nextLine();
      try{
        pris = Double.parseDouble(brukerInput);
        okNr = true;
      } catch (NumberFormatException e){
        System.out.println("\nUgyldig pris!\n");
      }
    }

    double virkestoff = 0;
    okNr = false;
    while (!okNr){
      System.out.println("Skriv inn virkestoffet paa legemiddelet:");
      brukerInput = inputScanner.nextLine();
      try{
        virkestoff = Double.parseDouble(brukerInput);
        okNr = true;
      } catch (NumberFormatException e){
        System.out.println("\nUgyldig virkestoff!\n");
      }
    }

    if (!type.equals("1")){
      int styrke = 0;
      okNr = false;
      while (!okNr){
        System.out.println("Skriv inn styrekn paa legemiddelet:");
        brukerInput = inputScanner.nextLine();
        try{
          virkestoff = Integer.parseInt(brukerInput);
          okNr = true;
        } catch (NumberFormatException e){
          System.out.println("\nUgyldig styrke!\n");
        }
      }
      if (type.equals("2"))
        legemidler.leggTil(new Narkotisk(navn, pris, virkestoff, styrke));
      if (type.equals("3"))
        legemidler.leggTil(new Vanedannende(navn, pris, virkestoff, styrke));
    }

    else
      legemidler.leggTil(new Vanlig(navn, pris, virkestoff));

    System.out.println("La til legemiddelet " + navn);
  }

  public static void leggTilPasient(){
    System.out.println("Skriv inn navn:");
    String navn = inputScanner.nextLine();

    int foedselsnummer = 0;
    Boolean okNr = false;
    while (!okNr){
      System.out.println("Skriv inn foedselsnummer:");
      brukerInput = inputScanner.nextLine();
      try{
        Integer.parseInt(brukerInput);
        okNr = true;
      } catch (NumberFormatException e){
        System.out.println("\nUgyldig foedselsnummer!\n");
      }
    }

    pasienter.leggTil(new Pasient(navn, brukerInput));
    System.out.println("La til " + navn + " | " + brukerInput);
  }

  public static void leggTilLege(){
    System.out.println("\n1. Lag ny lege\n2. Lag ny spesialist\n3. Tilbake til hovedmeny");
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
    }

    else if(brukerInput.equals("3"));

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
