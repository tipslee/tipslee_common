package com.jd.innovation.common.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by cdyuanlifei on 2016/7/27.
 */
public class DateUtilTest {
    @Test
    public void testIsSameWeek() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-E");
        for (int year = 1800; year < 2199; ++year) {
            calendar.set(year, Calendar.DECEMBER, 1);
            int maxDayOfMonth = calendar.getMaximum(Calendar.DAY_OF_MONTH);
            for (int day = 23; day <= maxDayOfMonth; ++day) {
                calendar.set(year, Calendar.DECEMBER, day);
                Date date1 = calendar.getTime();
                for (int day2 = 1; day2 <= 8; ++day2) {
                    calendar.set(year + 1, Calendar.JANUARY, day2);
                    Date date2 = calendar.getTime();
                    long diffDaysByCalendar = Math.abs(DateUtil.diffDaysByCalendar(date1, date2));
                    if (diffDaysByCalendar > 6) {
                        boolean result1 = DateUtil.isSameWeek(date1, date2);
                        boolean result2 = DateUtil.isSameWeek(date2, date1);
//                        System.out.println("date1: " + sdf.format(date1) + " | date2: " + sdf.format(date2) + " | "
//                                + result1 + " | vs " + result2 + " | diff " + diffDaysByCalendar);
                        assertFalse(result1);
                        assertFalse(result2);
                    } else {
                        boolean result1 = DateUtil.isSameWeek(date1, date2);
                        boolean result2 = DateUtil.isSameWeek(date2, date1);
                        System.out.println("date1: " + sdf.format(date1) + " | date2: " + sdf.format(date2) + " | "
                                + result1 + " | vs " + result2 + " | diff " + diffDaysByCalendar);
                        assertTrue(result1 == result2);
                    }

                }
            }
        }
    }
}