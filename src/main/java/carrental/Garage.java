package carrental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage extends UsefulMethods {
    private List<Car> listOfNotRentedCars = new ArrayList<>();
    private List<Car> listOfRentedCars = new ArrayList<>();

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
        System.out.println("Let's set the date of production " + carMarkModel + " ");
        System.out.print("Set year: ");
        String yearString = "Year";
        int year = checkIntNumberRange(1950, LocalDate.now().getYear(), yearString);
        System.out.print("Set month: ");
        String monthString = "Month";
        int month = checkIntNumberRange(1, 12, monthString);
        System.out.print("Set day: ");
        String dayString = "Day";
        int day = checkIntNumberRange(1, 31, dayString);
        car.setDateOfProduction(year, month, day);
        System.out.print("Set daily price for renting a " + carMarkModel + ": ");
        String priceString = "Price";
        double price = checkDoubleNumberRange(0d, priceString);
        car.setRentalPriseForOneDay(price);
        return car;
    }

    public Car firstCar(){
        return new Car("Opel", "Corsa", 120000, LocalDate.of(2010,04,13), BigDecimal.valueOf(80.0));
    }
    public Car secondCar(){
        return new Car("Skoda", "Fabia", 220000, LocalDate.of(2011,07,22), BigDecimal.valueOf(110.0));
    }

    public List<Car> getListOfNotRentedCars() {
        return listOfNotRentedCars;
    }

    public void setListOfNotRentedCars(List<Car> listOfNotRentedCars) {
        listOfNotRentedCars.add(firstCar());
        listOfNotRentedCars.add(secondCar());
//        int i = 0;
//        while(i == 100){
            listOfNotRentedCars.add(createNewCar());
//            i++;
//        }
        this.listOfNotRentedCars = listOfNotRentedCars;
    }


}



