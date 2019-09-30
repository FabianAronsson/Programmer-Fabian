import java.util.Scanner;
import java.util.ArrayList;

public class Modulo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> siffror = new ArrayList<Integer>(); // Skapade en lista med heltal.
		for (int i = 0; i < 10; i++) {
			int in = input.nextInt() % 42;
			if (!siffror.contains(in))
				siffror.add(in); // L�gger till ett nytt v�rde till listan som �r unikt. 
		}
		System.out.println(siffror.size()); //Eftersom det endast kommer finnas unika tal i listan s� r�cker det med att printa size f�r att f� r�tt output.
	}

}
	