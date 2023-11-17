package com.teamproject.mytripdiary;

import static com.teamproject.mytripdiary.R.id.btn_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn_home;
    private ImageButton btn_plus;
    private ImageButton btn_record;

    private Button btn_ex;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_plus = new Intent(MainActivity.this , Plus1.class);
                startActivity(go_plus);

            }
        });

        btn_ex = findViewById(R.id.btn_ex);
        btn_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_ex = new Intent(MainActivity.this , SetLocation.class);
                startActivity(go_ex);
            }
        });

    }

}