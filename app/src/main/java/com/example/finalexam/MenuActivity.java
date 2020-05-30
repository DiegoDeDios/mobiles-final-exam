package com.example.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

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
                //Toast.makeText(MenuActivity.this, "Generar Appo", Toast.LENGTH_SHORT).show();
                startGeneratorActivity();
            }
        });
        
        cListA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuActivity.this, "Lista Appo", Toast.LENGTH_SHORT).show();
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
                startEmergencyCall();
                //Toast.makeText(MenuActivity.this, "Llamar", Toast.LENGTH_SHORT).show();
            }
        });

        qrImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuActivity.this, "Aparece QR", Toast.LENGTH_SHORT).show();
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

    public void startEmergencyCall(){
        String emergencyNumber = "tel:911";
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL , Uri.parse(emergencyNumber)));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startEmergencyCall();
            }else{
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
