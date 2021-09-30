package com.example.sqliteexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperConnectClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 4;
    //Database Name
    private static final String DATABASE_NAME = "echannelingInfo_database";
    //Database Table name
    private static final String TABLE_NAME = "DOCTOR";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String HOSPITAL = "hospital";
    public static final String SPECIALIZATION = "specialization";
    public static final String CONTACTNUMBER = "contactnumber";




    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+HOSPITAL+" TEXT NOT NULL,"
            +SPECIALIZATION+" TEXT NOT NULL,"+CONTACTNUMBER+" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelperConnectClass(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Doctor Data
    public void addDoctor(DoctorModelClass doctorModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperConnectClass.NAME, doctorModelClass.getName());
        contentValues.put(DatabaseHelperConnectClass.EMAIL, doctorModelClass.getEmail());
        contentValues.put(DatabaseHelperConnectClass.HOSPITAL, doctorModelClass.getHospital());
        contentValues.put(DatabaseHelperConnectClass.SPECIALIZATION, doctorModelClass.getSpecialization());
        contentValues.put(DatabaseHelperConnectClass.CONTACTNUMBER, doctorModelClass.getContactnumber());


        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperConnectClass.TABLE_NAME, null,contentValues);
    }

    public List<DoctorModelClass> getDoctorList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<DoctorModelClass> storeDoctor = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String hospital = cursor.getString(3);
                String specialization = cursor.getString(4);
                String contactnumber = cursor.getString(5);



                storeDoctor.add(new DoctorModelClass(id,name,email,hospital,specialization,contactnumber));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctor;
    }
    //update Doctor
     public void updateDoctor(DoctorModelClass doctorModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperConnectClass.NAME,doctorModelClass.getName());
        contentValues.put(DatabaseHelperConnectClass.EMAIL,doctorModelClass.getEmail());
        contentValues.put(DatabaseHelperConnectClass.HOSPITAL, doctorModelClass.getHospital());
        contentValues.put(DatabaseHelperConnectClass.SPECIALIZATION, doctorModelClass.getSpecialization());
        contentValues.put(DatabaseHelperConnectClass.CONTACTNUMBER, doctorModelClass.getContactnumber());




        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(doctorModelClass.getId())});
    }
    //Delete Doctor
    public void deleteDoctor(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}

