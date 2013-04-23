package com.evertvdbruel.helpers;

import android.content.Context;

public class BuildHelper {

	public static Boolean isDebugBuild() {
		return BuildConfig.DEBUG;
	}

	public static String getPackageName(Context context) {
		return context.getPackageName();
	}

}
