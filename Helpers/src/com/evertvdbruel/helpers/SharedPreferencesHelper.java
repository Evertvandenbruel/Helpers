package com.evertvdbruel.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesHelper {
	
	public static String getPackageName(Context context) {
		return context.getApplicationContext().getPackageName();
	}

	public static SharedPreferences getSharedPreferencesFromPackageName(
			Context context) {
		return context.getSharedPreferences(
				SharedPreferencesHelper.getPackageName(context),
				Context.MODE_PRIVATE);
	}

	public static Editor getEditor(Context context) {
		return SharedPreferencesHelper.getSharedPreferencesFromPackageName(
				context).edit();
	}
}
