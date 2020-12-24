package com.crm.commun.tools;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateTools {
    public static final String EMPTY = "";
    public static final String FORMAT_YYYYMMDD = "YYYY-MM-DD";
    public static final String FORMAT_YYYYMMDDHH = "YYYY-MM-DD-HH";
    public static final String FORMAT_YYYYMMDDMM = "YYYY-MM-DD-HH-MM";
    public static final String FORMAT_YYYYMMDDMMSS = "YYYY-MM-DD-HH-MM-SS";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * isSameday
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameday(Date d1, Date d2) {
        Calendar cd1 = Calendar.getInstance();
        Calendar cd2 = Calendar.getInstance();
        cd1.setTime(d1);
        cd2.setTime(d2);
        String ds1 = cd1.get(Calendar.DAY_OF_MONTH) +EMPTY+ cd1.get(Calendar.MONTH) +EMPTY+ cd1.get(Calendar.YEAR);
        String ds2 = cd2.get(Calendar.DAY_OF_MONTH) +EMPTY+ cd2.get(Calendar.MONTH) +EMPTY+ cd2.get(Calendar.YEAR);
        return ds1.equals(ds2);
    }

    public static boolean before(Date d1,Date d2, String format) {
        Calendar cd1 = Calendar.getInstance();
        Calendar cd2 = Calendar.getInstance();
        cd1.setTime(d1);
        cd2.setTime(d2);
        int ds1 = cd1.get(Calendar.YEAR) + cd1.get(Calendar.MONTH) + cd1.get(Calendar.DAY_OF_MONTH);
        int ds2 = cd2.get(Calendar.YEAR) + cd2.get(Calendar.MONTH) + cd2.get(Calendar.DAY_OF_MONTH);
        return ds1 < ds2;
    }

    public static boolean before(LocalDate d1,LocalDate d2, String format) {
        return d1.isBefore(d2);
    }
    public static boolean after(LocalDate d1,LocalDate d2, String format) {
        return d1.isAfter(d2);
    }
    public static boolean after(Date d1,Date d2, String format) {
        Calendar cd1 = Calendar.getInstance();
        Calendar cd2 = Calendar.getInstance();
        cd1.setTime(d1);
        cd2.setTime(d2);
        int ds1 = cd1.get(Calendar.YEAR) + cd1.get(Calendar.MONTH) + cd1.get(Calendar.DAY_OF_MONTH);
        int ds2 = cd2.get(Calendar.YEAR) + cd2.get(Calendar.MONTH) + cd2.get(Calendar.DAY_OF_MONTH);
        return ds1 > ds2;
    }

    public static String toStr(Date strDate,String format)  {
        return new SimpleDateFormat(format).format(strDate);
    }

    public static LocalDate addMonth(LocalDate date,int i) {
       return date.plusMonths(i);
    }
}
