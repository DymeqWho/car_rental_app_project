package carrental;

import java.util.Scanner;

public abstract class UsefulMethods {
    int checkIntNumberRange(int numberMinimumRange, String establishedStringValue) {
        do {
            int range = parseIntValidator();
            if (range < numberMinimumRange) {
                System.out.print(establishedStringValue + " must be greater or equal to " + numberMinimumRange + ": ");
            } else {
                return range;
            }
        } while (true);
    }

    int checkIntNumberRange(int numberMinimumRange, int numberMaximumRange, String establishedStringValue) {
        do {
            int range = parseIntValidator();
            if (range < numberMinimumRange || range > numberMaximumRange) {
                System.out.print(establishedStringValue + " must be greater or equal to " + numberMinimumRange + " and lower or equal to " + numberMaximumRange + ": ");
            } else {
                return range;
            }
        } while (true);
    }

    private int parseIntValidator() throws NumberFormatException {
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

    private double parseDoubleValidator() throws NumberFormatException {
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

    double checkDoubleNumberRange(double numberMinimumRange, String establishedStringValue) {
        do {
            double range = parseDoubleValidator();
            if (range < numberMinimumRange) {
                System.out.print(establishedStringValue + " must be greater or equal to " + numberMinimumRange + ": ");
            } else {
                return range;
            }
        } while (true);
    }

    private boolean isLeapYear(int year) {
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

}
