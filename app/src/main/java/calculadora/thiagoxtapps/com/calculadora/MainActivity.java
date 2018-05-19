package calculadora.thiagoxtapps.com.calculadora;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button um;
    private Button dois;
    private Button tres;
    private Button quatro;
    private Button cinco;
    private Button seis;
    private Button sete;
    private Button oito;
    private Button nove;
    private Button somar;
    private Button subtrair;
    private Button multiplicar;
    private Button dividir;
    private Button igual;
    private Button limpar;
    private Button historico;
    private TextView resultado;
    private TextView informacao;
    private final char SOMAR = '+';
    private final char SUBTRAIR = '-';
    private final char MULTIPLICAR = '*';
    private final char DIVIDIR = '/';
    private final char IGUAL = 0;
    private double valor1 = Double.NaN;
    private double valor2;
    private char ACAO;
    public static final String PREFERENCES_CALCULADORA = "MinhasPreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarViewsUI();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "0");
            }
        });
        um.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "1");            }
        });
        dois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "2");            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "3");            }
        });
        quatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "4");            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "5");            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "6");            }
        });
        sete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "7");            }
        });
        oito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "8");            }
        });
        nove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "9");            }
        });
        somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "+");            }
        });
        subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "-");            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "X");            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informacao.setText(informacao.getText() + "/");            }
        });

        /*----OPERAÇÕES----*/
        somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
                ACAO = SOMAR;
                resultado.setText(String.valueOf(valor1) + "+");
                informacao.setText(null);
            }
        });
        subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
                ACAO = SUBTRAIR;
                resultado.setText(String.valueOf(valor1) + "-");
                informacao.setText(null);
            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
                ACAO = MULTIPLICAR;
                resultado.setText(String.valueOf(valor1) + "*");
                informacao.setText(null);
            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
                ACAO = DIVIDIR;
                resultado.setText(String.valueOf(valor1) + "/");
                informacao.setText(null);
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
                ACAO = IGUAL;
                resultado.setText(resultado.getText().toString() + String.valueOf(valor2) + "=" + String.valueOf(valor1));
                setPreference("HISTORICO",resultado.getText().toString());
                informacao.setText(null);
            }
        });
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(informacao.getText().length() > 0){
                    CharSequence nome = informacao.getText().toString();
                    informacao.setText(nome.subSequence(0,nome.length()-1));
                }else{
                    valor1 = Double.NaN;
                    valor2 = Double.NaN;
                    informacao.setText(null);
                    resultado.setText(null);
                }
            }
        });
        historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHistorico = new Intent(MainActivity.this,HistoricoActivity.class);
                goHistorico.putExtra("EXTRA_HISTORICO",getPreference("HISTORICO"));
                startActivity(goHistorico);
            }
        });
    }

    private void configurarViewsUI(){
        zero = (Button)findViewById(R.id.btn0);
        um = (Button)findViewById(R.id.btn1);
        dois = (Button)findViewById(R.id.btn2);
        tres = (Button)findViewById(R.id.btn3);
        quatro = (Button)findViewById(R.id.btn4);
        cinco = (Button)findViewById(R.id.btn5);
        seis = (Button)findViewById(R.id.btn6);
        sete = (Button)findViewById(R.id.btn7);
        oito = (Button)findViewById(R.id.btn8);
        nove = (Button)findViewById(R.id.btn9);
        somar = (Button)findViewById(R.id.btnSomar);
        subtrair = (Button)findViewById(R.id.btnSubtrair);
        multiplicar = (Button)findViewById(R.id.btnMultiplicar);
        dividir = (Button)findViewById(R.id.btnDividir);
        igual = (Button)findViewById(R.id.btnIgual);
        limpar = (Button)findViewById(R.id.btnLimpar);
        historico = (Button)findViewById(R.id.btnHistorico);
        resultado = (TextView)findViewById(R.id.txtResultado);
        informacao = (TextView)findViewById(R.id.txtControle);
    }

    private void calcular(){
        if(!Double.isNaN(valor1)) {
            valor2 = Double.parseDouble(informacao.getText().toString());

            switch (ACAO) {
                case SOMAR:
                    valor1 = valor1 + valor2;
                    break;
                case SUBTRAIR:
                    valor1 = valor1 - valor2;
                    break;
                case MULTIPLICAR:
                    valor1 = valor1 * valor2;
                    break;
                case DIVIDIR:
                    valor1 = valor1 / valor2;
                    break;
                case IGUAL:
                    break;
            }
        }else{
            valor1 = Double.parseDouble(informacao.getText().toString());
        }
    }

    public void setPreference(String chave, String valor){
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(PREFERENCES_CALCULADORA, MODE_PRIVATE).edit();

        SharedPreferences prefs = getSharedPreferences(PREFERENCES_CALCULADORA, MODE_PRIVATE);
        String textoObtido = prefs.getString(chave,null);
        if(textoObtido != null){
            valor = textoObtido + "; " + valor;
        }
        editor.putString(chave,valor);
        editor.apply();
    }

    public String getPreference(String chave){
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_CALCULADORA, MODE_PRIVATE);
        String textoObtido = prefs.getString(chave,null);
        return textoObtido;
    }
}
