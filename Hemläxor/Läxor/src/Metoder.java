import java.util.Scanner;

public class Metoder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		volume(input.nextDouble());

		// Denna metoden körs inte av någon anledning, men om du sätter kommentarer på
		// de andra metoderna så fungerar den.
		reverse(input.nextLine());

		count(input.nextLine(), input.next().charAt(0));

		sjorovare(input.nextLine());
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
	 * Skriver om en string baklänges genom att använda sig av charAt så man väljer
	 * sista tecknet i en string och sedan lägger till det i en ny String så man får
	 * Stringen omvänt.
	 * 
	 * @param str Tar in en String.
	 * @return Returnerar Stringen baklänges.
	 */
	public static String reverse(String str) {
		String reverseString = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverseString = reverseString + str.charAt(i);
		}
		return reverseString;
	}

	/**
	 * Denna metod tar in en String och en char och räknar sedan varje char som
	 * förekommer i Stringen.
	 * 
	 * @param str Indata för String.
	 * @param c   Indata för char.
	 * @return Retunerar antal gånger char c förekommer i String str.
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
	 * Denna metod tar in en String och sedan omvandlar den till sjörövarspråket.
	 * Den fungerar på så sätt att den kollar om tecknet på index i passar in på
	 * någon av if satserna och utför sedan addering av result + tecknet vid index i
	 * samt ett o enligt regeln för språket och därefter ett till tecken vid
	 * indexet. Det finns speciall fall för x och c där man får göra om dem till
	 * andra tecken.
	 *
	 * @param str Tar in en String som ska konverteras.
	 * @return Retunerar stringen i sjörövarspråket.
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
			} else if (str.charAt(i) == 'a' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'å'
					|| str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'y' || str.charAt(i) == 'ä'
					|| str.charAt(i) == 'ö' || str.charAt(i) == 'A' || str.charAt(i) == 'O' || str.charAt(i) == 'U'
					|| str.charAt(i) == 'Å' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'Y'
					|| str.charAt(i) == 'Ä' || str.charAt(i) == 'Ö') {
				result = result + str.charAt(i);
			} else {
				result = result + str.charAt(i) + "o" + str.charAt(i);
			}
		}
		return result;
	}
}
