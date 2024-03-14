package samaniego.martin.peliculas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class recuperacionActivity : AppCompatActivity() {
    lateinit var btn_recuperar_contra: Button
    lateinit var et_correo_recuperacion: EditText
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion)

        btn_recuperar_contra = findViewById(R.id.btn_recuperar_contra)
        et_correo_recuperacion = findViewById(R.id.et_correo_recuperacion)

        // Initialize Firebase Auth
        auth = Firebase.auth

        btn_recuperar_contra.setOnClickListener {

            val correo = et_correo_recuperacion.text.toString()

            if (!correo.isNullOrEmpty()) {

                auth.sendPasswordResetEmail(correo)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            //Log.d(TAG, "Email sent.")
                            Toast.makeText(this, "Email enviado", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this, "No se pudo enviar el correo", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Ingresar correo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}