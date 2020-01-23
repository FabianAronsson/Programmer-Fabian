import java.util.Scanner;

public class Numeroocho {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //gangerTabell();
        kvadrat();
    }

    public static void gangerTabell() {
        for (int i = 1; i <= 10; i++){
            System.out.println();
            for (int j = 1; j <= 10; j++){
                System.out.print(j * i + "  ");
            }
        }

    }

    public static void kvadrat() {
        int spaces = input.nextInt();
        String tecken = "";
        for (int i = 0; i < spaces; i++){
            tecken += "$";
        }

        if(spaces == 1){
            System.out.println(tecken);
        }
        else if(spaces == 2){
            System.out.println(tecken);
            System.out.println(tecken);
        }

        

    }
}
