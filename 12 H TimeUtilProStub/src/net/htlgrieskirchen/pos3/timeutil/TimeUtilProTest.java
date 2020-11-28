package net.htlgrieskirchen.pos3.timeutil;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TimeUtilProTest {
    private final LocalDate birthdayLocalDate = LocalDate.of(2004, 7, 27);
    private final LocalDateTime birthdayLocalDateTime = LocalDateTime.of(2004, 7, 27, 16, 0);
    private static Calendar calendar = Calendar.getInstance();
    private static Calendar calenderWithTime = Calendar.getInstance();

    @BeforeAll
    static void beforeAll() {
        calendar.clear();
        calendar.set(2004, Calendar.JULY, 27);
        calenderWithTime.clear();
        calenderWithTime.set(2004, Calendar.JULY, 27, 16, 0);
    }

    @Test
    void intToLocalDate() {
        assertEquals(birthdayLocalDate, TimeUtilPro.intToLocalDate(20040727));
    }

    @Test
    void longToLocalDate() {
        assertTrue(birthdayLocalDate.isEqual(TimeUtilPro.longToLocalDate(20040727L)));
    }

    @Test
    void dateToLocalDate() {
        assertTrue(birthdayLocalDate.isEqual(TimeUtilPro.dateToLocalDate(new Date(104, Calendar.JULY, 27))));
    }

    @Test
    void calendarToLocalDate() {
        assertEquals(birthdayLocalDate, TimeUtilPro.calendarToLocalDate(calendar));
    }

    @Test
    void intToLocalDateTime() {
        assertTrue(birthdayLocalDateTime.isEqual(TimeUtilPro.intToLocalDateTime(2004072716)));
    }

    @Test
    void longToLocalDateTime() {
        assertTrue(birthdayLocalDateTime.isEqual(TimeUtilPro.longToLocalDateTime(2004072716L)));
    }

    @Test
    void dateToLocalDateTime() {
        assertTrue(birthdayLocalDateTime.isEqual(TimeUtilPro.dateToLocalDateTime(new Date(104, Calendar.JULY, 27, 16, 0))));
    }

    @Test
    void calendarToLocalDateTime() {
        assertEquals(birthdayLocalDateTime, TimeUtilPro.calendarToLocalDateTime(calenderWithTime));
    }

    @Test
    void localDateToInt() {
        assertEquals(TimeUtilPro.localDateToInt(birthdayLocalDate), 20040727);
    }

    @Test
    void localDateToLong() {
        assertEquals(TimeUtilPro.localDateToLong(birthdayLocalDate), 20040727L);
    }

    @Test
    void localDateToDate() {
        assertEquals(TimeUtilPro.localDateToDate(birthdayLocalDate), new Date(104, Calendar.JULY, 27));
    }

    @Test
    void localDateToCalendar() {
        assertEquals(calendar, TimeUtilPro.localDateToCalendar(birthdayLocalDate));
    }

    @Test
    void localDateTimeToInt() {
        assertEquals(2004072716, TimeUtilPro.localDateTimeToInt(birthdayLocalDateTime));
    }

    @Test
    void localDateTimeToLong() {
        assertEquals(200407271600L, TimeUtilPro.localDateTimeToLong(birthdayLocalDateTime));
    }

    @Test
    void localDateTimeToDate() {
        assertEquals(TimeUtilPro.localDateTimeToDate(birthdayLocalDateTime), new Date(104, Calendar.JULY, 27, 16, 0));
    }

    @Test
    void localDateTimeToCalendar() {
        assertEquals(TimeUtilPro.localDateTimeToCalendar(birthdayLocalDateTime), calenderWithTime);
    }
}