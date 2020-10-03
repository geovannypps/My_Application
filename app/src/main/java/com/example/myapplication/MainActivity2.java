package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtNombre;
    TextView txtFecha;
    TextView txtTelefono;
    TextView txtEmail;
    TextView txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);

        Bundle miBundle = getIntent().getExtras();
        String Nombre = miBundle.getString("Nombre");
        String Fecha = miBundle.getString("Fecha");
        String Telefono = miBundle.getString("Telefono");
        String email = miBundle.getString("email");
        String Descripcion = miBundle.getString("Descripcion");

        txtNombre.setText(Nombre);
        txtFecha.setText(Fecha);
        txtTelefono.setText(Telefono);
        txtEmail.setText(email);
        txtDescripcion.setText(Descripcion);

    }

    public void goMainActivity (View view) {
        finish();
    }

}