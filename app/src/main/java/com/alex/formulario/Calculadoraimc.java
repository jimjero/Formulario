package com.alex.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Calculadoraimc extends AppCompatActivity implements View.OnClickListener{

    private TextView tvInformation;
    private TextView tvResult;
    private EditText txtHeight;
    private EditText txtWeight;
    private Button btnCalculator;
    private ImageView imState;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadoraimc);
        Intent intent = getIntent();
        String name = intent.getStringExtra("nameCalculator");
        String surname = intent.getStringExtra("surnameCalculator");
        String email = intent.getStringExtra("emailCalculator");
        String message = "Hola "+ name + " "+ surname + " es un gusto tenerte aca su correo para el informe es: "+email;
        setContentView(R.layout.activity_calculadoraimc);
        tvInformation = findViewById(R.id.tvInformation);
        tvResult = findViewById(R.id.tvResult);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        btnCalculator = findViewById(R.id.btnCalculator);
        imState = findViewById(R.id.imgState);
        tvInformation.setText(message);
        btnCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculator){
            double height = Double.parseDouble(String.valueOf(txtHeight.getText()));
            double weight = Double.parseDouble(String.valueOf(txtWeight.getText()));
            this.getImc(weight, height);
        }
    }
    private void getImc(double weight, double height) {
        double imc = (weight / Math.pow(height, 2));
        DecimalFormat dc = new DecimalFormat("#.00");
        if (imc < 18.5) {
            imState.setImageResource(R.drawable.pesobajo);
            tvResult.setText("RESULT" + "\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nBAJO PESO");
        } else if (imc < 25) {
            imState.setImageResource(R.drawable.pesonormal);
            tvResult.setText("RESULT" + "\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nPESO NORMAL");
        } else if (imc < 30) {
            imState.setImageResource(R.drawable.sobrepeso);
            tvResult.setText("RESULT" + "\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nSOBREPESO");
        } else if (imc < 35) {
            imState.setImageResource(R.drawable.obesidad);
            tvResult.setText("RESULT" + "\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nOBECIDAD");
        } else if (imc < 40) {
            imState.setImageResource(R.drawable.obecidadsevera);
            tvResult.setText("RESULT" + "\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nOBECIDAD SEVERA");
        } else if (imc >= 40) {
            imState.setImageResource(R.drawable.obecidadmorbida);
            tvResult.setText("RESULT" + "\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene OBECIDAD MORBIDA");
        }
    }
}