import java.util.Scanner; /* All text är exempeltext för att fylla rutor och för mig att labba*/

public class TBA {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int a = 0;

		System.out.println("Welcome to a text based adventure!");
		System.out.println("Select your name:");
		String name = input.nextLine();
		/* System.out.println(name); */
		System.out.printf("Choose your personality:\n" + "The Wise one: " + "This is the one that is very wise\n");
		System.out.printf("The Creative one: " + "This is the one that is very creative\n");
		System.out.println("The Handsome one: " + "This is the one that is very handsome\n");
		for (int i = 0; i < 10; i++) {
			String pes = input.nextLine(); /* pes står för personality */
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
			System.out.println("You wake up in your bed thinking what you will wear today.");
			System.out.println("Will you rise?");
			System.out.println("Yes or no?");
			String rise = input.nextLine();
			if(rise.equals("no")) {
				System.out.println("You stay in bed.");
			}
			else if(rise.equals("yes")) {
				System.out.println("You rise from bed.");
			}
		}
	}
}
