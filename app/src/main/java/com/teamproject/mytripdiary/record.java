package com.teamproject.mytripdiary;

import static com.teamproject.mytripdiary.R.id.btn_plus;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.w3c.dom.Text;


public class record extends AppCompatActivity {

    private MyDatabase myDatabase;
    private ImageButton btn_home;
    private ImageButton btn_plus;
    private ImageButton btn_record;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_home = new Intent(record.this , MainActivity.class);
                startActivity(go_home);

            }
        });


    }

    private  void showTravelRecords(){
        // DatabaseHelper 클래스를 사용하여 데이터베이스에 접근
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // 여행 기록을 조회하는 쿼리
        String query = "SELECT * FROM tbl_record";
        Cursor cursor = db.rawQuery(query, null);

        // 결과를 반복하면서 처리
        while (cursor.moveToNext()){
            @SuppressLint("Range") 
            int recordId = cursor.getInt(cursor.getColumnIndex("recordId"));
            @SuppressLint("Range")
            int idx = cursor.getInt(cursor.getColumnIndex("idx"));
            @SuppressLint("Range")
            int day = cursor.getInt(cursor.getColumnIndex("day"));
            @SuppressLint("Range")
            int time = cursor.getInt(cursor.getColumnIndex("time"));
            @SuppressLint("Range")
            String title = cursor.getString(cursor.getColumnIndex("title"));
            @SuppressLint("Range")
            String location = cursor.getString(cursor.getColumnIndex("location"));
            @SuppressLint("Range")
            String start_date = cursor.getString(cursor.getColumnIndex("start_date"));
            @SuppressLint("Range")
            String end_date = cursor.getString(cursor.getColumnIndex("end_date"));
            @SuppressLint("Range")
            String x = cursor.getString(cursor.getColumnIndex("x"));
            @SuppressLint("Range")
            String y = cursor.getString(cursor.getColumnIndex("y"));

            // 여기에서 가져온 데이터를 사용하여 UI에 표시하거나 다른 작업 수행
        }
        //사용이 끝난 리소스 해제
        cursor.close();
        dbHelper.close();
    }

}