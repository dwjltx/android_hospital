package com.example.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DoctorActivity2 extends Activity implements OnItemClickListener {
	//通过数据查询将病人名字以数组形式显示出来
	private String[] array={"病人1","病人2","病人3","病人4","病人5"};
	private ListView listview;
	private List<Map<String,Object>> datalist;
	//private SimpleAdapter adapter;
	private ArrayAdapter<String> adapter;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_main2);
		listview = (ListView) findViewById(R.id.sick_item);
		datalist = new ArrayList<Map<String, Object>>();
		//adapter=new SimpleAdapter(this, getData(), R.layout.lwlhsa,new String[]{"",""} , new int[]{R.id.image_sgn,R.id.theme_sgn});
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
		listview.setAdapter(adapter); 
		listview.setOnItemClickListener(this);
		
	
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){
		case 0:intent = new Intent(DoctorActivity2.this,Doc_sick_infoActivity.class);break;
		case 1:intent = new Intent(DoctorActivity2.this,Doc_sick_infoActivity.class);break;
		case 2:intent = new Intent(DoctorActivity2.this,Doc_sick_infoActivity.class);break;
		case 3:intent = new Intent(DoctorActivity2.this,Doc_sick_infoActivity.class);break;
		case 4:intent = new Intent(DoctorActivity2.this,Doc_sick_infoActivity.class);break;
		
		}
		startActivity(intent);
	}
	

}