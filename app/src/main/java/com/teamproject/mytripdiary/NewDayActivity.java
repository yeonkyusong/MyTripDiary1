// NewDayActivity.java

package com.teamproject.mytripdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class NewDayActivity extends AppCompatActivity {

    private ImageButton btn_home;
    private Button btn_next;
    private EditText editTextTime;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_day);


                btn_home = findViewById(R.id.btn_home);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        // PlanPerDay 액티비티에서 전달한 날짜 정보 받기
        int dayNumber = getIntent().getIntExtra("day_number", 0);

        // 날짜 정보를 화면에 표시
        TextView textView = findViewById(R.id.textViewDayNumber);
        textView.setText(String.format(Locale.getDefault(), "%d일차 계획", dayNumber));
        btn_home.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent go_home = new Intent(NewDayActivity.this , MainActivity.class);
                                            startActivity(go_home);

                                        }
                                    });

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_setlocation = new Intent(NewDayActivity.this ,SetLocation.class);
                startActivity(go_setlocation);
            }
        });


    }
}
