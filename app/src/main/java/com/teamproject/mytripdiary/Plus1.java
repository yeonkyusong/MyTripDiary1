package com.teamproject.mytripdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Plus1 extends AppCompatActivity {

    private Button btn_next;
    private Button btn_home;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus1);

        btn_next = findViewById(R.id.btn_next);
        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_home = new Intent(Plus1.this , MainActivity.class);
                startActivity(go_home);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_plus2 = new Intent(Plus1.this , Plus2.class);
                startActivity(go_plus2);
            }
        });

    }
}