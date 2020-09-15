package com.songjumin.moviereviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView txtView;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtView = findViewById(R.id.txtView);
        btnHome = findViewById(R.id.btnHome);

        Intent i = getIntent();
        String email = i.getStringExtra("email");
        String passwd = i.getStringExtra("passwd");

        txtView.setText(email + "님"+"\n"+"회원가입을 환영합니다.");

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Welcome.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}