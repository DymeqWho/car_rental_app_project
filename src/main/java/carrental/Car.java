package carrental;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Car extends UsefulMethods {
    private String mark;
    private String model;
    private int millage;
    private LocalDate dateOfProduction;
    private BigDecimal rentalPriseForOneDay;

    public Car() {
    }

    public Car(String mark, String model, int millage, LocalDate dateOfProduction, BigDecimal rentalPriseForOneDay) {
        this.mark = mark;
        this.model = model;
        this.millage = millage;
        this.dateOfProduction = dateOfProduction;
        this.rentalPriseForOneDay = rentalPriseForOneDay;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(Car car) {
        System.out.println("Let's set the date of production " + car.getMark() + " " + car.getModel() + ". ");
        System.out.print("Set year: ");
        String yearString = "Year";
        int year = checkIntNumberRange(1950, LocalDate.now().getYear(), yearString);
        System.out.print("Set number of month: ");
        String monthString = "Month";
        int month = checkIntNumberRange(1, 12, monthString);
        System.out.print("Set day: ");
        String dayString = "Day";
        int numberMaximumDayRange = getDaysInMonth(month, year);
        int day = checkIntNumberRange(1, numberMaximumDayRange, dayString);
        this.dateOfProduction = LocalDate.of(year, month, day);
    }

    public BigDecimal getRentalPriseForOneDay() {
        return rentalPriseForOneDay;
    }

    public void setRentalPriseForOneDay(double rentalPriseForOneDay) {

        this.rentalPriseForOneDay = BigDecimal.valueOf(rentalPriseForOneDay).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return " Mark:'" + mark + '\'' +
                ", Model:'" + model + '\'' +
                ", Millage: " + millage +
                ", Date of production: " + dateOfProduction +
                ", Rental prise for one day: " + rentalPriseForOneDay + ";";
    }

}
