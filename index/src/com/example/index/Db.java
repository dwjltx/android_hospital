package com.example.index;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Db extends SQLiteOpenHelper {

	public SQLiteDatabase database;
	private SQLiteDatabase db1;
	private SQLiteDatabase dbRead,dbWrite;
	public Db(Context context) {
		super(context, "hos", null, 1);//version ���ݿ�汾
		// TODO Auto-generated constructor stub
	} 
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {

		this.database=arg0;
		//����Ա
		arg0.execSQL("create table Apassword("+
	              "_id integer  primary key autoincrement,"+
				  " Auser  TEXT  DEFAULT  \"\","+    //����Ա�˺�
				  " Apassword TEXT     not null"+      //����Ա����       
				  
				")");
		
		//��λ
		arg0.execSQL("create table Bed ("+
	              "_id integer  primary key autoincrement,"+
				  " Bno  TEXT  DEFAULT  \"\","+   //��λ��
				  " Pno TEXT     not null"+        //סԺ��
				 
				  
				")");
		//ҽ��
		arg0.execSQL("create table Recipe ("+
	              "_id integer  primary key autoincrement,"+
				  " Rno  TEXT  DEFAULT  \"\","+  //ҽ����
				  " Rdate TEXT     null,"+   //ҽ������
				  " Mno           TEXT           null,"+  //ҩƷ��
				  " Mname        TEXT           null,"+  //ҩƷ����
				  " Pno           TEXT             null,"+  //סԺ��
				  " Dno          TEXT          null,"+   //ҽ�����
				  " Moperator          TEXT      null"+  //ʹ�÷���
				 
				  
				")");
		//ҽ��
		arg0.execSQL("create table Doctor ("+
	              "_id integer  primary key autoincrement,"+
				  " Dno  TEXT  DEFAULT  \"\","+  //ҽ�����
				  " Dname TEXT      null,"+   //ҽ������
				  " Dsex        TEXT           null,"+  //ҽ���Ա�
				  " Dtime        TEXT           null,"+  //����
				  " Dsection        TEXT           null"+  //ҽ���Ʊ�
				
				")");
		//ҽ����½
		arg0.execSQL("create table Dpassword ("+
	              "_id integer  primary key autoincrement,"+
				  " Duser  TEXT  DEFAULT  \"\","+
				  " Dpassword TEXT     not null"+
				")");
		//ҩƷ
		arg0.execSQL("create table Medicine ("+
	              "_id integer  primary key autoincrement,"+
				  "Mno  TEXT  DEFAULT  \"\","+  //ҩƷ���
				  " Mname TEXT      null,"+   //ҩƷ����
				  "Mprice        TEXT           null,"+   //ҩƷ�۸�
				  " Mplace        TEXT           null"+  //������
				  
				")");
		//����
		arg0.execSQL("create table Patient ("+
	              "_id integer  primary key autoincrement,"+
				  " Pno   TEXT  DEFAULT  \"\","+   //סԺ��
				  " Pname      null,"+     //����
				  " Ppassword            TEXT           null,"+  //��¼����
				  " Page            TEXT           null,"+    //����
				  " Psex            TEXT           null,"+  //�Ա�
				  " Pid          TEXT             null,"+  //���֤��
				  " Ptele        TEXT           null,"+   //��ϵ�绰
				  " Pis        TEXT           null,"+    //�Ƿ�סԺ
				  " Pin        TEXT           null,"+     //סԺ����
				  " Ptype       TEXT           null,"+    //�����������
				  " Pbno       TEXT           null,"+     //��λ
				  " Pcost       TEXT           null"+    //����
				 
				")");
		
	     Db.start(arg0);
		
		// TODO Auto-generated method stub
		
			Db.second(arg0);
		

	}

	private static void start(SQLiteDatabase database){
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
	
		database.execSQL("insert into Dpassword(Duser, Dpassword) values('2016', '123456')");
		database.execSQL("insert into Dpassword(Duser, Dpassword) values('2015', '123456')");
		//database.execSQL("insert into Patient(Pno, Ppassword) values('2014317200114', '123456')");
		
		ContentValues cv=new ContentValues();
		
		cv.put("Pno", "2016");
		cv.put("Pname", "");
		cv.put("Ppassword", "123456");
		cv.put("Page", "");
		cv.put("Psex", "");
		cv.put("Pid", "");
		cv.put("Ptele", "");
		cv.put("Pis", "");
		cv.put("Pin", "");
		cv.put("Ptype", "");
		cv.put("Pbno", "");
		cv.put("Pcost", "");
		database.insert("Patient", null, cv);
		
		
	    cv=new ContentValues();
		cv.put("Duser", "2017");
		cv.put("Dpassword", "123456");
		database.insert("Dpassword", null, cv);
		
		cv=new ContentValues();
		cv.put("Duser", "2018");
		cv.put("Dpassword", "123456");
		database.insert("Dpassword", null, cv);
		
	    cv=new ContentValues();
		cv.put("Auser", "2016");
		cv.put("Apassword", "123456");
		database.insert("Apassword", null, cv);
		
		
		cv=new ContentValues();
		cv.put("Mno", "1");
		cv.put("Mname", "999��ð��");
		cv.put("Mprice", "9.9");
		cv.put("Mplace", "������");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "2");
		cv.put("Mname", "�п�����Ƭ");
		cv.put("Mprice", "13.5");
		cv.put("Mplace", "������");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "3");
		cv.put("Mname", "������");
		cv.put("Mprice", "18");
		cv.put("Mplace", "�人��");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "4");
		cv.put("Mname", "����Ƭ");
		cv.put("Mprice", "15");
		cv.put("Mplace", "������");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "5");
		cv.put("Mname", "ά����Ƭ");
		cv.put("Mprice", "16");
		cv.put("Mplace", "������");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "4");
		cv.put("Mname", "��ðҩ");
		cv.put("Mprice", "15");
		cv.put("Mplace", "������");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Rno", "1");
		cv.put("Mname", "��ðҩ");
		database.insert("Recipe", null, cv);
		
	}
	
	
	private static void second(SQLiteDatabase database){
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("222222222222222222222222222222222222222222222222");
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
	
		//database.execSQL("update Dpassword set Duser='2014',Dpassword='1234'  where Duser='2016'");
		//database.execSQL("delete from Dpassword where Duser='2016'");
		
		
	}
	
	public void insert(String Duser,String Dpassword){
		
		ContentValues cv=new ContentValues();
		cv.put("Duser", Duser);
		cv.put("Dpassword", Dpassword);
		//database.insert("Dpassword", null, cv);
		
	}
//	public void Update(){
//		
//	}
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}

