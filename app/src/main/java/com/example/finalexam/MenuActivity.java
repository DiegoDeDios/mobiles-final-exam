package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    CardView cGenerateA,
            cListA,
            cLocation,
            cCall;

    ImageView qrImage;

    //qrpopup.xml
    //---------------------------
    Dialog dialog;

    ImageView closebtnimage;

    Button btnAccept;

    TextView titlePopUp,
            etMessage;
    //-----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cGenerateA = findViewById(R.id.generateA);
        cListA = findViewById(R.id.listsA);
        cLocation = findViewById(R.id.locationM);
        cCall = findViewById(R.id.emergencyCall);
        qrImage = findViewById(R.id.qrImage);
        dialog = new Dialog(this);
        
        cGenerateA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Generar Appo", Toast.LENGTH_SHORT).show();
                startGeneratorActivity();
            }
        });
        
        cListA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Lista Appo", Toast.LENGTH_SHORT).show();
                startListAppointmentActivity();
            }
        });

        cLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Ubicacion", Toast.LENGTH_SHORT).show();
            }
        });

        cCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Llamar", Toast.LENGTH_SHORT).show();
            }
        });

        qrImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Aparece QR", Toast.LENGTH_SHORT).show();
                showPopUp();
            }
        });

    }

    public void startListAppointmentActivity(){
        Intent intent = new Intent(this, AppointmentActivity.class);
        startActivity(intent);
    }

    public void startGeneratorActivity(){
        Intent intent = new Intent(this, AppointmentGeneratorActivity.class);
        startActivity(intent);
    }

    public void showPopUp(){
        dialog.setContentView(R.layout.qrpopup);
        closebtnimage = (ImageView) dialog.findViewById(R.id.closebtnimage);
        btnAccept = (Button) dialog.findViewById(R.id.btnAccept);
        titlePopUp = (TextView) dialog.findViewById(R.id.titlePopUp);
        etMessage = (TextView) dialog.findViewById(R.id.etMessage);

        closebtnimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
