import java.util.Scanner;

public class ett {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int s1 = input.nextInt();
		int s2 = input.nextInt();

		if (s1 < s2) {
			System.out.println(s1);
		} else {
			System.out.println(s2);
		}
	}

}
