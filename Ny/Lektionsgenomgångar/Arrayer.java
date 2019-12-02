public class Arrayer {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //alla datatyper fungerar.
        int[] arr2 = new int[21];

        for (int i = 0; i < 21; i++) {
            arr2[i] = 5 * i;
            System.out.println(arr2[i]);
        }

        for (int number: arr2) {
            System.out.println(number);
        }

        int[] arr3 = new int[11];
        for (int i = 0; i < 11; i++) {
            arr3[i] = 7 * i;
            System.out.println(arr3[i]);
        }
    }
}
