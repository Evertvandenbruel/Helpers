package com.evertvdbruel.helpers;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.provider.Settings;

public class LocationHelper {

	public static String getBestProvider(Context context,
			LocationManager locationManager) {
		locationManager = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);
		if (locationManager != null
				&& !locationManager
						.isProviderEnabled(LocationManager.GPS_PROVIDER)
				&& !locationManager
						.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			return null;
		}
		Criteria criteria = new Criteria();
		criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);
		criteria.setAccuracy(Criteria.NO_REQUIREMENT);
		String bestProvider = locationManager.getBestProvider(criteria, true);
		return bestProvider;
	}

	public static Intent getLocationSettingsIntent() {
		return new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	}

}
