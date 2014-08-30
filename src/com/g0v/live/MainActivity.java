package com.g0v.live;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bottom_tabs);
		// mTabHost = new FragmentTabHost(this);
		// mTabHost.setup(this, getSupportFragmentManager(),
		// R.id.menu_settings);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		Bundle b = new Bundle();
		b.putString("key", "Simple");
		
		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("直播"),
				Fragment1.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("報導"),
				Fragment1.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("ToDay"),
				Fragment1.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("國會"),
				Fragment1.class, null);
		
		mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("事件"),
				Fragment3.class, null);
		
		// setContentView(mTabHost);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// public TabSpec setIndicator(TabSpec spec, int resid) {
	// // TODO Auto-generated method stub
	// View v = LayoutInflater.from(this).inflate(R.layout.tabs_text, null);
	// v.setBackgroundResource(resid);
	// TextView text = (TextView) v.findViewById(R.id.tab_title);
	//
	// text.setText(spec.getTag());
	// return spec.setIndicator(v);
	// }

}
