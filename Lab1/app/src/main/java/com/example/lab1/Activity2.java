package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.text1);
        if (getIntent().getStringExtra("number")!=null){
            tv.setText(getIntent().getStringExtra("number"));
        }
        EditText edittext = findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!edittext.getText().toString().equals("")&&edittext.getText().toString().matches("-?\\d+(\\.\\d+)?")) {
                    Intent intent = new Intent(Activity2.this, MainActivity.class);
                    intent.putExtra("number",
                            Integer.parseInt(tv.getText().toString())
                                    + Integer.parseInt(edittext.getText().toString()) + "");
                    startActivity(intent);
                }
            }
        });

    }
}