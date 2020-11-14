package carrental;

public class Main {
    public static void main(String[] args) {

        User user = new User();

        user.setPesel();
        System.out.println("user.getPesel() = " + user.getPesel());
        user.setDateOfBirth(user.getYearOfBirth(),user.getMonthOfBirth(),user.getDayOfBirth());
        System.out.println("user.getDateOfBirth() = " + user.getDateOfBirth());
        //runningMenu();
    }

    public static void runningMenu() {
        Menu menu = new Menu();
        System.out.println();
        System.out.println("*** Welcome to car rental! ***");
        menu.runMenu();
    }
}