import java.util.Scanner;

/* All text är exempeltext för att fylla rutor och för mig att labba*/

public class TBA {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int a = 0;
		int adv = 0;

		System.out.println("Welcome to a text based adventure!");
		System.out.println("Select your name:");
		String name = input.nextLine(); 	/* System.out.println(name); */
		
		System.out.printf("Choose your personality:\n" + "The Wise one: " + "This is the one that is very wise\n");
		System.out.printf("The Creative one: " + "This is the one that is very creative\n");
		System.out.println("The Handsome one: " + "This is the one that is very handsome\n");
		for (int i = 0; i < 10; i++) {
			String pes = input.nextLine(); 	/* pes står för personality */
			if (pes.equals("Wise") || pes.equals("wise")) {
				System.out.printf("Welcome Wise one!\n");
				System.out.printf("You recieved knowledge 1000! A pair of asian parents \nand a massive brain!");
				a = 1;
				break;
			} else if (pes.equals("Creative") || pes.equals("creative")) {
				System.out.println("Welcome Creative one!");
				a = 2;
				break;
			} else if (pes.equals("Handsome") || pes.equals("handsome")) {
				System.out.println("Welcome Handsome one!");
				a = 3;
				break;
			} else {
				System.out.println("Psst.. type in the keyword only");
			}
		}
		if (a == 1) {
			System.out.printf("\n\nYou wake up in your bed thinking what you will wear today.");
			System.out.println();
			System.out.println();
			System.out.printf("Will you rise?\n");
			System.out.printf("Yes or no?\n");
			String rise = input.nextLine();
			if (rise.equals("no")) {
				System.out.println("You stay in bed.");
			} else if (rise.equals("yes")) {
				System.out.println("You rise from bed.");
			}
			else if (rise.equals("Yes")) {
				System.out.println("You rise from bed.");
			
		}
	}
		System.out.println("You walk up to your closet and open the door. You find school uniform upon school uniform. What wil you wear? ");
		System.out.println("School uniform");
		System.out.println("School uniform");
		System.out.println("School uniform");
		String uni = input.nextLine();
		if(uni.equals("School uniform")) {
			System.out.println("You wore the school uniform.");
		}
		System.out.println("You see a faint glow in the dark closet... Do you want to investigate?");
		String us = input.nextLine();
		if(us.equals("yes")) {
			System.out.println("You look further into your closet and to your exstatic suprise there is a buttfucking midget in there with his homosexual friend Hans who is from Germany and loves Greta.");
			 adv = 1;
		}
		else {
			System.out.println("You did not investigate");
			 adv = 0;
		}
		
		if(adv == 0) {
			System.out.println("You walk out of your room downstairs to the kitchen.");
		}
}		
}
