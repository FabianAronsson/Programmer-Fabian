import java.util.Scanner;

public class NewLabb3 {
        static Scanner input = new Scanner(System.in);

        public static void main(String[] args) {
            int operationSelection;
            double firstNumber;
            double secondNumber;
            boolean condition = true;
            System.out.println("Welcome to Java simple calc!");

            while (condition){
                System.out.println("Choose an operation to perform below:");
                System.out.println("1. Addition.");
                System.out.println("2. Subtraction.");
                System.out.println("3. Multiplication.");
                System.out.println("4. Division.");
                System.out.println("0. Exit.");

                operationSelection = input.nextInt();
                System.out.println();

                switch (operationSelection){
                    case 0:
                        System.out.println("Good Bye!");
                        condition = false;
                        break;
                    case 1:
                        input.nextLine();
                        System.out.flush();
                        System.out.println("Type the first number now:");
                        firstNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("Type the second number now:");
                        secondNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("The sum of the two numbers is:");
                        System.out.println(firstNumber + secondNumber);
                        break;
                    case 2:
                        input.nextLine();
                        System.out.flush();
                        System.out.println("Type the first number now:");
                        firstNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("Type the second number now:");
                        secondNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("The remainder of the two numbers is:");
                        System.out.println(firstNumber - secondNumber);
                        break;
                    case 3:
                        input.nextLine();
                        System.out.flush();
                        System.out.println("Type the first number now:");
                        firstNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("Type the second number now:");
                        secondNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("The product of the two numbers is:");
                        System.out.println(firstNumber * secondNumber);
                        break;
                    case 4:
                        input.nextLine();
                        System.out.flush();
                        System.out.println("Type the first number now:");
                        firstNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("Type the second number now:");
                        secondNumber = input.nextDouble();
                        System.out.println();
                        System.out.println("The quota of the two numbers is:");
                        System.out.println(firstNumber / secondNumber);
                        break;
                    default:
                        System.out.println("Invalid number!");
                        System.out.println();
                }
            }
        }
    }

