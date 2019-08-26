package com.example.quranproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_create_act,btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_create_act = (Button) findViewById(R.id.create_btn);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_create_act.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,learning_goals.class));
                finish();

            }

        });
        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,activity_login.class));
                finish();

            }

        });


    }
}
