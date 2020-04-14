public class start {
    /**
     * The main method that acts as the application.
     * Its only purpose is to boot up the program and then call on the controller.
     *
     * @param args
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.startGame();
    }
}
