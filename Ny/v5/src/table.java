import java.util.Random;

public class table {
    static Random rand = new Random();
    public static void main(String[] args) {

        lootTable(chance(0, 100));
    }

    public static int chance(int bottom, int top) {
        Random rand = new Random();

        return rand.nextInt(top - bottom  + 1) + bottom;
    }

    public static String lootTable(int probability) {

        if (probability < 5){
            System.out.println("1");
        }
        else if (probability < 30){
            System.out.println("2");
        }
        else{
            System.out.println("3");
        }
        return "a";
    }
}
