package com.account.util;

import com.account.exception.AppsException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarUtil {

    public static Date getDefaultParsedDateOnly(String date) throws AppsException {
        Date parsedDate;

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            parsedDate = format.parse(date);
            return parsedDate;
        } catch (ParseException e) {
            throw new AppsException("Invalid data format");
        }
    }

    public static String getDefaultFormattedDate(Date date) {
        return getFormattedDate(date, "dd/MM/yyyy");
    }

    public static String getFormattedDate(Date date, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }
}
