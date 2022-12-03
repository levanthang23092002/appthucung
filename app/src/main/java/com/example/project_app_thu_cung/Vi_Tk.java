package com.example.project_app_thu_cung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Vi_Tk extends AppCompatActivity {
    TextView txtnamestk,txtnamemapin,txtnamebank;
    EditText txtstk,txtmapin;
    Spinner txtbank;
    Button btnthem;
    ImageButton btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_tk);



        txtnamestk =findViewById(R.id.txt_vi_namestk);
        txtnamemapin = findViewById(R.id.txt_vi_namemaping);
        txtnamebank= findViewById(R.id.txt_vi_namebank);
        txtstk =findViewById(R.id.txt_vi_stkhoan);
        txtmapin =findViewById(R.id.txt_vi_maping);
        txtbank=findViewById(R.id.cbb_vi_bank);
        btnthem = findViewById(R.id.btn_vi_them);
        btnadd =findViewById(R.id.btn_vi_add);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamestk.setVisibility(View.VISIBLE);
                txtnamemapin.setVisibility(View.VISIBLE);
                txtnamebank.setVisibility(View.VISIBLE);
                txtstk.setVisibility(View.VISIBLE);
                txtmapin.setVisibility(View.VISIBLE);
                txtbank.setVisibility(View.VISIBLE);
                btnthem.setVisibility(View.VISIBLE);
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            String stk =txtstk.getText().toString();


            @Override
            public void onClick(View view) {

            }
        });
    }

}