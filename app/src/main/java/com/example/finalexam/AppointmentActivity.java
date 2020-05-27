package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AppointmentActivity extends AppCompatActivity {

    RecyclerView rvAppointment;
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    //qrpopup.xml
    //---------------------------
    Dialog dialog;

    ImageView closeinfobtnimage;

    Button btnInfoAccept,
            btnDelete;

    TextView etPatientInfo,
            etPatientExtraInfo;
    //-----------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        dialog = new Dialog(this);

        final ArrayList<Appointment> appointmentsExample = new ArrayList<>();
        appointmentsExample.add(new Appointment("Eduardo","Alonso", "Herrera", "M", "Nada", "Problemas para respirar", 25));
        appointmentsExample.add(new Appointment("Ihtzel","Ugalde", "Sebastian", "F", "Camaron", "Se pone Roja", 23));
        appointmentsExample.add(new Appointment("Emiliano","Alonso", "Herrera", "M", "Fresa", "Se enoja", 15));
        appointmentsExample.add(new Appointment("Eduardo","Alonso", "Herrera", "M", "Nada", "Problemas para respirar", 25));
        appointmentsExample.add(new Appointment("Ihtzel","Ugalde", "Sebastian", "F", "Camaron", "Se pone Roja", 23));
        appointmentsExample.add(new Appointment("Emiliano","Alonso", "Herrera", "M", "Fresa", "Se enoja", 15));
        appointmentsExample.add(new Appointment("Eduardo","Alonso", "Herrera", "M", "Nada", "Problemas para respirar", 25));
        appointmentsExample.add(new Appointment("Ihtzel","Ugalde", "Sebastian", "F", "Camaron", "Se pone Roja", 23));
        appointmentsExample.add(new Appointment("Emiliano","Alonso", "Herrera", "M", "Fresa", "Se enoja", 15));
        appointmentsExample.add(new Appointment("Eduardo","Alonso", "Herrera", "M", "Nada", "Problemas para respirar", 25));
        appointmentsExample.add(new Appointment("Ihtzel","Ugalde", "Sebastian", "F", "Camaron", "Se pone Roja", 23));
        appointmentsExample.add(new Appointment("Emiliano","Alonso", "Herrera", "M", "Fresa", "Se enoja", 15));
        appointmentsExample.add(new Appointment("Eduardo","Alonso", "Herrera", "M", "Nada", "Problemas para respirar", 25));
        appointmentsExample.add(new Appointment("Ihtzel","Ugalde", "Sebastian", "F", "Camaron", "Se pone Roja", 23));
        appointmentsExample.add(new Appointment("Emiliano","Alonso", "Herrera", "M", "Fresa", "Se enoja", 15));
        appointmentsExample.add(new Appointment("Eduardo","Alonso", "Herrera", "M", "Nada", "Problemas para respirar", 25));
        appointmentsExample.add(new Appointment("Ihtzel","Ugalde", "Sebastian", "F", "Camaron", "Se pone Roja", 23));
        appointmentsExample.add(new Appointment("Emiliano","Alonso", "Herrera", "M", "Fresa", "Se enoja", 15));

        rvAppointment = findViewById(R.id.rvAppointment);
        rvAppointment.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerViewAdapter(appointmentsExample);

        rvAppointment.setLayoutManager(layoutManager);
        rvAppointment.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(AppointmentActivity.this, "Cita: " + (position+1), Toast.LENGTH_SHORT).show();
                showPopUp(appointmentsExample.get(position).patientName, appointmentsExample.get(position).healthProblems);
            }
        });
    }

    public void showPopUp(String name, String problem){
        dialog.setContentView(R.layout.infopopup);
        closeinfobtnimage = (ImageView) dialog.findViewById(R.id.closeinfobtnimage);
        btnInfoAccept = (Button) dialog.findViewById(R.id.btnInfoAccept);
        btnDelete = (Button) dialog.findViewById(R.id.btnDelete);
        etPatientInfo = (TextView) dialog.findViewById(R.id.etPatientInfo);
        etPatientExtraInfo = (TextView) dialog.findViewById(R.id.etPatientExtraInfo);

        etPatientInfo.setText("Nombre: " + name);
        etPatientExtraInfo.setText("Problema: " + problem);

        closeinfobtnimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnInfoAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Codigo para borrar registro
                Toast.makeText(AppointmentActivity.this, "Se Borra Cita", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
