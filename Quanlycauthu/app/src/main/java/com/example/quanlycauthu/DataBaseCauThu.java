package com.example.quanlycauthu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseCauThu extends SQLiteOpenHelper {
    public DataBaseCauThu(@Nullable Context context) {
        super(context, "footballmanager.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE IF NOT EXISTS CAUTHU(ID INTEGER PRIMARY KEY AUTOINCREMENT,TENCT TEXT,SOAO INTEGER,DIACHI TEXT)";
        String insert1 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Lương Xuân Trường',7,'Hoàng Anh Gia Lai')";
        String insert2 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Nguyễn Văn Toàn',9,'Hoàng Anh Gia Lai')";
        String insert3 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Nguyễn Công Phượng',10,'Hoàng Anh Gia Lai')";
        String insert4 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Nguyễn Quang Hải',23,'CLB Hà Nội')";
        String insert5 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Bùi Tiến Dũng',1,'FLC Thanh Hóa')";
        String insert6 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Vũ Văn Thanh',17,'Hoàng Anh Gia Lai')";

        db.execSQL(sql);
    }
    public void excutequery(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public ArrayList<CauThu> danhSachCauThu()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<CauThu> cauThuArrayList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM CAUTHU",null );
        if(cursor.moveToFirst())
        {
            do {
                String ten,diachi;
                int id,soao;
                id = cursor.getInt(0);
                ten = cursor.getString(1);
                soao = cursor.getInt(2);
                diachi = cursor.getString(3);
                cauThuArrayList.add(new CauThu(id,ten,soao,diachi));
            }while (cursor.moveToNext());
        }
        return cauThuArrayList;
    }
    public boolean CapNhatCauThu(CauThu cauThu)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TENCT",cauThu.getTen());
        cv.put("SOAO",cauThu.getSoao());
        cv.put("DIACHI",cauThu.getDiachi());
        long update = db.update("CAUTHU",cv,"ID = "+cauThu.getId(),null);
        if(update == -1)
        {
            return false;
        }
        return true;
    }

    public boolean XoaCauThu(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long delete = db.delete("CAUTHU","ID = "+id,null);
        if(delete == -1)
        {
            return false;
        }
        return true;
    }



}
