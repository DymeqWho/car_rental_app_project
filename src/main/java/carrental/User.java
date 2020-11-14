package carrental;

import java.time.LocalDate;

public class User {
    private String name;
    private String LastName;
    private long pesel;
    private LocalDate dateOfBirth;
    private int numberOfRentedCars;

    public User() {
    }

    public User(String name, String lastName, long pesel, LocalDate dateOfBirth, int numberOfRentedCars) {
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

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long pesel) {
        pesel = 04122700000L;
        long peselL = pesel/100000L;
        System.out.println("peselL = " + peselL);
        int year;
        if (peselL <= 1000000L) {
          long  yearL = 2000 + ((int) peselL % 100L);
          year = (int)yearL;
            System.out.println("year = " + year);
        } else {
            long yearDivider = 1000000000L;
            long monthDivider = 10000000L;
            long dayDivider = 100000L;
            long yearL = pesel / yearDivider;
            System.out.println("yearL = " + yearL);
            long monthL = (pesel - yearL * yearDivider) / monthDivider;
            long dayL = (pesel - yearL * yearDivider - monthL * monthDivider) / dayDivider;
            year = (int) yearL + 1900;
            if (monthL > 12) {
                monthL = monthL - 20;
                year = (int) yearL + 2000;
            }
            if (year == 1900) {
                year = 2000;
            }
            System.out.println("year = " + year);
            int month = (int) monthL;
            System.out.println("month = " + month);
            int day = (int) dayL;
            System.out.println("day = " + day);
        }
        //    this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public int getNumberOfRentedCars() {
        return numberOfRentedCars;
    }

    public void setNumberOfRentedCars(int numberOfRentedCars) {
        this.numberOfRentedCars = numberOfRentedCars;
    }
}
