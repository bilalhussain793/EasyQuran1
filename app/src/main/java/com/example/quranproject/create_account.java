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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

public class create_account extends AppCompatActivity {
    Button btn_next,bt1,bt2;
    LinearLayout ln_1,ln_2,ln_3;


    CheckBox speak_arabic,prac_quran,learn_quran,correction_hifaz;
    //learn goals
    CheckBox self_improv,study_abroad,pass_interview,excel;
    EditText name,email,password,country_code,refrel;
    Spinner gender,contry;
    StringBuffer st_act=new StringBuffer();
    StringBuffer st_goals=new StringBuffer();




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


        Firebase.setAndroidContext(this);
        ln_1=findViewById(R.id.li1);
        ln_2=findViewById(R.id.li2);
        ln_3=findViewById(R.id.li3);

        btn_next = (Button) findViewById(R.id.btn_next);
        bt1=findViewById(R.id.bt_next1);
        bt2=findViewById(R.id.btn_next2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(speak_arabic.isChecked()||prac_quran.isChecked()||learn_quran.isChecked()||correction_hifaz.isChecked()){
                ln_1.setVisibility(View.GONE);
                ln_2.setVisibility(View.VISIBLE);
                if(speak_arabic.isChecked()){
                    st_act.append(speak_arabic.getText().toString());
                }
                if(prac_quran.isChecked()){
                    st_act.append(prac_quran.getText().toString());
                }
                if(learn_quran.isChecked()){
                    st_act.append(learn_quran.getText().toString());
                }
                if(correction_hifaz.isChecked()){
                    st_act.append(correction_hifaz.getText().toString());
                }

                Toast.makeText(create_account.this, ""+st_act, Toast.LENGTH_SHORT).show();
                //activities here

            }else{
                Toast.makeText(create_account.this, "Nothing is selected", Toast.LENGTH_SHORT).show();
            }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(self_improv.isChecked()||study_abroad.isChecked()||pass_interview.isChecked()||excel.isChecked()){
                    ln_2.setVisibility(View.GONE);
                    ln_3.setVisibility(View.VISIBLE);
                    if(self_improv.isChecked()){
                        st_goals.append(self_improv.getText().toString());
                    }
                    if(study_abroad.isChecked()){
                        st_goals.append(study_abroad.getText().toString());
                    }
                    if(pass_interview.isChecked()){
                        st_goals.append(pass_interview.getText().toString());
                    }
                    if(excel.isChecked()){
                        st_goals.append(excel.getText().toString());
                    }

                    Toast.makeText(create_account.this, ""+st_goals, Toast.LENGTH_SHORT).show();
                    //activities here

                }else{
                    Toast.makeText(create_account.this, "Nothing is selected", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String un,em,ps,country;
                un=name.getText().toString();
                em=email.getText().toString();
                ps=password.getText().toString();
                String rf=refrel.getText().toString();
                country=country_code.getText().toString();
                if(un.length()==0||em.length()==0||ps.length()==0||country.length()==0){

                    Toast.makeText(create_account.this, "All fields are required !", Toast.LENGTH_SHORT).show();

                }else{

                //final upload there
                    reg(em,un,ps,rf,country,st_act.toString(),st_goals.toString());
                }

                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }

        });

    }
    public void reg(final String email, final String username, final String pass, final String ref, final String country, final String acts, final String tsk){
        String url = "https://easyquran1-9aec4.firebaseio.com/users.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                Firebase reference = new Firebase("https://easyquran1-9aec4.firebaseio.com/users");

                if(s.equals("null")) {
                    reference.child(username).child("password").setValue(pass);
                    reference.child(username).child("email").setValue(email);
                    reference.child(username).child("username").setValue(username);
                    reference.child(username).child("refferal").setValue(ref);
                    reference.child(username).child("country").setValue(country);
                    reference.child(username).child("Activity").setValue(acts);
                    reference.child(username).child("Task").setValue(tsk);

                    Toast.makeText(create_account.this, "registration successful", Toast.LENGTH_LONG).show();
                }
                else {
                    try {
                        JSONObject obj = new JSONObject(s);

                        if (!obj.has(email)) {
                            reference.child(email).child("password").setValue(pass);
                            reference.child(email).child("email").setValue(email);
                            reference.child(email).child("username").setValue(username);
                            reference.child(email).child("refferal").setValue(ref);
                            reference.child(email).child("country").setValue(country);
                            reference.child(email).child("Activity").setValue(acts);
                            reference.child(email).child("Task").setValue(tsk);

                            //image will be added there

                            Toast.makeText(create_account.this, "registration successful", Toast.LENGTH_LONG).show();

                        } else {

                            Toast.makeText(create_account.this, "username already exists", Toast.LENGTH_LONG).show();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

//                pd.dismiss();
            }

        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError );
//                pd.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(create_account.this);
        rQueue.add(request);
    }
}
