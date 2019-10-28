import java.util.Scanner;

public class tre {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int a = 1;
		double high = 0;
		double x = 0;
		int s = 0;

		while (a == 1) {
			s = input.nextInt();
			if (s == 0) {
				a = 0;
				break;
			} else {
				high = s + high;
				x++;
			}

		}
		double mean = high / x;
		System.out.println(mean);
		System.out.println(high);
	}

}
