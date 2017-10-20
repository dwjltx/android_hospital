package com.example.index;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class StudentActivity extends Activity implements OnClickListener,OnCheckedChangeListener{
	private ImageButton imgb;
	private Button submitBt,newB;
	private EditText name,age,studentnum,telephone,sick;
	private RadioGroup sex;
	private int sexsign=0;
	public Db db;
	private MainActivity m;
	private SQLiteDatabase dbRead,dbWrite;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_main);
        
        System.out.println("���ǵ��������棬����������д");
    
  
     newB=(Button) findViewById(R.id.my2);
     name = (EditText) findViewById(R.id.studentname_s);
     sex = (RadioGroup) findViewById(R.id.studentsex);
     age = (EditText) findViewById(R.id.studentage_s);
     studentnum = (EditText) findViewById(R.id.studentnum_s);
     telephone = (EditText) findViewById(R.id.telephone_s);
     sick = (EditText) findViewById(R.id.sick_s);
     sex.setOnCheckedChangeListener(this);
     
     db=new Db(this);
     dbRead=db.getReadableDatabase();	
	 dbWrite=db.getWritableDatabase();
	 
	 System.out.println("��������Set��");
	 newB.setOnClickListener(new OnClickListener(){
		 @Override
		 public void onClick(View v){
			 System.out.println("�°�ť");
			// ���������ݼ��ص����ݿ���
				Cursor cr=dbRead.query("Patient",null,null,null,null,null,null);
				cr.moveToFirst();
				if(sexsign==0){
					ContentValues cv=new ContentValues();
				
					System.out.println("���"+name.getText().toString());
					
					cv.put("Pno", "2016");
					cv.put("Pname", name.getText().toString());
					cv.put("Ppassword", "123456");
					cv.put("Page", age.getText().toString());
					cv.put("Psex", "��");
					cv.put("Pid", studentnum.getText().toString());
					cv.put("Ptele", telephone.getText().toString());
					cv.put("Pis", "��");
					cv.put("Pin", "");
					cv.put("Ptype", sick.getText().toString());
					cv.put("Pbno", "");
					cv.put("Pcost", "");
					
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print(MainActivity.getRecorduser());
					
//					dbWrite.insert("Patient", null, cv);
//					System.out.println("����֮����");

//	
					//dbWrite.execSQL("Update Patient set Pname="+"'"+name.getText().toString()+"'"+",Psex='��',Page="+"'"+age.getText().toString()+"'"+",Pid="+"'"+studentnum.getText().toString()+"'"+",Ptele="+"'"+telephone.getText().toString()+"'"+",Ptype="+"'"+sick.getText().toString()+"'"+"where Pno="+"'"+MainActivity.getRecorduser()+"'");
					dbWrite.update("Patient", cv, "Pno=?", new String[]{MainActivity.getRecorduser()});
					//dbWrite.execSQL("Update Patient set Ptype="+"'"+sick.getText().toString()+"'"+"where Pno="+"'"+MainActivity.getRecorduser()+"'" );
					
					Cursor cc=dbRead.query("Patient", null, null, null, null, null, null);
					cc.moveToFirst();
					System.out.println("���"+cc.getString(0)+cc.getString(1)+cc.getString(2)+cc.getString(3)+cc.getString(4));
					
					new AlertDialog.Builder(StudentActivity.this).setTitle("����").setMessage("���Ѿ��ɹ��ύ").setNegativeButton("ȡ��",null).setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
		  				
		  				@Override
		  				public void onClick(DialogInterface dialog, int which) {
		  					// TODO Auto-generated method stub
		  					
		  					Intent it=new Intent(StudentActivity.this,Stu_ItemActivity.class);
							startActivityForResult(it,10);
//		  					Recorduser=user.getText().toString();
//		  					Recordpassword=password.getText().toString();
//		  					Intent it=new Intent(MainActivity.this,Doc_ItemActivity.class);
//							startActivityForResult(it,REQUEST);
		  				}
		  			}).show();
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					cr.moveToFirst();
					while(cr.moveToNext()){
					System.out.println("oooooooooooooooooooooooooo"+cr.getString(1)+cr.getString(2)+cr.getString(3)+cr.getString(4)+cr.getString(5)+cr.getString(6)+cr.getString(7)+cr.getString(8));
					}}else{
						ContentValues cv=new ContentValues();
						
						System.out.println("���"+name.getText().toString());
						cv.put("Pno", "1996");
						cv.put("Pname", name.getText().toString());
						cv.put("Ppassword", "1996");
						cv.put("Page", age.getText().toString());
						cv.put("Psex", "Ů");
						cv.put("Pid", studentnum.getText().toString());
						cv.put("Ptele", telephone.getText().toString());
						cv.put("Pis", "");
						cv.put("Pin", "");
						cv.put("Ptype", sick.getText().toString());
						cv.put("Pbno", "");
						cv.put("Pcost", "");
						
						System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						System.out.print(MainActivity.getRecorduser());
						//dbWrite.execSQL("Update Patient set Pname="+"'"+name.getText().toString()+"'"+",Psex='��',Page="+"'"+age.getText().toString()+"'"+",Pid="+"'"+studentnum.getText().toString()+"'"+",Ptele="+"'"+telephone.getText().toString()+"'"+",Ptype="+"'"+sick.getText().toString()+"'"+"where Pno="+"'"+MainActivity.getRecorduser()+"'");
						dbWrite.update("Patient", cv, "Pno=?", new String[]{MainActivity.getRecorduser()});
						new AlertDialog.Builder(StudentActivity.this).setTitle("����").setMessage("���Ѿ��ɹ��ύ").setNegativeButton("ȡ��",null).setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
			  				
			  				@Override
			  				public void onClick(DialogInterface dialog, int which) {
			  					// TODO Auto-generated method stub
//			  					Recorduser=user.getText().toString();
//			  					Recordpassword=password.getText().toString();
//			  					Intent it=new Intent(MainActivity.this,Doc_ItemActivity.class);
//								startActivityForResult(it,REQUEST);
			  				}
			  			}).show();
					
				}
				
			 
		 }
	 });
	 
     //Toast.makeText(this, "���سɹ�,�ȴ�ϵͳ����", Toast.LENGTH_SHORT).show();
	}


	
	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "���سɹ�,�ȴ�ϵͳ����", Toast.LENGTH_SHORT).show();
	}

	
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
//		switch(arg1){
//		case R.id.radio_man:
//			sexsign=0;break;
//		case R.id.radio_women:
//			sexsign=1;break;
//		}
	}
}
