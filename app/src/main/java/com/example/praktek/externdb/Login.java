package com.example.praktek.externdb;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class Login extends AppCompatActivity {

    RelativeLayout satu, dua, login;
    EditText username, password;
    TextView email;
    private String Susername, Spassword;
    Button log, creat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        satu = (RelativeLayout) findViewById(R.id.lin1);
        dua = (RelativeLayout) findViewById(R.id.lin2);
        username = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        dua.setVisibility(dua.GONE);
        log = (Button) findViewById(R.id.login);
        creat = (Button) findViewById(R.id.create);
        login = (RelativeLayout) findViewById(R.id.rellogin);
        email = (TextView) findViewById(R.id.textemail);

        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Create.class);
                startActivity(intent);
                login.setVisibility(login.GONE);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Susername = username.getText().toString();
                Spassword = password.getText().toString();
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean login = db.login(Susername,Spassword);
                if (login == true){
                    Toast.makeText(Login.this,"Sucessfully Login",Toast.LENGTH_SHORT).show();
                    dua.setVisibility(dua.VISIBLE);
                    satu.setVisibility(satu.GONE);
                    email.setText(ModalLogin.get_nama());
                } else {
                    Toast.makeText(Login.this,"can't be login",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}