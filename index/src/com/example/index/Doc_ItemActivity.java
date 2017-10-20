
package com.example.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class Doc_ItemActivity extends Activity implements OnItemClickListener{
	private ListView exp;
	private List<Map<String,Object>> datalist;
	//private SimpleAdapter adapter;
	private ArrayAdapter<String> adapter;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] sgn={"诊断挂号病人","常看病人资料","查看药品","病人出院","退出登录"};
		setContentView(R.layout.doc_item_main);
		exp = (ListView) findViewById(R.id.doc_listView_item1);
		datalist = new ArrayList<Map<String, Object>>();
		//adapter=new SimpleAdapter(this, getData(), R.layout.lwlhsa,new String[]{"",""} , new int[]{R.id.image_sgn,R.id.theme_sgn});
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sgn);
		exp.setAdapter(adapter);
		exp.setOnItemClickListener(this);
		
	
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){
		case 0:
			intent=new Intent(Doc_ItemActivity.this,DoctorActivity.class);
			break;
		case 1:
			intent=new Intent(Doc_ItemActivity.this,DoctorActivity2.class);
			break;
		case 2:
			intent=new Intent(Doc_ItemActivity.this,test.class);
			break;
		case 3:
			intent=new Intent(Doc_ItemActivity.this,DoctorActivity.class);
			break;
		case 4:
			
	  		intent=new Intent(Doc_ItemActivity.this,MainActivity.class);
			break;
		}
		startActivity(intent);
	}
	

}
