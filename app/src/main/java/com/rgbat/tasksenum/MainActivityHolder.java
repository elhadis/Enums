package com.rgbat.tasksenum;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityHolder extends RecyclerView.ViewHolder {
    TextView nameTask, taskNote, taskStatus;

    public MainActivityHolder(@NonNull View itemView) {
        super(itemView);

        nameTask = itemView.findViewById(R.id.name_task);
        taskNote = itemView.findViewById(R.id.task_note);
        taskStatus = itemView.findViewById(R.id.task_status);

    }
}
