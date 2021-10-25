package id.arya.sqlite;

import  android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import id.arya.sqlite.TabelHewan.*;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TernaKuDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db_ternaku";
    public TernaKuDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_HEWAN);
    }

    private static final String SQL_CREATE_TABLE_HEWAN = "CREATE TABLE "+
            KolomHewan.TABLE_NAME + " (" +
            KolomHewan._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KolomHewan.COLUMN_NAME_NAMA_HEWAN + " TEXT,  " +
            KolomHewan.COLUMN_NAME_JENIS_KELAMIN + " TEXT" +
            ");";


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DROP_TABLE_HEWAN);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_DROP_TABLE_HEWAN = "DROP TABLE IF EXISTS "+ KolomHewan.TABLE_NAME;

    public List<Hewan> getAllData(){
        List<Hewan> allHewan= new ArrayList<>();
        String querry = "SELECT * FROM " +KolomHewan.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(querry,null);
        if(cursor.moveToFirst()){
            do {
                Hewan insertHewan = new Hewan(cursor.getString(1),cursor.getString(2));
                allHewan.add(insertHewan);
            }while (cursor.moveToNext());
        }
        return  allHewan;
    }
}
