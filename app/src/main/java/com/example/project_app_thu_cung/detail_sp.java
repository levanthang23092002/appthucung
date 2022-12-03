package com.example.project_app_thu_cung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class detail_sp extends AppCompatActivity {
    Button btn;
    EditText txtnv;
    private DatabaseReference mDatabase;
    detailSP sanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sp);

        txtnv=findViewById(R.id.detail);
        btn=findViewById(R.id.btn_them);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String ten;
        ten =txtnv.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                sanpham = new detailSP("a","23k","tensp","mô ta","size s","size m","size l","size xl","số sao");
                mDatabase.child("detailSP").child(ten).setValue(sanpham);
            }
        });
    }
}