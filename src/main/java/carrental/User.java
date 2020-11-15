package carrental;

import java.time.LocalDate;
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


    public String getNameLastName() {
        return getName() + " " + getLastName();
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel() {
        Scanner scanner = new Scanner(System.in);
        boolean checking = false; //needed boolean for checking if PESEL has only 11 digits.
        boolean isThisGoodPesel = false; //needed for checking if PESEL is long enough and done by valid rules.
        int charPeselLenght = 0;
        char[] charPesel = null;

        //validating all PESEL special rules until they will be ok for setting only date of birth,
        // not until all digits will be legit by rule.
        do {
            //validating if PESEL has enough digits until it will be correct
            do {
                //putting PESEL for validating
                System.out.print("Set " + getNameLastName() + " PESEL: ");
                pesel = scanner.nextLine();
                //
                charPesel = pesel.toCharArray(); //changing PESEL for char array
                charPeselLenght = charPesel.length; //checking how long is car arry

                //checking if PESEL has only digits.
                for (char c : charPesel) {
                    if (c < 48 || c > 57) { //used ASCII table for digits only id.
                        System.out.println("this is not a PESEL! PESEL has only 11 digits!");
                        checking = false;
                        break;
                    } else {
                        checking = true;
                    }
                }
                //end of checking if PESEL has only digits. If it has only digits method will continue if not, it will
                // ask for putting 11 digits PESEL until it will has only digits.

                //validating if PESEL has 11 digits.
                if (checking) {
                    if (charPeselLenght == 11) {
                        this.pesel = pesel; //not necessary statement, but useful at least for me for code reading
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
            //end of validating if PESEL has only 11 digits. If everything is ok method will proceed.

            //acquisition of first 6 digits from PESEL, for setting date.
            String[] recoverNumberArry = new String[6];
            int[] intsArry = new int[6];
            for (int i = 0; i < charPeselLenght - 5; i++) {
                recoverNumberArry[i] = "" + charPesel[i]; //changing char array for String array
                intsArry[i] = Integer.parseInt(recoverNumberArry[i]); //reading ints from parsed String array
            }

            boolean itsOver1999 = false; //after year 1999 there are special rules for righting month digits.
            // I need to check this.
            boolean itIsValidPESEL = false; //month digits are key for validation all date of birth. They are also
            // (in this case) validating if all PESEL is correct.

            boolean wrongYear = false; //I need to check if set year digits are correct
            boolean wrongMonth = false; //I need to check if set month digits are correct
            boolean wrongDay = false; //I need to check if set day is correct

            //getting digits responsible for month in PESEL. Digits number 3 and 4.
            int month = intsArry[2] * 10 + intsArry[3];

            //I need to check if PESEL is not from future. In this case I check what year, month and day is
            // when this method is running
            Date dateForCurrentMonth = new Date();
            LocalDate localDate = dateForCurrentMonth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int currentMonth = localDate.getMonthValue();
            int currentYear = localDate.getYear();
            int currentDay = localDate.getDayOfMonth();

            //validating of month in PESEL if everything is ok, month will be set to DateOfBirth variable.
            if (month > 0 && month < 13) { //checking if this month is from 1900 - 1999
                itIsValidPESEL = true;
                isThisGoodPesel = true;
                this.monthOfBirth = month;
            } else if (month > 12 && month < 33) { //checking if this month is over 2000
                month -= 20;
                itsOver1999 = true;
                itIsValidPESEL = true;
                this.monthOfBirth = month;
                isThisGoodPesel = true;
            } else if (month > currentMonth && (currentYear >= yearOfBirth || currentYear == 0)) {
                wrongMonth = true;
                this.monthOfBirth = 0;
            }
            //if everything is ok, method will proceed. If not, user will be asked for putting correct PESEL
            // and all procedure will be checked from beginning.

            //checking what year is in first and second digits in PESEL covered.
            if (itIsValidPESEL) { //this will happen only when month in PESEL is correct.

                int year = intsArry[0] * 10 + intsArry[1]; //get first and second digits form PESEL for year.

                if (year <= LocalDate.now().getYear() && year >= 0 && itsOver1999) { //situation when year is over 1999
                    year += 2000;
                } else {                                                              //situation when year is 1900+
                    year += 1900;
                }
                this.yearOfBirth = year; //if year digits in PESEL are valid, this will be year of persons birth.
                isThisGoodPesel = true;
                if (year > currentYear) {
                    wrongYear = true;
                    this.yearOfBirth = 0;
                    isThisGoodPesel = false;
                }
                //if everything is ok, method will proceed, if not all method will start from beginning.

                int day = intsArry[4] * 10 + intsArry[5]; // getting fifth and sixth digits responsible for day in PESEL

                //validating if day in PESEL is correct.
                if (getDaysInMonth(this.monthOfBirth, this.yearOfBirth) >= day && isThisGoodPesel) { //checking if it is
                    //leap year and how many max days is in month covered in PESEL.
                    // Used method for this is in class UsefullMethods.
                    this.dayOfBirth = day;
                    isThisGoodPesel = true;
                } else if (currentDay > day && isThisGoodPesel) {
                    isThisGoodPesel = false;
                    wrongDay = true;
                }
            }
            //if everything is ok, method will end.

            //if something is wrong with year or month or day of birth this will show on screen
            // and method will run from beginning
            if (yearOfBirth == 0 || monthOfBirth == 0 || dayOfBirth == 0) {
                if (wrongYear || yearOfBirth == 0)
                    System.out.println("This is invalid PESEL! Wrong at least first or second digit.");
                if (wrongMonth || monthOfBirth == 0)
                    System.out.println("This is invalid PESEL! Wrong at least third or fourth digit.");
                if (wrongDay || dayOfBirth == 0)
                    System.out.println("This is invalid PESEL! Wrong at least fifth or sixth digit.");
                isThisGoodPesel = false;
            }

        } while (!isThisGoodPesel); //this is for looping method until everything will be correct
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

    @Override
    public String toString() {
        return " Name: '" + name + '\'' +
                ", LastName: '" + LastName + '\'' +
                ", PESEL: '" + pesel + '\'' +
                ", Date of birth: " + dateOfBirth;
    }
}
