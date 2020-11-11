package carrental;

public class Main {
    public static void main(String[] args) {

        //runningMenu();

        //test of methods:
        Car car = new Car();
        Garage garage = new Garage();
        garage.createNewCar(car);
        System.out.println();
        System.out.println("car.getMillage() = " + car.getMillage());
        //end of test

    }

    public static void runningMenu() {
        Menu menu = new Menu();
        menu.callMenu();
        menu.runMenu();
    }
}