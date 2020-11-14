package carrental;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu extends UsefulMethods {
    Scanner scanner = new Scanner(System.in);
    Garage garage = new Garage();
    HashMap<Integer, Car> mapOfNotRentedCars = new HashMap<>();

    private void callMenu() {
        System.out.println();
        System.out.println("1.  List of available cars: ");
        System.out.println("2.  Edit rental price: ");
        System.out.println("3.  Add new car: ");
        System.out.println("4.  List active users: ");
        System.out.println("5.  Add user: ");
        System.out.println("6.  Activate a user: ");
        System.out.println("7.  Rent a car: ");
        System.out.println("8.  List all rented cars: ");
        System.out.println("9.  Return a car: ");
        System.out.println("10. Display monthly report: ");
        System.out.println("11. Display yearly report: ");
        System.out.println("12. Exit.");
        System.out.println();
        //this number will show, when picked on console
    }

    public void runMenu() throws NumberFormatException {
        // number of iteration necessary for console menu.
        int i = 0;
        //number necessary for while statement
        int choise = 0;
        //beggining of do-while loop
        do {
            // there is place, where console is asking for pick number.
            callMenu();
            System.out.print("Main menu. Choose your option: ");
            String whatToChoose = scanner.nextLine();
            //NumberFormatException exception
            try {
                choise = Integer.parseInt(whatToChoose);
            } catch (NumberFormatException exception) {
                System.out.print("This is not a number! ");
            } finally {
                if (choise == 1) {
                    chooseOption(garage.getListOfNotRentedCars());
                    System.out.println();
                    runMenu();
                } else if (choise == 2) {
                    changeRentalPrice(garage.getListOfNotRentedCars());
                    runMenu();
                } else if (choise == 3) {
                    garage.putCarToListOfNotRentedCars(garage.getListOfNotRentedCars());
                    System.out.println();
                    runMenu();
                } else if (choise == 4) {
                    System.out.println("4.");
                } else if (choise == 5) {
                    System.out.println("5.");
                } else if (choise == 6) {
                    System.out.println("6.");
                } else if (choise == 7) {
                    System.out.println("7.");
                } else if (choise == 8) {
                    System.out.println("8.");
                } else if (choise == 9) {
                    System.out.println("9.");
                } else if (choise == 10) {
                    System.out.println("10.");
                } else if (choise == 11) {
                    System.out.println("11.");
                } else if (choise == 12) {
                    System.out.println("Goodbye!");
                } else {
                    System.out.println("Choose number between 1 to 12: ");
                }
                i++;
            }
        }
        while (choise <= 0 || choise > 12); // console will not ask about different number while number will be between 1-12.
    }

    private void chooseOption(List<Car> list) {
        System.out.println(list);
        do {
            System.out.print("Would you like to go back to menu? (Press \"1\" or \"y\"): ");
            String option = scanner.nextLine();
            if (option.equals("y") || option.equals("1"))
                break;
            else System.out.println("Wrong command. ");
        } while (true);
    }

    private Car changeRentalPrice(List<Car> list) {

        for (int i = 0; i < list.size(); i++) {
            mapOfNotRentedCars.put(i + 1, list.get(i));
        }
        mapOfNotRentedCars.remove(0);
        System.out.println("List of all available now cars: ");
        System.out.println(mapOfNotRentedCars.toString().replace("=", " index: "));
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
        return mapOfNotRentedCars.get(whichMark);
    }


}
