package carrental;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Car {
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

    public void setDateOfProduction(int year, int month, int day) {
        this.dateOfProduction = LocalDate.of(year, month, day);
    }

    public BigDecimal getRentalPriseForOneDay() {
        return rentalPriseForOneDay;
    }

    public void setRentalPriseForOneDay(double rentalPriseForOneDay) {
        this.rentalPriseForOneDay = BigDecimal.valueOf(rentalPriseForOneDay);
    }

    @Override
    public String toString() {
        return "Mark:'" + mark + '\'' +
                ", Model:'" + model + '\'' +
                ", Millage: " + millage +
                ", Date Of Production: " + dateOfProduction +
                ", Rental Prise For One Day: " + rentalPriseForOneDay + ";\n";
    }
}
