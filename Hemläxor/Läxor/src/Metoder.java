import java.util.Scanner;

public class Metoder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		volume(input.nextDouble());

		// Denna metoden k�rs inte av n�gon anledning, men om du s�tter kommentarer p�
		// de andra metoderna s� fungerar den.
		reverse(input.nextLine());

		count(input.nextLine(), input.next().charAt(0));

		sjorovare(input.nextLine());
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
	 * Skriver om en string bakl�nges genom att anv�nda sig av charAt s� man v�ljer
	 * sista tecknet i en string och sedan l�gger till det i en ny String s� man f�r
	 * Stringen omv�nt.
	 * 
	 * @param str Tar in en String.
	 * @return Returnerar Stringen bakl�nges.
	 */
	public static String reverse(String str) {
		String reverseString = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverseString = reverseString + str.charAt(i);
		}
		return reverseString;
	}

	/**
	 * Denna metod tar in en String och en char och r�knar sedan varje char som
	 * f�rekommer i Stringen.
	 * 
	 * @param str Indata f�r String.
	 * @param c   Indata f�r char.
	 * @return Retunerar antal g�nger char c f�rekommer i String str.
	 */
	public static int count(String str, char c) {
		int numberOfcharacters = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				numberOfcharacters++;
			}
		}
		return numberOfcharacters;
	}

	/**
	 * Denna metod tar in en String och sedan omvandlar den till sj�r�varspr�ket.
	 * Den fungerar p� s� s�tt att den kollar om tecknet p� index i passar in p�
	 * n�gon av if satserna och utf�r sedan addering av result + tecknet vid index i
	 * samt ett o enligt regeln f�r spr�ket och d�refter ett till tecken vid
	 * indexet. Det finns speciall fall f�r x och c d�r man f�r g�ra om dem till
	 * andra tecken.
	 *
	 * @param str Tar in en String som ska konverteras.
	 * @return Retunerar stringen i sj�r�varspr�ket.
	 */
	public static String sjorovare(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				result = result + ' ';
			} else if (str.charAt(i) == 'x') {
				result = result + "koksos";
			} else if (str.charAt(i) == 'c') {
				result = result + "kok";
			} else if (str.charAt(i) == 'a' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == '�'
					|| str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'y' || str.charAt(i) == '�'
					|| str.charAt(i) == '�' || str.charAt(i) == 'A' || str.charAt(i) == 'O' || str.charAt(i) == 'U'
					|| str.charAt(i) == '�' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'Y'
					|| str.charAt(i) == '�' || str.charAt(i) == '�') {
				result = result + str.charAt(i);
			} else {
				result = result + str.charAt(i) + "o" + str.charAt(i);
			}
		}
		return result;
	}
}
