package com.teamproject.mytripdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class MyDatabase {

    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public MyDatabase(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // 첫 번째 테이블에 데이터 삽입
    public long insertDataToTrip(String title, String start_date, String end_date) {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("start_date", start_date);
        values.put("end_date", end_date);
        return database.insert("tbl_trip", null, values);
    }

    // 두 번째 테이블에 데이터 삽입
    public long insertDataToSchedule(int idx, int day, String time, String location, double x, double y) {
        ContentValues values = new ContentValues();
        values.put("idx", idx);
        values.put("day", day);
        values.put("time", time);
        values.put("location", location);
        values.put("x", x);
        values.put("y", y);
        return database.insert("tbl_schedule", null, values);
    }

    // 첫 번째 테이블에서 모든 데이터 조회
    public Cursor getAllDataFromTrip() {
        String[] columns = {"idx", "title", "start_date", "end_date"};
        return database.query("tbl_trip", columns, null, null, null, null, null);
    }

    // 두 번째 테이블에서 모든 데이터 조회
    public Cursor getAllDataFromSchedule() {
        String[] columns = {"idx", "day", "time", "location", "x", "y"};
        return database.query("tbl_schedule", columns, null, null, null, null, null);
    }

    // 기타 필요한 메서드들...
}
