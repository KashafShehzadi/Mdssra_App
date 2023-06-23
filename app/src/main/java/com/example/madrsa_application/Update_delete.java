package com.example.madrsa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class        Update_delete extends AppCompatActivity {
    EditText editTextName;
    EditText start;
    EditText end;
    EditText editTextMnzil;
    EditText editTextSbqi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        // Retrieve the Student ID from the intent
        Intent intent = getIntent();
        int studentId = intent.getIntExtra("studentId", -1);

        // Retrieve the student data based on the ID (Replace this with your own logic to fetch the data)
        DB_model_class student = getStudentData(studentId);

        // Initialize the EditText fields
        editTextName = findViewById(R.id.editTextName );
        start = findViewById(R.id.Start);
        end = findViewById(R.id.End);
        editTextMnzil = findViewById(R.id.editTextMnzil);
        editTextSbqi = findViewById(R.id.editTextSbqi);

        // Set the values of the EditText fields
        editTextName.setText(student.get_Name());
        start.setText(String.valueOf(student.get_start()));
        end.setText(String.valueOf(student.get_end()));
        editTextMnzil.setText(String.valueOf(student.get_mnzil()));
        editTextSbqi.setText(String.valueOf(student.get_sbqi()));

        // Handle the update button click event
        Button updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Get the updated values from the EditText fields
                String updatedName = editTextName.getText().toString();
                int updatedStart= Integer.parseInt(start.getText().toString());
                int updatedEnd= Integer.parseInt(end.getText().toString());

                int updatedMnzil = Integer.parseInt(editTextMnzil.getText().toString());
                int updatedSbqi = Integer.parseInt(editTextSbqi.getText().toString());

                // Perform the update operation (Replace this with your own logic to update the data)
                updateStudentData(studentId, updatedName, updatedStart,updatedEnd, updatedMnzil, updatedSbqi);

                // Display a toast message or perform any other necessary operations
                Toast.makeText(Update_delete.this, "Student data updated successfully", Toast.LENGTH_SHORT).show();
            }


        });

        // Handle the delete button click event
        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform the delete operation (Replace this with your own logic to delete the data)
                deleteStudentData(studentId);

                // Display a toast message or perform any other necessary operations
                Toast.makeText(Update_delete.this, "Student data deleted successfully", Toast.LENGTH_SHORT).show();

                // Finish the activity and return to the previous screen
                finish();
            }
        });
    }

    // Replace the following methods with your own logic to retrieve, update, and delete student data

    private DB_model_class getStudentData(int studentId) {

        MyDBHelper DB = new MyDBHelper(this);
        DB_model_class N=DB.getSelected(studentId);
        return N;
    }

    private void updateStudentData(int studentId, String updatedName, int start,int end, int updatedMnzil, int updatedSbqi) {
        // Update the student data in your data source based on the ID with the updated values
        MyDBHelper DB = new MyDBHelper(this);
        DB.updateStudent(studentId, updatedName, start,end, updatedMnzil, updatedSbqi);
    }

    private void deleteStudentData(int studentId) {
        // Delete the student data from your data source based on the ID
        MyDBHelper DB = new MyDBHelper(this);
        DB.deleteStudent(studentId);
    }
}
