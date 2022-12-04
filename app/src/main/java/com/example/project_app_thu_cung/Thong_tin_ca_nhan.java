package com.example.project_app_thu_cung;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Thong_tin_ca_nhan extends AppCompatActivity implements ValueEventListener {
    private TextView txtten,txtngsing,txtgt,txtsdt,txtdiachi;
    private ImageButton btn_ve;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference ref= db.getReference();

    private DatabaseReference diachi=ref.child("user").child(apunti.sdt).child("diachi");
    private DatabaseReference gioitinh =ref.child("user").child(apunti.sdt).child("gioitinh");
    private DatabaseReference hoten =ref.child("user").child(apunti.sdt).child("hoten");
    private DatabaseReference ngaysinh=ref.child("user").child(apunti.sdt).child("ngaysinh");
    private DatabaseReference sdt =ref.child("user").child(apunti.sdt).child("sdt");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        btn_ve = findViewById(R.id.btn_ttcn_back);
        txtten =(TextView) findViewById(R.id.txthoten);
        txtngsing =(TextView) findViewById(R.id.txtngaysinh);
        txtgt =(TextView) findViewById(R.id.txtgioitinh);
        txtsdt =(TextView) findViewById(R.id.txtsdt);
        txtdiachi =(TextView) findViewById(R.id.txtdiachi);
        ref = FirebaseDatabase.getInstance().getReference();
       // Toast.makeText(Thong_tin_ca_nhan.this,apunti.sdt,Toast.LENGTH_SHORT).show();


        btn_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if (snapshot.getValue(String.class)!=null){
            String key =snapshot.getKey();
            if(key.equals("hoten")){
                String khoahoc =snapshot.getValue(String.class);
                txtten.setText(khoahoc);
            }
            if(key.equals("gioitinh")){
                String khoahoc =snapshot.getValue(String.class);
                txtgt.setText(khoahoc);
            }
            if(key.equals("sdt")){
                String khoahoc =snapshot.getValue(String.class);
                txtsdt.setText(khoahoc);
            }
            if(key.equals("diachi")){
                String khoahoc =snapshot.getValue(String.class);
                txtdiachi.setText(khoahoc);
            }
            if(key.equals("ngaysinh")){
                String khoahoc =snapshot.getValue(String.class);
                txtngsing.setText(khoahoc);
            }
        }
    }
    @Override
    public void onCancelled(@NonNull DatabaseError error) {


    }
    @Override
    protected void onStart() {
        super.onStart();
        hoten.addValueEventListener(this);
        gioitinh.addValueEventListener(this);
        diachi.addValueEventListener(this);
        ngaysinh.addValueEventListener(this);
        sdt.addValueEventListener(this);

    }
    public void openlogin(){
        Intent intent = new Intent(this ,Home.class);
        startActivity(intent);
    }
}