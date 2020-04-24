package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private TextInputEditText inPrecoAlcool, inPrecoGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado       = findViewById(R.id.txtViewResultado);
        inPrecoAlcool     = findViewById(R.id.txtInputAlcool);
        inPrecoGasolina   = findViewById(R.id.txtInputGasolina);

    }


    public void calcular(View view){
        String precoAlcool = inPrecoAlcool.getText().toString();
        String precogasolina = inPrecoGasolina.getText().toString();

        boolean camposValidados = validar(precoAlcool, precogasolina);

        if (camposValidados){

            double intPrecoAlcool = Double.parseDouble(precoAlcool);
            double intPrecoGasolina= Double.parseDouble(precogasolina);
            if((intPrecoAlcool/intPrecoGasolina)>=0.7){
                resultado.setText("Ultilize Gasolina!");
            }else{
                resultado.setText("Ultilize Alcool!");
            }
        }else{
            resultado.setText("Preencha todos os campos com os respecivos preços");
        }
    }

    public boolean validar(String pAlcool, String pGasolina){
        boolean camposValidados = true;

        if(pAlcool == null || pGasolina.equals("") || pAlcool.equals("") || pGasolina== null){
            camposValidados = false;
        }

        return camposValidados;
    }



}
