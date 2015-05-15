package com.example.swipe;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	ViewPager addapter = null;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);

		addapter = (ViewPager) findViewById(R.id.pager);
		addapter.setAdapter(new PageAddapter(getSupportFragmentManager()));
	}
}
