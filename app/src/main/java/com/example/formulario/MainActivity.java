package com.example.formulario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ednombre;
    EditText edTelefono;
    EditText edemail;
    DatePicker edfecha_nacimiento;
    EditText eddescripcion;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Bundle edit_datos = getIntent().getExtras();

            String nombre = edit_datos.getString("nombre");
            String tel = edit_datos.getString("telefono");
            String fechaNac = edit_datos.getString("fecha_nacimiento");
            String email = edit_datos.getString("email");
            String descripcion = edit_datos.getString("descripcion");

            ednombre = (EditText) findViewById(R.id.edNombre);
            edTelefono = (EditText) findViewById(R.id.edTel);
            edemail = (EditText) findViewById(R.id.edEmail);
            edfecha_nacimiento = (DatePicker) findViewById(R.id.dpCalendario);
            eddescripcion = (EditText) findViewById(R.id.edDesc);

            ednombre.setText(nombre);
            edTelefono.setText(tel);
            edemail.setText(email);
            eddescripcion.setText(descripcion);
            String[] fecha = fechaNac.split("/",0);
            int dia = Integer.valueOf(fecha[0]);
            int mes = Integer.valueOf(fecha[1]);
            int año = Integer.valueOf(fecha[2]);
            edfecha_nacimiento.init(año, mes-1, dia, null);

        } catch (Exception e){

        }

        Button btn = (Button) findViewById(R.id.btnSiguiente);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edNombre = (EditText) findViewById(R.id.edNombre);
                EditText edTel = (EditText) findViewById(R.id.edTel);
                EditText edEmail = (EditText) findViewById(R.id.edEmail);
                DatePicker dpCalendario = (DatePicker) findViewById(R.id.dpCalendario);
                EditText edDesc = (EditText) findViewById(R.id.edDesc);

                Intent intent = new Intent(MainActivity.this, Detalles_formulario.class);
                intent.putExtra(getResources().getString(R.string.nombre_completo),edNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.telefono),edTel.getText().toString());
                intent.putExtra(getResources().getString(R.string.fecha_nacimiento),dpCalendario.getDayOfMonth() + "/" + Integer.parseInt(String.valueOf(dpCalendario.getMonth()+1)) + "/" + dpCalendario.getYear());
                intent.putExtra(getResources().getString(R.string.email),edEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion),edDesc.getText().toString());

                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();


    }
}