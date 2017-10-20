package com.example.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Look_RecordActivity extends Activity{
	private ListView  listview;
	//private TextView  date,bingyin,getway,doctorname;
	private String[] date1={"0000-00-00","0010-00-01","2014-02-03","2016-06-06","2016-05-06"};
	private String[] bingyin1={"急性阑尾炎","尿性","普通感冒","手指骨断裂","脑子进水"};
	private String[] getway1={"治疗办法1","治疗办法2","治疗办法3","治疗办法4","治疗办法5"};
	private String[] doctorname1={"医生1","医生2","医生3","医生4","医生5"};	
	private List<Map<String,Object>> datalist;
     private ArrayAdapter<String> adapter1,adapter2,adapter3,adapter4;
	private SimpleAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.look_sick_history);
		listview = (ListView) findViewById(R.id.bingrenbingli);
		
		datalist = new ArrayList<Map<String,Object>>();
		
		//date = (TextView) findViewById(R.id.dateime_record);
		//bingyin = (TextView) findViewById(R.id.bingyin_record);
		//getway = (TextView) findViewById(R.id.getway_record);
		//doctorname = (TextView) findViewById(R.id.doctorname_record);
		 //adapter1 = new ArrayAdapter<String>(Look_RecordActivity.this, android.R.layout.simple_list_item_1,date1);
		 //adapter2 = new ArrayAdapter<String>(Look_RecordActivity.this, android.R.layout.simple_list_item_1,bingyin1);
		 //adapter3 = new ArrayAdapter<String>(Look_RecordActivity.this, android.R.layout.simple_list_item_1,getway1);
		 //adapter4 = new ArrayAdapter<String>(Look_RecordActivity.this, android.R.layout.simple_list_item_1,doctorname1);
		adapter = new SimpleAdapter(this, getdata(),R.layout.sickt_report_example,new String[]{"data","bingyin","getway","doctorname"},new int[]{R.id.dateime_record,R.id.bingyin_record,R.id.getway_record,R.id.doctorname_record});
		listview.setAdapter(adapter);
	
	}
	private List<Map<String, Object>> getdata() {
		// TODO Auto-generated method stub
		Map<String,Object> map = null;
		
		for(int i=0;i<date1.length;i++){
			map = new HashMap<String, Object>();
			map.put("data",date1[i]);
			map.put("bingyin",bingyin1[i]);
			map.put("getway",getway1[i]);
			map.put("doctorname", doctorname1[i]);
			datalist.add(map);
		}
		
		return datalist;
	}
	
}
