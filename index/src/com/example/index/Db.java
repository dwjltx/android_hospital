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
		super(context, "hos", null, 1);//version 数据库版本
		// TODO Auto-generated constructor stub
	} 
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {

		this.database=arg0;
		//管理员
		arg0.execSQL("create table Apassword("+
	              "_id integer  primary key autoincrement,"+
				  " Auser  TEXT  DEFAULT  \"\","+    //管理员账号
				  " Apassword TEXT     not null"+      //管理员密码       
				  
				")");
		
		//床位
		arg0.execSQL("create table Bed ("+
	              "_id integer  primary key autoincrement,"+
				  " Bno  TEXT  DEFAULT  \"\","+   //床位号
				  " Pno TEXT     not null"+        //住院号
				 
				  
				")");
		//医嘱
		arg0.execSQL("create table Recipe ("+
	              "_id integer  primary key autoincrement,"+
				  " Rno  TEXT  DEFAULT  \"\","+  //医嘱号
				  " Rdate TEXT     null,"+   //医嘱日期
				  " Mno           TEXT           null,"+  //药品号
				  " Mname        TEXT           null,"+  //药品名称
				  " Pno           TEXT             null,"+  //住院号
				  " Dno          TEXT          null,"+   //医生编号
				  " Moperator          TEXT      null"+  //使用方法
				 
				  
				")");
		//医生
		arg0.execSQL("create table Doctor ("+
	              "_id integer  primary key autoincrement,"+
				  " Dno  TEXT  DEFAULT  \"\","+  //医生编号
				  " Dname TEXT      null,"+   //医生姓名
				  " Dsex        TEXT           null,"+  //医生性别
				  " Dtime        TEXT           null,"+  //工龄
				  " Dsection        TEXT           null"+  //医生科别
				
				")");
		//医生登陆
		arg0.execSQL("create table Dpassword ("+
	              "_id integer  primary key autoincrement,"+
				  " Duser  TEXT  DEFAULT  \"\","+
				  " Dpassword TEXT     not null"+
				")");
		//药品
		arg0.execSQL("create table Medicine ("+
	              "_id integer  primary key autoincrement,"+
				  "Mno  TEXT  DEFAULT  \"\","+  //药品编号
				  " Mname TEXT      null,"+   //药品名称
				  "Mprice        TEXT           null,"+   //药品价格
				  " Mplace        TEXT           null"+  //出产地
				  
				")");
		//病人
		arg0.execSQL("create table Patient ("+
	              "_id integer  primary key autoincrement,"+
				  " Pno   TEXT  DEFAULT  \"\","+   //住院号
				  " Pname      null,"+     //姓名
				  " Ppassword            TEXT           null,"+  //登录密码
				  " Page            TEXT           null,"+    //年龄
				  " Psex            TEXT           null,"+  //性别
				  " Pid          TEXT             null,"+  //身份证号
				  " Ptele        TEXT           null,"+   //联系电话
				  " Pis        TEXT           null,"+    //是否住院
				  " Pin        TEXT           null,"+     //住院日期
				  " Ptype       TEXT           null,"+    //疾病类型诊断
				  " Pbno       TEXT           null,"+     //床位
				  " Pcost       TEXT           null"+    //费用
				 
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
		cv.put("Mname", "999感冒灵");
		cv.put("Mprice", "9.9");
		cv.put("Mplace", "惠州市");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "2");
		cv.put("Mname", "感康复方片");
		cv.put("Mprice", "13.5");
		cv.put("Mplace", "长春市");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "3");
		cv.put("Mname", "葡萄糖");
		cv.put("Mprice", "18");
		cv.put("Mplace", "武汉市");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "4");
		cv.put("Mname", "银翘片");
		cv.put("Mprice", "15");
		cv.put("Mplace", "北京市");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "5");
		cv.put("Mname", "维生素片");
		cv.put("Mprice", "16");
		cv.put("Mplace", "西安市");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Mno", "4");
		cv.put("Mname", "感冒药");
		cv.put("Mprice", "15");
		cv.put("Mplace", "北京市");
		database.insert("Medicine", null, cv);
		
		cv=new ContentValues();
		cv.put("Rno", "1");
		cv.put("Mname", "感冒药");
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

