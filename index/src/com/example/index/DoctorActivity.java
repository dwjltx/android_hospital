package com.example.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DoctorActivity extends ListActivity implements OnItemClickListener{
	//通过数据查询将病人名字以数组形式显示出来
	private String[] array={"病人1","病人2","病人3","病人4","病人5"};
	private ListView listview;
	private List<Map<String,Object>> datalist;
	//private SimpleAdapter adapter;
	private  SimpleCursorAdapter adapter;
	private Intent intent;
	private Db db;
	private SQLiteDatabase dbRead,dbWrite;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_main);
		db=new Db(this);
		dbRead=db.getReadableDatabase();	
		dbWrite=db.getWritableDatabase();
		listview = (ListView) findViewById(R.id.Pname);
		//datalist = new ArrayList<Map<String, Object>>();
		//adapter=new SimpleAdapter(this, getData(), R.layout.lwlhsa,new String[]{"",""} , new int[]{R.id.image_sgn,R.id.theme_sgn});
		//adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
		//listview.setAdapter(adapter); 
		Cursor mm=dbRead.query("Patient", new String[]{"Pname"}, null, null, null, null, null);
		adapter=new SimpleCursorAdapter(this,R.layout.unpatient,mm,new String[]{"Pname"},new int[]{R.id.Pname});
		setListAdapter(adapter);
		//listview.setOnItemClickListener(this);
		refreshListView();
	
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){
		case 0:intent = new Intent(DoctorActivity.this,Doc_sick_infoActivity.class);break;
		case 1:intent = new Intent(DoctorActivity.this,Doc_sick_infoActivity.class);break;
		case 2:intent = new Intent(DoctorActivity.this,Doc_sick_infoActivity.class);break;
		case 3:intent = new Intent(DoctorActivity.this,Doc_sick_infoActivity.class);break;
		case 4:intent = new Intent(DoctorActivity.this,Doc_sick_infoActivity.class);break;
		
		}
		startActivity(intent);
	}
	
	private void refreshListView(){
		Cursor c=dbRead.query("Patient", new String[]{"Pname"}, "Pis=?", new String[]{"是"}, null,null,null);
	    adapter.changeCursor(c);
	}

}