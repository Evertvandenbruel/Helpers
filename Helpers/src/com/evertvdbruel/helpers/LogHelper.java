package com.evertvdbruel.helpers;

import android.content.Context;
import android.util.Log;

public class LogHelper {

	public static void debugOnlyLog(String tag, String msg) {
		if (BuildHelper.isDebugBuild()) {
			Log.d(tag, msg);
		}
	}

	public static void debugOnlyLog(Context context, String msg) {
		LogHelper.debugOnlyLog(BuildHelper.getPackageName(context), msg);
	}

}
