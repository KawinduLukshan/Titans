package com.example.echanneling_system.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PA_DBHelper extends SQLiteOpenHelper {

    public static final String DATA_BASE_NAME = "echannelingInfo.db";

    public PA_DBHelper(Context context) {
        super(context, DATA_BASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase adb) {

        String SQL_P_APPOINTMENT_CREATE = "CREATE TABLE "+PA_Master.Pappointment.TABLE_NAME_1+" ("+
               PA_Master.Pappointment._ID+" INTEGER PRIMARY KEY,"+
               PA_Master.Pappointment.COLUMN_NAME_PNAME1+" TEXT,"+
               PA_Master.Pappointment.COLUMN_NAME_PAGE1+" TEXT,"+
               PA_Master.Pappointment.COLUMN_NAME_PNIC1+" TEXT,"+
               PA_Master.Pappointment.COLUMN_NAME_PPHONE1+" TEXT,"+
               PA_Master.Pappointment.COLUMN_NAME_PDATE1+" TEXT,"+
               PA_Master.Pappointment.COLUMN_NAME_DOC1+" TEXT,"+
               PA_Master.Pappointment.COLUMN_NAME_HOS1+" TEXT)";

        adb.execSQL(SQL_P_APPOINTMENT_CREATE);

        String SQL_APPOINTMANTPAY_CREATE = "CREATE TABLE "+PA_Master.Appointment_Pay.TABLE_NAME_02+" ("+
                PA_Master.Appointment_Pay._ID+" INTEGER PRIMARY KEY,"+
                PA_Master.Appointment_Pay.COLUMN_NAME_BANKNAME+" TEXT,"+
                PA_Master.Appointment_Pay.COLUNM_NAME_CARDNO+" TEXT,"+
                PA_Master.Appointment_Pay.COLUNM_NAME_CVV+" TEXT,"+
                PA_Master.Appointment_Pay.COLUMN_NAME_EXPIREDATE+" TEXT)";

        adb.execSQL(SQL_APPOINTMANTPAY_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public long addappointment(String p_name1,String p_age1,String p_nic1,String p_phone1,String p_date1,String p_doctor1, String p_hospital1){
        SQLiteDatabase adb = getWritableDatabase();

        ContentValues cval = new ContentValues();

        cval.put(PA_Master.Pappointment.COLUMN_NAME_PNAME1,p_name1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_PAGE1,p_age1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_PNIC1,p_nic1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_PPHONE1,p_phone1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_PDATE1,p_date1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_DOC1,p_doctor1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_HOS1,p_hospital1);

        long RowId1 = adb.insert(PA_Master.Pappointment.TABLE_NAME_1,null,cval);
        return RowId1;
    }

    public void deleteappointment(String p_name1){
        SQLiteDatabase adb = getReadableDatabase();
        String selection1 = PA_Master.Pappointment.COLUMN_NAME_PNAME1 + " LIKE ?";
        String [] selectionArgs1 = {p_name1};
        adb.delete(PA_Master.Pappointment.TABLE_NAME_1,selection1,selectionArgs1);
    }

    public int updateappointment(String p_name1,String p_age1,String p_nic1,String p_phone1,String p_date1){
        SQLiteDatabase adb = getReadableDatabase();
        ContentValues cval = new ContentValues();

        cval.put(PA_Master.Pappointment.COLUMN_NAME_PNIC1,p_age1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_PNIC1,p_nic1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_PPHONE1,p_phone1);
        cval.put(PA_Master.Pappointment.COLUMN_NAME_PDATE1,p_date1);

        String selection1 = PA_Master.Pappointment.COLUMN_NAME_PNAME1 +" LIKE ?";
        String[] selectionArgs1 = {p_name1};

        int count1 = adb.update(
                PA_Master.Pappointment.TABLE_NAME_1,
                cval,
                selection1,
                selectionArgs1
        );
        return count1;

    }

    //add new payment
    public long appointmentpayment(String p_bankname1,String pcardno ,String cvvno ,String expiredate){
        SQLiteDatabase pdb = getWritableDatabase();

        ContentValues cval2 =new ContentValues();

        cval2.put(PA_Master.Appointment_Pay.COLUMN_NAME_BANKNAME,p_bankname1);
        cval2.put(PA_Master.Appointment_Pay.COLUNM_NAME_CARDNO,pcardno);
        cval2.put(PA_Master.Appointment_Pay.COLUNM_NAME_CVV,cvvno);
        cval2.put(PA_Master.Appointment_Pay.COLUMN_NAME_EXPIREDATE,expiredate);

        long RowID2 = pdb.insert(PA_Master.Appointment_Pay.TABLE_NAME_02,null,cval2);
        return RowID2;
    }
}

