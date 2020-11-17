package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewLifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLifeCycle = findViewById(R.id.textViewLifeCycle);
        Log.d("LifeCycle: ", "onCreate()");
        textViewLifeCycle.append("onCreate()" + "\n");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle: ", "onRestart()");
        textViewLifeCycle.append("onRestart()" + "\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle: ", "onStart()");
        textViewLifeCycle.append("onStart()" + "\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle: ", "onResume()");
        textViewLifeCycle.append("onResume()" + "\n");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle: ", "onPause()");
        textViewLifeCycle.append("onPause()" + "\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle: ", "onStop()");
        textViewLifeCycle.append("onStop()" + "\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle: ", "onDestroy()");
        textViewLifeCycle.append("onDestroy()" + "\n");
    }
}