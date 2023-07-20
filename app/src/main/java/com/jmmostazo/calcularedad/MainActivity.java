package com.jmmostazo.calcularedad;
/*
* Proyecto Jorge Martínez Mostazo
* App Android que calcula la edad perruna a partir de la humana
* Elemntos usados en esta app
* 1. Crear una app desde inicio en Java
* 2. Uso de Views: TextView, EditText, Button, LinearLayout
* 3. strings.xml Confiuración de string de idiomas
* 4. Diseño de views
* 5. Uso de Logcat
* 6. Uso y configuración de github
* 7. Databinding
* */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicio de elementos Views
        TextView txtEdad = findViewById(R.id.txtEdad);
        EditText edadHumana;
        edadHumana = findViewById(R.id.etEdadHumana);
        TextView edadPerruna = findViewById(R.id.txtEdadPerro);
        Button btnCalcular = findViewById(R.id.btEdad);


        //Uso de Log
        Log.d("MainActivity","Actvity creado");

        txtEdad.setText(R.string.dime_edad);
        btnCalcular.setOnClickListener(view -> {
            //Pasamos el numero de edad a un string
            String edad = edadHumana.getText().toString();

            int edadInt = 0;
            if (!edad.isEmpty()) edadInt = Integer.parseInt(edad);
            else {
                Log.d("MainActivity","Campo edad vacío");
                Toast.makeText(this,getString(R.string.introduce_edad),Toast.LENGTH_SHORT).show();
            }

            int resultado = edadInt*7;
            edadPerruna.setText(getString(R.string.resultado,resultado));

        });


    }
}