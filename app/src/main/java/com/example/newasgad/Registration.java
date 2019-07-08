package com.example.newasgad;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.microedition.khronos.egl.EGLDisplay;

public class Registration extends AppCompatActivity {

    private EditText et_dob, et_name, et_surname, et_email, et_password;
    private Button btnRegister;
    private TextView tv_Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        et_dob = findViewById(R.id.etDOB);
        et_name = findViewById(R.id.etName);
        btnRegister = findViewById(R.id.btnRegister);
        tv_Login = findViewById(R.id.tvLogin);


        final Calendar myCalender = Calendar.getInstance();

       final DatePickerDialog.OnDateSetListener dob = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, month);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                String dateFormat = "YY/MM/DD";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat( dateFormat, Locale.US);

                et_dob.setText(simpleDateFormat.format(myCalender.getTime()));
            }
        };

        et_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Registration.this,dob,
                        myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        tv_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity();
                Toast.makeText(Registration.this, "Waiting for Khanyi and Login Branch", Toast.LENGTH_SHORT).show();

            }
        });

    }




}
