package com.leyber.galeas.leyber_galeas_prueba_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etNombresU, etApellidosU, etDividendoU, etDivisorU, etParteEnteraU, etResiduoU, etInvertidoU;
    private Button btnSiguienteU, btnMostrarResultadosU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);

        etNombresU = findViewById(R.id.etNombresU);
        etApellidosU = findViewById(R.id.etApellidosU);
        etDividendoU = findViewById(R.id.etDividendoU);
        etDivisorU = findViewById(R.id.etDivisorU);
        etParteEnteraU = findViewById(R.id.etParteEnteraU);
        etResiduoU = findViewById(R.id.etResiduoU);
        etInvertidoU = findViewById(R.id.etInvertidoU);

        btnSiguienteU = findViewById(R.id.btnSiguienteU);
        btnMostrarResultadosU = findViewById(R.id.btnMostrarResultadosU);

        btnSiguienteU.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(i, 100);
        });

        btnMostrarResultadosU.setOnClickListener(v->{

        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK && data != null){
            String nombres = data.getStringExtra("nombres");
            String apellidos = data.getStringExtra("apellidos");
            int dividendo = data.getIntExtra("dividendo",0);
            int divisor = data.getIntExtra("divisor",1);
            int parteEntera = data.getIntExtra("parteEntera",0);
            int residuo = data.getIntExtra("residuo",0);
            int invertido = data.getIntExtra("invertido",0);

            etNombresU.setText(nombres);
            etApellidosU.setText(apellidos);
            etDividendoU.setText(String.valueOf(dividendo));
            etDivisorU.setText(String.valueOf(divisor));
            etParteEnteraU.setText(String.valueOf(parteEntera));
            etResiduoU.setText(String.valueOf(residuo));
            etInvertidoU.setText(String.valueOf(invertido));

            btnMostrarResultadosU.setEnabled(true);

        }
    }
}
