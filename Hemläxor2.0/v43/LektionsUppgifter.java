import java.util.Scanner;

public class LektionsUppgifter {

	public static void main(String[] args) {
		
		
		kelvin(32);
	}

	/**
	 * Skriver ut texten HAHAHAHAHAHAHA.
	 */
	public static void lol() {
		System.out.println("HAHAHAHAHAHAHA.");
	}

	/**
	 * Denna metod skriver ut det minsta värdet.
	 * 
	 * @param a = a är indata för en int a
	 * @param b = b är indata för en int b
	 */
	public static void min(int a, int b) {
		if (a < b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}
	
	/**
	 * Denna metod skriver ut talen från 1 till n. 
	 * 
	 * @param n = där n är en int som matas in av användaren.
	 */
	public static void count(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}
	
	public static double kelvin(double celsius) {
		double kelvin = celsius + 273.15;
		return kelvin;
	}
}
