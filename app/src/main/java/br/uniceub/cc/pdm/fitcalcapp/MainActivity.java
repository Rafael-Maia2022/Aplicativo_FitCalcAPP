package br.uniceub.cc.pdm.fitcalcapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // Valores

    public Float IMC;
    public Float Peso;
    public Float Altura;
    public String str;
    public Float IMC_IDEAL;
    public Float x1;
    public Float x2;


    // Tela
    public LinearLayout layout_calculadora_IMC;
    public LinearLayout layout_caluladora_Peso_ideal;
    public LinearLayout layout_calculadora_Altura_ideal;


    // tela principal
    public Button Calculadora_IMC;
    public Button Calculadora_Peso_Ideal;
    public Button Calculadora_Altura_Ideal;

    // calculadora IMC

    public RadioButton calculadora_imc_Sexo_Masculino;
    public RadioButton calculadora_imc_Sexo_Feminino;
    public EditText calculadora_imc_Altura;
    public EditText calculadora_imc_Peso;
    public TextView calculadora_imc_Resultado;

    public Button Calculadora_IMC_calcular;
    public Button Calculadora_IMC_voltar;

    // peso ideal
    public RadioButton calculadora_peso_ideal_Sexo_Masculino;
    public RadioButton calculadora_peso_ideal_Sexo_feminino;
    public EditText calculadora_peso_ideal_Altura;
    public Button Calculadora_Peso_Ideal_Calcular;
    public Button Calculadora_Peso_Ideal_Voltar;
    public TextView Calculadora_peso_ideal_Resultado;

    // Altura ideal
    public RadioButton calculadora_altura_ideal_Sexo_Masculino;
    public RadioButton calculadora_altura_ideal_Sexo_Feminino;
    public EditText calculadora_altura_ideal_Peso;
    public TextView calculadora_Altura_ideal_Resultado;
    public Button Calculadora_Altura_Ideal_Calcular;
    public Button Calculadora_Altura_Ideal_Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        CarregarTelaPrincipal();
    }
    public void CarregarTelaPrincipal(){
        setContentView(R.layout.tela_principal);
        Calculadora_IMC = findViewById(R.id.button_Calculadora_IMC);
        Calculadora_Peso_Ideal = findViewById(R.id.button_Calculadora_Peso_Ideal);
        Calculadora_Altura_Ideal = findViewById(R.id.button_Calculadora_Altura_Ideal);

        Calculadora_IMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarCalculadoraIMC();
            }
        });
        Calculadora_Peso_Ideal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarCalculadoraPesoIdeal();
            }
        });
        Calculadora_Altura_Ideal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarCalculadoraAlturaIdeal();
            }
        });
    }

    public void CarregarCalculadoraIMC(){
        // IMC = PESO / ( ALTURA ^ 2 )
        setContentView(R.layout.calculadora_imc);
        calculadora_imc_Sexo_Masculino = findViewById(R.id.radioButton_calculadora_imc_Sexo_Masculino);
        calculadora_imc_Sexo_Feminino = findViewById(R.id.radioButton_calculadora_imc_Sexo_Feminino);
        calculadora_imc_Altura = findViewById(R.id.editTextText_calculadora_imc_Altura);
        calculadora_imc_Peso = findViewById(R.id.editTextText_calculadora_imc_Peso);
        calculadora_imc_Resultado = findViewById(R.id.textView_calculadora_imc_Resultado);
        Calculadora_IMC_calcular =  findViewById(R.id.button_Calculadora_IMC_calcular);
        Calculadora_IMC_voltar = findViewById(R.id.button_Calculadora_IMC_voltar);
        layout_calculadora_IMC = findViewById(R.id.layout_tela_IMC);

        Calculadora_IMC_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {CarregarTelaPrincipal();}
        });

        layout_calculadora_IMC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        x1=event.getX();
                        return true;

                    case MotionEvent.ACTION_UP:
                        x2=event.getX();
                        if(x2-x1>100){
                            CarregarTelaPrincipal();
                        }
                        return true;
                    default: return false;
                }
            }
        });

        Calculadora_IMC_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    str = calculadora_imc_Altura.getText().toString();
                    Altura = Float.parseFloat(str);
                    str = calculadora_imc_Peso.getText().toString();
                    Peso = Float.parseFloat(str);
                    IMC = Peso / (Altura * Altura);

                if(calculadora_imc_Sexo_Masculino.isChecked()){
                    if(IMC < 18.5){
                        calculadora_imc_Resultado.setText(
                                "Então Abaixo do peso");
                    } else if (IMC > 18.5 && IMC<24.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Peso normal");
                    } else if (IMC >25.0 && IMC< 29.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Pré-obesidade");
                    } else if (IMC > 30.0 && IMC < 34.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Obesidade Grau 1");
                    } else if (IMC> 35.0 && IMC < 39.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Obesidade Grau 2");
                    } else if (IMC> 40) {
                        calculadora_imc_Resultado.setText(
                                "Então Obesidade Grau 3");
                    }

                } else if (calculadora_imc_Sexo_Feminino.isChecked()) {
                    if(IMC < 18.5){
                        calculadora_imc_Resultado.setText(
                                "Então Abaixo do peso");
                    } else if (IMC > 18.5 && IMC<26.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Peso normal");
                    } else if (IMC >27.0 && IMC< 32.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Pré-obesidade");
                    } else if (IMC > 33.0 && IMC < 37.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Obesidade Grau 1");
                    } else if (IMC> 38.0 && IMC < 44.9) {
                        calculadora_imc_Resultado.setText(
                                "Então Obesidade Grau 2");
                    } else if (IMC> 45) {
                        calculadora_imc_Resultado.setText(
                                "Então Obesidade Grau 3");
                    }
                }else{calculadora_imc_Resultado.setText("Selecione um Sexo");}

                }catch(Exception ex){
                    calculadora_imc_Resultado.setText(
                            "Erro:\n cetifique-se que não haja letras \n e que os numeros NÃO sejam separados por virgula' , '");}
            }
        });

    }

    public void CarregarCalculadoraPesoIdeal(){
        setContentView(R.layout.calculadora_peso_ideal);
        calculadora_peso_ideal_Sexo_Masculino = findViewById(R.id.radioButton_calculadora_peso_ideal_Sexo_Masculino);
        calculadora_peso_ideal_Sexo_feminino =  findViewById(R.id.radioButton_calculadora_peso_ideal_Sexo_feminino);
        calculadora_peso_ideal_Altura = findViewById(R.id.editTextText_calculadora_peso_ideal_Altura);
        Calculadora_Peso_Ideal_Calcular = findViewById(R.id.button_Calculadora_Peso_Ideal_Calcular);
        Calculadora_Peso_Ideal_Voltar = findViewById(R.id.button_Calculadora_Peso_Ideal_Voltar);
        Calculadora_peso_ideal_Resultado = findViewById(R.id.textView_calculadora_peso_ideal_Resultado);
        layout_caluladora_Peso_ideal=findViewById(R.id.layout_tela_Peso_Ideal);

        Calculadora_Peso_Ideal_Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {CarregarTelaPrincipal();}
        });

        layout_caluladora_Peso_ideal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        x1=event.getX();
                        return true;

                    case MotionEvent.ACTION_UP:
                        x2=event.getX();
                        if(x2-x1>100){
                            CarregarTelaPrincipal();
                        }
                        return true;
                    default: return false;
                }
            }
        });

        Calculadora_Peso_Ideal_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    str = calculadora_peso_ideal_Altura.getText().toString();
                    Altura = Float.parseFloat(str);
                    if (calculadora_peso_ideal_Sexo_Masculino.isChecked()) {
                        IMC_IDEAL = 21.7F;
                        Peso=IMC_IDEAL*(Altura*Altura);
                        Calculadora_peso_ideal_Resultado.setText(String.format("Voce deveria estar pesando: %.2f Kg",Peso));
                    } else if (calculadora_peso_ideal_Sexo_feminino.isChecked()) {
                        IMC_IDEAL = 22.7F;
                        Peso=IMC_IDEAL*(Altura*Altura);
                        Peso=IMC_IDEAL*(Altura*Altura);
                        Calculadora_peso_ideal_Resultado.setText(String.format("Voce deveria estar pesando: %.2f Kg",Peso));
                    } else {
                        Calculadora_peso_ideal_Resultado.setText("Escolha um Sexo");
                    }
                }catch(Exception e){
                    Calculadora_peso_ideal_Resultado.setText(
                            "Erro:\n cetifique-se que não haja letras \n e que os numeros NÃO sejam separados por virgula' , '");

                }
            }
        });
    }

    public void CarregarCalculadoraAlturaIdeal(){
        setContentView(R.layout.calculadora_altura_ideal);
        calculadora_altura_ideal_Sexo_Masculino = findViewById(R.id.radioButton_calculadora_altura_ideal_Sexo_Masculino);
        calculadora_altura_ideal_Sexo_Feminino = findViewById(R.id.radioButton_calculadora_altura_ideal_Sexo_Feminino);
        calculadora_altura_ideal_Peso = findViewById(R.id.editTextText_calculadora_altura_ideal_Peso);
        calculadora_Altura_ideal_Resultado = findViewById(R.id.textView_calculadora_Altura_ideal_Resultado);
        Calculadora_Altura_Ideal_Calcular = findViewById(R.id.button_Calculadora_Altura_Ideal_Calcular);
        Calculadora_Altura_Ideal_Voltar = findViewById(R.id.button_Calculadora_Altura_Ideal_Voltar);
        layout_calculadora_Altura_ideal=findViewById(R.id.layout_tela_Altura_Ideal);

        Calculadora_Altura_Ideal_Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {CarregarTelaPrincipal();}
        });

        layout_calculadora_Altura_ideal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        x1=event.getX();
                        return true;

                    case MotionEvent.ACTION_UP:
                        x2=event.getX();
                        if(x2-x1>100){
                            CarregarTelaPrincipal();
                        }
                        return true;
                    default: return false;
                }
            }
        });

        Calculadora_Altura_Ideal_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    str = calculadora_altura_ideal_Peso.getText().toString();
                    Peso = Float.parseFloat(str);
                    if (calculadora_altura_ideal_Sexo_Masculino.isChecked()) {
                        IMC_IDEAL = 21.7F;
                        Altura = (float) Math.pow((Peso / IMC_IDEAL),(1F/2F));
                        calculadora_Altura_ideal_Resultado.setText(String.format("altura idela é de %.2f Metros", Altura));
                    } else if (calculadora_altura_ideal_Sexo_Feminino.isChecked()) {
                        IMC_IDEAL = 22.7F;
                        Altura = (float) Math.pow((Peso / IMC_IDEAL),(1F/2F));
                        calculadora_Altura_ideal_Resultado.setText(String.format("altura idela é de %.2f Metros", Altura));
                    } else {
                        calculadora_Altura_ideal_Resultado.setText("Escolha um sexo");
                    }

                }catch(Exception e){
                    calculadora_Altura_ideal_Resultado.setText("Erro:\n cetifique-se que não haja letras \n e que os numeros NÃO sejam separados por virgula' , '");}
            }
        });
    }
}