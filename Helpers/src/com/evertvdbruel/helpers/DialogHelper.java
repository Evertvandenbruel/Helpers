package com.evertvdbruel.helpers;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class DialogHelper {

	public static Builder createAlertDialog(Context context, String title,
			String message, OnClickListener positiveOnClickListener,
			OnClickListener negativeOnClickListener) {
		return DialogHelper.createAlertDialog(context, title, message,
				context.getString(android.R.string.ok),
				positiveOnClickListener,
				context.getString(android.R.string.cancel),
				negativeOnClickListener);
	}

	public static Builder createAlertDialog(Context context, String title,
			String message, String positiveText,
			OnClickListener positiveOnClickListener, String negativeText,
			OnClickListener negativeOnClickListener) {
		AlertDialog.Builder alert = new AlertDialog.Builder(context);

		if (!StringHelper.isEmpty(title)) {
			alert.setTitle(title);
		}

		if (!StringHelper.isEmpty(message)) {
			alert.setMessage(message);
		}

		if (!ObjectHelper.isEmpty(positiveOnClickListener)) {
			alert.setPositiveButton(positiveText, positiveOnClickListener);
		}

		if (!ObjectHelper.isEmpty(negativeOnClickListener)) {
			alert.setNegativeButton(negativeText, negativeOnClickListener);
		}

		return alert;
	}
}
