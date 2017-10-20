package com.example.index;

import android.os.Bundle;


import java.sql.Connection;
import java.util.ArrayList;

//import com.example.textsql.MainActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	//private String[] ZYF={"本医院联系电话：","15927141740"};
	private Button load;
	private EditText user,password;
	private RadioButton radio0,radio1,radio2;
	public Db db;
	private SQLiteDatabase dbRead,dbWrite;
	private static String Recorduser,Recordpassword;
	private SimpleCursorAdapter adapter;
	public static String getRecorduser() {
		return Recorduser;
	}

	public static void setRecorduser(String recorduser) {
		Recorduser = recorduser;
	}

	public static String getRecordpassword() {
		return Recordpassword;
	}

	public static void setRecordpassword(String recordpassword) {
		Recordpassword = recordpassword;
	}

	private EditText etName,etSex;
	public Button btnAdd;
	
	 final static int REQUEST=10;
//	private OnClickListener btnAddListener=new OnClickListener(){
//		@Override
//		public void onClick(View v){
//			
//		}
//	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
		load=(Button) findViewById(R.id.radioButton3);
		user=(EditText) findViewById(R.id.user);
		password=(EditText) findViewById(R.id.password);
		radio0=(RadioButton) findViewById(R.id.radio0);
		radio1=(RadioButton) findViewById(R.id.radio1);
		radio2=(RadioButton) findViewById(R.id.radio2);
		//Button button=(Button) findViewById(R.id.button1);
		//第一次建立数据库
		db=new Db(this);
		//db.close();
		
		
		dbRead=db.getReadableDatabase();	
		dbWrite=db.getWritableDatabase();

		
		load.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Cursor cursor = dbRead.query("Dpassword", null, null, null, null, null, null);
				Cursor patientpassword = dbRead.query("Patient", null, null, null, null, null, null);
				Cursor adm=dbRead.query("Apassword", null, null, null, null, null, null);
				Cursor medicine=dbRead.query("Medicine", null, null, null, null, null, null);
				while(medicine.moveToNext()){
					String Mno1=medicine.getString(1);
					String Mname1=medicine.getString(2);
					String Mprice1=medicine.getString(3);
					String Mplace1=medicine.getString(4);
					System.out.println(Mno1+" "+Mname1+" "+Mprice1+" "+Mplace1);
				}
				
					
				if(radio1.isChecked()){	
				while (cursor.moveToNext()) {  
					System.out.println("1111111111111111");
				      	
				    	  String user1 = cursor.getString(1); //获取第一列的值,第一列的索引从0开始  
					      String password1 = cursor.getString(2);//获取第二列的值  
				    	  System.out.println("22222222222222222222222");
				    	  if(user.getText().toString().equals(user1)&&password.getText().toString().equals(password1)){
				    		  System.out.println("33333333333333333333333");
				    		  new AlertDialog.Builder(MainActivity.this).setTitle("提醒").setMessage("你是医生已经成功登陆").setNegativeButton("取消",null).setPositiveButton("确定",new DialogInterface.OnClickListener() {
				  				
				  				@Override
				  				public void onClick(DialogInterface dialog, int which) {
				  					// TODO Auto-generated method stub
				  					Recorduser=user.getText().toString();
				  					Recordpassword=password.getText().toString();
				  					Intent it=new Intent(MainActivity.this,Doc_ItemActivity.class);
									startActivityForResult(it,REQUEST);
				  				}
				  			}).show();
				    		  
				    	  }
				      }
				}
				      
				      else if(radio0.isChecked()){
				    	  while(patientpassword.moveToNext()){
				    	  String user1 = patientpassword.getString(1); //获取第一列的值,第一列的索引从0开始  
					      String password1 = patientpassword.getString(3);//获取第二列的值  
				    	  System.out.println("22222222222222222222222");
				    	  if(user.getText().toString().equals(user1)&&password.getText().toString().equals(password1)){
				    		  System.out.println("33333333333333333333333");
				    		  new AlertDialog.Builder(MainActivity.this).setTitle("提醒").setMessage("你是学生已经成功登陆").setNegativeButton("取消",null).setPositiveButton("确定",new DialogInterface.OnClickListener() {
				  				@Override
				  				public void onClick(DialogInterface dialog, int which) {
				  					// TODO Auto-generated method stub
				  					Recorduser=user.getText().toString();
				  					Recordpassword=password.getText().toString();
				  					Intent it=new Intent(MainActivity.this,Stu_ItemActivity.class);
									startActivityForResult(it,REQUEST);
				  				}
				  			}).show();
				    		  
				    	  }
				      }
				      }
				      
				      else if(radio2.isChecked()){	
				    	  while(adm.moveToNext()){
				    	  String user1 = adm.getString(1); //获取第一列的值,第一列的索引从0开始  
					      String password1 = adm.getString(2);//获取第二列的值  
				    	  System.out.println("22222222222222222222222");
				    	  if(user.getText().toString().equals(user1)&&password.getText().toString().equals(password1)){
				    		  System.out.println("33333333333333333333333");
				    		  new AlertDialog.Builder(MainActivity.this).setTitle("提醒").setMessage("你是管理员已经成功登陆").setNegativeButton("取消",null).setPositiveButton("确定",new DialogInterface.OnClickListener() {
				  				@Override
				  				public void onClick(DialogInterface dialog, int which) {
				  					// TODO Auto-generated method stub
				  					Recorduser=user.getText().toString();
				  					Recordpassword=password.getText().toString();
				  					Intent it=new Intent(MainActivity.this,SgnActivity.class);
									startActivityForResult(it,REQUEST);
				  				}
				  			}).show();
				    		  
				    	  }
				      }
				      }
				       
				  
			}
			
		});
    }
//    @Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
}
