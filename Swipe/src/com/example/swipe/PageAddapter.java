package com.example.swipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAddapter extends FragmentPagerAdapter {


	public PageAddapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new SubActivity();
		case 1:
			return new SubActivity2();
		default:
			return new SubActivity();
		}

	}

	@Override
	public int getCount() {
		return 3;
	}

}
