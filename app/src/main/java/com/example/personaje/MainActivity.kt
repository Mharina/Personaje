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

        val spinnerRaza: Spinner = findViewById(R.id.spinnerRaza)
        val spinnerClase: Spinner = findViewById(R.id.spinnerClase)
        val foto: ImageView = findViewById(R.id.imageView)

        val opcionesRaza: Array<String> = resources.getStringArray(R.array.raza)
        val opcionesClase: Array<String> = resources.getStringArray(R.array.clase)

        val adapterRaza: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesRaza)
        spinnerRaza.adapter = adapterRaza
        val adapterClase: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesClase)
        spinnerClase.adapter = adapterClase

        spinnerRaza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionRaza: String = parent?.getItemAtPosition(position) as String
                val seleccionClase: String = spinnerClase.selectedItem as String
                val imagenResId: String = obtenerImagen(seleccionRaza, seleccionClase)

            }
            fun obtenerImagen(seleccionRaza: String, seleccionClase: String): String {
                var foto:String
                foto=""
                when (seleccionRaza){
                    "Humano" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto="@drawable/humanomago"
                            }
                            "Brujo" -> {
                                foto="@drawable/humanobrujo"
                            }
                            "Guerrero" -> {
                                foto="@drawable/humanoguerrero"
                            }
                        }
                    }
                    "Elfo" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto="@drawable/elfomago.jpg"
                            }
                            "Brujo" -> {
                                foto="@drawable/elfobrujo.jpg"
                            }
                            "Guerrero" -> {
                                foto="@drawable/elfoguerrero.jpg"
                            }
                        }
                    }
                    "Enano" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto="@drawable/enanomago.jpg"
                            }
                            "Brujo" -> {
                                foto="@drawable/enanobrujo.jpg"
                            }
                            "Guerrero" -> {
                                foto="@drawable/enanoguerrero.jpg"
                            }
                        }
                    }
                    "Maldito" -> {
                        when (seleccionClase) {
                            "Mago" -> {
                                foto="@drawable/malditomago.jpg"
                            }
                            "Brujo" -> {
                                foto="@drawable/malditobrujo.jpg"
                            }
                            "Guerrero" -> {
                                foto="@drawable/malditoguerrero.jpg"
                            }
                        }
                    }
                }

                return foto
            }
        }

        //sC.onItemSelectedListener = object


    }

}