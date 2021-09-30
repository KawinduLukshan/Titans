package com.example.sqliteexample.DataBase;

import android.provider.BaseColumns;

public final class PA_Master {

    private PA_Master(){}

    public static class Pappointment implements BaseColumns{
        public static final String TABLE_NAME_1  = "pappointments";
        public static final String COLUMN_NAME_PNAME1 = "p_name1";
        public static final String COLUMN_NAME_PAGE1 = "p_age1";
        public static final String COLUMN_NAME_PNIC1 = "p_nic1";
        public static final String COLUMN_NAME_PPHONE1 = "p_phone1";
        public static final String COLUMN_NAME_PDATE1 = "p_date1";
        public static final String COLUMN_NAME_DOC1 = "p_doctor1";
        public static final String COLUMN_NAME_HOS1 = "p_hospital1";
    }

    public static class Appointment_Pay implements BaseColumns{
        public static final String TABLE_NAME_02 = "appointment_pay";
        public static final String COLUMN_NAME_BANKNAME = "p_bankname1";
        public static final String COLUNM_NAME_CARDNO = "pcardno";
        public static final String COLUNM_NAME_CVV = "cvvno";
        public static final String COLUMN_NAME_EXPIREDATE = "expiredate";
    }
}
