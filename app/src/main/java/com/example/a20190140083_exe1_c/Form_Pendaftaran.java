package com.example.a20190140083_exe1_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Form_Pendaftaran extends AppCompatActivity
{
    EditText edNama, edAlamat, edEmail,  edPassword, edRPassword;

    Button btSelesai;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form__pendaftaran);

        btSelesai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (edNama.getText().toString().isEmpty() ||
                        edAlamat.getText().toString().isEmpty() ||
                        edEmail.getText().toString().isEmpty() ||
                        edPassword.getText().toString().isEmpty() ||
                        edRPassword.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "Wajib isi seluruh data!!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (edPassword.getText().toString().equals(edRPassword.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil!!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Password dan RePassword harus sama!!!", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}