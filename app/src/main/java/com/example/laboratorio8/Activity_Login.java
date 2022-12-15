package com.example.laboratorio8;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToActivityMenu(View view) {
        EditText edtUserName = findViewById(R.id.edtUserName);
        EditText edtPassword = findViewById(R.id.edtUserPassword);
        TextView txtMessage = findViewById(R.id.txtMessage);

        String user = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        if(user.equals("admin") && password.equals("123")){
            txtMessage.setText("");
            Intent intentActivityMenu = new Intent(this, Activity_Menu.class);
            startActivity(intentActivityMenu);
        } else {
            Log.d(TAG,"usuario: " + user + ", Password: " + password);
            txtMessage.setText("Usuario o contraseña invalidos");
        }
    }
}