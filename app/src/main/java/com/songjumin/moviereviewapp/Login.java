package com.songjumin.moviereviewapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.songjumin.moviereviewapp.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    EditText editEmail;
    EditText editPasswd;
    Button btnLogin;
    Button btnRegister;
    Button btnCancel;
    CheckBox autoLogin;

    Intent i;

    String savedEmail;
    String savePassed;

    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPasswd = findViewById(R.id.editPasswd1);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);
        autoLogin = findViewById(R.id.autoLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String passwd = editPasswd.getText().toString().trim();

                if(email.contains("@") == false){
                    Toast.makeText(Login.this, "이메일형식이 올바르지 않습니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(passwd.isEmpty() || passwd.length() < 4 || passwd.length() > 12){
                    Toast.makeText(Login.this, "비밀번호 규칙에 맞지 않습니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty() || passwd.isEmpty()){
                    Toast.makeText(Login.this, "이메일과 비밀번호 둘 다 입력해주세요.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                JSONObject body = new JSONObject();
                try {
                    body.put("email", email);
                    body.put("passwd", passwd);
                }catch (JSONException e){
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST,
                        Util.BASE_URL + "/api/v1/users/login",
                        body,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String token = response.getString("token");
                                    Log.i("AAA", "network token : "+token);
                                    SharedPreferences sp = getSharedPreferences(Util.PREFERENCE_NAME, MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("token", token);
                                    editor.apply();
                                    finish();
                                    return;
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                Volley.newRequestQueue(Login.this).add(request);

                if(autoLogin.isChecked()){
                    editor.putBoolean("autoLogin", true);
                }else {
                    editor.putBoolean("autoLogin", false);
                }
                editor.apply();
                // 리뷰쓰는 창으로 이동해야함 수정하기!!
                Intent i = new Intent(Login.this, MainActivity.class);
                i.putExtra("email", email);
                startActivity(i);
                finish();
            }
        });

        boolean auto_login = sp.getBoolean("autoLogin", false);
        if (auto_login == true){
            editEmail.setText(savedEmail);
            editPasswd.setText(savePassed);
            autoLogin.setChecked(true);
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}