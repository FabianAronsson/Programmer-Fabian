import java.util.Scanner;

public class Metoder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		volume(input.nextDouble());
		
		reverse(input.nextLine());
		
	}
	
	/**
	 * Metoden räknar ut vad volymen på ett klot är.
	 * 
	 * @param radius Tar in ett värde från användaren.
	 * @return Returnerar volymen.
	 */
	public static double volume(double radius) {
		double volume = (4 * Math.PI * Math.pow(radius, 3)) / 3;
		System.out.println(volume);
		return volume;
	}
	
	/**
	 *  Skriver om en string baklänges genom att använda sig av charAt så man väljer sista tecknet i en string och sedan lägger till det i en ny String så man får Stringen omvänt.
	 *  
	 * @param str Tar in en String str.
	 * @return Returnerar Stringen baklänges.
	 */
	public static String reverse(String str) {
		String reverse = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		System.out.println(reverse);
		return str;
	}
}
