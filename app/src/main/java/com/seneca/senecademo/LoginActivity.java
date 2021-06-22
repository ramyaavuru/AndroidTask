package com.seneca.senecademo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText Email,Password;
    Button login;
    public static boolean flag=false;
   // https://github.com/ramyaavuru/AndroidTask.git
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loin);
        Email=(EditText)findViewById(R.id.email);

        Password=(EditText)findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Email.getText().toString().isEmpty()&&!Password.getText().toString().isEmpty())
                {
                    flag=true;
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Please enter username or passowrd", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
