package carrental;

import java.util.Collections;
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
        System.out.println("There is: available " + listOfNotRentedCarsSize + " car(s). Press 1 or \"c\" to make operation on that list first.");
        if (listOfActiveUsers != null)
            System.out.println("There is: " + listOfActiveUsersSize + " active user(s). Press 2 or \"u\" to make operation on that list first.");
        else System.out.println("2. There is no available users! Add some first!");
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
            } else if (option.equals("c") || option.equals("u")) {
                break;
            } else System.out.println("This is not valid character!");
        } while (true);

        int choiceCar = 0;
        int choiceUser = 0;
        String messageNumber = "Which car you want to rent? If you want to exit, press 0. Put a number: ";
        String messageUser = "Who do you want to rent a car? If you want to exit, press 0. Put a number: ";

        if (optionInt == 1 || option.equals("c")) {
            choiceCar = returnWhichCarIsOfficiallyChosen(listOfNotRentedCars, listOfNotRentedCarsSize, messageNumber);
            System.out.println("For who do you want to rent a car? ");
            if (listOfActiveUsers == null) {
                System.out.println("There is no one active for who you can rent a car! Add first someone to Active Users list!");
            } else {
                choiceUser = returnWhichUserIsOfficiallyChosen(listOfActiveUsers, messageUser, listOfActiveUsersSize);
            }
        }

        if (optionInt == 2 || option.equals("u")) {
            choiceUser = returnWhichUserIsOfficiallyChosen(listOfActiveUsers, messageUser, listOfActiveUsersSize);
        }
    }

    private int returnWhichCarIsOfficiallyChosen(List<Car> listOfNotRentedCars, int listOfNotRentedCarsSize, String messageNumber) {
        int choiceCar;
        showAvailableCars(listOfNotRentedCars);
        do {
            choiceCar = whichNumberYouWantToPeek(listOfNotRentedCarsSize, messageNumber);
            if (listOfNotRentedCars.isEmpty()) {
                System.out.println("List is empty. Now you will exit.");
                choiceCar = 0;
                break;
            }
            if (choiceCar > 0) {
                break;
            } else {
                System.out.println("Choose another number! ");
            }
        } while (true);
        System.out.println(chosenObject(choiceCar, listOfNotRentedCars, listOfNotRentedCarsSize));
        return choiceCar;
    }

    private int returnWhichUserIsOfficiallyChosen(List<User> listOfActiveUsers, String messageUser, int listOfActiveUsersSize) {
        int choiceUser;
        showListOfAvailableUsers(listOfActiveUsers);
        do {
            choiceUser = whichNumberYouWantToPeek(listOfActiveUsersSize, messageUser);
            if (listOfActiveUsers == null) {
                System.out.println("List is empty. Now you will exit.");
                choiceUser = 0;
                break;
            }
            if (choiceUser > 0) {
                break;
            } else {
                System.out.println("Choose another number! ");
            }
        } while (true);
        System.out.println(chosenObject(choiceUser, listOfActiveUsers));
        return choiceUser;
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

    private int whatIsYourChoise() {
        Scanner scanner = new Scanner(System.in);
        int chiceInt = 0;
        do {
            String choise = scanner.nextLine();
            if (isThisInt(choise)) {
                return chiceInt = Integer.parseInt(choise);
            } else System.out.print("Put a proper number: ");
        } while (true);
    }

    private int whichNumberYouWantToPeek(int listSize, String message) {
        do {
            System.out.print(message);
            int choiceNumber = whatIsYourChoise();
            if (choiceNumber <= listSize) {
                return choiceNumber;
            } else System.out.print("This is invalid number! ");
        } while (true);
    }

    private int chosenObject(int whichNumberOfChoice, List<Car> something, int sizeOfList) {
        for (int i = 0; i < sizeOfList; i++) {
            if (whichNumberOfChoice - 1 == i) {
                System.out.print("Chosen is: " + something.get(i).toString() + "; number: ");
                return i + 1;
            }
        }
        return -1;
    }

    private int chosenObject(int whichNumberOfChoice, List<User> something) {
        int sizeOfList;
        if (something == null) {
            sizeOfList = 0;
        } else {
            sizeOfList = something.size();
        }
        for (int i = 0; i < sizeOfList; i++) {
            if (whichNumberOfChoice - 1 == i) {
                System.out.print("Chosen is: " + something.get(i).toString() + "; number: ");
                return i + 1;
            }
        }
        return -1;
    }


}