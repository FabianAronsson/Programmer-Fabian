import java.util.Scanner;

public class fem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = 0;
		int sum = 0;

		for (int i = 0; i < 10000; i++) {
			if (a % 7 == 0) {
				sum = a + sum;
			}
			a++;
		}
		System.out.println(sum);
	}

}
