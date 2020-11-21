package carrental;

import java.util.*;

public class CustomersRoom extends UsefulMethods {
    private List<User> listOfNotActivatedUsers = new ArrayList<>();
    private List<User> listOfActivatedUsers = new ArrayList<>();

    public CustomersRoom() {
    }

    public List<User> getListOfNotActivatedUsers() {
        return listOfNotActivatedUsers;
    }

    public List<User> getListOfActivatedUsers() {
        if (listOfActivatedUsers.isEmpty()) {
            return null;
        }
        return listOfActivatedUsers;
    }

    public void showListOfActivatedUsers() {
        if (listOfActivatedUsers.isEmpty()) {
            System.out.println("Is empty!");
        } else {
            for (int i = 0; i < listOfActivatedUsers.size(); i++) {
                System.out.println(getListOfActivatedUsers().get(i));
            }
        }
    }

    public void addUserToListOfNotActivatedUsers() {
        System.out.println("Add new, not yet active user. ");
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        boolean isLeapYear = true;
        System.out.print("Set users name: ");
        user.setName(scanner.nextLine());
        System.out.print("Set " + user.getName() + " last name: ");
        user.setLastName(scanner.nextLine());
        user.setPesel();
        isLeapYear = isValidPESELyear(user.getYearOfBirth(), user);
        String choise = "";
        do {
            if (choise.equals("1") || choise.equals("n")) {
                System.out.print("Set users name: ");
                user.setName(scanner.nextLine());
            } else if (choise.equals("2") || choise.equals("l")) {
                System.out.print("Set " + user.getName() + " last name: ");
                user.setLastName(scanner.nextLine());
            } else if (choise.equals("3") || choise.equals("p")) {
                user.setPesel();
                if (isThisInt("" + user.getYearOfBirth())) {
                    isLeapYear = isValidPESELyear(user.getYearOfBirth(), user);
                } else {
                    System.out.println("This is very wrong PESEL! ");
                    isLeapYear = false;
                }
            }
            System.out.println("You would like to add: ");
            System.out.println("User = " + user.toString());
            System.out.print("Is this correct? Press \"1\" or \"y\" if \"yes\". In \"no\" press anything else: ");
            String yesOrNo = scanner.nextLine().toLowerCase();
            if (yesOrNo.equals("1") || yesOrNo.equals("y")) {
                listOfNotActivatedUsers.add(user);
                break;
            } else {
                System.out.println("What would you like to change? ");
                System.out.println("Press \"1\" or \"n\" for name.");
                System.out.println("Press \"2\" or \"l\" for last name.");
                System.out.println("Press \"3\" or \"p\" for PESEL.");
                System.out.print("Your choise is: ");
                choise = scanner.nextLine().toLowerCase();
            }
        } while (isLeapYear);
    }

    public void activateAUser(List<User> user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("List of Users: ");
        for (int i = 0; i < user.size(); i++) {
            boolean isValidAge = isSomeoneAdult(user.get(i).getDateOfBirth(), 18);
            if (isValidAge) {
                System.out.println((i + 1) + ": " + user.get(i).getNameLastName() + " is adult.");
            } else {
                System.out.println((i + 1) + ": " + user.get(i).getNameLastName() + " is under legal age!");
            }
        }
        if (listOfNotActivatedUsers.isEmpty()) {
            System.out.println("List is empty! Add first users!");
        } else {
            System.out.print("Who you want to activate? Choose number: ");
            do {
                String choise = scanner.nextLine();
                if (isThisInt(choise)) {
                    int choiseInt = Integer.parseInt(choise);
                    if (choiseInt < 0 || choiseInt > listOfNotActivatedUsers.size()) {
                        System.out.println("User not available! Choose existing number: ");
                    } else {
                        //need to valid if customer is legal in age!
                        if (isSomeoneAdult(listOfNotActivatedUsers.get(choiseInt - 1).getDateOfBirth(),18)) {
                            listOfActivatedUsers.add(listOfNotActivatedUsers.get(choiseInt - 1));
                            listOfNotActivatedUsers.remove(choiseInt - 1);
                            System.out.println("List of activated users: ");
                            showListOfActivatedUsers();
                            break;
                        } else {
                            System.out.println("Chosen person is under legal age for driving car! Legal age is 18 years old!");
                            break;
                        }
                    }
                } else System.out.print("Try again. Who you want to activate? Choose number: ");
            } while (true);

        }
    }
}

