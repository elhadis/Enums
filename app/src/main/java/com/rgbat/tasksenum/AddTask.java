package com.rgbat.tasksenum;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText taskNameView = findViewById(R.id.task_name);
                final String taskName = taskNameView.getText().toString();
                EditText taskNoteView = findViewById(R.id.task_note);
                 final String taskNote = taskNoteView.getText().toString();
                RadioGroup radioGroup = findViewById(R.id.radio_group);
              final int selectedID = radioGroup.getCheckedRadioButtonId();
              if (taskName.equals("")){
                  Toast.makeText(getBaseContext(),"You not wrote name task",Toast.LENGTH_LONG).show();
              }else if (selectedID== -1){
                  Toast.makeText(getBaseContext(),"You not decided status",Toast.LENGTH_LONG).show();
              }else{
                  RadioButton radioButton =(RadioButton)findViewById(selectedID);
                  final  Statuses status = Statuses.getStatus(radioButton.getText().toString());
                  AlertDialog.Builder alert = new AlertDialog.Builder(AddTask.this);


                  alert.setTitle("Add new task"); // Tittle of alert
                  alert.setMessage("You sure want add this task?"); // main massage of alert
                  alert.setCancelable(false);
                  alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          Toast.makeText(getBaseContext(), "Add task cenceled", Toast.LENGTH_LONG).show();
                      }
                  });

                  alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          Task task = new Task(taskName, taskNote, status); //making new task
                          //Add Task option 1
                          DataManager.addTask(task); //add new task to list of tasks

                          JSONObject object = new JSONObject();
                          try {
                              object.put("Name Task",taskName);
                              object.put("note", taskNote);
                          } catch (JSONException e) {
                              e.printStackTrace();
                          }
                          Intent intent = new Intent();
                          intent.putExtra("newTask", object.toString()); //for option 2
                          setResult(Activity.RESULT_OK,intent);
                          finish();


                      }
                  });
                  alert.show();
              }



            }
        });

            }
        }












