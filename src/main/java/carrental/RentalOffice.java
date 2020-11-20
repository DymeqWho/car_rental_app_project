package carrental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalOffice extends UsefulMethods {

    private List<RentalOffice> listOfRentedCars = new ArrayList<>();
    private Car rentedCar;
    private User client;
    private LocalDate dateOfRent;
    private LocalDate dateOfReturn;
    private BigDecimal priceForRentForClient;
    private int howManyDays;
    private BigDecimal income;

    public RentalOffice() {
    }

    public RentalOffice(Car rentedCar, User client, LocalDate dateOfRent, BigDecimal priceForRentForClient, int howManyDays) {
        this.rentedCar = rentedCar;
        this.client = client;
        this.dateOfRent = dateOfRent;
        this.priceForRentForClient = priceForRentForClient;
        this.howManyDays = howManyDays;
    }

    public RentalOffice(Car rentedCar, User client, LocalDate dateOfRent, LocalDate dateOfReturn, BigDecimal priceForRentForClient, int howManyDays, BigDecimal income) {
        this.rentedCar = rentedCar;
        this.client = client;
        this.dateOfRent = dateOfRent;
        this.dateOfReturn = dateOfReturn;
        this.priceForRentForClient = priceForRentForClient;
        this.howManyDays = howManyDays;
        this.income = income;
    }

    public List<RentalOffice> getListOfRentedCars() {
        return listOfRentedCars;
    }

    public void setListOfRentedCars(List<RentalOffice> listOfRentedCars) {
        this.listOfRentedCars = listOfRentedCars;
    }

    public Car getRentedCar() {
        return rentedCar;
    }

    public void setRentedCar(Car rentedCar) {
        this.rentedCar = rentedCar;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public BigDecimal getPriceForRentForClient() {
        return priceForRentForClient;
    }

    public void setPriceForRentForClient(BigDecimal priceForRentForClient) {
        this.priceForRentForClient = priceForRentForClient;
    }

    public int getHowManyDays() {
        return howManyDays;
    }

    public void setHowManyDays(int howManyDays) {
        this.howManyDays = howManyDays;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    //This method should expand!
    public void rentACar(List<Car> listOfNotRentedCars, List<User> listOfActiveUsers) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        int listOfNotRentedCarsSize = listOfNotRentedCars.size();
        int listOfActiveUsersSize;

        if (listOfActiveUsers != null)
            listOfActiveUsersSize = listOfActiveUsers.size();
        else listOfActiveUsersSize = 0;

        Car choiceCar = null;
        User choiceUser = null;
        String confirmation = "";

        do {
            System.out.println("Rent a car!");
            System.out.println();
            System.out.println("There is: available " + listOfNotRentedCarsSize + " car(s). Press 1 or \"c\" to make operation on that list first.");
            if (listOfActiveUsers != null)
                System.out.println("There is: " + listOfActiveUsersSize + " active user(s). Press 2 or \"u\" to make operation on that list first.");
            else System.out.println("2. There is no available users! Add some first!");
            System.out.println("Pres any other number or letter to exit.");
            System.out.println();

            String option;
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

            String messageNumber = "Which car you want to rent? ";
            String messageUser = "Who do you want to rent a car? ";
            String noActiveUsersMessage = "There is no one active for who you can rent a car! Add first someone to Active Users list!";
            String noAvailableCars = "There is no available cars! ";

            if (optionInt == 1 || option.equals("c")) {
                if (listOfNotRentedCars.isEmpty()) {
                    System.out.println(noAvailableCars);
                } else {
                    if (listOfActiveUsers == null) {
                        System.out.println(noActiveUsersMessage);
                    } else {
                        choiceCar = returnWhichCarIsOfficiallyChosen(listOfNotRentedCars, listOfNotRentedCarsSize, messageNumber);
                        System.out.println("For who do you want to rent a car? ");
                        choiceUser = returnWhichUserIsOfficiallyChosen(listOfActiveUsers, messageUser, listOfActiveUsersSize);
                    }
                }
            }

            if (optionInt == 2 || option.equals("u")) {
                if (listOfActiveUsers == null) {
                    System.out.println(noActiveUsersMessage);
                } else {
                    if (listOfNotRentedCars.isEmpty()) {
                        System.out.println(noAvailableCars);
                    } else {
                        choiceUser = returnWhichUserIsOfficiallyChosen(listOfActiveUsers, messageUser, listOfActiveUsersSize);
                        System.out.println("Which car you want to rent for " + choiceUser.getNameLastName() + "? ");
                        choiceCar = returnWhichCarIsOfficiallyChosen(listOfNotRentedCars, listOfNotRentedCarsSize, messageNumber);
                    }
                }
            }

            if (optionInt != 1 && optionInt != 2 && !option.equals("c") && !option.equals("u")) {
                break;
            }
            System.out.println();
            assert choiceUser != null;
            String carMarkModel = choiceCar.getMark() + " " + choiceCar.getModel();
            System.out.println("You want to rent for " + choiceUser.getNameLastName() + " car: " + carMarkModel
                    + " from year: " + choiceCar.getDateOfProduction().getYear() + ". Is this correct?");
            System.out.print("Choose \"y\" or \"1\" if \"yes\". If \"no\" choose anything else: ");
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equals("y") || yesOrNo.equals("1")) {
                do { // need investigation if this is really useless. 
                    do {
                        System.out.print("For how many days " + choiceUser.getNameLastName() + " would like to rent a car?: ");
                        String howManyDays = scanner.nextLine();
                        if (isThisInt(howManyDays) && !howManyDays.equals("0")) {
                            setHowManyDays(Integer.parseInt(howManyDays));
                            break;
                        } else System.out.println("This is not valid count of days! ");
                    } while (true);
                    System.out.println(choiceUser.getNameLastName() + " wish to rent a car " + carMarkModel + " for "
                            + " * " + getHowManyDays() + " *  days is this correct? ");
                    System.out.print("Choose \"y\" or \"1\" if \"yes\". If \"no\" choose anything else: ");
                    confirmation = scanner.nextLine();
                    if (confirmation.equals("y") || confirmation.equals("1")) {
                        setRentedCar(choiceCar);
                        setClient(choiceUser);
                        BigDecimal bonusForOlderThan40 = BigDecimal.ZERO;
                        BigDecimal bonusForMoreThan100 = BigDecimal.ZERO;
                        if (isOlderThan40(choiceUser)) {
                            bonusForOlderThan40 = choiceCar.getRentalPriseForOneDay().multiply(BigDecimal.valueOf(0.1));
                        }
                        if (choiceUser.getNumberOfRentedCars() > 100) {
                            bonusForMoreThan100 = choiceCar.getRentalPriseForOneDay().multiply(BigDecimal.valueOf(0.1));
                        }
                        setPriceForRentForClient(choiceCar.getRentalPriseForOneDay().subtract(bonusForOlderThan40).subtract(bonusForMoreThan100));
                        break;
                    } else {
                        System.out.println("You did not confirm for how many days should car be rented!");
                        break;
                    }
                } while (true); // need investigation if this is really useless.
            }
            break;
        } while (true);
        System.out.println("Operation: ");
        if (confirmation.equals("y") || confirmation.equals("1")) {
            listOfRentedCars.add(new RentalOffice(rentedCar, client, LocalDate.now(), priceForRentForClient, howManyDays));
            listOfNotRentedCars.remove(choiceCar);
            for (int i = listOfRentedCars.size() - 1; i >= 0; ) {
                System.out.println("Car: " + listOfRentedCars.get(i).getRentedCar().toString());
                System.out.println("Client: " + listOfRentedCars.get(i).getClient().toString());
                System.out.println("From date: " + listOfRentedCars.get(i).getDateOfRent());
                System.out.println("Price for that client after all bonuses: " + listOfRentedCars.get(i).getPriceForRentForClient());
                System.out.println("How many days of rental: " + listOfRentedCars.get(i).getHowManyDays());
                break;
            }
        } else {
            System.out.println("did not succeed!");
        }
    }

    public void showListOfAllRentedCars() {
        if (listOfRentedCars.size() > 0) {
            for (int i = listOfRentedCars.size() - 1; i >= 0; i--) {
                System.out.println("Car: " + listOfRentedCars.get(i).getRentedCar().toString());
                System.out.println("Client: " + listOfRentedCars.get(i).getClient().toString());
                System.out.println("From date: " + listOfRentedCars.get(i).getDateOfRent());
                System.out.println("Price for that client after all bonuses: " + listOfRentedCars.get(i).getPriceForRentForClient());
                System.out.println("How many days of rental: " + listOfRentedCars.get(i).getHowManyDays());
                System.out.println();
            }
        } else {
            System.out.println("List is empty!");
        }
    }


    private boolean isOlderThan40(User user) {
        LocalDate interestingLocalDate = user.getDateOfBirth();
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();
        int monthNow = now.getMonthValue();
        int dayNow = now.getDayOfMonth();
        int interestingYear = interestingLocalDate.getYear();
        int interestingMonth = interestingLocalDate.lengthOfMonth();
        int interestingDay = interestingLocalDate.getDayOfMonth();
        if ((dayNow - interestingDay <= 0 && monthNow - interestingMonth <= 0) || dayNow - interestingDay >= 0) {
            if (monthNow - interestingMonth <= 0) {
                return yearNow - interestingYear >= 40;
            }
        }
        return false;
    }

    private Car returnWhichCarIsOfficiallyChosen(List<Car> listOfNotRentedCars, int listOfNotRentedCarsSize, String messageNumber) {
        int choiceCar;
        showAvailableCars(listOfNotRentedCars);
        do {
            choiceCar = whichNumberYouWantToPeek(listOfNotRentedCarsSize, messageNumber);
            if (listOfNotRentedCars.isEmpty()) {
                System.out.println("List is empty. Now you will exit.");
                break;
            }
            if (choiceCar > 0) {
                break;
            } else {
                System.out.println("Choose another number! ");
            }
        } while (true);
        return chosenObject(choiceCar, listOfNotRentedCars, listOfNotRentedCarsSize);
    }

    private User returnWhichUserIsOfficiallyChosen(List<User> listOfActiveUsers, String messageUser, int listOfActiveUsersSize) {
        int choiceUser;
        showListOfAvailableUsers(listOfActiveUsers);
        do {
            choiceUser = whichNumberYouWantToPeek(listOfActiveUsersSize, messageUser);
            if (listOfActiveUsers == null) {
                System.out.println("List is empty. Now you will exit.");
                break;
            }
            if (choiceUser > 0) {
                break;
            } else {
                System.out.println("Choose another number! ");
            }
        } while (true);
        return chosenObject(choiceUser, listOfActiveUsers);

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

    private Car chosenObject(int whichNumberOfChoice, List<Car> something, int sizeOfList) {
        int peak = 0;
        for (int i = 0; i < sizeOfList; i++) {
            if (whichNumberOfChoice - 1 == i) {
                peak = i;
                System.out.print("Chosen car number " + (peak + 1) + " is: " + something.get(peak));
            }
        }
        return something.get(peak);
    }

    private User chosenObject(int whichNumberOfChoice, List<User> something) {
        int choice = 0;
        int sizeOfList;
        if (something == null) {
            return null;
        } else {
            sizeOfList = something.size();
        }
        for (int i = 0; i < sizeOfList; i++) {
            if (whichNumberOfChoice - 1 == i) {
                choice = i;
                System.out.print("Chosen user number " + (choice + 1) + " is: " + something.get(i).getNameLastName());
            }
        }
        return something.get(choice);
    }
}