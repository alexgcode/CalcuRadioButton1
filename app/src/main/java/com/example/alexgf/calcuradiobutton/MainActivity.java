package com.example.alexgf.calcuradiobutton;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;  //Declaracion de variables
    private TextView tv1;
    private RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_num1);    //Inicialización de variables
        et2 = (EditText)findViewById(R.id.txt_num2);    //comunicacion entre parte grafica y logica
        tv1 = (TextView) findViewById(R.id.txt_result); //importa objetos de la vista
        rb1 = (RadioButton)findViewById(R.id.rbt1);
        rb2 = (RadioButton)findViewById(R.id.rbt2);
        rb3 = (RadioButton)findViewById(R.id.rbt3);
        rb4 = (RadioButton)findViewById(R.id.rbt4);
    }

    public void calculate(View view) {
        String value1 = et1.getText().toString();   //extrae los textos de los objetos de la vista
        String value2 = et2.getText().toString();

        int num1  = 0;
        int num2  = 0;
        try
        {
            if(value1 != null && value2 != null) {  //verifica que los valores de las vistas no sean nulos
                num1 = Integer.parseInt(value1);    //convierte los textos en valores numericos
                num2 = Integer.parseInt(value2);
            }
        }
        catch (NumberFormatException e)
        {
            num1 = 0;   //asegura que los numeros siempre tengan valores numericos asi no haya nada en los view
            num2 = 0;
        }


        int result = -1;
        String resultado = "";

        if(rb1.isChecked()==true){  //comprueba si esta seleccionado la suma
            result = num1 + num2;
            resultado = String.valueOf(result);

        }else if(rb2.isChecked()==true){    //comprueba si esta seleccionado la resta
            result = num1 - num2;
            resultado = String.valueOf(result);

        }else if (rb3.isChecked() == true){     //comprueba si esta seleccionado la multiplicación
            result = num1 * num2;
            resultado = String.valueOf(result);
        }else if (rb4.isChecked() == true){     //comprueba si esta seleccionado la división
            if(num2 == 0) {
                resultado = "No existe";
            }else{
                result = num1 / num2;
                resultado = String.valueOf(result);
            }
        }else {
            resultado = "Porfavor seleccione una operación";
        }


        tv1.setText(resultado);

    }

}
