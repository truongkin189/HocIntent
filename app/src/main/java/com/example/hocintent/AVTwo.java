package com.example.hocintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AVTwo extends AppCompatActivity {
    ListView listView;
    private ArrayList<Student> listStudent;
    private StudentAdaper studentAdaper;
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_v_two);
        listView = findViewById(R.id.listView);
        listStudent = new ArrayList<>();
        listStudent.add(new Student("Truong" , "23","Nam"));
        listStudent.add(new Student("Nhung" , "21","Nữ"));
        listStudent.add(new Student("Ngọc" , "22","Nữ"));
        studentAdaper = new StudentAdaper(this ,R.layout.item_student , listStudent);
        listView.setAdapter(studentAdaper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("data", listStudent.get(i));
                setResult(0, intent);
                finish();
            }
        });
    }
}
