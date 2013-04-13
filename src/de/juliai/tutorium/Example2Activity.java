package de.juliai.tutorium;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author JuliaI
 */
public class Example2Activity extends Activity {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);

		final TextView textView = (TextView) findViewById(R.id.textView1);
		final String textcontent = getIntent().getStringExtra("textcontent");
		textView.setText(textcontent);
	}
}
