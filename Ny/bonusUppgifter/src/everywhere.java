import java.util.ArrayList;
import java.util.Scanner;

public class everywhere {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        distinct(input.nextInt());
    }

    /**
     * Denna metod löser uppgiften "I've been everywhere, man". Den fungerar genom att man endast lägger in ett värde i arraylisten om det inte redan
     * finns i arrayen. Därefter printar man listans storlek eftersom det endast kommer att finnas unika värden i listan.
     *
     * @param cases Tar in antal gånger Alice har varit på en arbetsresa. 
     */
    public static void distinct(int cases) {
        for (int i = 0; i < cases; i++) {
            int trips = input.nextInt();
            input.nextLine(); //buffer
            ArrayList<String> arrTrips = new ArrayList<String>();
            for (int j = 0; j < trips; j++) {
                String temp = input.nextLine();
                if (!(arrTrips.contains(temp))) {
                    arrTrips.add(temp);
                }
            }
            System.out.println(arrTrips.size());
        }
    }
}
