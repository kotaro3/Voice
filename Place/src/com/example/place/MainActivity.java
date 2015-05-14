package com.example.place;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener{

	LocationManager mLocationManager = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mLocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setPowerRequirement(Criteria.POWER_MEDIUM);

		String provider = mLocationManager.getBestProvider(criteria, true);

		TextView tv_provider = (TextView)findViewById(R.id.Provider);
		tv_provider.setText("Provider:"+ provider);

		mLocationManager.requestLocationUpdates(provider, 0, 0, this);


	}

	@Override
	protected void onResume() {
		if(mLocationManager != null){
			mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		}

		super.onResume();
	}

	@Override
	protected void onPause() {
		if(mLocationManager != null){
			mLocationManager.removeUpdates(this);
		}
		super.onPause();
	}

	@Override
	public void onLocationChanged(Location location) {
		TextView text1 = (TextView)findViewById(R.id.textView1);
		TextView text2 = (TextView)findViewById(R.id.textView2);
		text1.setText("latitude:   "+location.getLatitude());
		Log.v("latitude",String.valueOf(location.getLatitude()));
		text2.setText("longitude:   "+location.getLongitude());
		Log.v("longitude", String.valueOf(location.getLongitude()));



	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		switch(status){
		case LocationProvider.AVAILABLE:
		  Log.v("Status","AVAILABLE");
		  break;
		case LocationProvider.OUT_OF_SERVICE:
		  Log.v("Status","OUT_OF_SERVICE");
		  break;
		case  LocationProvider.TEMPORARILY_UNAVAILABLE:
		  Log.v("Status","TEMPORARILY_UNAVAILABLE");
		  break;
		}

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ


	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
