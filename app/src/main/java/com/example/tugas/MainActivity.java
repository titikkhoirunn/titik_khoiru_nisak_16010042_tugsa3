package com.example.tugas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.ed_username);
        password = findViewById(R.id.ed_password);
        masuk = findViewById(R.id.bt_masuk);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this);
                    Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show ();
                    Intent login = new Intent(getApplicationContext(), home.class);
                    startActivity(login);
                }else if(username.getText().toString().isEmpty()&& password.getText().toString().equals("admin")){
                    username.setError("tidak boleh kosong");
                }else if(username.getText().toString().equals("admin")&& password.getText().toString().isEmpty()){
                    password.setError("tidak boleh kosong");
                }else if(username.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
                    username.setError("tidak boleh kosong");
                    password.setError("tidak boleh kosong");
                }
            }
        });
    }
}
