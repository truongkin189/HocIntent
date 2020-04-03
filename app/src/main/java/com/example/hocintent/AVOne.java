package com.example.hocintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AVOne extends AppCompatActivity {
    Intent intent;
    TextView hello;
    Button listStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_v_one);
        hello = findViewById(R.id.hello);
        listStudent = findViewById(R.id.listStudent);
        intent = new Intent(this, AVTwo.class);
        Bundle bundle = getIntent().getBundleExtra("data");
        hello.setText("Xin chào: "+bundle.getString("user"));
        listStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Student student = (Student) data.getSerializableExtra("data");
        Toast.makeText(this, student.getName()+"\n"+ student.getAge()+"\n"+student.getSex(), Toast.LENGTH_SHORT).show();
    }
}
