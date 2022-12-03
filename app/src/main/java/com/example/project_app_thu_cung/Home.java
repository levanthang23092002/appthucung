package com.example.project_app_thu_cung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements Onclickitem {
    private FirebaseDatabase db;
    private DatabaseReference ref;
    ArrayList<SanPham> arrayList;
    private List<SanPham> listsp;
    private AdapterSanphan adapterSanphan;
    Button btn_gy,btn_ta,btn_pk,btn_qa;
    NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    RecyclerView recyc;
    SanPham sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
        getListGioY();

        btn_gy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListGioY();
            }
        });
        btn_qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListQuanAo();
            }
        });
        btn_pk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListPhukien();
            }
        });
        btn_ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListThucAn();
            }
        });





        arrayList = new ArrayList<>();
        mDrawerLayout = findViewById(R.id.drawer_layout);

        BottomNavigationView bt  = findViewById(R.id.bottom_nav);
        bt.setSelectedItemId(R.id.mes);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.mes:
                        break;
                    case R.id.account:
                        Intent acc = new Intent(Home.this,Thong_tin_ca_nhan.class);
                        startActivity(acc);
                        break;
                    case R.id.cart:
                        Intent giohang = new Intent(Home.this,ShoppingCartActivity.class);
                        startActivity(giohang);
                        break;
                    case R.id.note:
                        Intent thongbao = new Intent(Home.this,DanhGiaActivity.class);
                        startActivity(thongbao);
                        break;
                }

                return true;
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.mes:
                                Toast.makeText(Home.this,"Thành công",Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bottom_nav,menu);
        return true;
    }
    @SuppressLint("WrongViewCast")
    private void initUI(){
        recyc = findViewById(R.id.rcv);
        btn_gy = findViewById(R.id.btn_goiy);
        btn_pk = findViewById(R.id.btn_phukien);
        btn_qa = findViewById(R.id.btn_quanao);
        btn_ta = findViewById(R.id.btn_thucan);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyc.setLayoutManager(linearLayoutManager);

        recyc.setLayoutManager(new GridLayoutManager(this,1));
        recyc.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyc.addItemDecoration(dividerItemDecoration);

        listsp = new ArrayList<>();
        adapterSanphan= new AdapterSanphan(listsp,this);
        recyc.setAdapter(adapterSanphan);

    }
    private void getListGioY(){
        listsp.clear();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("SanPham").child("GoiY");


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    SanPham sanpham = dataSnapshot.getValue(SanPham.class);
                    listsp.add(sanpham);

                }
                adapterSanphan.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this,"get list false",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getListThucAn(){
        listsp.clear();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("SanPham").child("Thucan");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    SanPham sanpham = dataSnapshot.getValue(SanPham.class);
                    listsp.add(sanpham);

                }
                adapterSanphan.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this,"get list false",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getListPhukien(){
        listsp.clear();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("SanPham").child("Phukien");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    SanPham sanpham = dataSnapshot.getValue(SanPham.class);
                    listsp.add(sanpham);

                }
                adapterSanphan.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this,"get list false",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getListQuanAo(){
        listsp.clear();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("SanPham").child("Quanao");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    SanPham sanpham = dataSnapshot.getValue(SanPham.class);
                    listsp.add(sanpham);

                }
                adapterSanphan.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this,"get list false",Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onItemClick(Class<chi_tiet_san_pham> note) {
        Intent intent = new Intent();
        intent.setClass(Home.this, Ao1Activity.class);
        startActivity(intent);
    }
}