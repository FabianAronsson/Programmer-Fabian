import java.util.Scanner;

public class R2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int r1 = 0;
		int r2 = 0;
		int s = 0;

		r1 = input.nextInt();
		s = input.nextInt();

		if (r1 > -1000 && r1 < 1000 && s > -1000 && s < 1000) {
			r2 = s * 2 - r1;
			System.out.println(r2);
		}

	}

}