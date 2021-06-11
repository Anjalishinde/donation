package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.donation.databinding.ActivitySignupBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loginbutt(View view){
        Toast.makeText(this,"login",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this, signup.class);
        startService(intent);
    }
}