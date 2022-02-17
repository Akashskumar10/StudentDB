package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4;
    AppCompatButton b1, b2;
    String getName, getRollNo, getAdmissionNo, getCollege;
    DatabaseHelper DbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        DbHelper = new DatabaseHelper(this);
        DbHelper.getWritableDatabase();
        ed1 = (EditText) findViewById(R.id.nm1);
        ed2 = (EditText) findViewById(R.id.roll);
        ed3 = (EditText) findViewById(R.id.adm1);
        ed4 = (EditText) findViewById(R.id.clg1);
        b1 = (AppCompatButton) findViewById(R.id.sbt1);
        b2 = (AppCompatButton) findViewById(R.id.backbtn);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName = ed1.getText().toString();
                getRollNo = ed2.getText().toString();
                getAdmissionNo = ed3.getText().toString();
                getCollege = ed4.getText().toString();
                boolean result = DbHelper.insertData(getName, getRollNo, getAdmissionNo, getCollege);
                if (result == true) {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");

                    Toast.makeText(getApplicationContext(), "submitted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to Insert", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}
