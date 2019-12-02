import java.util.Scanner;

public class fyra {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int s2 = 0;
		int i = 1;
		int sum = 0;

		int s1 = input.nextInt();
		while (i < 10 && sum < 100000) {
			s2 = input.nextInt();
			sum = s1 * s2;
			i++;
		}
		System.out.printf(sum + "    " + i);
	}

}
