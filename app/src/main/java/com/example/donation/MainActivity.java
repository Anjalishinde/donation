package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void loginbutt(View view){
        Toast.makeText(this,"login",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this, MainHome.class);
        startActivity(intent);
    }
}