package com.rgbat.tasksenum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int NUM_REQUEST = 123;
    TaskAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv_list);
        adapter = new TaskAdapter();
        rv.setAdapter(adapter);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddTask.class);
                startActivityForResult(intent, NUM_REQUEST); //moving to the page "AddTask.java" temporary, with receive result

            }
        });

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NUM_REQUEST && resultCode == RESULT_OK){ //checking number request, and result of action in the page
            adapter.addTask(); //making update of RecycleView, becouse we made update Task List
//            Toast.makeText(getBaseContext(), "Task Added", Toast.LENGTH_LONG).show(); // this code, just for test
//            MainActivityAdapter adapter2 = new MainActivityAdapter();
//            RecyclerView rv = findViewById(R.id.rv_list);
//            rv.setAdapter(adapter2);
        }else{
            Toast.makeText(getBaseContext(), "Had nay mistake!", Toast.LENGTH_LONG).show();
        }
    }
}
