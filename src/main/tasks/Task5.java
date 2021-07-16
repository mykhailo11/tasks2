package main.tasks;

import java.math.BigInteger;

public class Task5 {

    private static final int DAYS_PER_WEEK = 7;
    private static final int MONTHS_PER_YEAR = 12;
    private enum DAYS_PER_MONTH{
        FULL(31),
        FOURWEEKS(28),
        OTHER(30);
        private final int days;
        DAYS_PER_MONTH(int days){
            this.days = days;
        }
        public int getDays(){
            return days;
        }
    }
    private enum Months{
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;
        public static Months getMonth(int num){
            switch(num){
                case 1:
                return FEBRUARY;
                case 2:
                return MARCH;
                case 3:
                return APRIL;
                case 4:
                return MAY;
                case 5:
                return JUNE;
                case 6:
                return JULY;
                case 7:
                return AUGUST;
                case 8:
                return SEPTEMBER;
                case 9:
                return OCTOBER;
                case 10:
                return NOVEMBER;
                case 11:
                return DECEMBER;
                default:
                case 0:
                return JANUARY;
            }
        }
    }

    private Task5() { }
    public static BigInteger evaluateWeekDay(BigInteger weekday){
        return weekday.abs().mod(BigInteger.valueOf(DAYS_PER_WEEK));
    }
    public static BigInteger evaluateMonth(BigInteger month){
        return month.abs().mod(BigInteger.valueOf(MONTHS_PER_YEAR));
    }
    public static BigInteger evaluateMonthDay(BigInteger monthDay, BigInteger month){
        switch (Months.getMonth(month.intValue())){
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return monthDay.abs().mod(BigInteger.valueOf(DAYS_PER_MONTH.FULL.getDays()));
            case FEBRUARY:
                return monthDay.abs().mod(BigInteger.valueOf(DAYS_PER_MONTH.FOURWEEKS.getDays()));
            default:
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return monthDay.abs().mod(BigInteger.valueOf(DAYS_PER_MONTH.OTHER.getDays()));
        }
    }
    /**
     * @param newYearWeekDay - number of the week day for the first of January in the common year
     * @param monthDay - desired day number of the month
     * @param month - desired month number
     * @return - number of the week day that corresponds to the specified data
     */
    public static BigInteger getWeekDayOf(BigInteger newYearWeekDay, BigInteger monthDay, BigInteger month) throws IllegalArgumentException{
        newYearWeekDay = evaluateWeekDay(newYearWeekDay);
        month = evaluateMonth(month);
        monthDay = evaluateMonthDay(monthDay, month);
        switch (Months.getMonth(month.intValue())){
            case JANUARY:
            case OCTOBER:
                return newYearWeekDay.add(BigInteger.valueOf(0)).mod(BigInteger.valueOf(7)).add(monthDay.mod(BigInteger.valueOf(7))).mod(BigInteger.valueOf(7));
            case FEBRUARY:
            case MARCH:
            case NOVEMBER:
                return newYearWeekDay.add(BigInteger.valueOf(3)).mod(BigInteger.valueOf(7)).add(monthDay.mod(BigInteger.valueOf(7))).mod(BigInteger.valueOf(7));
            case APRIL:
            case JULY:
                return newYearWeekDay.add(BigInteger.valueOf(6)).mod(BigInteger.valueOf(7)).add(monthDay.mod(BigInteger.valueOf(7))).mod(BigInteger.valueOf(7));
            case MAY:
                return newYearWeekDay.add(BigInteger.valueOf(1)).mod(BigInteger.valueOf(7)).add(monthDay.mod(BigInteger.valueOf(7))).mod(BigInteger.valueOf(7));
            case AUGUST:
                return newYearWeekDay.add(BigInteger.valueOf(2)).mod(BigInteger.valueOf(7)).add(monthDay.mod(BigInteger.valueOf(7))).mod(BigInteger.valueOf(7));
            case JUNE:
                return newYearWeekDay.add(BigInteger.valueOf(4)).mod(BigInteger.valueOf(7)).add(monthDay.mod(BigInteger.valueOf(7))).mod(BigInteger.valueOf(7));
            case SEPTEMBER:
            case DECEMBER:
                return newYearWeekDay.add(BigInteger.valueOf(5)).mod(BigInteger.valueOf(7)).add(monthDay.mod(BigInteger.valueOf(7))).mod(BigInteger.valueOf(7));
            default:
                return BigInteger.ZERO;
        }
    }
}
