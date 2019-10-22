import java.util.Scanner;

public class Metoder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		volume(input.nextDouble());
		
		reverse(input.nextLine());
		
		count(input.nextLine(), input.next().charAt(0));
	}
	
	/**
	 * Metoden räknar ut vad volymen på ett klot är.
	 * 
	 * @param radius Tar in ett värde från användaren.
	 * @return Returnerar volymen.
	 */
	public static double volume(double radius) {
		double volume = (4 * Math.PI * Math.pow(radius, 3)) / 3;
		return volume;
	}
	
	/**
	 *  Skriver om en string baklänges genom att använda sig av charAt så man väljer sista tecknet i en string och sedan lägger till det i en ny String så man får Stringen omvänt.
	 *  
	 * @param str Tar in en String.
	 * @return Returnerar Stringen baklänges.
	 */
	public static String reverse(String str) {
		String reverseString = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseString = reverseString + str.charAt(i);
		}
		return reverseString;
	}
	
	/**
	 * Denna metod tar in en String och en char och räknar sedan varje char som förekommer i Stringen. 
	 * 
	 * @param str Indata för String.
	 * @param c   Indata för char.
	 * @return    Retunerar antal gånger char c förekommer i String str.
	 */
	public static int count(String str, char c) {
		int numberOfcharacters = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				numberOfcharacters++;
			}	
		}
		return numberOfcharacters;
	}
}
