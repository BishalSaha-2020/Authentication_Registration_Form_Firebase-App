package com.example.firebase_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    EditText email;
    EditText password;
    private Button login;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email=findViewById(R.id.email3);
        password=findViewById(R.id.password3);
        login=findViewById(R.id.Login);
        auth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1))
                {
                    Toast.makeText(MainActivity2.this, "Enter Email and Password Both Bro!", Toast.LENGTH_SHORT).show();
                }
                else{
                    login2(email1,password1);
                }
            }
    });
}
    private void login2(String email,String password){
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(MainActivity2.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                Toast.makeText(MainActivity2.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                next();

            }

        });
    }
    public  void next(){
        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity3.class);

        startActivity(intent);
    }
}