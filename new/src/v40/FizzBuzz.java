import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			
			int x = 0;
			int y = 0;
			int n = 0;
			int i = 0;
			x = input.nextInt();
			y = input.nextInt();
			n = input.nextInt();
			
			for(i = 1; i <= n; i++) {
				if(i % x == 0 && i % y == 0){
					System.out.println("FizzBuzz");
				}
				else if(i % x == 0) {
					System.out.println("Fizz");
				}
				else if(i % y == 0) {
					System.out.println("Buzz");
				}
				else {
					System.out.println(i);
				}
				
	}
	}

}
