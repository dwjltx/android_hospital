package com.example.index;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Instruct extends Activity {

	Button button;
	@Override
	
	protected void onCreate(Bundle savedInstanceState){
		setContentView(R.layout.fanhui);
		super.onCreate(savedInstanceState);
		button=(Button)findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent in=getIntent();
				setResult(RESULT_OK,in);
				finish();
			}
		});
	}
}
