package com.jmmostazo.calcularedad;
/*
* Proyecto Jorge Martínez Mostazo
* App Android que calcula la edad perruna a partir de la humana
* Elemntos usados en esta app
* 1. Crear una app desde inicio en Java
* 2. Uso de Views: TextView, EditText, Button, LinearLayout
* 3. strings.xml Configuración de string de idiomas
* 4. Diseño de views
* 5. Uso de Logcat
* 6. Uso y configuración de github
* 7. Databinding. Crea componentes en tiempo de compilación.
* En build.gradle buildFeatures{ dataBinding true }
* 8. Layouts:
* a. FrameLayout. Una unica view
* b. LinearLayout. Vertical. Se colocan views verticalmente (abajo)
* Horizontal. Se colocan views horizontalmente (izda a derecha)
* c. RelativeLayout. Es muy versatil colocando views
* d. ConstraintLayout. Se realiza desde diseño. Similar a Relative.
* Recomendable para pocos views (5 o 10)
* */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jmmostazo.calcularedad.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inicio contentview clásico sin binding
        //setContentView(R.layout.activity_main);

        //DataBinding. Formamos el layout
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Inicio de elementos Views clásicos findViewById
        /*
        TextView txtEdad = findViewById(R.id.txtEdad);
        EditText edadHumana;
        edadHumana = findViewById(R.id.etEdadHumana);
        TextView edadPerruna = findViewById(R.id.txtEdadPerro);
        Button btnCalcular = findViewById(R.id.btEdad);
        */

        //Inicio de elementos Views binding
        TextView txtEdad = binding.txtEdad;
        EditText edadHumana;
        edadHumana = binding.etEdadHumana;
        TextView edadPerruna = binding.txtEdadPerro;
        Button btnCalcular = binding.btEdad;

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