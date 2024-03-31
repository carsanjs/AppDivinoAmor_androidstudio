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

public class registroAdmin extends AppCompatActivity {

    EditText editTextTextPersonName,nombre,descripcion,editTextTextPersonName4;
    Button btnsession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminregistro);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        nombre = findViewById(R.id.nombre);
        descripcion = findViewById(R.id.descripcion);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        btnsession = findViewById(R.id.btnsession);

        btnsession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Admin");

                if (editTextTextPersonName.getText().toString().isEmpty() || nombre.getText().toString().isEmpty()
                        || descripcion.getText().toString().isEmpty() || editTextTextPersonName4.getText().toString().isEmpty()) {

                    Context context = getApplicationContext();
                    String mensaje = "INGRESE LOS DATOS";
                    Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                }else{

                    Map<String, Object> map = new HashMap<>();

                    map.put("id",editTextTextPersonName.getText().toString());
                    map.put("name",nombre.getText().toString());
                    map.put("email",descripcion.getText().toString());
                    map.put("password",editTextTextPersonName4.getText().toString());
                    myRef.child(editTextTextPersonName.getText().toString()).updateChildren(map);

                    CharSequence text = "Usuario registrado con éxito";
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(registroAdmin.this, MainActivity.class));
                }
            }
        });

    }
}
