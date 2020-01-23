import java.util.Arrays;

public class bubble_sort {
    public static void main(String[] args) {
        int[] list = {9, 123, 4, 241, 8 ,6 ,1, 2};
            bubble(list);
    }

    public static void bubble(int[] list) {
        int temp;
        for (int i = 1; i < list.length; i++){
            for (int j = 0; j < list.length - i; j++){
                if (list[j] > list[j + 1]){
                 temp = list[j];
                 list[j] = list[j + 1];
                 list[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
        }
    }

