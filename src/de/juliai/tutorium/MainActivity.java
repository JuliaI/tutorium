package de.juliai.tutorium;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * @author JuliaI
 */
public class MainActivity extends Activity {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		showBool();
	}

	/**
	 * 
	 */
	private void showBool() {
		final SharedPreferences sharedPref = PreferenceManager
				.getDefaultSharedPreferences(this);
		boolean bool = sharedPref.getBoolean("checkBoxPrefsKey", false);
		TextView tv = (TextView) findViewById(R.id.textView2);
		tv.setText("Boolean is " + bool);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainmenu, menu);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
		case R.id.itemsettings:
			final Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			return true;
		case R.id.itemrefresh:
			showBool();
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
