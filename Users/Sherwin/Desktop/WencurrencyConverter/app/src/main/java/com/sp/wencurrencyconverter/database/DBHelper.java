package com.sp.wencurrencyconverter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.sp.wencurrencyconverter.Constants;

/**
 * Created by Sherwin on 4/26/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+ Constants.DATABASE_BASE
                               + Constants.COLUMN_BASE_ID + "( INTEGER PRIMARY KEY AUTO INCREMENT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS currency");
        onCreate(db);
    }

    public boolean insertCurrency(String base,String rate,String date){

        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.CURRENCY_COLUMN_BASE, base);
            contentValues.put(Constants.CURRENCY_COLUMN_RATES, rate);
            contentValues.put(Constants.CURRENCY_COLUMN_LAST_UPDATE, date);
            db.insert(Constants.DATABASE_TABLE_RATES, null, contentValues);
        }catch (SQLiteException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }


    public Cursor getCurrency(String[] currencyCodes){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT ",null);

        return null;
    }

}
