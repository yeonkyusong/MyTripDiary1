package com.teamproject.mytripdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PlanPerDay extends AppCompatActivity {

    private ImageButton btn_home;

    private LinearLayout layoutButtons;
    private String startDate, endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_per_day);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent go_home= new Intent(PlanPerDay.this , MainActivity.class);
                                            startActivity(go_home);
                                        }
                                    });

                // 여행 시작날짜와 종료날짜를 받아옴
                startDate = getIntent().getStringExtra("start_date");
        endDate = getIntent().getStringExtra("end_date");

        layoutButtons = findViewById(R.id.layoutButtons);

        try {
            // 날짜 형식을 파싱하여 Date 객체로 변환
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);

            // 여행 기간 계산
            Calendar calendarStart = Calendar.getInstance();
            Calendar calendarEnd = Calendar.getInstance();
            calendarStart.setTime(start);
            calendarEnd.setTime(end);
            long diffMillis = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
            int days = (int) (diffMillis / (24 * 60 * 60 * 1000)) + 1; // 시작일을 포함하기 위해 +1 추가

            // 버튼 생성
            for (int i = 1; i <= days; i++) {
                Button button = new Button(this);
                button.setText(i + "일차 계획");
                button.setId(i);
                final int dayNumber = i;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PlanPerDay.this, NewDayActivity.class);
                        intent.putExtra("day_number", dayNumber); // 클릭한 버튼의 날짜 정보를 전달
                        startActivity(intent);
                    }
                });
                layoutButtons.addView(button);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}