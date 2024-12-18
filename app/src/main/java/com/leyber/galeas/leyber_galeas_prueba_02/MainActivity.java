package com.leyber.galeas.leyber_galeas_prueba_02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNombresU, etApellidosU, etDividendoU, etDivisorU, etParteEnteraU, etResiduoU, etInvertidoU;
    private Button btnSiguienteU, btnMostrarResultadosU;
    private boolean regresoConDatos = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_activity_main);

        etNombresU = findViewById(R.id.etNombresU);
        etApellidosU = findViewById(R.id.etApellidosU);
        etDividendoU = findViewById(R.id.etDividendoU);
        etDivisorU = findViewById(R.id.etDivisorU);
        etParteEnteraU = findViewById(R.id.etParteEnteraU);
        etResiduoU = findViewById(R.id.etResiduoU);
        etInvertidoU = findViewById(R.id.etInvertidoU);

        

    }

}