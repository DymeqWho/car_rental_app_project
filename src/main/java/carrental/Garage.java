package carrental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage {
    private List<Car> listOfNotRentedCars = new ArrayList<>();
    private List<Car> listOfRentedCars = new ArrayList<>();

    public Car createNewCar(Car car) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set mark of new car: ");
        car.setMark(scanner.nextLine());
        String carMark = car.getMark();
        System.out.print("Set model of new " + carMark + " car: ");
        car.setModel(scanner.nextLine());
        String carModel = car.getModel();
        String carMarkModel = carMark + " " + carModel;
        System.out.print("Set millage of new " + carMarkModel + ": ");
        do {
            int millage = parseIntValidator();
            if (millage < 0) {
                System.out.print("Millage must be bigger or equal to 0: ");
            } else {
                car.setMillage(millage);
                break;
            }
        } while (true);
        System.out.println("Set date of production" + carMark + ": ");
        System.out.print("Set year: ");
        //continue there
        //should set validator for date
        return car;
    }

    private int parseIntValidator() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        String intForPars = scanner.nextLine();
        int parsedInt = -1;
        boolean t = false;
        do {
            try {
                parsedInt = Integer.parseInt(intForPars);
                if (parsedInt >= 0) {
                    t = true;
                    return parsedInt;
                } else {
                    t = false;
                }
            } catch (NumberFormatException exception) {
                System.out.print("this is not valid number! Choose number higher or equal to 0: ");
                t = true;
                intForPars = scanner.nextLine();
            }
        }
        while (t);
        return parsedInt;
    }
}



