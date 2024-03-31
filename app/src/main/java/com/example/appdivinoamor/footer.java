package com.example.appdivinoamor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class footer extends AppCompatActivity {


    private ImageButton iniciarsesion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

//        iniciarsesion = findViewById(R.id.btnFinicio);
//
//        iniciarsesion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(footer.this, iniciosesion.class));
//            }
//        });

    }

}
