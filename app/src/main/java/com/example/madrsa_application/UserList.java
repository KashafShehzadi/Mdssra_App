package com.example.madrsa_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        List<DB_model_class> students = new ArrayList<>();
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        MyDBHelper DB=new MyDBHelper(this);
        RecyclerView.LayoutManager layoutManager;
        students=DB.getAll();
        recyclerView=findViewById(R.id.Recycle);



        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyAdapter(students);
        recyclerView.setAdapter(adapter);

    }
}