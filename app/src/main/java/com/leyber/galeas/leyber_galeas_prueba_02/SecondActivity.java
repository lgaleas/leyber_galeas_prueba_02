package com.leyber.galeas.leyber_galeas_prueba_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText etNombresD, etApellidosD, etDividendoD, etDivisorD, etNumeroD;
    private Button btnSiguienteD, btnCerrarD;

    private boolean regresoDesdeTRES = false;
    private String nombres, apellidos;
    private int dividendo, divisor, numero;
    private int parteEntera, residuo, invertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_second);

        etNombresD = findViewById(R.id.etNombresD);
        etApellidosD = findViewById(R.id.etApellidosD);
        etDividendoD = findViewById(R.id.etDividendoD);
        etDivisorD = findViewById(R.id.etDivisorD);
        etNumeroD = findViewById(R.id.etNumeroD);

        btnSiguienteD = findViewById(R.id.btnSiguienteD);
        btnCerrarD = findViewById(R.id.btnCerrarD);

        btnSiguienteD.setOnClickListener(v -> {
            if(!regresoDesdeTRES){
                nombres = etNombresD.getText().toString();
                apellidos = etApellidosD.getText().toString();

                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("nombres", nombres);
                i.putExtra("apellidos", apellidos);
                startActivityForResult(i,200);
            } else {

            }
        });

        btnCerrarD.setOnClickListener(v->{
            Intent result = new Intent();
            result.putExtra("nombres", nombres);
            result.putExtra("apellidos", apellidos);
            result.putExtra("dividendo", dividendo);
            result.putExtra("divisor", divisor);
            result.putExtra("parteEntera", parteEntera);
            result.putExtra("residuo", residuo);
            result.putExtra("invertido", invertido);
            setResult(RESULT_OK, result);
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==200 && resultCode==RESULT_OK && data!=null){
            regresoDesdeTRES = true;

            nombres = data.getStringExtra("nombres");
            apellidos = data.getStringExtra("apellidos");
            dividendo = data.getIntExtra("dividendo",0);
            divisor = data.getIntExtra("divisor",1);
            numero = data.getIntExtra("numero",0);
            parteEntera = data.getIntExtra("parteEntera",0);
            residuo = data.getIntExtra("residuo",0);
            invertido = data.getIntExtra("invertido",0);

            etNombresD.setText(nombres);
            etApellidosD.setText(apellidos);
            etDividendoD.setText(String.valueOf(dividendo));
            etDivisorD.setText(String.valueOf(divisor));
            etNumeroD.setText(String.valueOf(numero));

            etNombresD.setEnabled(true);
            etApellidosD.setEnabled(true);
            etDividendoD.setEnabled(false);
            etDivisorD.setEnabled(false);
            etNumeroD.setEnabled(false);

            btnCerrarD.setEnabled(true);
        }
    }
}
