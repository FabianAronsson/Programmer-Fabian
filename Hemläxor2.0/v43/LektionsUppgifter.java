import java.util.Scanner;

public class LektionsUppgifter {

	public static void main(String[] args) {
		lol();

		Scanner in = new Scanner(System.in);
		min(in.nextInt(), in.nextInt());

	}

	/**
	 * Skriver ut texten HAHAHAHAHAHAHA.
	 */
	public static void lol() {
		System.out.println("HAHAHAHAHAHAHA");
	}
	
	/**
	 * Denna metod skriver ut 
	 * 
	 * @param a
	 * @param b
	 */
	public static void min(int a, int b) {
			if(a < b) {
				System.out.println(a);
			}
			else {
				System.out.println(b);
			}
		}
}
