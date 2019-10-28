import java.util.Scanner;

public class sex {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double h;
		double r;

		h = input.nextDouble();
		r = input.nextDouble();

		double v = Math.PI * Math.pow(r, 2) * h;

		System.out.println(v);

	}

}
