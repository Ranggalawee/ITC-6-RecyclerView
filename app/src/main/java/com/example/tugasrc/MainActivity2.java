package com.example.tugasrc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageView Logo2;
    TextView Ket;

    String data1;
    int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Logo2 = findViewById(R.id.Logo2);
        Ket = findViewById(R.id.Ket);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("gambar")) {

            data1 = getIntent().getStringExtra("data1");
            gambar = getIntent().getIntExtra("gambar", 1);

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        Ket.setText(data1);
        Logo2.setImageResource(gambar);
    }

}