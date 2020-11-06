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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.text1);
        EditText edittext = findViewById(R.id.editText);
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!edittext.getText().toString().equals("")){
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("number", Integer.parseInt(tv.getText().toString())
                            + Integer.parseInt(edittext.getText().toString()));
                    startActivityForResult(intent, 1);
                }
                else
                    Toast.makeText(MainActivity.this, R.string.error_message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Integer result = data.getIntExtra("result", 0);
                TextView tv = (TextView) findViewById(R.id.text1);
                tv.setText(result.toString());
                EditText edittext = findViewById(R.id.editText);
                edittext.setText("");
            }
        }
    }
}