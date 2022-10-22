package model;

import java.time.LocalDate;

public class Date {

    private LocalDate today;
    private int day, month, year;

    public Date() {
        today = LocalDate.now();
        this.day = today.getDayOfMonth();
        this.month = today.getMonthValue();
        this.year = today.getYear();
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(LocalDate date) {
        this.today = date;
    }
    public LocalDate now() {

        this.today = LocalDate.now();
        return today;
    }

    public void plusYears(int years) {
        this.today = today.plusYears(years);
    }

    public void plusMonths(int months) {
        this.today = today.plusMonths(months);
    }

    public void plusDays(int days) {
        this.today = today.plusDays(days);
    }

     public LocalDate getToday( ) {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public int getDay( ) {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth( ) {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear( ) {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString( ) {
        return "date{" +
                "today=" + today +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

}
