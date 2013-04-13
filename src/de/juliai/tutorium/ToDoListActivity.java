package de.juliai.tutorium;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author JuliaI
 */
public class ToDoListActivity extends ListActivity {

	private List<String> todos = new ArrayList<String>();

	private ArrayAdapter<String> adapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todolist);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, todos);
		setListAdapter(adapter);

		// show existing to-dos
		restoreTodos();

		// on-click-event
		final Button listButton = (Button) findViewById(R.id.listButton);

		listButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addTodo();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onStop() {
		super.onStop();
		storeTodos();
	}

	/**
	 * 
	 */
	private void addTodo() {
		final EditText et = (EditText) findViewById(R.id.listInputField);
		todos.add(et.getText().toString());
		adapter.notifyDataSetChanged();
		et.setText("");
	}

	/**
	 * 
	 */
	private void storeTodos() {
		final SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);

		final Editor prefEditor = prefs.edit();
		prefEditor.putInt("count", todos.size());

		for (int i = 0; i < todos.size(); i++) {
			prefEditor.putString("todo" + i, todos.get(i));
		}
		prefEditor.commit();
	}

	/**
	 * 
	 */
	private void restoreTodos() {
		final SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);

		int count = prefs.getInt("count", 0);
		for (int i = 0; i < count; i++) {
			todos.add(prefs.getString("todo" + i, ""));
		}
	}
}
