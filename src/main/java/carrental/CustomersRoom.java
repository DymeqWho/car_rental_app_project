package carrental;

import java.util.*;

public class CustomersRoom {
    private List<User> listOfNotActivatedUsers = new ArrayList<>();
    private List<User> listOfActivatedUsers = new ArrayList<>();

    public CustomersRoom() {
    }

    public List<User> getListOfNotActivatedUsers() {
        return listOfNotActivatedUsers;
    }

    public List<User> getListOfActivatedUsers() {
        System.out.println("List of active users: ");
        if (listOfActivatedUsers.isEmpty()) {
            System.out.println("Is empty!");
        }
        return listOfActivatedUsers;
    }

    public void addUserToListOfNotActivatedUsers() {
        System.out.println("Add new, not yet active user. ");
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.print("Set users name: ");
        user.setName(scanner.nextLine());
        System.out.print("Set " + user.getName() + " last name: ");
        user.setLastName(scanner.nextLine());
        System.out.print("Set " + user.getNameLastName() + " PESEL: ");
        user.setPesel();
        user.setDateOfBirth(user.getYearOfBirth(), user.getMonthOfBirth(), user.getDayOfBirth());

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
                user.setDateOfBirth(user.getYearOfBirth(), user.getMonthOfBirth(), user.getDayOfBirth());
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
        } while (true);
    }

    public void activateAUser(List<User> user) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> mapOfNotActiveUsers = new HashMap<>();
        for (int i = 0; i < user.size(); i++) {
            mapOfNotActiveUsers.put(i + 1, user.get(i).getNameLastName());
        }
        if (mapOfNotActiveUsers.isEmpty()) {
            System.out.println("List is empty! Add first users!");
        } else {
            System.out.println("List of Users: ");
            //System.out.println(mapOfNotActiveUsers.toString().replace("=", ": "));
            for (int i = 1; i < mapOfNotActiveUsers.size() + 1; i++) {
                System.out.println(i + ": " + mapOfNotActiveUsers.get(i));
            }
            System.out.print("Who you want to activate? Choose number: ");
            String choise = scanner.nextLine();
            int choiseInt = Integer.parseInt(choise);
//            for (int i = 1; i < mapOfNotActiveUsers.size() + 1; i++){
//                if(choiseInt == i){
//                    listOfActivatedUsers = mapOfNotActiveUsers.get(i);
//                }
        }
    }

}

