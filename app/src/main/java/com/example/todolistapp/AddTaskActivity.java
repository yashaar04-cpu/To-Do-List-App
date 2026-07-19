package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    EditText taskTitleEdit;
    Spinner categorySpinner;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Lower content dynamically
        LinearLayout rootLayout = findViewById(R.id.addTaskLayout);
        rootLayout.setPadding(
                rootLayout.getPaddingLeft(),
                200, // Adjust this to push lower
                rootLayout.getPaddingRight(),
                rootLayout.getPaddingBottom()
        );

        taskTitleEdit = findViewById(R.id.taskTitleEdit);
        categorySpinner = findViewById(R.id.categorySpinner);
        saveButton = findViewById(R.id.saveButton);

        // Spinner categories
        String[] categories = {"🌸 General", "⭐ Important", "⏰ Urgent"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        saveButton.setOnClickListener(v -> {
            String title = taskTitleEdit.getText().toString().trim();
            String category = categorySpinner.getSelectedItem().toString();

            if (title.isEmpty()) {
                Toast.makeText(this, "Please enter a task title", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("taskTitle", title);
            resultIntent.putExtra("taskCategory", category);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}




