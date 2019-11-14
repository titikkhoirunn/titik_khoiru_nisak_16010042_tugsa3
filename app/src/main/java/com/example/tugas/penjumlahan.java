package com.example.tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class penjumlahan extends AppCompatActivity {
    EditText nilai1, nilai2;
    Button hitung;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjumlahan);

        nilai1 = findViewById(R.id.ed_nilai1);
        nilai2 = findViewById(R.id.ed_nilai2);
        hitung = findViewById(R.id.bt_hitung);
        hasil = findViewById(R.id.tv_hasil);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a,b,c;
                a= Integer.valueOf(nilai1.getText().toString());
                b=Integer.valueOf(nilai2.getText().toString());
                c=a+b;
                hasil.setVisibility(View.VISIBLE);
                hasil.setText(String.valueOf(c));
            }
        });
    }
}
