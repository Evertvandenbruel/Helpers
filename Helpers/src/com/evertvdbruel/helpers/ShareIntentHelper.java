package com.evertvdbruel.helpers;

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;

public class ShareIntentHelper {

	public static Intent getTextShareIntent(String text) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, text);
		sendIntent.setType("text/plain");
		return sendIntent;
	}

	public static Intent getShareFileIntent(String type, Uri uriToFile) {
		Intent shareIntent = new Intent();
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_STREAM, uriToFile);
		shareIntent.setType(type);
		return shareIntent;
	}

	public static Intent getShareImageShareIntent(Uri uriToFile) {
		return ShareIntentHelper.getShareFileIntent("image/*", uriToFile);
	}

	public static Intent getShareMultipleFilesIntent(String type,
			ArrayList<Uri> uris) {
		Intent shareIntent = new Intent();
		shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
		shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
		shareIntent.setType(type);
		return shareIntent;
	}

	public static Intent getShareMultipleFilesIntent(ArrayList<Uri> uris) {
		return ShareIntentHelper.getShareMultipleFilesIntent("image/*", uris);
	}

}
