package com.example.firebase_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    Button show;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        show=findViewById(R.id.show);
        list=findViewById(R.id.list);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> a=new ArrayList<>();
                ArrayAdapter adapter=new ArrayAdapter<String>(MainActivity4.this,R.layout.items,a);
                list.setAdapter(adapter);
                FirebaseDatabase.getInstance().getReference().child("Contact Form").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            a.clear();
                            for(DataSnapshot snapshot1:snapshot.getChildren()){
                                Contact i=snapshot1.getValue(Contact.class);

                                String t=i.getName()+":"+i.getAge();
                                a.add(t);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                    }
                });
            }
        });
    }
}