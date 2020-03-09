import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class everywhere {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++){
            ArrayList<String> array = new ArrayList<>();
            int cities = input.nextInt();
            input.nextLine();
            for (int j = 0; j < cities; j++){
                array.add(input.nextLine());
                System.out.println(array.size());
            }
        }

          /*  Scanner sc = new Scanner(System.in);
            int cases = sc.nextInt();
            for(int i = 0; i < cases; i++){
                HashSet<String> set = new HashSet<>();
                int cities = sc.nextInt();
                sc.nextLine();
                for(int j = 0; j < cities; j++)
                    set.add(sc.nextLine());
                System.out.println(set.size());
            }*/

    }

    public static int a (int cases) {

        return 1;
    }
}
