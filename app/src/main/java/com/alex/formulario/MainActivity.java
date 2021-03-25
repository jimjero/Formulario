package com.alex.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDone;
    private EditText txtName;
    private EditText txtSurname;
    private EditText txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDone = findViewById(R.id.btnDone);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtSurname = findViewById(R.id.txtSurname);
        btnDone.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDone) {
            String name = txtName.getText().toString();
            String surname = txtSurname.getText().toString();
            String email = txtEmail.getText().toString();
            if (name.isEmpty()) {
                CustomToastView.makeErrorToast(this,"Error al validar el Nombre",R.layout.custom_toast).show();
                return;
            }
            if (surname.isEmpty()) {
                CustomToastView.makeErrorToast(this,"Error al validar el Apellido",R.layout.custom_toast).show();
                return;
            }
            if (!isValidEmail(email)) {
                CustomToastView.makeErrorToast(this,"Error al validar el Email",R.layout.custom_toast).show();
                return;
            }
            Intent myIntent = new Intent(this, Calculadoraimc.class);
            myIntent.putExtra("nameCalculator", name);
            myIntent.putExtra("surnameCalculator", surname);
            myIntent.putExtra("emailCalculator", email);
            startActivity(myIntent);
        }

    }

    private Boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}