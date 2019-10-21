import java.util.Scanner;

public class Metoder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		volume(input.nextDouble());
		
		reverse(input.nextLine());
		
	}
	
	/**
	 * Metoden r�knar ut vad volymen p� ett klot �r.
	 * 
	 * @param radius Tar in ett v�rde fr�n anv�ndaren.
	 * @return Returnerar volymen.
	 */
	public static double volume(double radius) {
		double volume = (4 * Math.PI * Math.pow(radius, 3)) / 3;
		System.out.println(volume);
		return volume;
	}
	
	/**
	 *  Skriver om en string bakl�nges genom att anv�nda sig av charAt s� man v�ljer sista tecknet i en string och sedan l�gger till det i en ny String s� man f�r Stringen omv�nt.
	 *  
	 * @param str Tar in en String str.
	 * @return Returnerar Stringen bakl�nges.
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
