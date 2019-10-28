import java.util.Scanner;

public class sju {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv in hur stor kvadrat du vill ha");

		int width = input.nextInt();
		String spaces = "";
		
		if(width != 2) {
			int numberOfSpaces = width - 2;
			spaces = String.format("%1$" + numberOfSpaces + "s", "");
		}
		

		for (int i = 0; i < width; i++) {
			System.out.print("$");
		}
		System.out.println();
		
		width -= 1;
		for (int i = 1; i < width; i++) {
			System.out.println("$" + spaces + "$");
		}
		width += 1;

		if (width != 1) {
			for (int i = 0; i < width; i++) {
				System.out.print("$");
			}
		}
	}

}
