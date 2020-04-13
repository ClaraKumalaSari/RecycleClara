package com.example.recycleclara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class mahasiswa_detail extends AppCompatActivity {
    private TextView txtnim, txtnama, txtnohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_detail);

        txtnim=(TextView) findViewById(R.id.nim_mhs);
        txtnama=(TextView) findViewById(R.id.nama_mhs);
        txtnohp=(TextView) findViewById(R.id.nohp_mhs);

        Show_Detail_Mahasiswa();
    }
    private void Show_Detail_Mahasiswa()
    {
        txtnim.setText(getIntent().getStringExtra("nim").toString());
        txtnama.setText(getIntent().getStringExtra("nama").toString());
        txtnohp.setText(getIntent().getStringExtra("nohp").toString());
    }
}
