package com.rgbat.tasksenum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<MainActivityHolder> {
    @NonNull
    @Override
    public MainActivityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row, parent, false);
        return new MainActivityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityHolder holder, int position) {

        holder.nameTask.setText(DataManager.getTasks().get(position).getNameTask());
        holder.taskNote.setText(DataManager.getTasks().get(position).getNote());
        holder.taskStatus.setText(DataManager.getTasks().get(position).getStatus().toString());
    }



    @Override
    public int getItemCount() {
        return DataManager.getTasks().size();
    }

    public void addTask(){ // here we making
        notifyDataSetChanged();
    }

}
