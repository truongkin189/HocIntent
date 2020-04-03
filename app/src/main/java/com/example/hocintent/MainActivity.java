package com.example.hocintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText useName,passWord;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        useName = findViewById(R.id.useName);
        passWord = findViewById(R.id.passWord);
        btnLogin = findViewById(R.id.btnLogin);
        final Intent intent = new Intent(this, AVOne.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = useName.getText().toString().trim();
                String pass = passWord.getText().toString().trim();
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy diền đầy đủ thông tin", Toast.LENGTH_LONG).show();
                }else if(!user.equals("admin") || !pass.equals("admin")){
                    Toast.makeText(MainActivity.this,"Thông tin đăng nhập sai", Toast.LENGTH_LONG).show();
                }else{
                    Bundle bundle = new Bundle();
                    bundle.putString("user",user);
                    intent.putExtra("data", bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
