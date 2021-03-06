package com.gilang.smice_p;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		/*if(savedInstanceState != null){
			return;
		}*/
		
		DownloadFragment downloadFragment = new DownloadFragment();
		downloadFragment.setArguments(getIntent().getExtras());
		getSupportFragmentManager().beginTransaction().replace(R.id.container, downloadFragment).commit();
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction trans = fragmentManager.beginTransaction();
		if(position == 0)
			trans.replace(R.id.container, new MapFragment()).addToBackStack(null).commit();
		else if(position == 1)
			trans.replace(R.id.container, new SessionFragment()).addToBackStack(null).commit();
		else if(position == 2)
			trans.replace(R.id.container, MainDataFragment.newInstance(position + 1)).addToBackStack(null).commit();
		else if(position == 3)
			trans.replace(R.id.container, new MapFragment()).addToBackStack(null).commit();
		else if(position == 4)
			trans.replace(R.id.container, new MapFragment()).addToBackStack(null).commit();
		else if(position == 5)
			trans.replace(R.id.container, new DownloadFragment()).addToBackStack(null).commit();
		else if(position == 6)
			trans.replace(R.id.container, new MapFragment()).addToBackStack(null).commit();
		else if(position == 7)
			trans.replace(R.id.container, new MapFragment()).addToBackStack(null).commit();
		else if(position == 8)
			trans.replace(R.id.container, new MapFragment()).addToBackStack(null).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		//actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
