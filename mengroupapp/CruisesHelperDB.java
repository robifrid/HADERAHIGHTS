package com.example.dor.mengroupapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dor on 20/01/2018.
 */

public class CruisesHelperDB extends SQLiteOpenHelper {

    private  static final String DB_NAME = "MGC_cruises.db";
    private  static final int DB_VERSION = 1;

    public  static final String TBL_CRUISES = "TBL_MGSCRUISES";
    public  static final String CRU_NUMBER = "CruseNumber";  // auto increment primary key
    public  static final String CRU_RES = "CruseReservation"; // a number obtained from the CLUB reservation WEB site
    public  static final String CRU_DATE = "CruseDate";
    public  static final String CRU_FROM = "CruseFromHour";
    public  static final String CRU_TO = "CruseToHour";
    public  static final String CRU_ROUND = "CruseRound";  // number of round (increments after all members finished a round)
    public  static final String CRU_SHIP = "CruseShip";  // ship name, default value Toma
    public  static final String CRU_TOOK_PLACE = "CruseTookPlace";  // "Y" - for YES, "N" - for NO
    public  static final String CRU_SKIPPER_CODE = "CruseSkipperCode";  // responsible skipper
    public  static final String CRU_NEW_NUMBER = "CruseNewNumber";  // CRU_number of postponed cruise
    public  static final String CRU_COMMENTS = "CruseComments";
    public  static final String CRU_NOTES = "CruseNotes";
    public  static final String CRU_WEATHER = "CruseWeather";
    public  static final String CRU_COLOR = "CruseColor";  // color to use for different cruise status
    public  static final String CRU_MEDIA = "CruseMedia"; // connected media
    public  static final String CRU_MENU = "CruseMenu"; //connected menu
    public  static final String CRU_GUESTS = "CruseGuests";



    public CruisesHelperDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createString = "CREATE TABLE " + TBL_CRUISES;
        createString += " ( " + CRU_NUMBER + " INTEGET PRIMARY KEY, ";
        createString += CRU_RES + " INTEGER, ";
        createString += CRU_DATE + " TEXT, ";
        createString += CRU_FROM + " TEXT, ";
        createString += CRU_TO + " TEXT, ";
        createString += CRU_ROUND + " TEXT, ";
        createString += CRU_SHIP + " TEXT, ";
        createString += CRU_TOOK_PLACE + " TEXT, ";
        createString += CRU_SKIPPER_CODE + " INTEGER, ";
        createString += CRU_NEW_NUMBER + " INTEGER, ";
        createString += CRU_COMMENTS + " TEXT, ";
        createString += CRU_NOTES + " TEXT, ";
        createString += CRU_WEATHER + " TEXT, ";
        createString += CRU_COLOR + " INTEGER, ";
        createString += CRU_MEDIA + " TEXT, ";
        createString += CRU_MENU + " TEXT, ";
        createString += CRU_GUESTS + " TEXT);";
        db.execSQL(createString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteString = "DROP TABLE IF EXISTS " + TBL_CRUISES;
        db.execSQL(deleteString);
        onCreate(db);

    }
}
