package carrental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Bookkeeping {
    private int numberOfRentals;
    private LocalDate actualDate;
    private List<Bookkeeping> listOfOperations = new ArrayList<>();
    private BigDecimal income;

    public Bookkeeping() {
    }

    public Bookkeeping(int numberOfRentals, LocalDate actualDate, BigDecimal income) {
        this.numberOfRentals = numberOfRentals;
        this.actualDate = actualDate;
        this.income = income;
    }

    public int getNumberOfRentals() {
        return numberOfRentals;
    }

    public void setNumberOfRentals(int numberOfRentals) {
        this.numberOfRentals = numberOfRentals;
    }

    public LocalDate getActualDate() {
        return actualDate;
    }

    public void setActualDate(LocalDate actualDate) {
        this.actualDate = actualDate;
    }

    public List<Bookkeeping> getListOfOperations() {
        if (listOfOperations.isEmpty()) {
            System.out.println("List is empty!");
        }
        return listOfOperations;
    }

    public void setListOfOperations(List<Bookkeeping> listOfOperations) {
        this.listOfOperations = listOfOperations;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public void showListOfAllOperationsInMonth() {
        if (listOfOperations.isEmpty()) {
            System.out.println("List of operations is empty!");
        } else {
            Month month = null;
            BigDecimal income = BigDecimal.ZERO;
            int numberOfOperations = 0;
            for (int i = 0; i < listOfOperations.size(); i++) {
                month = listOfOperations.get(i).getActualDate().getMonth();
                income = income.add(listOfOperations.get(i).getIncome());
                numberOfOperations += listOfOperations.get(i).getNumberOfRentals();
            }
            System.out.println("Year " + LocalDate.now().getYear());
            System.out.println("Earnings in month: " + month + " Total income: " + income
                    + " Number of operations: " + numberOfOperations);
        }
    }

    public void showListOfAllOperationsInYear() {
        System.out.println("Year " + LocalDate.now().getYear() + " summary: ");
        if (listOfOperations.isEmpty()) {
            System.out.println("List of operations is empty!");
        } else {
            Month month = null;
            BigDecimal income = BigDecimal.ZERO;
            int numberOfOperations = 0;

            String january = "Ernings for " + Month.JANUARY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String february = "Earnings for " + Month.FEBRUARY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String march = "Earnings for " + Month.MARCH + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String april = "Earnings for " + Month.APRIL + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String may = "Earnings for " + Month.MAY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String june = "Earnings for " + Month.JUNE + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String july = "Earnings for " + Month.JULY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String august = "Earnings for " + Month.AUGUST + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String september = "Earnings for " + Month.SEPTEMBER + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String october = "Earnings for " + Month.OCTOBER + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            String november = "Earnings for " + Month.NOVEMBER + ":   Total number of rentals: " + numberOfOperations + " Income: " + income;
            String december = "Earnings for " + Month.DECEMBER + ": Total number of rentals: " + numberOfOperations + " Income: " + income;

            for (Bookkeeping bookkeeping : listOfOperations) {
                month = bookkeeping.getActualDate().getMonth();
                income = income.add(bookkeeping.getIncome());
                numberOfOperations += bookkeeping.getNumberOfRentals();
            }

            if (month == Month.JANUARY) {
                january = "Earnings for " + Month.JANUARY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.FEBRUARY) {
                february = "Earnings for " + Month.FEBRUARY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.MARCH) {
                march = "Earnings for " + Month.MARCH + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.APRIL) {
                april = "Earnings for " + Month.APRIL + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.MAY) {
                may = "Earnings for " + Month.MAY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.JUNE) {
                june = "Earnings for " + Month.JUNE + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.JULY) {
                july = "Earnings for " + Month.JULY + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.AUGUST) {
                august = "Earnings for " + Month.AUGUST + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.SEPTEMBER) {
                september = "Earnings for " + Month.SEPTEMBER + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.OCTOBER) {
                october = "Earnings for " + Month.OCTOBER + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.NOVEMBER) {
                november = "Earnings for " + Month.NOVEMBER + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }

            if (LocalDate.now().getMonth() == Month.DECEMBER) {
                december = "Earnings for " + Month.DECEMBER + ": Total number of rentals: " + numberOfOperations + " Income: " + income;
            }
            System.out.println(january);
            System.out.println(february);
            System.out.println(march);
            System.out.println(april);
            System.out.println(may);
            System.out.println(june);
            System.out.println(july);
            System.out.println(august);
            System.out.println(september);
            System.out.println(october);
            System.out.println(november);
            System.out.println(december);
        }
    }
}

