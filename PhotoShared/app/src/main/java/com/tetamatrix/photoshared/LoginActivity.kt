package com.tetamatrix.photoshared

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.tetamatrix.photoshared.Ui.PostActivity
import com.tetamatrix.photoshared.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        //Kullanıcı login olmuş mu?
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    //Giriş Butonu
    fun loginBtn(view: View) {
        auth.signInWithEmailAndPassword(binding.edtEmail.text.toString(), binding.edtPassword.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                //Başarolı ise
                val currentUser = auth.currentUser?.email.toString()
                Toast.makeText(this, "Hoşgeldin : ${currentUser}", Toast.LENGTH_LONG).show()
                val intent = Intent(this, PostActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, "${exception.localizedMessage}", Toast.LENGTH_LONG).show()
        }

    }

    //Kayıt texti işlemleri
    fun registerTxt(view: View) {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            //asnyc
            if (task.isSuccessful) {
                //Başarolı ise
                val intent = Intent(this, PostActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, "${exception.localizedMessage}", Toast.LENGTH_LONG).show()
        }
    }
}