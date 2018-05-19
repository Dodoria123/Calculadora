package calculadora.thiagoxtapps.com.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        btn0.setOnClickListener(){
            numeroAleatorio = rand.nextInt(frases.size)
            textoNovaFraseId.setText(frases[numeroAleatorio])
        }
        */
    }
}
