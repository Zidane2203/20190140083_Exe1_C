package com.example.a20190140083_exe1_c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btSignin;
    EditText edEmail, edPassword;
    String Email, Password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), Form_Pendaftaran.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSignin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Email = edEmail.getText().toString();
                Password = edPassword.getText().toString();
                String email = "admin@mail.com";
                String pass = "123456";

                if (Email.isEmpty() || Password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(), "Email dan Password wajib diisi!", Toast.LENGTH_LONG);
                    t.show();
                } else {
                    if (Email.equals(email) && Password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses!", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", Email.trim());
                        b.putString("b", Password.trim());

                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                        i.putExtras(b);

                        startActivity(i);
                    } else {
                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal!", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }
}