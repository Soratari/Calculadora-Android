package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
// adicionar a função de uma biblioteca OnClick
    private Button numero1, numero2, numero3, numero4, numero5, numero6, numero7, numero8, numero9, numero0, ponto, adicao, multiplicacao, divisao, resultado,subtracao, bks, clean;
//declaração das variaveis dos botões.

    private TextView txtExpressao, txtResultado;
    // declaração das váriaveis da tela de resultado e da conta no visor.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Componentes();
//variavel publica dos componentes.

        getSupportActionBar().hide();

        //esconder a barra com o nome da aplicação

        numero1.setOnClickListener(this);
        numero2.setOnClickListener(this);
        numero3.setOnClickListener(this);
        numero4.setOnClickListener(this);
        numero5.setOnClickListener(this);
        numero6.setOnClickListener(this);
        numero7.setOnClickListener(this);
        numero8.setOnClickListener(this);
        numero9.setOnClickListener(this);
        numero0.setOnClickListener(this);
        ponto.setOnClickListener(this);
        adicao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        //indicação de valor para cada botão.

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtExpressao.setText(" ");
                txtResultado.setText(" ");
            }
        });
        //botão para limpar o visor completamente

        bks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()) {

                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtExpresao = string.substring(var0, var1);
                    expressao.setText(txtExpresao);

                }
                txtResultado.setText(" ");

            }
        });
        //botão backspace

        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expression = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if (result == (double) longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));

                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception e) {

                }
            }
        });
    }//botão para mostrar o resultado da operação

    private void Componentes(){
        numero1 = findViewById(R.id.bt_um);
        numero2 = findViewById(R.id.bt_dois);
        numero3 = findViewById(R.id.bt_tres);
        numero4 = findViewById(R.id.bt_quatro);
        numero5 = findViewById(R.id.bt_cinco);
        numero6 = findViewById(R.id.bt_seis);
        numero7 = findViewById(R.id.bt_sete);
        numero8 = findViewById(R.id.bt_oito);
        numero9 = findViewById(R.id.bt_nove);
        numero0 = findViewById(R.id.bt_zero);
        ponto = findViewById(R.id.bt_ponto);
        adicao = findViewById(R.id.bt_adicao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        subtracao = findViewById(R.id.bt_subtracao);
        resultado = findViewById(R.id.bt_resultado);
        bks = findViewById(R.id.bks);
        clean = findViewById(R.id.bt_clean);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        //IDs conectados com cada váriavel declarada.



    }

    public void AdicionarExpressao(String string,boolean clean){

        if(txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (clean){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

    }//para fazer a declaração dos numeros da conta

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_um:
                AdicionarExpressao("1",true);
                break;

            case R.id.bt_dois:
                AdicionarExpressao("2",true);
                break;

            case R.id.bt_tres:
                AdicionarExpressao("3",true);
                break;

            case R.id.bt_quatro:
                AdicionarExpressao("4",true);
                break;

            case R.id.bt_cinco:
                AdicionarExpressao("5",true);
                break;

            case R.id.bt_seis:
                AdicionarExpressao("6",true);
                break;

            case R.id.bt_sete:
                AdicionarExpressao("7",true);
                break;

            case R.id.bt_oito:
                AdicionarExpressao("8",true);
                break;

            case R.id.bt_nove:
                AdicionarExpressao("9",true);
                break;

            case R.id.bt_zero:
                AdicionarExpressao("0",true);
                break;

            case R.id.bt_ponto:
                AdicionarExpressao(".",true);
                break;

            case R.id.bt_adicao:
                AdicionarExpressao("+",false);
                break;

            case R.id.bt_subtracao:
                AdicionarExpressao("-",false);
                break;

            case R.id.bt_multiplicacao:
                AdicionarExpressao("*",false);
                break;

            case R.id.bt_divisao:
                AdicionarExpressao("/",false);
                break;
        }// programa ação de cada botão das operações e numeros
    }
}
