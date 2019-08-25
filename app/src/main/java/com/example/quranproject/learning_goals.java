package com.example.quranproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class learning_goals extends AppCompatActivity {
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_goals);
        btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),frequent_activities.class);
            }

        });
    }
}
