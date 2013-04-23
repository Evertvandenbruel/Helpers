package com.evertvdbruel.helpers;

import java.text.DecimalFormat;

public class StringHelper {

	public static Boolean isEmpty(String string) {
		return (string == null || string.equals(""));
	}

	// http://developer.android.com/reference/java/text/DecimalFormat.html
	public static String formatNumber(Double number, String format) {
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(number);
	}

}
