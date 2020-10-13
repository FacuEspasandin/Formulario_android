package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detalles_formulario extends AppCompatActivity {

    private TextView nombre;
    private TextView fecha_nacimiento;
    private TextView telefono;
    private TextView email;
    private TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_formulario);

        Bundle datos_formulario = getIntent().getExtras();

        String nombre = datos_formulario.getString(getResources().getString(R.string.nombre_completo));
        String fechaNac = datos_formulario.getString(getResources().getString(R.string.fecha_nacimiento));
        String tel = datos_formulario.getString(getResources().getString(R.string.telefono));
        String email = datos_formulario.getString(getResources().getString(R.string.email));
        String descripcion = datos_formulario.getString(getResources().getString(R.string.descripcion));

        this.nombre = (TextView) findViewById(R.id.tvNombre);
        fecha_nacimiento = (TextView) findViewById(R.id.tvFechaNac);
        telefono = (TextView) findViewById(R.id.tvTel);
        this.email = (TextView) findViewById(R.id.tvEmail);
        this.descripcion = (TextView) findViewById(R.id.tvDesc);

        this.nombre.setText(nombre);
        fecha_nacimiento.setText(fechaNac);
        telefono.setText(tel);
        this.email.setText(email);
        this.descripcion.setText(descripcion);

    }

    public void editar(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nombre", nombre.getText().toString());
        intent.putExtra("fecha_nacimiento", fecha_nacimiento.getText().toString());
        intent.putExtra("telefono", telefono.getText().toString());
        intent.putExtra("email", email.getText().toString());
        intent.putExtra("descripcion", descripcion.getText().toString());
        startActivity(intent);
        finish();
    }
}