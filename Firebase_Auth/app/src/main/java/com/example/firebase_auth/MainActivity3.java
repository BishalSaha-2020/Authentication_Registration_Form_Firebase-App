package com.example.firebase_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {
    EditText name;
    EditText age;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Test", Toast.LENGTH_SHORT).show();

                HashMap<String,Object> m=new HashMap<String, Object>();
                m.put("name",name.getText().toString());
                m.put("age",age.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Contact Form").push().setValue(m);

            }
        });
    }
    public  void show(){
        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity4.class);

        startActivity(intent);
    }
}