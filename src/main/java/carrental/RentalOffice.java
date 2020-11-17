package carrental;

import java.util.List;

public class RentalOffice {

    //This method should expand!
    public void rentACar(List<Car> listOfNotRentedCars, List<User> listOfActiveUsers) {
        int listOfNotRentedCarsSize = listOfNotRentedCars.size();
        int listOfActiveUsersSize;
        if(listOfActiveUsers != null)
        listOfActiveUsersSize = listOfActiveUsers.size();
        else listOfActiveUsersSize = 0;

        System.out.println("1. There is: available " + listOfNotRentedCarsSize + " car(s).");
        if(listOfActiveUsers != null)
        System.out.println("2. There is: " + listOfActiveUsersSize + " active user(s).");
        else System.out.println("2. There is no available users! Add some first!");

        System.out.println();
        System.out.println("List of available cars: ");
        if (listOfNotRentedCarsSize > 0) {
            int i = 1;
            for (Car car : listOfNotRentedCars) {
                System.out.println("Number " + i + " " + car.toString());
                i++;
            }
        } else System.out.println("There is no available car!");

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