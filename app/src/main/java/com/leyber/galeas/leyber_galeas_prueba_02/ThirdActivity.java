package com.leyber.galeas.leyber_galeas_prueba_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    private EditText etNombresT, etApellidosT, etDividendoT, etDivisorT, etNumeroT;
    private Button btnCerrarT;

    private String nombres, apellidos;
    private int dividendo, divisor, numero;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_third);

        etNombresT = findViewById(R.id.etNombresT);
        etApellidosT = findViewById(R.id.etApellidosT);
        etDividendoT = findViewById(R.id.etDividendoT);
        etDivisorT = findViewById(R.id.etDivisorT);
        etNumeroT = findViewById(R.id.etNumeroT);

        btnCerrarT = findViewById(R.id.btnCerrarT);

        Intent i = getIntent();
        nombres = i.getStringExtra("nombres");
        apellidos = i.getStringExtra("apellidos");

        etNombresT.setText(nombres);
        etApellidosT.setText(apellidos);

        etDividendoT.setEnabled(true);
        etDivisorT.setEnabled(true);
        etNumeroT.setEnabled(true);

        btnCerrarT.setOnClickListener(v->{
            String dividendoStr = etDividendoT.getText().toString();
            String divisorStr = etDivisorT.getText().toString();
            String numeroStr = etNumeroT.getText().toString();

            if(dividendoStr.isEmpty()) dividendoStr="0";
            if(divisorStr.isEmpty()) divisorStr="1";
            if(numeroStr.isEmpty()) numeroStr="0";

            dividendo = Integer.parseInt(dividendoStr);
            divisor = Integer.parseInt(divisorStr);
            numero = Integer.parseInt(numeroStr);

            int parteEntera = 0;
            int tempDividendo = dividendo;
            int tempDivisor = divisor == 0 ? 1 : divisor;
            while(tempDividendo >= tempDivisor){
                tempDividendo = tempDividendo - tempDivisor;
                parteEntera++;
            }

            int residuo = tempDividendo;
            int invertido = 0;
            int tempNum = numero;
            while(tempNum > 0){
                int digito = tempNum % 10;
                invertido = invertido * 10 + digito;
                tempNum = tempNum / 10;
            }
            if(numero < 0) {
                invertido = -invertido;
            }

            Intent result = new Intent();
            result.putExtra("nombres", nombres);
            result.putExtra("apellidos", apellidos);
            result.putExtra("dividendo", dividendo);
            result.putExtra("divisor", divisor);
            result.putExtra("numero", numero);
            result.putExtra("parteEntera", parteEntera);
            result.putExtra("residuo", residuo);
            result.putExtra("invertido", invertido);
            setResult(RESULT_OK, result);
            finish();
        });
    }
}
