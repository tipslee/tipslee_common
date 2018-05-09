package com.jd.innovation.common.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cdyuanlifei on 2016/7/25.
 */
public class DateUtil {

    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    private static final String default_format = "yyyy-MM-dd HH:mm:ss";
    private static final String format_yyyy = "yyyy";
    private static final String format_yyyyMM = "yyyy-MM";
    private static final String format_yyyyMMdd = "yyyy-MM-dd";
    private static final String format_yyyyMMddHH = "yyyy-MM-dd HH";
    private static final String format_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
    private static final String format_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    public static final int SUNDAY = 7;

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    /**
     * 获取当前时间
     *
     * @return Date
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 获取年
     *
     * @param datetime
     * @return int
     */
    public static int getYear(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份中的对应日期
     *
     * @param datetime
     * @return int (1~31)
     */
    public static int getDayOfMonth(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取月份
     *
     * @param datetime
     * @return int (1~12)
     */
    public static int getMonthOfYear(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取星期
     *
     * @param datetime
     * @return int (1~7) 1-星期一，7-星期天
     */
    public static int getDayOfWeek(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day == 0) {
            day = SUNDAY;
        }
        return day;
    }

    /**
     * 获取datetime在一年中处于第几天
     *
     * @param datetime
     * @return int
     */
    public static int getDayOfYear(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取小时字段
     *
     * @param datetime
     * @return int(0~23)
     */
    public static int getHourField(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟字段
     *
     * @param datetime
     * @return int(0~59)
     */
    public static int getMinuteField(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取秒字段
     *
     * @param datetime
     * @return long
     */
    public static int getSecondField(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取毫秒字段
     *
     * @param datetime
     * @return long
     */
    public static int getMillisecondField(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * 获取一共有多少小天(不四舍五入)
     *
     * @param datetime
     * @return long
     */
    public static long getDays(Date datetime) {
        return datetime.getTime() / (24 * 3600 * 1000);
    }

    /**
     * 获取一共有多少小时(不四舍五入)
     *
     * @param datetime
     * @return long
     */
    public static long getHours(Date datetime) {
        return datetime.getTime() / (3600 * 1000);
    }

    /**
     * 获取一共有多少分钟(不四舍五入)
     *
     * @param datetime
     * @return long
     */
    public static long getMinutes(Date datetime) {
        return datetime.getTime() / (60 * 1000);
    }

    /**
     * 获取一共有多少秒(不四舍五入)
     *
     * @param datetime
     * @return long
     */
    public static long getSeconds(Date datetime) {
        return datetime.getTime() / 1000;
    }

    /**
     * 获取一共有多少毫秒(不四舍五入)
     *
     * @param datetime
     * @return long
     */
    public static long getMilliseconds(Date datetime) {
        return datetime.getTime();
    }

    /**
     * 获取输入的代表星期的datetime是一月中的第几周
     *
     * @param datetime
     * @return int
     */
    public static int getWeekOfMonth(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取输入的代表星期的datetime是一年中的第几周
     *
     * @param datetime
     * @return int
     */
    public static int getWeekOfYear(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取输入的代表月份的datetime包含多少天
     *
     * @param datetime
     * @return int
     */
    public static int getMaxDateOfMonth(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取输入的代表年的datetime包含多少天
     *
     * @param datetime
     * @return int
     */
    public static int getMaxDateOfYear(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取输入的代表月的datetime包含多少周
     *
     * @param datetime
     * @return int
     */
    public static int getMaxWeekOfMonth(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取输入的代表年的datetime包含多少周
     *
     * @param datetime
     * @return int
     */
    public static int getMaxWeekOfYear(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.getActualMaximum(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 根据传入的时间字符串返回对应的日期对象
     *
     * @param datetimeString 时间字符串，形如：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss 等
     * @param format         时间字符串对应的解析格式，刑如：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss 等
     * @return Date / null
     */
    public static Date toDatetime(String datetimeString, String format) {
        Date result = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            result = simpleDateFormat.parse(datetimeString);
        } catch (Exception e) {
            log.error("Fail to parse datetime.", e);
        }
        return result;
    }

    /**
     * 返回datetime的字符串形式，形如：yyyy-MM-dd HH:mm:ss
     *
     * @param datetime
     * @return String
     */
    public static String toString(Date datetime) {
        return toString(datetime, null);
    }

    /**
     * 返回datetime的字符串形式
     *
     * @param datetime 时间对象
     * @param format   格式，例如：yyyy-MM-dd HH:mm:ss 或 yyyy/MM/dd 等
     * @return String / null
     */
    public static String toString(Date datetime, String format) {
        String result = null;
        SimpleDateFormat simpleDateFormat = null;
        try {
            if (StringUtils.isNotBlank(format)) {
                simpleDateFormat = new SimpleDateFormat(format);
            } else {
                simpleDateFormat = new SimpleDateFormat(default_format);
            }
            result = simpleDateFormat.format(datetime);
        } catch (Exception e) {
            log.error("Fail to parse datetime.", e);
        }
        return result;
    }

    /**
     * datetime1 - datetime2 年之差
     *
     * @param datetime1
     * @param datetime2
     * @return int
     */
    public static int diffYears(Date datetime1, Date datetime2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime1);
        int month1 = calendar.get(Calendar.YEAR);
        calendar.setTime(datetime2);
        int month2 = calendar.get(Calendar.YEAR);
        return month1 - month2;
    }

    /**
     * datetime1 - datetime2 月之差
     *
     * @param datetime1
     * @param datetime2
     * @return int
     */
    public static int diffMonths(Date datetime1, Date datetime2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime1);
        int month1 = calendar.get(Calendar.MONTH);
        calendar.setTime(datetime2);
        int month2 = calendar.get(Calendar.MONTH);
        return month1 - month2;
    }

    /**
     * datetime1 - datetime2 天之差
     *
     * @param datetime1
     * @param datetime2
     * @return long
     */
    public static long diffDays(Date datetime1, Date datetime2) {
        return (datetime1.getTime() - datetime2.getTime()) / (24 * 3600 * 1000);
    }

    public static long diffDaysByCalendar(Date datetime1, Date datetime2) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format_yyyyMMdd);
            return diffDays(sdf.parse(sdf.format(datetime1)), sdf.parse(sdf.format(datetime2)));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * datetime1 - datetime2 时之差
     *
     * @param datetime1
     * @param datetime2
     * @return long
     */
    public static long diffHours(Date datetime1, Date datetime2) {
        return (datetime1.getTime() - datetime2.getTime()) / (3600 * 1000);
    }

    /**
     * datetime1 - datetime2 分之差
     *
     * @param datetime1
     * @param datetime2
     * @return long
     */
    public static long diffMiniutes(Date datetime1, Date datetime2) {
        return (datetime1.getTime() - datetime2.getTime()) / (60 * 1000);
    }

    /**
     * datetime1 - datetime2 秒之差
     *
     * @param datetime1
     * @param datetime2
     * @return long
     */
    public static long diffSeconds(Date datetime1, Date datetime2) {
        return (datetime1.getTime() - datetime2.getTime()) / (1000);
    }

    /**
     * datetime1 + datetime2
     *
     * @param datetime1
     * @param datetime2
     * @return Date
     */
    public static Date add(Date datetime1, Date datetime2) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(datetime1.getTime() + datetime2.getTime());
        return date;
    }

    /**
     * datetime1 - datetime2
     *
     * @param datetime1
     * @param datetime2
     * @return Date
     */
    public static Date minus(Date datetime1, Date datetime2) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(datetime1.getTime() - datetime2.getTime());
        return date;
    }

    /**
     * 判断时间顺序
     *
     * @param datetime1
     * @param datetime2
     * @return true - datetime1在datetime2之前
     */
    public static boolean isBefore(Date datetime1, Date datetime2) {
        return (datetime2.getTime() - datetime1.getTime()) > 0;
    }

    /**
     * 判断时间顺序
     *
     * @param datetime1
     * @param datetime2
     * @return true - datetime1在datetime2之前或相等
     */
    public static boolean isBeforeOrEqual(Date datetime1, Date datetime2) {
        return (datetime2.getTime() - datetime1.getTime()) >= 0;
    }

    /**
     * 判断时间顺序
     *
     * @param datetime1
     * @param datetime2
     * @return true - datetime1和datetime2相等
     */
    public static boolean equal(Date datetime1, Date datetime2) {
        return datetime2.getTime() == datetime1.getTime();
    }

    /**
     * 判断时间顺序
     *
     * @param datetime1
     * @param datetime2
     * @return true - datetime1在datetime2之后
     */
    public static boolean isAfter(Date datetime1, Date datetime2) {
        return (datetime2.getTime() - datetime1.getTime()) < 0;
    }

    /**
     * 判断时间顺序
     *
     * @param datetime1
     * @param datetime2
     * @return true - datetime1在datetime2之后或相等
     */
    public static boolean isAfterOrEqual(Date datetime1, Date datetime2) {
        return (datetime2.getTime() - datetime1.getTime()) <= 0;
    }

    /**
     * datetime + milliseconds，使用roll实现
     *
     * @param datetime
     * @param milliseconds
     * @return Date
     */
    public static Date addMilliseconds(Date datetime, int milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.roll(Calendar.MILLISECOND, milliseconds);
        return calendar.getTime();
    }

    /**
     * datetime + seconds，使用roll实现
     *
     * @param datetime
     * @param seconds
     * @return Date
     */
    public static Date addSeconds(Date datetime, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.roll(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    /**
     * datetime + minutes，使用roll实现
     *
     * @param datetime
     * @param minutes
     * @return Date
     */
    public static Date addMinutes(Date datetime, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.roll(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * datetime + hours，使用roll实现
     *
     * @param datetime
     * @param hours
     * @return Date
     */
    public static Date addHours(Date datetime, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.roll(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    /**
     * datetime + days，使用roll实现
     *
     * @param datetime
     * @param days
     * @return Date
     */
    public static Date addDays(Date datetime, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.roll(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * datetime + months，使用roll实现
     *
     * @param datetime
     * @param months
     * @return Date
     */
    public static Date addMonths(Date datetime, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.roll(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * 判断datetime1与datetime2是否是同一秒
     *
     * @param datetime1
     * @param datetime2
     * @return boolean
     */
    public static boolean isSameSecond(Date datetime1, Date datetime2) {
        SimpleDateFormat sdf = new SimpleDateFormat(format_yyyyMMddHHmmss);
        return sdf.format(datetime1).equals(sdf.format(datetime2));
    }

    /**
     * 判断datetime1与datetime2是否是同一分钟
     *
     * @param datetime1
     * @param datetime2
     * @return boolean
     */
    public static boolean isSameMinute(Date datetime1, Date datetime2) {
        SimpleDateFormat sdf = new SimpleDateFormat(format_yyyyMMddHHmm);
        return sdf.format(datetime1).equals(sdf.format(datetime2));
    }

    /**
     * 判断datetime1与datetime2是否是同一小时
     *
     * @param datetime1
     * @param datetime2
     * @return boolean
     */
    public static boolean isSameHour(Date datetime1, Date datetime2) {
        SimpleDateFormat sdf = new SimpleDateFormat(format_yyyyMMddHH);
        return sdf.format(datetime1).equals(sdf.format(datetime2));
    }

    /**
     * 判断datetime1与datetime2是否是同一天
     *
     * @param datetime1
     * @param datetime2
     * @return boolean
     */
    public static boolean isSameDay(Date datetime1, Date datetime2) {
        SimpleDateFormat sdf = new SimpleDateFormat(format_yyyyMMdd);
        return sdf.format(datetime1).equals(sdf.format(datetime2));
    }

    /**
     * 判断datetime1与datetime2是否是同一月
     *
     * @param datetime1
     * @param datetime2
     * @return boolean
     */
    public static boolean isSameMonth(Date datetime1, Date datetime2) {
        SimpleDateFormat sdf = new SimpleDateFormat(format_yyyyMM);
        return sdf.format(datetime1).equals(sdf.format(datetime2));
    }

    /**
     * 判断datetime1与datetime2是否是同一年
     *
     * @param datetime1
     * @param datetime2
     * @return boolean
     */
    public static boolean isSameYear(Date datetime1, Date datetime2) {
        SimpleDateFormat sdf = new SimpleDateFormat(format_yyyy);
        return sdf.format(datetime1).equals(sdf.format(datetime2));
    }

    /**
     * 判断datetime1与datetime2是否是同一周，星期一~星期天算一周，以星期天为间隔，星期天属于之前一周，星期一属于后一周
     *
     * @param datetime1
     * @param datetime2
     * @return boolean
     */
    public static boolean isSameWeek(Date datetime1, Date datetime2) {
        boolean result = false;
        int year1 = getYear(datetime1);
        int year2 = getYear(datetime2);
        int month1 = getMonthOfYear(datetime1);
        int month2 = getMonthOfYear(datetime2);
        int dayOfWeek1 = getDayOfWeek(datetime1);
        int dayOfWeek2 = getDayOfWeek(datetime2);
        long diffDays = diffDays(datetime1, datetime2);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //date1: 2998-12-30-星期日 | date2: 2999-01-01-星期二 | true | vs tru
        if (Math.abs(diffDays) < calendar.getMaximum(Calendar.DAY_OF_WEEK)) {// 时间相差超过1周
            if (year1 == year2) {
                if (getWeekOfYear(datetime1) == getWeekOfYear(datetime2)) {
                    result = true;
                }
            } else if (year1 - year2 == 1 && month1 == JANUARY && month2 == DECEMBER) {
                calendar.set(year1, Calendar.JANUARY, 1);
                int dayOfWeek = getDayOfWeek(calendar.getTime());
                if ((dayOfWeek2 < dayOfWeek) && (dayOfWeek <= dayOfWeek1)) {
                    result = true;
                }
            } else if (year2 - year1 == 1 && month1 == DECEMBER && month2 == JANUARY) {
                calendar.set(year2, Calendar.JANUARY, 1);
                int dayOfWeek = getDayOfWeek(calendar.getTime());
                if ((dayOfWeek1 < dayOfWeek) && (dayOfWeek <= dayOfWeek2)) {
                    result = true;
                }
            }// else {result = false;}
        }
        return result;
    }
}
