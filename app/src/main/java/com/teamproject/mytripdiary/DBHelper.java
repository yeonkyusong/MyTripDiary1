package com.teamproject.mytripdiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDatabase";

    private static final int DATABASE_VERSION = 1;

    // 테이블 생성 쿼리
    private static final String CREATE_TABLE_TRIP =
            "CREATE TABLE IF NOT EXISTS tbl_trip (\n" +
                    "    `idx` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    title TEXT,\n" +
                    "    start_date DATE,\n" +
                    "    end_date DATE\n" +
                    ");";
    private static final String CREATE_TABLE_SCHEDULE =
            "CREATE TABLE IF NOT EXISTS tbl_schedule (\n" +
                    "    `idx` INTEGER NOT NULL,\n" +
                    "    `day` INTEGER NOT NULL,\n" +
                    "    `time` TEXT NOT NULL,\n" +
                    "    `location` TEXT DEFAULT NULL,\n" +
                    "    `x` REAL DEFAULT NULL,\n" +
                    "    `y` REAL DEFAULT NULL,\n" +
                    "    PRIMARY KEY (`idx`, `day`, `time`)\n" +
                    ");\n";

    private static final String CREATE_TABLE_RECORD =
            "CREATE TABLE IF NOT EXISTS tbl_record (\n" +
                    "    'recordId' INTEGER NOT NULL,\n" +
                    "    `idx` INTEGER NOT NULL,\n" +
                    "    `day` INTEGER NOT NULL,\n" +
                    "    `time` TEXT NOT NULL,\n" +
                    "    `location` TEXT DEFAULT NULL,\n" +
                    "    `x` REAL DEFAULT NULL,\n" +
                    "    `y` REAL DEFAULT NULL,\n" +
                    "    title TEXT,\n" +
                    "    start_date DATE,\n" +
                    "    end_date DATE,\n" +
                    "    PRIMARY KEY (`idx`, `day`, `time`)\n" +
                    ");\n";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TRIP);
        db.execSQL(CREATE_TABLE_SCHEDULE);
        db.execSQL(CREATE_TABLE_RECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 데이터베이스 업그레이드 시 필요한 작업 수행
    }

}
