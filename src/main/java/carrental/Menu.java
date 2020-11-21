package carrental;

import java.util.Scanner;

public class Menu extends UsefulMethods {
    Scanner scanner = new Scanner(System.in);
    Garage garage = new Garage();
    CustomersRoom customersRoom = new CustomersRoom();
    RentalOffice rentalOffice = new RentalOffice();
    Bookkeeping bookkeeping = new Bookkeeping();

    private void callMenu() {
        System.out.println();
        System.out.println("1.  List of available cars: ");
        System.out.println("2.  Edit rental price: ");
        System.out.println("3.  Add new car: ");
        System.out.println("4.  List active users: ");
        System.out.println("5.  Add user: ");
        System.out.println("6.  Activate a user: ");
        System.out.println("7.  Rent a car: ");
        System.out.println("8.  List of all rented cars: ");
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
                    garage.presentCars();
                    backToMenu();
                } else if (choise == 2) {
                    garage.changeRentalPrice(garage.getListOfNotRentedCars());
                    backToMenu();
                } else if (choise == 3) {
                    garage.putCarToListOfNotRentedCars(garage.getListOfNotRentedCars());
                    backToMenu();
                } else if (choise == 4) {
                    System.out.println("List of active users: ");
                    customersRoom.showListOfActivatedUsers();
                    backToMenu();
                } else if (choise == 5) {
                    customersRoom.addUserToListOfNotActivatedUsers();
                    System.out.println();
                    runMenu();
                } else if (choise == 6) {
                    customersRoom.activateAUser(customersRoom.getListOfNotActivatedUsers());
                    backToMenu();
                } else if (choise == 7) {
                    rentalOffice.rentACar(garage.getListOfNotRentedCars(), customersRoom.getListOfActivatedUsers(), bookkeeping.getListOfOperations());
                    backToMenu();
                } else if (choise == 8) {
                    rentalOffice.showListOfAllRentedCars();
                    backToMenu();
                } else if (choise == 9) {
                    rentalOffice.returnCarFromRental(rentalOffice.getListOfRentedCars(), garage.getListOfNotRentedCars());
                    backToMenu();
                } else if (choise == 10) {
                    bookkeeping.showListOfAllOperationsInMonth();
                    backToMenu();
                } else if (choise == 11) {
                    if (bookkeeping.getListOfOperations().isEmpty()) {
                        System.out.println("Make some operations first!");
                    } else {
                        bookkeeping.showListOfAllOperationsInYear();
                    }
                    backToMenu();
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

    private void enterForGoingBackToMenu() {
        System.out.print("Pres enter for going back to menu: ");
        scanner.nextLine();
    }

    private void backToMenu() {
        System.out.println();
        enterForGoingBackToMenu();
        System.out.println();
        runMenu();
    }
}
