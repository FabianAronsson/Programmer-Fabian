import java.util.Scanner;

public class Metoder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		volume(input.nextDouble());
		
		reverse(input.nextLine());
		
		count(input.nextLine(), input.next().charAt(0));
	}
	
	/**
	 * Metoden r�knar ut vad volymen p� ett klot �r.
	 * 
	 * @param radius Tar in ett v�rde fr�n anv�ndaren.
	 * @return Returnerar volymen.
	 */
	public static double volume(double radius) {
		double volume = (4 * Math.PI * Math.pow(radius, 3)) / 3;
		return volume;
	}
	
	/**
	 *  Skriver om en string bakl�nges genom att anv�nda sig av charAt s� man v�ljer sista tecknet i en string och sedan l�gger till det i en ny String s� man f�r Stringen omv�nt.
	 *  
	 * @param str Tar in en String.
	 * @return Returnerar Stringen bakl�nges.
	 */
	public static String reverse(String str) {
		String reverseString = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseString = reverseString + str.charAt(i);
		}
		return reverseString;
	}
	
	/**
	 * Denna metod tar in en String och en char och r�knar sedan varje char som f�rekommer i Stringen. 
	 * 
	 * @param str Indata f�r String.
	 * @param c   Indata f�r char.
	 * @return    Retunerar antal g�nger char c f�rekommer i String str.
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
