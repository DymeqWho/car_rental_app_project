package carrental;

public class Main {
    public static void main(String[] args) {

        //runningMenu();

        //test of methods:
//        Car car = new Car();
       Garage garage = new Garage();
//        garage.createNewCar(car);
//        System.out.println();
//        System.out.println("car.getMark() = " + car.getMark());
//        System.out.println("car.getModel() = " + car.getModel());
//        System.out.println("car.getMillage() = " + car.getMillage());
//        System.out.println("car.getDateOfProduction() = " + car.getDateOfProduction());
//        System.out.println("car.getRentalPriseForOneDay() = " + car.getRentalPriseForOneDay());
//        System.out.println("car = " + car.toString());
        //end of test

        garage.setListOfNotRentedCars(garage.getListOfNotRentedCars());
        System.out.println("garage.getListOfNotRentedCars() = " + garage.getListOfNotRentedCars().toString());

    }

    public static void runningMenu() {
        Menu menu = new Menu();
        menu.callMenu();
        menu.runMenu();
    }
}