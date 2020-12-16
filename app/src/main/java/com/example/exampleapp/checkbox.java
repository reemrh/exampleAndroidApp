package com.example.exampleapp;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class checkbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        CheckBox checkbox2 = findViewById(R.id.checkbox2);
        CheckBox checkbox3 = findViewById(R.id.checkbox3);

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox1:
                if (checked){
                    checkbox1.setPaintFlags(checkbox1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }else {
                    checkbox1.setPaintFlags(checkbox1.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
                break;
            case R.id.checkbox2:
                if (checked){
                    checkbox2.setPaintFlags(checkbox2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }else {
                    checkbox2.setPaintFlags(checkbox2.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
                break;
            case R.id.checkbox3:
                if (checked){
                    checkbox3.setPaintFlags(checkbox3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }else {
                    checkbox3.setPaintFlags(checkbox3.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
                break;

            // TODO: Veggie sandwich
        }
    }
}