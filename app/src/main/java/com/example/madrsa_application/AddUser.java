package com.example.madrsa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {
EditText name,roll,Class,start,end,mnzil,sbqi;
Button Add,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        MyDBHelper DB=new MyDBHelper(this);
        name = findViewById(R.id.Name);
        roll = findViewById(R.id.roll_edit);
        Class = findViewById(R.id.class12);
        start = findViewById(R.id.StartVersetEdit);
        end = findViewById(R.id.endingVerse_edit);
        mnzil = findViewById(R.id.mnzilEdit);
        sbqi = findViewById(R.id.SabqiEdit);
        view = findViewById(R.id.view);
        Add=findViewById(R.id.Add);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddUser.this,UserList.class));
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String N=name.getText().toString();
                String Roll=roll.getText().toString();
                int C = Integer.parseInt(Class.getText().toString());
                int s = Integer.parseInt(start.getText().toString());
                int e=Integer.parseInt(end.getText().toString());
                int M=Integer.parseInt(mnzil.getText().toString());
                int Sq=Integer.parseInt(sbqi.getText().toString());

           boolean i=DB.addContent(N, C,s,e,Roll,Sq,M);
           if(i==true){
               Toast.makeText(AddUser.this, "Student Added", Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(AddUser.this, "Not Added", Toast.LENGTH_SHORT).show();
           }
            }
        });

    }


}