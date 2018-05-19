package calculadora.thiagoxtapps.com.calculadora;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistoricoActivity extends AppCompatActivity {

    private TextView descricaoHistorico;
    private Button limparHistorico;
    private Button voltarCalculadora;
    public static final String PREFERENCES_CALCULADORA = "MinhasPreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        configurarViewsUI();

        Intent intent = getIntent();
        String historico = intent.getStringExtra("EXTRA_HISTORICO");
        descricaoHistorico.setText(historico);

        limparHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparHistoricoPreference();
            }
        });
        voltarCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void configurarViewsUI(){
        limparHistorico = (Button)findViewById(R.id.btnLimparHistorico);
        voltarCalculadora = (Button)findViewById(R.id.btnVoltarCalculadora);
        descricaoHistorico = (TextView)findViewById(R.id.txtDescricaoHistorico);
    }
    public void limparHistoricoPreference(){
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(PREFERENCES_CALCULADORA, MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
        descricaoHistorico.setText(null);
    }
}
