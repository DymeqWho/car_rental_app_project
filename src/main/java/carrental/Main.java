package carrental;

public class Main {
    public static void main(String[] args) {

        User user = new User();
       // user.setPesel(01122700000L);
        user.setDateOfBirth(user.getPesel());
        System.out.println(user.getDateOfBirth());

        //runningMenu();
    }

    public static void runningMenu() {
        Menu menu = new Menu();
        System.out.println();
        System.out.println("*** Welcome to car rental! ***");
        menu.runMenu();
    }
}