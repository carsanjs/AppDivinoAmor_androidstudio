package com.example.appdivinoamor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class iniciosesion extends AppCompatActivity {

    EditText descripcion,editTextTextPersonName4;
    Button btnsession,button;
    private DatabaseReference database;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciasession);

        descripcion= findViewById(R.id.descripcion);
        editTextTextPersonName4= findViewById(R.id.editTextTextPersonName4);
        btnsession= findViewById(R.id.btnsession);
        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnsession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myusers = database.getReference("Admin");

                try {
                    //String email = loginEmail.getText().toString().trim();
                    //String password = loginPassword.getText().toString().trim();

                    if (descripcion.getText().toString().isEmpty() && editTextTextPersonName4.getText().toString().isEmpty()) {

                        CharSequence text = "CAMPOS VACIOS.";
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                    }else{

                        myusers.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                                    if (descripcion.getText().toString().equals(snapshot.child("email").getValue()) && editTextTextPersonName4.getText().toString().equals(snapshot.child("password").getValue())) {

                                        CharSequence text = "INICIO CORRECTAMENTE!!";
                                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), homeInicio.class);
                                        startActivity(intent);
                                        limpiaredittext();
                                        return;
                                    }

                                }
                                CharSequence text = "Usuario o contraseña incorrecta.";
                                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                    }
                }
                catch (Exception e){
                    System.out.print(e.getMessage());
                }
            }
        });
    }
    private void limpiaredittext(){
        descripcion.setText("");
        editTextTextPersonName4.setText("");
    }
}
