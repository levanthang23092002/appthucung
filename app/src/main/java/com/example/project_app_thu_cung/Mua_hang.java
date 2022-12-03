package com.example.project_app_thu_cung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Mua_hang extends AppCompatActivity {
    ImageView btn_comback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua_hang);

        btn_comback=findViewById(R.id.img_muahang_comback);
        btn_comback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hom = new Intent(Mua_hang.this,Home.class);
                startActivity(hom);
            }
        });

    }
}