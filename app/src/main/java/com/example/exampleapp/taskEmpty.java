package com.example.exampleapp;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class taskEmpty extends AppCompatActivity {

    CheckBox checkbox_example;
    TextView checkboxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_empty);
        checkbox_example = findViewById(R.id.checkbox_example);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        checkboxValue = findViewById(R.id.checkboxValue);

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_example:
                if (checked) {
                    checkbox_example.setPaintFlags(checkbox_example.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    checkboxValue.setText("" + checkbox_example.isChecked());
                } else {
                    checkbox_example.setPaintFlags(checkbox_example.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    checkboxValue.setText("" + checkbox_example.isChecked());
                }

                break;

            // TODO: Veggie sandwich
        }
    }
}