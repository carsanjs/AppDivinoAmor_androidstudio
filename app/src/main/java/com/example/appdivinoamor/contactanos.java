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

public class contactanos extends AppCompatActivity {

    EditText idmesssaje, editxtnombre, editextcorreo, editmessage;
    Button btnenviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_contactanos);

        idmesssaje = findViewById(R.id.idmesssaje);
        editxtnombre = findViewById(R.id.editxtnombre);
        editextcorreo = findViewById(R.id.editextcorreo);
        editmessage = findViewById(R.id.editmessage);
        btnenviar = findViewById(R.id.btnenviar);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnenviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("Mensaje");

                        if (idmesssaje.getText().toString().isEmpty() || editxtnombre.getText().toString().isEmpty()
                                || editextcorreo.getText().toString().isEmpty() || editmessage.getText().toString().isEmpty()) {

                            Context context = getApplicationContext();
                            String mensaje = "INGRESE LOS DATOS";
                            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                        } else {

                            Map<String, Object> map = new HashMap<>();

                            map.put("id", idmesssaje.getText().toString());
                            map.put("Nombre", editxtnombre.getText().toString());
                            map.put("Correo", editextcorreo.getText().toString());
                            map.put("Mensaje", editmessage.getText().toString());
                            myRef.child(idmesssaje.getText().toString()).updateChildren(map);

                            CharSequence text = "Mensaje registrado con éxito";
                            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(contactanos.this, homeInicio.class));
                        }

                    }
                });

            }
        });
    }
}