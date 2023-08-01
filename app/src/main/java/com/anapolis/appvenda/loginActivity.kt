package com.anapolis.appvenda;

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anapolis.appvenda.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class loginActivity :   AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        window.statusBarColor= Color.parseColor("#FFFFFF")

            binding.btEntrar.setOnClickListener {

                val telefone = binding.editTelefone.text.toString()
                val senha = binding.editSenha.text.toString()

                when{
                    telefone.isEmpty() -> {
                        binding.editTelefone.error = "Preencha o Telefone!"
                    }
                    senha.isEmpty() -> {
                        binding.editSenha.error = "Preencha a Senha!"
                    }
                    telefone.length <= 10 -> {
                        val snackbar = Snackbar.make(it,"O telefone precisa ter 11 digitos!",Snackbar.LENGTH_SHORT)
                        snackbar.show()
                    }
                    senha.length <= 5 -> {
                        val snackbar = Snackbar.make(it,"A senha precisa ter pelo menos 6 caracteres",Snackbar.LENGTH_SHORT)
                        snackbar.show()
                    }
                    else -> {
                        login(it)
                    }
            }
        }

            binding.btCadastrar.setOnClickListener{
                telaDeCadastro(it)
            }


    }
    private fun login(view: View){

        val progressBar = binding.progressBar
        progressBar.visibility = View.VISIBLE

        binding.btEntrar.isEnabled = false
        binding.btEntrar.setTextColor(Color.parseColor("#FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaPrincipal()
            val snackbar = Snackbar.make(view,"Login efetuado com sucesso!", Snackbar.LENGTH_SHORT)
            snackbar.show()
        },3000)
    }
    private fun navegarTelaPrincipal(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun telaDeCadastro(view: View){

        val progressBar = binding.progressBar
        progressBar.visibility = View.VISIBLE

        binding.btCadastrar.isEnabled = false
        binding.btCadastrar.setTextColor(Color.parseColor("#FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaDeCadastro()
        },500)
    }
    private fun navegarTelaDeCadastro() {
        val intent = Intent(this,cadastroActivity::class.java)
        startActivity(intent)
        finish()
    }
}