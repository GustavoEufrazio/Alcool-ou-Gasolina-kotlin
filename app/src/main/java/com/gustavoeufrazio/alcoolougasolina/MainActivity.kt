package com.gustavoeufrazio.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    val txt_resultado = findViewById<View>(R.id.txt_resultado) as TextView
    fun btCalcular(view: View){
        //recupera os valores
        //val precoAlcool = findViewById<View>(R.id.edit_preco_alcool) as EditText
        //depois do plugin
        val precoAlcool = findViewById<View>(R.id.edit_preco_alcool) as EditText
        val precoGasolina = findViewById<View>(R.id.edit_preco_gasolina) as EditText

        val validaCampos = validarCampos(precoAlcool.text.toString(), precoGasolina.text.toString())
        if(validaCampos){
            calcularMelhorPreco(precoAlcool.text.toString(),precoGasolina.text.toString());
        }else{
            txt_resultado.setText("Preencha os preços primeiro!")
        }

    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){
        val valorAlcool = precoAlcool.toDouble();
        val valorGasolina = precoGasolina.toDouble()
        //acima convertemos os valores de string para double

        val resultadoPreco = valorAlcool / valorGasolina;

        if(resultadoPreco >= 0.7){
            txt_resultado.setText("Melhor utilizar a Gasolina")
        }else{
            txt_resultado.setText("Melhor utilizar o alcool")
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean{
        var camposValidados: Boolean = true

        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if(precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados;
    }
}