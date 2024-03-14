package samaniego.martin.peliculas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginActivity : AppCompatActivity() {
    lateinit var btn_ingresar:Button
    lateinit var btn_registro:Button
    lateinit var tv_recuperacion:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_ingresar = findViewById(R.id.btn_ingresar)
        btn_registro = findViewById(R.id.btn_registro)
        tv_recuperacion = findViewById(R.id.tv_recuperacion)

        btn_registro.setOnClickListener {
            var intent = Intent (this, registroActivity::class.java)
            startActivity(intent)
        }

        btn_ingresar.setOnClickListener {
            var intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        tv_recuperacion.setOnClickListener {
            var intent = Intent (this, recuperacionActivity::class.java)
            startActivity(intent)
        }
    }
}