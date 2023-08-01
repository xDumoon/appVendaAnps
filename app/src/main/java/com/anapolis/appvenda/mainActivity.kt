package com.anapolis.appvenda;

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anapolis.appvenda.databinding.ActivityLoginBinding
import com.anapolis.appvenda.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this,"Bem vindo", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titulo = findViewById<TextView>(R.id.titulo)
        titulo.text = "Compra e Venda Anápolis"
        val informacao = findViewById<TextView>(R.id.informacao)
        informacao.text = "Número da Polícia Federal: 190 | Ajuda com o app:62994491941"
        val bemvindo = findViewById<TextView>(R.id.bemvindo)
        bemvindo.text = "Bem vindo(a), o que pretende fazer hoje?"
        val atencao = findViewById<TextView>(R.id.atencao)
        atencao.text = "ATENÇÃO\nEste app não realiza transações, apenas atuamos como uma vitrine para os vendedores. Para realizar qualquer compra contate o vendedor para saber mais informações"
        val buttonvender = findViewById<Button>(R.id.ButtonVender)
        buttonvender.text = "Vender"
        val buttoncomprar= findViewById<Button>(R.id.buttoncomprar)
        buttoncomprar.text = "Comprar"

        binding.ButtonVender.setOnClickListener{
            telaDeLogin(it)
        }
    }
    private fun telaDeLogin(view: View){

        val progressBar = binding.progressBar
        progressBar.visibility = View.VISIBLE

        binding.ButtonVender.isEnabled = false
        binding.ButtonVender.setTextColor(Color.parseColor("#FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaDeLogin()
        },100)
    }

    private fun navegarTelaDeLogin(){
        val intent = Intent(this,loginActivity::class.java)
        startActivity(intent)
        finish()
    }

}



