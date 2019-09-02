package com.example.quranproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class create_account extends AppCompatActivity {
    Button btn_next,bt1,bt2;
    LinearLayout ln_1,ln_2,ln_3;


    CheckBox speak_arabic,prac_quran,learn_quran,correction_hifaz;
    //learn goals
    CheckBox self_improv,study_abroad,pass_interview,excel;
    EditText name,email,password,country_code,refrel;
    Spinner gender,contry;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        speak_arabic=findViewById(R.id.arabic);
        prac_quran=findViewById(R.id.pra_quran);
        learn_quran=findViewById(R.id.learn_quran);
        correction_hifaz=findViewById(R.id.hifaz);
        self_improv=findViewById(R.id.cb_improve);
        study_abroad=findViewById(R.id.cb_study);
        pass_interview=findViewById(R.id.cb_pass);
        excel=findViewById(R.id.cb_Excel);
        name=findViewById(R.id.etUsername);
        email=findViewById(R.id.etEmail);
        password=findViewById(R.id.etPassword);
        country_code=findViewById(R.id.etcountry);
        refrel=findViewById(R.id.etReferral);
        gender=findViewById(R.id.gen);
        contry=findViewById(R.id.Country);



ln_1=findViewById(R.id.li1);
ln_2=findViewById(R.id.li2);
ln_3=findViewById(R.id.li3);

btn_next = (Button) findViewById(R.id.btn_next);
bt1=findViewById(R.id.bt_next1);
bt2=findViewById(R.id.btn_next2);

bt1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
ln_1.setVisibility(View.GONE);
ln_2.setVisibility(View.VISIBLE);


    }
});
bt2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
ln_2.setVisibility(View.GONE);
ln_3.setVisibility(View.VISIBLE);
    }
});

        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Navdrawer.class));
                finish();
            }

        });
    }
}
