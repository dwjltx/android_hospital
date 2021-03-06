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

public class test extends ListActivity {
	private SQLiteDatabase dbRead,dbWrite;
	private  SimpleCursorAdapter adapter;
	private EditText Mno,Mname,Mprice,Mplace;
	private Db db;
	private Button button,button2;
	

	
	private OnItemLongClickListener ListViewItemLongClickListener=new OnItemLongClickListener(){
  //长按删除
	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int position, long id) {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(test.this).setTitle("提醒").setMessage("确定要删除该项吗？").setNegativeButton("取消",null).setPositiveButton("确定",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Cursor c=adapter.getCursor();
				c.moveToPosition(position);
				
				int itemId=c.getInt(c.getColumnIndex("_id"));
				dbWrite.delete("Medicine","_id=?",new String[]{itemId+""} );
				refreshListView();
			}
		}).show();

		return true;
	}
	
};
	

	@Override
	protected void onCreate(Bundle savedInstanceState){
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		button=(Button)findViewById(R.id.btn);
		//点击跳转按钮
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				Intent in=getIntent();
				setResult(RESULT_OK,in);
				finish();
			}
		});
		
		
		//点击添加按钮
		button2=(Button) findViewById(R.id.tian);
		Mno=(EditText) findViewById(R.id.Mno);
		Mname=(EditText) findViewById(R.id.Mname);
		Mprice=(EditText) findViewById(R.id.Mprice);
		Mplace=(EditText) findViewById(R.id.Mplace);
		
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues cv=new ContentValues();
				cv.put("Mno", Mno.getText().toString());
				cv.put("Mname", Mname.getText().toString());
				cv.put("Mprice", Mprice.getText().toString());
				cv.put("Mplace", Mplace.getText().toString());
				dbWrite.insert("Medicine", null, cv);
				
				refreshListView();
			}
			
		});
		
		//长按反应
		getListView().setOnItemLongClickListener(ListViewItemLongClickListener);
		
		db=new Db(this);
		dbRead=db.getReadableDatabase();	
		dbWrite=db.getWritableDatabase();
		
		adapter=new SimpleCursorAdapter(this,R.layout.user_list,null,new String[]{"Mno","Mname","Mprice","Mplace"},new int[]{R.id.Mno,R.id.Mname,R.id.Mprice,R.id.Mplace});
		setListAdapter(adapter);
//		Cursor c=dbRead.query("Medicine", null, null, null, null, null, null);
//		while(c.moveToNext()){
//			String Mno1=c.getString(1);
//			String Mname1=c.getString(2);
//			String Mprice1=c.getString(3);
//			String Mplace1=c.getString(4);
//            String M=Mno1+Mname1+Mprice1+Mplace1;
//			String[] zzz={M};
//			
//			ArrayAdapter<String> adapter=new ArrayAdapter<String>(
//	        		test.this,android.R.layout.activity_list_item,zzz);
//	        ListView listView=(ListView) findViewById(R.id.action_settings);
//	        listView.setAdapter(adapter);
//		}
//		
		refreshListView();
		
	}
	
	
	

	private void refreshListView(){
		Cursor c=dbRead.query("Medicine", null, null, null, null, null, null);
	    adapter.changeCursor(c);
	}
}
