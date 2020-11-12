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
}
