package de.juliai.tutorium;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author JuliaI
 */
public class Example1Activity extends Activity {

	public static final String TAG = "Example1Activity";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);

		// get elements
		final Button button = (Button) findViewById(R.id.button1);
		final EditText editText = (EditText) findViewById(R.id.editText1);

		// on-click-event
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// show entered text in toast
				Toast.makeText(Example1Activity.this,
						editText.getText().toString(), Toast.LENGTH_LONG)
						.show();
				Log.d(TAG, editText.getText().toString());

				// send intent to second activity
				final Intent intent = new Intent(Example1Activity.this,
						Example2Activity.class);
				intent.putExtra("textcontent", editText.getText().toString());
				startActivity(intent);
			}
		});
	}

}
