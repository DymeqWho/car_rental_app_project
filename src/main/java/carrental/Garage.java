package carrental;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Garage extends UsefulMethods {
    private final List<Car> listOfNotRentedCars;
    private HashMap<Integer, Car> mapOfNotRentedCars = new HashMap<>();

    public Garage() {
        this.listOfNotRentedCars = new ArrayList<>();
        this.listOfNotRentedCars.add(0, firstCar());
        this.listOfNotRentedCars.add(1, secondCar());
    }

    public Car createNewCar() {
        Car car = new Car();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set mark of new car: ");
        car.setMark(scanner.nextLine());
        String carMark = car.getMark();
        System.out.print("Set model of new " + carMark + " car: ");
        car.setModel(scanner.nextLine());
        String carModel = car.getModel();
        String carMarkModel = carMark + " " + carModel;
        System.out.print("Set millage of new " + carMarkModel + ": ");
        String millageString = "Millage";
        car.setMillage(checkIntNumberRange(0, millageString));
        car.setDateOfProduction(car);
        System.out.print("Set daily price for renting a " + carMarkModel + ": ");
        String priceString = "Price";
        double price = checkDoubleNumberRange(0d, priceString);
        car.setRentalPriseForOneDay(price);
        System.out.println();
        String addedCarString = "New added car is: " + car.toString();
        System.out.println(addedCarString);
        do {
            System.out.println("It this correct? ");
            System.out.println("If yes, press \"1\" or \"y\". ");
            System.out.println("If you want to change 'Mark', press \"2\" or \"m\". ");
            System.out.println("If you want to change 'Model', press \"3\" or \"o\". ");
            System.out.println("If you want to change 'Millage', press \"4\" or \"i\". ");
            System.out.println("If you want to change 'Date of production', press \"5\" or \"d\". ");
            System.out.println("If you want to change 'Rental price for one day', press \"6\" or \"r\". ");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("1") || choice.equals("y")) {
                break;
            } else if (choice.equals("2") || choice.equals("m")) {
                String oldMark = car.getMark();
                System.out.println("Actual 'Mark' is: " + oldMark);
                System.out.print("Set mark of new car: ");
                car.setMark(scanner.nextLine());
                System.out.println("You have changed " + oldMark + " on " + car.getMark());
                addedCarString = "New added car is: " + car.toString();
                System.out.println(addedCarString);
            } else if (choice.equals("3") || choice.equals("o")) {
                String oldModel = car.getModel();
                System.out.println("Actual 'Model' is: " + oldModel);
                System.out.print("Set model of new car: ");
                car.setModel(scanner.nextLine());
                System.out.println("You have changed " + oldModel + " on " + car.getModel());
                addedCarString = "New added car is: " + car.toString();
                System.out.println(addedCarString);
            } else if (choice.equals("4") || choice.equals("i")) {
                int oldMillage = car.getMillage();
                System.out.println("Actual 'Millage' is: " + oldMillage);
                System.out.print("Set millage of new car: ");
                car.setMillage(checkIntNumberRange(0, millageString));
                System.out.println("You have changed " + oldMillage + " on " + car.getMillage());
                addedCarString = "New added car is: " + car.toString();
                System.out.println(addedCarString);
            } else if (choice.equals("5") || choice.equals("d")) {
                LocalDate oldDate = car.getDateOfProduction();
                System.out.println("Actual 'Date' is: " + oldDate);
                car.setDateOfProduction(car);
                System.out.println("You have changed " + oldDate + " on " + car.getMillage());
                addedCarString = "New added car is: " + car.toString();
                System.out.println(addedCarString);
            } else if (choice.equals("6") || choice.equals("r")) {
                BigDecimal oldPrice = car.getRentalPriseForOneDay();
                System.out.println("Actual 'Rental price for one day' is: " + oldPrice);
                double newPrice = checkDoubleNumberRange(0d, priceString);
                car.setRentalPriseForOneDay(newPrice);
                addedCarString = "New added car is: " + car.toString();
                System.out.println(addedCarString);
            }
        } while (true);
        return car;
    }

    public Car firstCar() {
        return new Car("Opel", "Corsa", 120000, LocalDate.of(2010, 4, 13), BigDecimal.valueOf(80.0));
    }

    public Car secondCar() {
        return new Car("Skoda", "Fabia", 220000, LocalDate.of(2011, 7, 22), BigDecimal.valueOf(110.0));
    }


    public List<Car> getListOfNotRentedCars() {
        return listOfNotRentedCars;
    }

    public void putCarToListOfNotRentedCars(List<Car> listOfNotRentedCars) {
        listOfNotRentedCars.add(createNewCar());
    }

    public void presentCars() {
        System.out.println("List of available cars: ");
        System.out.println();
        if (listOfNotRentedCars.size() > 0) {
            int i = 1;
            for (Car car : listOfNotRentedCars) {
                System.out.println("Number " + i + " " + car.toString());
                i++;
            }
        } else System.out.println("There is no available car!");
    }

    public Car changeRentalPrice(List<Car> list) {

        for (int i = 0; i < list.size(); i++) {
            mapOfNotRentedCars.put(i + 1, list.get(i));
        }
        mapOfNotRentedCars.remove(0);
        System.out.println("List of all available now cars: ");
        for (int i = 1; i < mapOfNotRentedCars.size() + 1; i++) {
            System.out.println("index " + i + ": " + mapOfNotRentedCars.get(i).toString().replace("=", " index: "));
        }
        boolean finishIt = true;
        int whichMark;
        do {
            System.out.print("Which car rental price you would like to change? Sign index: ");
            whichMark = parseIntValidator();
            if (whichMark <= mapOfNotRentedCars.size() && whichMark >= 1) {
                System.out.println("Chosen car is: ");
                System.out.println(mapOfNotRentedCars.get(whichMark));
                finishIt = false;
            } else {
                System.out.println("There is no such car!");
            }
        } while (finishIt);
        BigDecimal oldPrice = mapOfNotRentedCars.get(whichMark).getRentalPriseForOneDay();
        System.out.print("Actual price is: " + oldPrice + ". What new price you would like to set?: ");
        double newPrice = parseDoubleValidator();
        BigDecimal newPriseBDRound = BigDecimal.valueOf(newPrice).setScale(2, RoundingMode.HALF_UP);
        System.out.print("Old price was: " + oldPrice + ". New price is: " + newPriseBDRound);
        mapOfNotRentedCars.get(whichMark).setRentalPriseForOneDay(newPrice);
        System.out.println();
        return mapOfNotRentedCars.get(whichMark);
    }
}



