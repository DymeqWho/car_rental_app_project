package carrental;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class UsefulMethods {
    public int checkIntNumberRange(int numberMinimumRange, String establishedStringValue) {
        do {
            int range = parseIntValidator();
            if (range < numberMinimumRange) {
                System.out.print(establishedStringValue + " must be greater or equal to " + numberMinimumRange + ": ");
            } else {
                return range;
            }
        } while (true);
    }

    public int checkIntNumberRange(int numberMinimumRange, int numberMaximumRange, String establishedStringValue) {
        do {
            int range = parseIntValidator();
            if (range < numberMinimumRange || range > numberMaximumRange) {
                System.out.print(establishedStringValue + " must be greater or equal to " + numberMinimumRange + " and lower or equal to " + numberMaximumRange + ": ");
            } else {
                return range;
            }
        } while (true);
    }

    public int parseIntValidator() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        String intForPars = scanner.nextLine();
        int parsedInt = -1;
        boolean t = false;
        do {
            try {
                parsedInt = Integer.parseInt(intForPars);
                if (parsedInt >= 0) {
                    t = true;
                    return parsedInt;
                } else {
                    t = false;
                }
            } catch (NumberFormatException exception) {
                System.out.print("This is not a number! Pick a number: ");
                t = true;
                intForPars = scanner.nextLine();
            }
        }
        while (t);
        return parsedInt;
    }

    public double parseDoubleValidator() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        String intForPars = scanner.nextLine();
        double parsedInt = -1.0;
        boolean t = false;
        do {
            try {
                parsedInt = Double.parseDouble(intForPars);
                if (parsedInt >= 0) {
                    t = true;
                    return parsedInt;
                } else {
                    t = false;
                }
            } catch (NumberFormatException exception) {
                System.out.print("This is not a number! Pick a number: ");
                t = true;
                intForPars = scanner.nextLine();
            }
        }
        while (t);
        return parsedInt;
    }

    public double checkDoubleNumberRange(double numberMinimumRange, String establishedStringValue) {
        do {
            double range = parseDoubleValidator();
            if (range < numberMinimumRange) {
                System.out.print(establishedStringValue + " must be greater or equal to " + numberMinimumRange + ": ");
            } else {
                return range;
            }
        } while (true);
    }

    public boolean isLeapYear(int year) {
        if (year > 0 && year <= 9999) {
            boolean isBy4 = year % 4 == 0;
            boolean isBy100 = year % 100 == 0;
            boolean isBy400 = year % 400 == 0;
            if (isBy4 || isBy100) {
                if (isBy100) {
                    return isBy400;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int getDaysInMonth(int month, int year) {
        if (month == 1) {
            return 31;
        }
        if (month == 2 && isLeapYear(year)) {
            return 29;
        } else if (month == 2 && !isLeapYear(year)) {
            return 28;
        }
        if (month == 3) {
            return 31;
        }
        if (month == 4) {
            return 30;
        }
        if (month == 5) {
            return 31;
        }
        if (month == 6) {
            return 30;
        }
        if (month == 7) {
            return 31;
        }
        if (month == 8) {
            return 31;
        }
        if (month == 9) {
            return 30;
        }
        if (month == 10) {
            return 31;
        }
        if (month == 11) {
            return 30;
        }
        if (month == 12) {
            return 31;
        }
        return -1;
    }

    public final boolean isThisInt(String string) {
        boolean isThisInt = false;
        char[] charArry = string.toCharArray();
        for (char c : charArry) {
            if (c < 48 || c > 57) {
                System.out.print("This is not a number! ");
                isThisInt = false;
                break;
            } else isThisInt = true;
        }
        return isThisInt;
    }

    public boolean isValidPESELyear(int year, User user) {
        if (isLeapYear(year)) {
            if (user.getMonthOfBirth() == 2 && user.getDayOfBirth() < 30) {
                user.setDateOfBirth(user.getYearOfBirth(), user.getMonthOfBirth(), user.getDayOfBirth());
                return true;
            } else if (user.getMonthOfBirth() != 2) {
                user.setDateOfBirth(user.getYearOfBirth(), user.getMonthOfBirth(), user.getDayOfBirth());
                return true;
            } else {
                System.out.println("This is not valid year! ");
                return false;
            }
        }
        if (!isLeapYear(year)) {
            if (user.getMonthOfBirth() == 2 && user.getDayOfBirth() < 29) {
                user.setDateOfBirth(user.getYearOfBirth(), user.getMonthOfBirth(), user.getDayOfBirth());
                return true;
            } else if (user.getMonthOfBirth() != 2) {
                user.setDateOfBirth(user.getYearOfBirth(), user.getMonthOfBirth(), user.getDayOfBirth());
                return true;
            } else {
                System.out.println("***************************  This is not valid day in this year! ***************************");
                return false;
            }
        }
        return false;
    }


    public boolean isValidPESELyear(int year, int month, int day) {
        if (isLeapYear(year)) {
            if (month == 2 && day < 30) {
                return true;
            } else if (month != 2) {
                return true;
            } else {
                System.out.println("***************************  I think you have made a grate mistake with this date! ***************************");
                return false;
            }
        }
        if (!isLeapYear(year)) {
            if (month == 2 && day < 29) {
                return true;
            } else if (month != 2) {
                return true;
            } else {
                System.out.println("***************************  This is not valid day in this year! ***************************");
                return false;
            }
        }
        return false;
    }

    public boolean isSomeoneAdult(LocalDate interestingLocalDate) {
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();
        int monthNow = now.getMonthValue();
        int dayNow = now.getDayOfMonth();
        int interestingYear = interestingLocalDate.getYear();
        int interestingMonth = interestingLocalDate.lengthOfMonth();
        int interestingDay = interestingLocalDate.getDayOfMonth();
        if ((dayNow - interestingDay <= 0 && monthNow - interestingMonth <= 0) || dayNow - interestingDay >= 0 ) {
            if (monthNow - interestingMonth <= 0) {
                return yearNow - interestingYear >= 18;
            }
        }
        return false;
    }
}
