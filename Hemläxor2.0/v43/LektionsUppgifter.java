import java.util.Scanner;

public class LektionsUppgifter {

	public static void main(String[] args) {
		//();

		Scanner input = new Scanner(System.in);
		//min(input.nextInt(), input.nextInt());

		//count(input.nextInt());

		//kelvin(input.nextDouble());

		//ageControl(input.nextInt());
		
		stair(input.nextInt());
	}

	/**
	 * Skriver ut texten HAHAHAHAHAHAHA.
	 */
	public static void lol() {
		System.out.println("HAHAHAHAHAHAHA.");
	}

	/**
	 * Denna metod skriver ut det minsta v�rdet.
	 * 
	 * @param a = a �r indata f�r en int a
	 * @param b = b �r indata f�r en int b
	 */
	public static void min(int a, int b) {
		if (a < b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}

	/**
	 * Denna metod skriver ut talen fr�n 1 till n.
	 * 
	 * @param n = d�r n �r en int som matas in av anv�ndaren.
	 */
	public static void count(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}

	/**
	 * Konverterar celsius till kelvin.
	 * 
	 * @param celsius Tar in ett v�rde f�r celsius.
	 * @return Returnerar konverteringen kelvin.
	 */
	public static double kelvin(double celsius) {
		double kelvin = celsius + 273.15;
		return kelvin;
	}

	/**
	 * Denna metod kollar vilken �lder du �r och printar en text beroende p� vilken
	 * �lder du skrev in.
	 * 
	 * @param age Tar in en int som �r �lder.
	 */
	public static void ageControl(int age) {
		if (age <= 5) {
			System.out.println("Sm�barn f�r inte g�ra n�got.");
		} else if (age <= 12) {
			System.out.println("Du f�r spela Fortnite.");
		} else if (age <= 17) {
			System.out.println("Du f�r k�ra moppe.");
		} else if (age <= 20) {
			System.out.println("Du f�r k�ra bil.");
		} else if (age <= 64) {
			System.out.println("Du f�r vuxenstraff om du g�r n�got dumt.");
		} else if (age <= 99) {
			System.out.println("Du �r pension�r.");
		} else if (age >= 100) {
			System.out.println("R.I.P?");
		}
	}

	public static int stair(int steps) {
		String space = "";
		String letter = "x";
		String stair = "";
		for (int i = 1; i < steps; i++) {
			
			space += " ";
		}
		for (int j = 0; j < steps; j++) {
			stair = space + letter;
			letter = letter + "x";
			if(!space.equals("")) {
				space = space.substring(1);
			}

			System.out.println(stair);
		}
		int result = 1;
		return result;
	}
}
