import java.util.Scanner;
import java.util.ArrayList;

public class Modulo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> siffror = new ArrayList<Integer>(); // Skapade en lista med heltal.
		for (int i = 0; i < 10; i++) {
			int in = input.nextInt() % 42;
			if (!siffror.contains(in))
				siffror.add(in); // Lägger till ett nytt värde till listan som är unikt. 
		}
		System.out.println(siffror.size()); //Eftersom det endast kommer finnas unika tal i listan så räcker det med att printa size för att få rätt output.
	}

}
	