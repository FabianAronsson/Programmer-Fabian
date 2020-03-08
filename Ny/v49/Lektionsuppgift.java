import java.util.Scanner;

public class Lektionsuppgift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = new String[10];
        for (int i = 0; i < names.length; i++) {
            names[i] = input.nextLine();
        }

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            for (int j = i + 1; j < names.length; j++) {
                String otherName = names[j];
                if (name.equals(otherName)) {
                    System.out.println(name);
                }
            }
        }
    }
}
