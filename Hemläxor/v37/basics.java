import java.util.Scanner;

public class basics {
			public static void main(String[] args) {
				
				Scanner input = new Scanner(System.in);
				
				System.out.println("Vad heter du?");
				
				String namn = input.nextLine();
				
				System.out.println("Hur gammal �r du?");
				
				String alder = input.nextLine();
				
				System.out.println("Vad �r din adress?");
				
				String adress = input.nextLine();
						
				System.out.println("Vad �r ditt postnummer?");
				
				String pnum = input.nextLine();
						
				System.out.println("I vilken stad bor du i?");
				
				String stad = input.nextLine();
				
				System.out.println("Vad �r ditt telefonnummer?");
				
				String tnum = input.nextLine();
			}
}
