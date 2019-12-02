public class Hemläxa {
    public static void main(String[] args) {
        String[] names = {"Tomas", "Tomas", "Tomas", "Are", "Tomas", "Are", "Tomas", "Are", "Tomas", "Niklas"};

        int years = 0;
        for (int i = 0; i < 10; i++) {
            if (names[i] == "Are") {
                years++;
            }
        }
        System.out.println(years);
    }
}


