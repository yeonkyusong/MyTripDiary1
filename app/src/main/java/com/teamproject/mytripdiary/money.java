package com.teamproject.mytripdiary;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 패키지, import 선언 등은 여기에 포함

public class money extends AppCompatActivity {

    private LinearLayout userAndLocationCategoryLayout;
    private ImageButton plusButton;
    private int totalAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAndLocationCategoryLayout = findViewById(R.id.user_and_location_category_layout);
        plusButton = findViewById(R.id.plus);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserAndLocationCategoryLayout();
            }
        });
    }

    private void addUserAndLocationCategoryLayout() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View newUserAndLocationCategoryLayout = inflater.inflate(R.layout.user_and_location_category_layout, userAndLocationCategoryLayout, false);
        newUserAndLocationCategoryLayout.setId(View.generateViewId());
        userAndLocationCategoryLayout.addView(newUserAndLocationCategoryLayout);
        setUserInfoAndLocationCategoryLayoutListeners(newUserAndLocationCategoryLayout);
    }

    private void setUserInfoAndLocationCategoryLayoutListeners(View newUserAndLocationCategoryLayout) {
        EditText editTextAmount = newUserAndLocationCategoryLayout.findViewById(R.id.editTextAmount);
        editTextAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 텍스트 변경 전에 수행할 작업
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 텍스트가 변경될 때 수행할 작업
            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculateTotalAmount();
            }
        });
    }

    private void calculateTotalAmount() {
        totalAmount = 0;
        for (int i = 0; i < userAndLocationCategoryLayout.getChildCount(); i++) {
            View childView = userAndLocationCategoryLayout.getChildAt(i);
            EditText editTextAmount = childView.findViewById(R.id.editTextAmount);
            if (editTextAmount != null && editTextAmount.getText() != null && !editTextAmount.getText().toString().isEmpty()) {
                totalAmount += Integer.parseInt(editTextAmount.getText().toString());
            }
        }
        TextView totalExpenseTextView = findViewById(R.id.totalExpenseTextView);
        totalExpenseTextView.setText("총 금액: " + totalAmount + " 원");
    }
}
