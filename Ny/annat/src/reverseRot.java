import java.util.Scanner;

public class reverseRot {
    public static void main(String[] args) {
    a(2);
    }

    public static int a (int cases) {
        Scanner input = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
        String reversedSentence = "";
        String sentence = "";
        int rotation = 0;
        for (int i = 0; i < cases; i++){
            boolean a = true;
            reversedSentence = "";
            rotation = input.nextInt();
            input.nextLine(); //buffer
            sentence = input.nextLine();
            for (int j = 0; j < sentence.length(); j++){
                reversedSentence += sentence.charAt((sentence.length() - 1) - j) ;
            }

                for (int k = 0; k < reversedSentence.length() - 1; k++){
                        char temp = reversedSentence.charAt(k);
                        int indexOf = alphabet.indexOf(temp);
                    System.out.println(alphabet.charAt(indexOf));

                }

        }

        return 1;
    }
}
