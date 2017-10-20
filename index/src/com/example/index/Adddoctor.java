package com.example.index;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Adddoctor extends Activity {
	private SQLiteDatabase dbRead,dbWrite;
	private  SimpleCursorAdapter adapter;
	private EditText bianhao,mima;
	private Db db;
	private Button button,button2;

	@Override
	
	protected void onCreate(Bundle savedInstanceState){
		setContentView(R.layout.add_doctor);
		super.onCreate(savedInstanceState);
		button=(Button)findViewById(R.id.mymy2);
         bianhao=(EditText) findViewById(R.id.bianhao);
         mima=(EditText) findViewById(R.id.mima);
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues cv=new ContentValues();
				cv.put("Duser", bianhao.getText().toString());
				cv.put("Dpassword", mima.getText().toString());
				dbWrite.insert("Dpassword", null, cv);
				 new AlertDialog.Builder(Adddoctor.this).setTitle("提醒").setMessage("你提交成功").setNegativeButton("取消",null).setPositiveButton("确定",new DialogInterface.OnClickListener() {
		  				
		  				@Override
		  				public void onClick(DialogInterface dialog, int which) {
		  					// TODO Auto-generated method stub
//		  					Recorduser=user.getText().toString();
//		  					Recordpassword=password.getText().toString();
//		  					Intent it=new Intent(MainActivity.this,Doc_ItemActivity.class);
//							startActivityForResult(it,REQUEST);
		  				}
		  			}).show();
				refreshListView();
			}
		});
		db=new Db(this);
		dbRead=db.getReadableDatabase();	
		dbWrite=db.getWritableDatabase();
	}
	private void refreshListView(){
		Cursor c=dbRead.query("Dpassword", null, null, null, null, null, null);
	    adapter.changeCursor(c);
	}
}
