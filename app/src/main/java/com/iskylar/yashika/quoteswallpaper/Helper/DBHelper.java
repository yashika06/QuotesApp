package com.iskylar.yashika.quoteswallpaper.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yashika on 12-07-2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="Quotes";
    private static final String FAV_TABLE = "favourites";
    private static final String DWNLD_TABLE = "downloads";
    private static final String IMAGE_ID = "image";
    private static final String IMAGE_DES = "description";
    private Context context;
    public DBHelper(Context context) {
        super(context, DB_NAME,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+FAV_TABLE+" ( "+IMAGE_ID+" INTEGER PRIMARY KEY, "+IMAGE_DES+" VARCHAR ) ");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+DWNLD_TABLE+" ( "+IMAGE_ID+" INTEGER PRIMARY KEY, "+IMAGE_DES+" VARCHAR ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+FAV_TABLE+"");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DWNLD_TABLE+"");
    }
}
