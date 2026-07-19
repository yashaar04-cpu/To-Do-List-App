package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();
    TaskAdapter adapter;
    Button addButton;
    ListView taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = findViewById(R.id.taskList);
        addButton = findViewById(R.id.addButton);

        // Sample tasks
        tasks.add(new Task("Buy Milk", "🌸 General"));
        tasks.add(new Task("Mobile Assignment", "⭐ Important"));
        tasks.add(new Task("Clean Room", "⏰ Urgent"));

        adapter = new TaskAdapter(this, tasks);
        taskList.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivityForResult(intent, 100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("taskTitle");
            String category = data.getStringExtra("taskCategory");

            tasks.add(new Task(title, category));
            adapter.notifyDataSetChanged();
        }
    }
}




