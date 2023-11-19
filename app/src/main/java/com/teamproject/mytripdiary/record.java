package com.teamproject.mytripdiary;

import static com.teamproject.mytripdiary.R.id.btn_plus;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class record extends AppCompatActivity {

    private ImageButton btn_home;
    private ImageButton btn_plus;
    private ImageButton btn_record;

    private DBHelper dbHelper;

    private  void showTravelRecords(){
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatbase();

        String query = "SELECT * FROM tbl_record";
        Cursor cursor = db.rawQuery(query, null);

    }




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

}