import java.util.Random;

public class random {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++){
            System.out.println(randomNum(1, 100));
        }
    }

    public static int randomNum(int bottom, int top) {
        /*double num = Math.random();

        num *= (top - bottom + 1);

        num += bottom;*/


        Random rand = new Random();
        return rand.nextInt(top - bottom + 1) + bottom;
    }
}
