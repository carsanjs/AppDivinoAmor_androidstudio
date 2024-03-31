package com.example.appdivinoamor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class donaciones extends AppCompatActivity {

    EditText idCodigo,correo,descripcion,spinner_moneda,editTextTextPersonName4;

    Button btnsession;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_donaciones);

        idCodigo = findViewById(R.id.idCodigo);
        correo = findViewById(R.id.correo);
        descripcion = findViewById(R.id.descripcion);
        spinner_moneda = findViewById(R.id.spinner_moneda);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        btnsession = findViewById(R.id.btnsession);

        btnsession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Donaciones");

                if (idCodigo.getText().toString().isEmpty() || correo.getText().toString().isEmpty()
                        || descripcion.getText().toString().isEmpty() || spinner_moneda.getText().toString().isEmpty() || editTextTextPersonName4.getText().toString().isEmpty()) {

                    Context context = getApplicationContext();
                    String mensaje = "INGRESE LOS DATOS";
                    Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                }else{

                    Map<String, Object> map = new HashMap<>();

                    map.put("id",idCodigo.getText().toString());
                    map.put("correo",correo.getText().toString());
                    map.put("descripcion",descripcion.getText().toString());
                    map.put("moneda",spinner_moneda.getText().toString());
                    map.put("monto a donar",editTextTextPersonName4.getText().toString());
                    myRef.child(idCodigo.getText().toString()).updateChildren(map);

                    CharSequence text = "Donación registrada con éxito";
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(donaciones.this, homeInicio.class));
                }
            }
        });
    }
}
