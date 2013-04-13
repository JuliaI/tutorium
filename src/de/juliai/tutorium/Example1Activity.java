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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);

		Log.i(this.getClass().getName(), "onCreate");

		// get elements
		final Button button1 = (Button) findViewById(R.id.button1);
		final EditText editText = (EditText) findViewById(R.id.editText1);

		// on-click-event
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// show entered text in toast
				Toast.makeText(Example1Activity.this,
						editText.getText().toString(), Toast.LENGTH_LONG)
						.show();
				Log.d(this.getClass().getName(), editText.getText().toString());

				// send intent to second activity
				final Intent intent = new Intent(Example1Activity.this,
						Example2Activity.class);
				intent.putExtra("textcontent", editText.getText().toString());
				startActivity(intent);
			}
		});

		// button for settings-example
		final Button button2 = (Button) findViewById(R.id.button2);

		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(Example1Activity.this,
						MainActivity.class);
				startActivity(intent);
			}
		});
		
		// button for todo-list-example
		final Button button3 = (Button) findViewById(R.id.button3);

		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(Example1Activity.this,
						ToDoListActivity.class);
				startActivity(intent);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onResume() {
		super.onResume();
		Log.i(this.getClass().getName(), "onResume");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onPause() {
		super.onPause();
		Log.i(this.getClass().getName(), "onPause");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onStop() {
		super.onStop();
		Log.i(this.getClass().getName(), "onStop");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onStart() {
		super.onStart();
		Log.i(this.getClass().getName(), "onStart");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onRestart() {
		super.onRestart();
		Log.i(this.getClass().getName(), "onRestart");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(this.getClass().getName(), "onDestroy");
	}
}
