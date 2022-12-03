package com.example.project_app_thu_cung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ao1Activity extends AppCompatActivity {
    ImageButton btn_trove;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Button btncong,btntru;
    TextView soluong;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietao1);
        btn_trove=findViewById(R.id.btn_detail_trove);
        radioGroup= findViewById(R.id.radio_btn);
        btncong=findViewById(R.id.btn_detail_cong);
        btntru=findViewById(R.id.btn_detail_tru);
        soluong=findViewById(R.id.txt_detail_soluong);
        img=findViewById(R.id.img_detail_danhgia);



        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 =new Intent(Ao1Activity.this,DanhGiaActivity.class);
                startActivity(intent5);
            }
        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sl= soluong.getText().toString();
                int i = Integer.valueOf(sl);
                if(i<=1){
                    Toast.makeText(Ao1Activity.this, "Chọn ít nhất 1 sản phẩm", Toast.LENGTH_SHORT).show();
                }else {
                    i = i - 1;
                    sl = String.valueOf(i);
                    soluong.setText(sl);
                }
            }
        });
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sl= soluong.getText().toString();
                int i = Integer.valueOf(sl);
                    i = i + 1;
                    sl = String.valueOf(i);
                    soluong.setText(sl);
            }
        });



        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ao1Activity.this, Home.class);
                startActivity(intent);
            }
        });
    }
    public void checkButton(View v){
        int radioId =radioGroup.getCheckedRadioButtonId();
        radioButton =findViewById(radioId);
    }
}