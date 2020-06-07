package org.senac.conversortemperatura_f_p_c

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    private lateinit var editText : EditText
    private lateinit var rButtonCelsios : RadioButton
    private lateinit var rButtonFahrenheit : RadioButton
    private lateinit var bConverterValor : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.eTextTemperatura) as EditText

        rButtonCelsios = findViewById<RadioButton>(R.id.rButtonCelsios) as RadioButton
        rButtonFahrenheit = findViewById<RadioButton>(R.id.rButtonFahrenheit) as RadioButton

        bConverterValor = findViewById<Button>(R.id.bConverterValor) as Button

        bConverterValor.setOnClickListener{convercao(it)}
    }

    private fun convercao(
        view: View
    ) {
        if (validador()) {
            var temp: Double = editText.text.toString().toDouble()

            if (rButtonCelsios.isChecked) {
                temp = (temp - 32) * 1.8
            } else if(rButtonFahrenheit.isChecked) {
                temp = temp * 1.8 + 32
            }
            editText.setText(temp.toString())

            var alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
                alertDialogBuilder.setTitle(" Seu Resultado : ")
                alertDialogBuilder.setMessage(" Sua Temperatura Convertida é :${bConverterValor}")
                alertDialogBuilder.setNeutralButton("Ok") { _, _->}

                alertDialogBuilder.create().show()
        }
    }

    private fun validador() : Boolean{
        var validador = true

        if (editText.text.trim().isEmpty()){
            editText.setError(" Você deve informar a temperatura")
            validador= false
        }

        return validador
    }
}