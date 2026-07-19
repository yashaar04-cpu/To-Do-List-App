package com.example.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.task_item, parent, false);
        }

        Task task = getItem(position);

        TextView title = convertView.findViewById(R.id.taskTitle);
        TextView category = convertView.findViewById(R.id.taskCategory);

        title.setText(task.title);
        category.setText(task.category);

        return convertView;
    }
}


