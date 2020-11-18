package carrental;

import java.util.List;
import java.util.Scanner;

public class RentalOffice extends UsefulMethods {

    //This method should expand!
    public void rentACar(List<Car> listOfNotRentedCars, List<User> listOfActiveUsers) {
        Scanner scanner = new Scanner(System.in);
        int listOfNotRentedCarsSize = listOfNotRentedCars.size();
        int listOfActiveUsersSize;

        if (listOfActiveUsers != null)
            listOfActiveUsersSize = listOfActiveUsers.size();
        else listOfActiveUsersSize = 0;

        System.out.println("Rent a car!");
        System.out.println();
        System.out.println("There is: available " + listOfNotRentedCarsSize + " car(s). Press 1 or \"c\" to see the list.");
        if (listOfActiveUsers != null)
            System.out.println("There is: " + listOfActiveUsersSize + " active user(s). Press 2 or \"u\" to see the list.");
        else System.out.println("2. There is no available users! Add some first!");

        System.out.println("Press 3 or \"b\" if ypu want to see both lists; car list and user list.");

        System.out.println("Pres any other number to exit.");
        System.out.println();

        String option = "";
        int optionInt = 0;
        do {
            System.out.print("What is your option?: ");
            option = scanner.nextLine().toLowerCase();
            boolean isThisNumber = isThisInt(option);

            if (isThisNumber) {
                optionInt = Integer.parseInt(option);
                break;
            } else if (option.equals("c") || option.equals("u") || option.equals("b")) {
                break;
            } else System.out.println("This is not valid character!");
        } while (true);

        if (optionInt == 1 || option.equals("c")) {
            showAvailableCars(listOfNotRentedCars);
        }
        if (optionInt == 2 || option.equals("u")) {
            showListOfAvailableUsers(listOfActiveUsers);
        }
        if (optionInt == 3 || option.equals("b")) {
            showAvailableCars(listOfNotRentedCars);
            showListOfAvailableUsers(listOfActiveUsers);
        }
    }


    private void showAvailableCars(List<Car> listOfNotRentedCars) {
        int listOfNotRentedCarsSize = listOfNotRentedCars.size();
        System.out.println("List of available cars: ");
        if (listOfNotRentedCarsSize > 0) {
            int i = 1;
            for (Car car : listOfNotRentedCars) {
                System.out.println("Number " + i + " " + car.toString());
                i++;
            }
        } else System.out.println("There is no available car!");
    }

    private void showListOfAvailableUsers(List<User> listOfActiveUsers) {
        System.out.println();
        System.out.println("List of available, active users: ");
        if (listOfActiveUsers != null) {
            int j = 1;
            for (User user : listOfActiveUsers) {
                System.out.println("Index: " + j + " " + user.toString());
                j++;
            }
        } else System.out.println("There is no available users! ");
    }
}