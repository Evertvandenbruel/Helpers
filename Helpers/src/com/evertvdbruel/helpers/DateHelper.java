package com.evertvdbruel.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;

public class DateHelper {

	public static String stringFromDate(Date date, String format,
			Context context) {
		SimpleDateFormat simpleDateFormat = DateHelper.getSimpleDateFormat(
				context, format);
		return simpleDateFormat.format(date);
	}

	public static Date dateFromString(String date, String format,
			Context context) throws ParseException {
		SimpleDateFormat simpleDateFormat = DateHelper.getSimpleDateFormat(
				context, format);
		return simpleDateFormat.parse(date);
	}

	public static SimpleDateFormat getSimpleDateFormat(Context context,
			String format) {
		return new SimpleDateFormat(format, LocaleHelper.getLocale(context));
	}

}
