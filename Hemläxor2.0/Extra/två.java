import java.util.Scanner;

public class två {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int sum = 0;
		int s1 = 10223;
		int s = 0;
		for (int i = 0; i < s1; i++) {
			s = s1 % 10;
			s1 = s1 / 10;
			sum += s;
		}
		System.out.println(sum + 1);

	}

}
