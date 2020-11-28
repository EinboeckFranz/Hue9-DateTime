package net.htlgrieskirchen.pos3.timeutil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeUtilPro {
    private int[] splitPositions = {4, 6, 8, 10, 12};
    private TimeUtilPro() {}

    // ########## LOCALDATE METHODS ##########
    public static LocalDate intToLocalDate(int date) {
        return stringToLocalDate(String.valueOf(date));
    }

    public static LocalDate longToLocalDate(long date) {
        return stringToLocalDate(String.valueOf(date));
    }
    
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    
    public static LocalDate calendarToLocalDate(Calendar date) {
        return LocalDate.ofInstant(date.toInstant(), date.getTimeZone().toZoneId());
    }

    private static LocalDate stringToLocalDate(String date) {
        return LocalDate.of(Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(4, 6)),
                Integer.parseInt(date.substring(6, 8)));
    }

    // ########## LOCALDATETIME METHODS ##########

    public static LocalDateTime intToLocalDateTime(int dateTime) {
        return longToLocalDateTime(dateTime * 100L);
    }
    
    public static LocalDateTime longToLocalDateTime(long dateTime) {
        String dateTimeString = String.valueOf(dateTime);
        return LocalDateTime.of(Integer.parseInt(dateTimeString.substring(0, 4)),
                Integer.parseInt(dateTimeString.substring(4, 6)),
                Integer.parseInt(dateTimeString.substring(6, 8)),
                Integer.parseInt(dateTimeString.substring(8, 10)),
                dateTimeString.length() > 10 ? Integer.parseInt(dateTimeString.substring(10, 12)) : 0);
    }
    
    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        return dateTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
    
    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        return LocalDateTime.ofInstant(dateTime.toInstant(), dateTime.getTimeZone().toZoneId());
    }

    // ########## INT METHODS ##########
    
    public static int localDateToInt(LocalDate date) {
        return Integer.parseInt(date.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    public static int localDateTimeToInt(LocalDateTime dateTime) {
        //Cannot add minutes -> To Long Integer
        return Integer.parseInt(dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHH")));
    }

    // ########## LONG METHODS ##########

    public static long localDateToLong(LocalDate date) {
        return ((long) date.getYear() * 10000) +
                ((long)date.getMonthValue() * 100) +
                ((long) date.getDayOfMonth());
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        return ((long) dateTime.getYear() * 100000000) +
                ((long) dateTime.getMonthValue() * 1000000) +
                ((long) dateTime.getDayOfMonth() * 10000) +
                ((long) dateTime.getHour() * 100) +
                ((long) dateTime.getMinute());
    }

    // ########## DATE METHODS ##########

    public static Date localDateToDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    // ########## CALENDAR METHODS ##########
    
    public static Calendar localDateToCalendar(LocalDate localDate) {
        Date date = localDateToDate(localDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        Date date = localDateTimeToDate(dateTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}