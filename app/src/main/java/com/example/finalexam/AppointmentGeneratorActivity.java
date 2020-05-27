package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppointmentGeneratorActivity extends AppCompatActivity {

    Button btnRegisterA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_generator);

        btnRegisterA = findViewById(R.id.btnRegisterA);
        btnRegisterA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMenuActivity();
            }
        });
    }

    public void startMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
