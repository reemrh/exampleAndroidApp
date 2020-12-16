package com.example.exampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

    public class TaskAdapterEx extends Adapter<TaskAdapterEx.TaskVh> {

        CheckBox checkboxValue;
        Context context;
        List<TaskItem> tasks;

        public TaskAdapterEx(Context context, List<TaskItem> tasks) {
            this.context = context;
            this.tasks = tasks;
        }

        @NonNull
        @Override
        public TaskVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_task_empty, parent, false);
            return new TaskVh(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskVh holder, int position) {
            holder.setData(tasks.get(position));
        }

        @Override
        public int getItemCount() {
            return tasks.size();
        }


        class TaskVh extends RecyclerView.ViewHolder {

            TextView isChecked;
            CheckBox title;

            public TaskVh(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.checkbox_example);
                isChecked = itemView.findViewById(R.id.checkboxValue);
            }

            public void setData(final TaskItem task) {
                title.setText(task.getTitle());
                isChecked.setText(task.getIsChecked());
            }
        }
    }
