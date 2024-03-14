package samaniego.martin.peliculas

import android.os.Bundle
import android.util.Log
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

class registroActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var btn_registrar: Button
    lateinit var et_correo_registro: EditText
    lateinit var et_contra1_registro: EditText
    lateinit var et_contra2_registro: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        et_correo_registro = findViewById(R.id.et_correo_registro)
        et_contra1_registro = findViewById(R.id.et_contra1_registro)
        et_contra2_registro = findViewById(R.id.et_contra2_registro)
        btn_registrar = findViewById(R.id.btn_registrar)

        // Initialize Firebase Auth
        auth = Firebase.auth

        btn_registrar.setOnClickListener {
            var correo = et_correo_registro.text.toString()
            var contra1 = et_contra1_registro.text.toString()
            var contra2 = et_contra2_registro.text.toString()

            if (!correo.isNullOrEmpty() && !contra1.isNullOrEmpty() && !contra2.isNullOrEmpty()) {
                if (contra1 == contra2) {

                    auth.createUserWithEmailAndPassword(correo, contra1)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Exito", "createUserWithEmail:success")
                                Toast.makeText(
                                    baseContext,
                                    "Usuario registrado correctamente ${user?.email}",
                                    Toast.LENGTH_SHORT,
                                ).show()
                                finish()
                                //updateUI(user)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Error", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(
                                    baseContext,
                                    "No se pudo registrar el usuario",
                                    Toast.LENGTH_SHORT,
                                ).show()
                                //updateUI(null)
                            }
                        }

                } else {
                    Toast.makeText(this, "Las contraeñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Ingresar datos de correo y contraseña", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
