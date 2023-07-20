package com.jmmostazo.calcularedad;
/*
* Proyecto Jorge Martínez Mostazo
* App Android que calcula la edad perruna a partir de la humana
* */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edadHumana;
        edadHumana = findViewById(R.id.etEdadHumana);
        TextView edadPerruna = findViewById(R.id.txtEdadPerro);
        Button btnCalcular = findViewById(R.id.btEdad);


        //Uso de Log
        


        btnCalcular.setOnClickListener(view -> {
            //Pasamos el numero de edad a un string
            String edad = edadHumana.getText().toString();

            int edadInt = 0;
            if (!edad.isEmpty()) edadInt = Integer.parseInt(edad);
            else edadPerruna.setText("Introduce una edad");

            int resultado = edadInt*7;
            edadPerruna.setText("Edad Perruna: "+resultado+" años");

        });


    }
}