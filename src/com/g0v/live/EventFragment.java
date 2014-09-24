package com.g0v.live;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EventFragment extends MainFragment {

	private FragmentTabHost inTab;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		inTab = new FragmentTabHost(getActivity());
		inTab.setup(getActivity(), getChildFragmentManager(),
				R.id.menu_settings);

		Bundle b = new Bundle();
		b.putString("key", "Simple");
		inTab.addTab(inTab.newTabSpec("simple").setIndicator("Simple"),
				LiveFragment.class, b);
		//
		b = new Bundle();
		b.putString("key", "Contacts");
		inTab.addTab(inTab.newTabSpec("contacts")
				.setIndicator("Contacts"), ParliamentFragment.class, b);
		
		return inTab;
	}
}
