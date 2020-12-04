package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainService mainService;
    boolean mainBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MainService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        mainBound = false;
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            MainService.LocalBinder binder = (MainService.LocalBinder) service;
            mainService = binder.getService();
            mainBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mainBound = false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        EditText e1 = findViewById(R.id.e1);
        EditText e2 = findViewById(R.id.e2);
        TextView text1 = findViewById(R.id.text1);
        int number1 = Integer.parseInt(e1.getText().toString());
        int number2 = Integer.parseInt(e2.getText().toString());

        switch (item.getItemId()) {
            case R.id.menu_addition:
                text1.setText(mainService.addition(number1, number2)+"");
                return true;
            case R.id.menu_subtraction:
                text1.setText(mainService.subtraction(number1, number2)+"");
                return true;
            case R.id.menu_multiplication:
                text1.setText(mainService.multiplication(number1, number2)+"");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}