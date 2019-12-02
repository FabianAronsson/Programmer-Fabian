import java.util.Scanner;

public class Länder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] countries = {"Iceland", "Sweden", "Norway", "Finland"};
        String[] correctCountries = new String[4];
        String[] incorrectCountries = new String[4];
        boolean one = false;
        System.out.println("Write all countries in Scandinavia:");
        for (int i = 0; i < 4; i++) {
            String country = input.nextLine();
            one = false;
            for (String nation : countries) {
                if (nation.equals(country)) {
                    one = true;
                }
            }
            if (one) {
                correctCountries[i] = country;
            } else if (!one) {
                incorrectCountries[i] = country;
            }
        }
        if (correctCountries == null) {
            System.out.println("No correct countries");
        } else {
            System.out.println("Correct countries");
            for (String name : correctCountries) {
                if (name != null) {
                    System.out.println(name);
                }
            }
        }

        if (incorrectCountries == null) {
            System.out.println("No correct countries! Better luck next time.");
        } else {
            System.out.println("Incorrect countries");
            for (String name : incorrectCountries) {
                if (name != null) {
                    System.out.println(name);
                }
            }
        }
    }
}
//Gör en kod som som ber användaren att att lista alla länder i Norden och sen kolla om personen har listat alla rätt.

