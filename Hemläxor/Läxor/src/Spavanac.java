import java.util.Scanner;

public class Spavanac {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int h = 0;
		int m = 0;
		int u = 0;
		h = input.nextInt();
		m = input.nextInt();

		m = m - 45;
		if (h == 0) {
			h = 24;
		}
		if (m < 0) {
			h = h * 60;
			h = h + m;
			h = h / 60;
		}

		if (m < 0) {
			u = 60;
			m = u + m;
		}
		System.out.println(h + " " + m);
	}

}
