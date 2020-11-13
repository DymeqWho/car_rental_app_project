package carrental;

public class Main {
    public static void main(String[] args) {

        runningMenu();
    }

    public static void runningMenu() {
        Menu menu = new Menu();
        System.out.println();
        System.out.println("*** Welcome to car rental! ***");
        menu.runMenu();
    }
}