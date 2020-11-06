package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.text1);
        EditText edittext = findViewById(R.id.editText);
        Integer input = getIntent().getIntExtra("number", 0);
        tv.setText(input.toString());

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!edittext.getText().toString().equals("")){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result", Integer.parseInt(tv.getText().toString())
                            + Integer.parseInt(edittext.getText().toString()));
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }
                else
                    Toast.makeText(Activity2.this, R.string.error_message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}