package com.g0v.live;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	private FragmentTabHost inTab;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bottom_tabs);
		
		inTab = (FragmentTabHost) findViewById(android.R.id.tabhost);
		inTab.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		
		inTab.addTab(
			inTab.newTabSpec("live").setIndicator(getString(R.string.tab_live)),
			LiveFragment.class,
			null
		);

		inTab.addTab(
			inTab.newTabSpec("news").setIndicator(getString(R.string.tab_news)),
			NewsFragment.class,
			null
		);

		inTab.addTab(
			inTab.newTabSpec("today").setIndicator(getString(R.string.tab_today)),
			ToDayFragment.class,
			null
		);

		inTab.addTab(
			inTab.newTabSpec("parliament").setIndicator(getString(R.string.tab_parliament)),
			ParliamentFragment.class,
			null
		);
		
		inTab.addTab(
			inTab.newTabSpec("event").setIndicator(getString(R.string.tab_event)),
			EventFragment.class,
			null
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void openToDayFragment()
	{
	}
}
