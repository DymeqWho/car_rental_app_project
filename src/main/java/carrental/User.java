package carrental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class User extends UsefulMethods {
    private String name;
    private String LastName;
    private String pesel;
    private LocalDate dateOfBirth;
    private int numberOfRentedCars;
    private int yearOfBirth;
    private int monthOfBirth;
    private int dayOfBirth;
    private String nameLastName = getName() + " " + getLastName();

    public User() {
    }

    public User(String name, String lastName, String pesel, LocalDate dateOfBirth, int numberOfRentedCars) {
        this.name = name;
        LastName = lastName;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.numberOfRentedCars = numberOfRentedCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel() {
        Scanner scanner = new Scanner(System.in);
        boolean checking = false;
        boolean isThisGoodPesel = false;
        int charPeselLenght = 0;
        char[] charPesel = null;

        do {
            do {
                System.out.print("Set " + nameLastName + " PESEL: ");
                pesel = scanner.nextLine();
                charPesel = pesel.toCharArray();
                charPeselLenght = charPesel.length;

                for (char c : charPesel) {
                    if (c < 48 || c > 57) {
                        System.out.println("this is not a PESEL!");
                        checking = false;
                        break;
                    } else {
                        checking = true;
                    }
                }

                if (checking) {
                    if (charPeselLenght == 11) {
                        this.pesel = pesel;
                        checking = true;
                        isThisGoodPesel = true;
                    } else if (charPeselLenght < 11) {
                        int miss = 11 - charPeselLenght;
                        if (miss > 1) {
                            System.out.println("PESEL number is too short! " + miss + " digits are missing.");
                        } else {
                            System.out.println("PESEL number is too short! " + miss + " digit is missing.");
                        }
                        checking = false;
                        isThisGoodPesel = false;
                    } else {
                        int miss = charPeselLenght - 11;
                        if (miss > 1) {
                            System.out.println("PESEL number is too long! " + "Delete " + miss + " digits.");
                        } else {
                            System.out.println("PESEL number is too long! " + "Delete " + miss + " digit.");
                        }
                        checking = false;
                        isThisGoodPesel = false;
                    }

                }
            } while (!checking);

            String[] recoverNumberArry = new String[6];
            int[] intsArry = new int[6];
            for (int i = 0; i < charPeselLenght - 5; i++) {
                recoverNumberArry[i] = "" + charPesel[i];
                intsArry[i] = Integer.parseInt(recoverNumberArry[i]);
            }

            int month = intsArry[2] * 10 + intsArry[3];

            boolean itsOver1999 = false;
            boolean itIsValidPESEL = false;

            boolean wrongYear = false;
            boolean wrongMonth = false;
            boolean wrongDay = false;

            Date dateForCurrentMonth = new Date();
            LocalDate localDate = dateForCurrentMonth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int currentMonth = localDate.getMonthValue();
            int currentYear = localDate.getYear();

            if (month > 0 && month < 13) {
                itIsValidPESEL = true;
                isThisGoodPesel = true;
                this.monthOfBirth = month;
            } else if (month > 12 && month < 33) {
                month -= 20;
                itsOver1999 = true;
                itIsValidPESEL = true;
                this.monthOfBirth = month;
                isThisGoodPesel = true;
            }
            if (month > currentMonth && (currentYear >= yearOfBirth || currentYear == 0)) { //CHECKING
                wrongMonth = true;
//                System.out.println("This is invalid PESEL! Wrong at least third or fourth digit.");
                this.monthOfBirth = 0;
            }

            if (itIsValidPESEL) {
                int year = intsArry[0] * 10 + intsArry[1];
                if (year <= LocalDate.now().getYear() && year >= 0 && itsOver1999) {
                    year += 2000;
                } else {
                    year += 1900;
                }
                this.yearOfBirth = year;
                isThisGoodPesel = true;
                if (year > currentYear) {
                    wrongYear = true;
//                    System.out.println("This is invalid PESEL! Wrong at least first or second digit.");
                    this.yearOfBirth = 0;
                    isThisGoodPesel = false;
                }

                int day = intsArry[4] * 10 + intsArry[5];
                if (getDaysInMonth(this.monthOfBirth, this.yearOfBirth) >= day && isThisGoodPesel) {
                    this.dayOfBirth = day;
                    isThisGoodPesel = true;
                } else {
                    isThisGoodPesel = false;
                }
                int currentDay = localDate.getDayOfMonth();
                if (day > currentDay && (currentYear >= yearOfBirth || currentYear == 0)) {
                    wrongDay = true;
//                    System.out.println("This is invalid PESEL! Wrong at least fifth or sixth digit.");
                    isThisGoodPesel = false;
                }
            }
            if (yearOfBirth == 0 || monthOfBirth == 0 || dayOfBirth == 0) {
                if(wrongYear)
                    System.out.println("This is invalid PESEL! Wrong at least first or second digit.");
                if(wrongMonth)
                    System.out.println("This is invalid PESEL! Wrong at least third or fourth digit.");
                if(wrongDay)
                    System.out.println("This is invalid PESEL! Wrong at least fifth or sixth digit.");
                isThisGoodPesel = false;
            }
        } while (!isThisGoodPesel);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public int getNumberOfRentedCars() {
        return numberOfRentedCars;
    }

    public void setNumberOfRentedCars(int numberOfRentedCars) {
        this.numberOfRentedCars = numberOfRentedCars;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }
}
