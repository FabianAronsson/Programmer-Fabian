import java.util.Arrays;
import java.util.Scanner;

public class v38 {
	public static void main(String[] args) {
		System.out.println("Skriv in 10 hela tal");
		
		Scanner input = new Scanner(System.in);
		int s1 = input.nextInt();
		int s2 = input.nextInt();
		int s3 = input.nextInt();
		int s4 = input.nextInt();
		int s5 = input.nextInt();
		int s6 = input.nextInt();
		int s7 = input.nextInt();
		int s8 = input.nextInt();
		int s9 = input.nextInt();
		int s10 = input.nextInt();
		
		int[] siffror = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
		Arrays.sort(siffror);

		System.out.println("Högst: " + siffror[siffror.length - 1]);
		System.out.println("Lägst: " + siffror[0]);
		System.out.println("Medelvärde: " + (s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10) / 10.);
	}
}
