package com.teamproject.mytripdiary;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.teamproject.mytripdiary.PlanPerDay;

import java.util.Calendar;

public class Plus2 extends AppCompatActivity {

    private Button btn_next, btn_selectStartDate, btn_selectEndDate;
    private Calendar calendar;
    private ImageButton btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus2);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent go_home = new Intent(Plus2.this, MainActivity.class);
                                            startActivity(go_home);

                                        }
                                    });

                btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_planperday = new Intent(Plus2.this, PlanPerDay.class);
                startActivity(go_planperday);
            }
        });

        btn_selectStartDate = findViewById(R.id.btn_selectStartDate);
        btn_selectEndDate = findViewById(R.id.btn_selectEndDate);
        calendar = Calendar.getInstance();

        btn_selectStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog("start");
            }
        });

        btn_selectEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog("end");
            }
        });
    }

    private void showDatePickerDialog(final String dateType) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;

                        if (dateType.equals("start")) {
                            // Handle the selected start date
                            // Example: txtStartDate.setText(selectedDate);
                        } else if (dateType.equals("end")) {
                            // Handle the selected end date
                            // Example: txtEndDate.setText(selectedDate);
                        }

                        Toast.makeText(Plus2.this, "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();
                    }
                },
                year, month, dayOfMonth);

        datePickerDialog.show();
    }
}
