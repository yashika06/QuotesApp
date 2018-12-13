package com.iskylar.yashika.quoteswallpaper.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.iskylar.yashika.quoteswallpaper.Model.Image;

import java.util.ArrayList;

/**
 * Created by Yashika on 12-07-2017.
 */

public class DownloadDbHelper {

    private SQLiteDatabase wdatabase;
    private SQLiteDatabase rdatabase;
    public static final String DWNLD_TABLE = "downloads";
    public static final String IMAGE_ID = "image";
    public static final String IMAGE_DES = "description";
    private Context context;
    private DBHelper dbHelper;
    public DownloadDbHelper(Context context) {
        this.context=context;
        dbHelper = new DBHelper(context);
        wdatabase = dbHelper.getWritableDatabase();
        rdatabase = dbHelper.getReadableDatabase();
    }
    public boolean insertData(int imageRes,String desc){

        if (!checkExistence(imageRes)){
            ContentValues values = new ContentValues();
            values.put(IMAGE_ID,imageRes);
            values.put(IMAGE_DES,desc);
            wdatabase.insert(DWNLD_TABLE,null,values);
            Toast.makeText(context,"image inserted",Toast.LENGTH_SHORT).show();
            wdatabase.close();
            return true;
        }
        else return false;

    }
    public boolean checkExistence(int imageRes){

        String query = "SELECT "+IMAGE_ID+" FROM "+DWNLD_TABLE+" WHERE "+IMAGE_ID+" = '"+imageRes+"'";
        Cursor cursor = rdatabase.rawQuery(query,null);
        if (cursor.getCount()>0){
            return true;
        }
        else return false;
    }
    public ArrayList<Image> retrieveData(){

        String query = "SELECT * FROM "+DWNLD_TABLE+"";
        Cursor cursor = rdatabase.rawQuery(query,null);
        ArrayList<Image> list = new ArrayList<>();
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                list.add(new Image(cursor.getInt(0), cursor.getString(1)));
                Toast.makeText(context, "list created", Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(context, "size of list: "+list.size(), Toast.LENGTH_SHORT).show();
        return list;
    }
}
