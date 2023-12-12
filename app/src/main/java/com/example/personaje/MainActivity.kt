package com.example.personaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spinnerRaza: Spinner = findViewById(R.id.spinnerRaza)
        var spinnerClase: Spinner = findViewById(R.id.spinnerClase)
        var foto: ImageView = findViewById(R.id.imageView)

        var opcionesRaza: Array<String> = resources.getStringArray(R.array.raza)
        var opcionesClase: Array<String> = resources.getStringArray(R.array.clase)

        var adapterRaza: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesRaza)
        spinnerRaza.adapter = adapterRaza
        var adapterClase: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesClase)
        spinnerClase.adapter = adapterClase

        spinnerRaza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var seleccionRaza: String = parent?.getItemAtPosition(position) as String
                var seleccionClase: String = spinnerClase.selectedItem as String
                obtenerImagen(foto,seleccionRaza,seleccionClase)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
            private fun obtenerImagen(foto: ImageView, seleccionRaza: String, seleccionClase: String) {

                when (seleccionRaza){
                    "Humano" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto.setImageResource(R.drawable.humanomago)
                            }
                            "Brujo" -> {
                                foto.setImageResource(R.drawable.humanobrujo)
                            }
                            "Guerrero" -> {
                                foto.setImageResource(R.drawable.humanoguerrero)
                            }
                        }
                    }
                    "Elfo" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto.setImageResource(R.drawable.elfomago)
                            }
                            "Brujo" -> {
                                foto.setImageResource(R.drawable.elfobrujo)
                            }
                            "Guerrero" -> {
                                foto.setImageResource(R.drawable.elfoguerrero)
                            }
                        }
                    }
                    "Enano" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto.setImageResource(R.drawable.enanomago)
                            }
                            "Brujo" -> {
                                foto.setImageResource(R.drawable.enanobrujo)
                            }
                            "Guerrero" -> {
                                foto.setImageResource(R.drawable.enanoguerrero)
                            }
                        }
                    }
                    "Maldito" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto.setImageResource(R.drawable.malditomago)
                            }
                            "Brujo" -> {
                                foto.setImageResource(R.drawable.malditobrujo)
                            }
                            "Guerrero" -> {
                                foto.setImageResource(R.drawable.malditoguerrero)
                            }
                        }
                    }
                }

            }
}

        //sC.onItemSelectedListener = object




