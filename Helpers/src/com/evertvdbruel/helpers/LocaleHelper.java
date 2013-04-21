package com.evertvdbruel.helpers;

import java.util.Locale;

import android.content.Context;

public class LocaleHelper {

	public static Locale getLocale(Context context) {
		return context.getResources().getConfiguration().locale;
	}

}
