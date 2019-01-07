package com.example.praktek.externdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Create extends AppCompatActivity {

    EditText nama, email, pass, confirmpass;
    Button create, cancel;
    private String Snama, Semail, Spass, Sconfirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        nama = (EditText) findViewById(R.id.create_nama);
        email = (EditText) findViewById(R.id.create_email);
        pass = (EditText) findViewById(R.id.create_pass);
        confirmpass = (EditText) findViewById(R.id.create_confirmpass);
        create = (Button) findViewById(R.id.create_btncreate);
        cancel = (Button) findViewById(R.id.create_btncancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snama = nama.getText().toString();
                Semail = email.getText().toString();
                Spass = pass.getText().toString();
                Sconfirmpass = confirmpass.getText().toString();
                if (Snama.equals("")){
                    Toast.makeText(Create.this,"Field name don't be empty!", Toast.LENGTH_SHORT).show();
                    nama.requestFocus();
                } else if (Semail.equals("")){
                    Toast.makeText(Create.this,"Field email don't be empty!", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                } else if (Spass.equals("")){
                    Toast.makeText(Create.this,"Field password don't be empty!", Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                } else if (Sconfirmpass.equals("")){
                    Toast.makeText(Create.this,"Field confirm password don't be empty!", Toast.LENGTH_SHORT).show();
                    confirmpass.requestFocus();
                } else if (!(Spass.equals(Sconfirmpass))){
                    Toast.makeText(Create.this,"Field password && confirm password do same!", Toast.LENGTH_SHORT).show();
                    confirmpass.requestFocus();
                } else {
                    DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                    boolean cekEmail = db.cekEmail(Semail);
                    if (cekEmail == false){
                        Toast.makeText(Create.this,"Email already exist!", Toast.LENGTH_SHORT).show();
                        email.setText("");
                        email.requestFocus();
                    } else {
                        db.CreateAccoount(new ModalLogin(null, Snama, Semail, Spass));
                        Toast.makeText(Create.this,"Registered", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
