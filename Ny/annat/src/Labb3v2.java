/*
 * Name: Labb3v2
 *
 * @author Fabian and Leo TE18C
 * @version 2.0
 */

import java.util.Scanner;

public class Labb3v2 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    /**
     * This method acts like the general method where it tells the user what options
     * he/she/it has and then proceeds sends a new input to a different method.
     */
    public static void start() {
        System.out.println("Welcome to a simple Java Calculator!");

        while (true) {
            System.out.printf("%nChoose an operation to perform below:%n1. Addition.%n2. Subtraction.%n3. Multiplication.%n4. Division.%n0. Exit.%n%n");
            operation(input.nextInt());
        }
    }

    /**
     * The "operation" method decides which operation should be chosen. It does this by taking in an int and
     * then deciding which case in the switch statement it shall take. Afterwards it calls upon a different method depending
     * on which case was chosen. Then program asks the user to input two values depending on the operation.
     *
     * @param option "Option" is the value used for deciding upon which operation to be executed.
     */
    public static void operation(int option) {
        switch (option) {                                                                                               //started with "if" statements, but later changed to a "switch" statement due to "switch" statements being faster in this case
            case 0:
                System.out.printf("%nGood Bye!%n");
                System.exit(0);
            case 1:
                System.out.printf("%nYou have chosen addition.%nType the first number and the second number now:%n");
                System.out.println(addition(input.nextDouble(), input.nextDouble()));
                break;
            case 2:
                System.out.printf("%nYou have chosen subtraction.%nType the first number and the second number now:%n");
                System.out.println(subtraction(input.nextDouble(), input.nextDouble()));
                break;
            case 3:
                System.out.printf("%nYou have chosen multiplication.%nType the first number and the second number now:%n");
                System.out.println(multiplication(input.nextDouble(), input.nextDouble()));
                break;
            case 4:
                System.out.printf("%nYou have chosen division.%nType the first number and the second number now:%n");
                System.out.println(division(input.nextDouble(), input.nextDouble()));
                break;
            default:
                System.out.printf("%nInvalid input!%n");
                break;
        }
    }                                                                                                                    //the methods below are operations

    /**
     * This method calculates what the sum of two number using addition. It then returns the sum.
     *
     * @param firstNumber       First value used in expression.
     * @param secondNumber      Second value used in expression.
     * @return                  Returns the sum of the two numbers.
     */
    public static double addition(double firstNumber, double secondNumber) {
        System.out.println("The sum of the two numbers is:");
        return (firstNumber + secondNumber);
    }

    /**
     * This method calculates what the remainder of two number using subtraction. It then returns the remainder.
     *
     * @param firstNumber       First value used in expression.
     * @param secondNumber      Second value used in expression.
     * @return                  Returns the remainder of the two numbers.
     */
    public static double subtraction(double firstNumber, double secondNumber) {
        System.out.println("The remainder of the two numbers is:");
        return (firstNumber - secondNumber);
    }

    /**
     * This method calculates the product of two numbers using multiplication. It then returns the product.
     *
     * @param firstNumber       First value used in expression.
     * @param secondNumber      Second value used in expression.
     * @return                  Returns the product of the two numbers.
     */
    public static double multiplication(double firstNumber, double secondNumber) {
        System.out.println("The product of the two numbers is:");
        return (firstNumber * secondNumber);
    }

    /**
     * This method calculates the quota of two numbers using division. It then returns the product.
     *
     * @param firstNumber       First value used in expression.
     * @param secondNumber      Second value used in expression.
     * @return                  Returns the quota of the two numbers.
     */
    public static double division(double firstNumber, double secondNumber) {
        System.out.println("The quota of the two numbers is:");
        return (firstNumber / secondNumber);
    }
}
