package com.example.index;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;


public class Doc_sick_infoActivity extends Activity implements OnItemClickListener {
	//通过数据查询将病人名字以数组形式显示出来
	String[] str={"阿凡达","阿莫西林","阿里云","金鸡益母草","金嗓子","当归","党参","诺氟沙星","诺含片","金戈"};
	private MultiAutoCompleteTextView multi;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doc_sick_info);
		multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		adapter = new ArrayAdapter<String>(Doc_sick_infoActivity.this,android.R.layout.simple_list_item_1,str);
		multi.setAdapter(adapter);
		
		multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	

}