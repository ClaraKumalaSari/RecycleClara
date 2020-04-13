package com.example.recycleclara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MahasiswaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        prepareMahasiswaData();
        mAdapter = new  MahasiswaAdapter(mahasiswaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerView, new
                RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick (View view,int position){
                Mahasiswa mhs = mahasiswaList.get(position);
                Toast.makeText(getApplicationContext(), mhs.getNama() + "is selected!", Toast.LENGTH_SHORT).show();
                Intent detail_mahasiswa = new Intent(MainActivity.this, mahasiswa_detail.class);
                detail_mahasiswa.putExtra("nim", mahasiswaList.get(position).getNim());
                detail_mahasiswa.putExtra("nama", mahasiswaList.get(position).getNama());
                detail_mahasiswa.putExtra("nohp", mahasiswaList.get(position).getNohp());
                startActivity(detail_mahasiswa);
            }

            @Override
            public void onLongClick (View view,int position){
            }
        }));
    }

        private void prepareMahasiswaData() {
            mahasiswaList = new ArrayList<>();
            mahasiswaList.add(new Mahasiswa("Clara Kumala Sari","311710277","085819467071"));
            mahasiswaList.add(new Mahasiswa("Afif Fathurohman","311710477","08771234567"));
            mahasiswaList.add(new Mahasiswa("Dimas Panji Adityantoro","311710065","0857190765889"));
        }

    }

