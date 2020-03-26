import java.util.Scanner;

public class Kommandolokke {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean lokkeFerdig = false;

		while (!lokkeFerdig) {
			System.out.println("\nVelg en handling:");
			System.out.println("(1) Skriv ut oversikt over pasienter, leger, legemidler og resepter");
			System.out.println("(2) Opprett og legge til nye elementer");
			System.out.println("(3) Bruke en resept");
			System.out.println("(4) Skriv ut statistikk");
			System.out.println("(5) Skrive alle data til fil");
			System.out.println("(blank) Avslutt");
			System.out.print("> ");

			String input = scanner.nextLine();
			switch (input) {
				case "":	lokkeFerdig = true;
							break;
				case "1":	System.out.println("\nSett inn oversikt-metode her");
							break;
				case "2":	System.out.println("\nSett inn legg-til-metode her");
							break;
				case "3":	System.out.println("\nSett inn resept-metode her");
							break;
				case "4":	System.out.println("\nSett inn statistikk-metode her");
							break;
				case "5":	System.out.println("\nSett inn fil-metode her");
							break;
				default:	System.out.println("\nUgyldig input.");
							break;
			}

			// alternativ versjon av siste avsnitt i tilfelle switch-statement er uforstaaelig:
			// String input = scanner.nextLine();
			// if (input.equals("")) {
			// 	lokkeFerdig = true;
			// } else if (input.equals("1")) {
			// 	System.out.println("\nSett inn oversikt-metode her");
			// } else if (input.equals("2")) {
			// 	System.out.println("\nSett inn legg-til-metode her");
			// } else if (input.equals("3")) {
			// 	System.out.println("\nSett inn resept-metode her");
			// } else if (input.equals("4")) {
			// 	System.out.println("\nSett inn statistikk-metode her");
			// } else if (input.equals("5")) {
			// 	System.out.println("\nSett inn fil-metode her");
			// } else {
			// 	System.out.println("\nUgyldig input.");
			// }
		}
	}
}