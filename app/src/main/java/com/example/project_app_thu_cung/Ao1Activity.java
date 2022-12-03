package com.example.project_app_thu_cung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Ao1Activity extends AppCompatActivity {
    ImageButton btn_trove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietao1);
        btn_trove=findViewById(R.id.btn_detail_trove);
        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ao1Activity.this, Home.class);
                startActivity(intent);
            }
        });
    }
}