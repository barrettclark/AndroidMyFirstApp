package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// You can also restore activity state with the savedInstanceState,
		// or you can use onRestoreInstanceState
		// if (savedInstanceState != null) {
		// } else {
		// }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user click the Send button */
	public void sendMessage(View view) {
	  // Do something in response to button
	  Intent intent = new Intent(this, DisplayMessageActivity.class);
	  EditText editText = (EditText) findViewById(R.id.edit_message);
	  String message = editText.getText().toString();
	  intent.putExtra(EXTRA_MESSAGE, message);
	  startActivity(intent);
	}

	/**
	 * Stop animations or other ongoing actions that could consume CPU.
	 * Commit unsaved changes, but only if users expect such changes to be
		permanently saved when they leave 
	 * Release system resources, such as broadcast receivers, handles to sensors
		(like GPS), or any resources that may affect battery life while your
		activity is paused and the user does not need them
	 */
	@Override
	public void onPause() {
		super.onPause();
	}
	
	/**
	 * The system calls this method every time your activity comes into the
		foreground, including when it's created for the first time
	 * Resume (initialize) anything paused in onPause()
	 */
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onDestroy() {
		// this is not always required, but we need to kill things that we background processed
		super.onDestroy();
		
		// Stop method tracing that the activity started in onCreate()
		android.os.Debug.stopMethodTracing();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		// save state in whatever you were doing
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		// The activity is either being restarted or started for the first time
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		
		// Activity being restarted from stopped state
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// save state
		// savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
		
		// Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		// Restore state members from saved instance
	}
	
}
