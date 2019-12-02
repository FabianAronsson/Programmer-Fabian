import java.util.Scanner;

public class StuckInATimeLoop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = 1;
		int s = input.nextInt();
		for (int i = 0; i < s; i++) {
			System.out.println(a++ + " Abracadabra");
		}

	}

}
