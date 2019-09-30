import java.util.Scanner;

public class v37 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Vad heter du?");

		String namn = input.nextLine();

		System.out.println("Hur gammal är du?");

		String alder = input.nextLine();

		System.out.println("Vad är din adress?");

		String adress = input.nextLine();

		System.out.println("Vad är ditt postnummer?");

		String pnum = input.nextLine();

		System.out.println("I vilken stad bor du i?");

		String stad = input.nextLine();

		System.out.println("Vad är ditt telefonnummer?");

		String tnum = input.nextLine();

		System.out.println();

		System.out.println("Vad heter du ? " + namn);

		System.out.println("Hur gammal är du ? " + alder);

		System.out.println("Vad är din adress ? " + adress);

		System.out.println("Vad är ditt postnummer ? " + pnum);

		System.out.println("I vilken stad bor du i ? " + stad);

		System.out.println("Vad är ditt telefonnummer ? " + tnum);

		System.out.println();

		System.out.println("Information:");

		System.out.printf("Namn:\t %s%n", namn);

		System.out.printf("Ålder:\t %s%n", alder);

		System.out.printf("Adress:\t %s%n", adress + "\n\t" + " " + pnum + " " + stad);

		System.out.printf("Telefon: %s", tnum);
	}
}
