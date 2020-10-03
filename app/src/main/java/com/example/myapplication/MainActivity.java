package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();
    EditText t1;

    EditText edtNombre;
    EditText edtFecha;
    EditText edtTelefono;
    EditText edtEmail;
    EditText edtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);

        t1 = (EditText) findViewById(R.id.edtFecha);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
            }
        });


    }

    public void colocar_fecha() {
        t1.setText((mDayIni + "/" + (mMonthIni+1) + "/" + mYearIni));
    }

    private DatePickerDialog.OnDateSetListener mDataSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYearIni = year;
            mMonthIni = monthOfYear;
            mDayIni = dayOfMonth;
            colocar_fecha();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDataSetListener, sDayIni, sMonthIni, sYearIni);
        }
        return null;
    }

    public void goCheckData(View view) {

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtFecha = (EditText) findViewById(R.id.edtFecha);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);

        String Nombre = edtNombre.getText().toString();
        String Fecha = edtFecha.getText().toString();
        String telefono = edtTelefono.getText().toString();
        String email = edtEmail.getText().toString();
        String descripcion = edtDescripcion.getText().toString();

        Intent miIntent = new Intent(MainActivity.this, MainActivity2.class);
        Bundle miBundle = new Bundle();
        miBundle.putString("Nombre", edtNombre.getText().toString());
        miBundle.putString("Fecha", Fecha);
        miBundle.putString("Telefono", telefono);
        miBundle.putString("email", email);
        miBundle.putString("Descripcion", descripcion);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);

    }

}