package com.iskylar.yashika.quoteswallpaper.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by Yashika on 04-07-2017.
 */

public class FavouriteDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="Quotes";
    private static final String TABLE_NAME = "favourites";
    private static final String IMAGE_ID = "image";
    private Context context;
    public FavouriteDbHelper(Context context) {
        super(context, DB_NAME,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+IMAGE_ID+" INTEGER PRIMARY KEY ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+"");

    }
    public boolean insertData(int imageRes){
        SQLiteDatabase database = this.getWritableDatabase();
        if (!checkExistence(imageRes)){
            ContentValues values = new ContentValues();
            values.put(IMAGE_ID,imageRes);
            database.insert(TABLE_NAME,null,values);
            database.close();
            return true;
        }
        else return false;

    }

    public boolean checkExistence(int imageRes){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT "+IMAGE_ID+" FROM "+TABLE_NAME+" WHERE "+IMAGE_ID+" = '"+imageRes+"'";
        Cursor cursor = database.rawQuery(query,null);
        if (cursor.getCount()>0){
            return true;
        }
        else return false;
    }

    public ArrayList<Integer> retrieveData(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+"";
        Cursor cursor = database.rawQuery(query,null);
        ArrayList<Integer> list = new ArrayList<>();
        while (cursor.moveToNext()){
            list.add(cursor.getInt(0));
        }

        return list;
    }
    public boolean deleteImage(int imageRes){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME,IMAGE_ID+"='"+imageRes+"'",null);
        return false;
    }
}
