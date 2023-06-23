package com.example.madrsa_application;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVH> {

    List<DB_model_class> StudentList;
    public MyAdapter(List<DB_model_class> Students) {
        this.StudentList = Students;
    }

    @NonNull
    @Override
    public MyAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singe_item1, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyVH holder, int position) {
        holder.data=StudentList.get(position);
        holder.Name.setText(holder.data.get_Name());

        holder.Sabaq.setText(holder.data.get_verse());
        holder.Sbqi.setText(String.valueOf(holder.data.get_sbqi()));
        holder.Mnzil.setText(String.valueOf(holder.data.get_mnzil()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the EditActivity with the selected Student's ID
                Intent intent = new Intent(view.getContext(), Update_delete.class);
                intent.putExtra("studentId", holder.data.get_Id()); // Pass the Student ID to the EditActivity
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return StudentList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {

        TextView Name;
        TextView Sabaq;

        TextView Mnzil;
        TextView Sbqi;

        DB_model_class data;
        public MyVH(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.Name);
            Mnzil= itemView.findViewById(R.id.Mnzil);

            Sabaq = itemView.findViewById(R.id.Sabaq);
            Sbqi = itemView.findViewById(R.id.Sbqi);

        }
    }
}