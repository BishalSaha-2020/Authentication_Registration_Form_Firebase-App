package com.example.firebase_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    private Button register;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email3);
        password=findViewById(R.id.password3);
        register=findViewById(R.id.Login);
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1))
                {
                    Toast.makeText(MainActivity.this, "Enter Email and Password Both Bro!", Toast.LENGTH_SHORT).show();
                }
                else{
                    regis(email1,password1);
                }
            }
        });
    }
    private void regis(String email,String password){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Successfully register", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public  void hello(View v){
        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,Main_Activity10.class);

        startActivity(intent);
    }
}