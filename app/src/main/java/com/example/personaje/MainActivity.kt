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
        var spinnerEstadoVital: Spinner = findViewById(R.id.spinnerEstadoVital)
        var foto: ImageView = findViewById(R.id.imageView)

        var opcionesRaza: Array<String> = resources.getStringArray(R.array.raza)
        var opcionesClase: Array<String> = resources.getStringArray(R.array.clase)
        var opcionesEstadoVital: Array<String> = resources.getStringArray(R.array.estadoVital)

        var adapterRaza: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesRaza)
        spinnerRaza.adapter = adapterRaza
        var adapterClase: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesClase)
        spinnerClase.adapter = adapterClase
        var adapterEstadoVital: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesEstadoVital)
        spinnerEstadoVital.adapter = adapterEstadoVital

        spinnerRaza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var seleccionRaza: String = parent?.getItemAtPosition(position) as String
                var seleccionClase: String = spinnerClase.selectedItem as String
                //var seleccionEstadoVital: String = spinnerEstadoVital.selectedItem as String
                obtenerImagen(foto, seleccionRaza, seleccionClase)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spinnerClase.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var seleccionClase: String = parent?.getItemAtPosition(position) as String
                var seleccionRaza: String = spinnerRaza.selectedItem as String
                //var seleccionEstadoVital: String = spinnerEstadoVital.selectedItem as String
                obtenerImagen(foto, seleccionRaza, seleccionClase)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spinnerEstadoVital.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var seleccionEstadoVital: String = parent?.getItemAtPosition(position) as String
                var seleccionRaza: String = spinnerRaza.selectedItem as String
                var seleccionClase: String = spinnerClase.selectedItem as String
                obtenerImagen3(foto, seleccionRaza, seleccionClase, seleccionEstadoVital)
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
                        foto.setImageResource(R.drawable.humanomagoanciano)
                    }
                    "Brujo" -> {
                        foto.setImageResource(R.drawable.humanobrujoadulto)
                    }
                    "Guerrero" -> {
                        foto.setImageResource(R.drawable.humanoguerreroadulto)
                    }
                }
            }
            "Elfo" -> {
                when (seleccionClase) {
                    "Mago" -> {
                        foto.setImageResource(R.drawable.elfomagoadulto)
                    }
                    "Brujo" -> {
                        foto.setImageResource(R.drawable.elfobrujoadulto)
                    }
                    "Guerrero" -> {
                        foto.setImageResource(R.drawable.elfoguerreroadulto)
                    }
                }
            }
            "Enano" -> {
                when (seleccionClase) {
                    "Mago" -> {
                        foto.setImageResource(R.drawable.enanomagoanciano)
                    }
                    "Brujo" -> {
                        foto.setImageResource(R.drawable.enanobrujoanciano)
                    }
                    "Guerrero" -> {
                        foto.setImageResource(R.drawable.enanoguerreroadulto)
                    }
                }
            }
            "Maldito" -> {
                when (seleccionClase) {
                    "Mago" -> {
                        foto.setImageResource(R.drawable.malditomagoanciano)
                    }
                    "Brujo" -> {
                        foto.setImageResource(R.drawable.malditobrujoadulto)
                    }
                    "Guerrero" -> {
                        foto.setImageResource(R.drawable.malditoguerreroadulto)
                    }
                }
            }
        }

    }
    private fun obtenerImagen3(
        foto: ImageView,
        seleccionRaza: String,
        seleccionClase: String,
        seleccionEstadoVital: String
    ) {

        when (seleccionRaza) {
            "Humano" -> {
                when (seleccionClase) {
                    "Mago" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.humanomagoanciano)
                            }
                        }
                    }

                    "Brujo" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.humanobrujoadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }
                        }
                    }

                    "Guerrero" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.humanoguerreroadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }
                        }
                    }
                }
            }

            "Elfo" -> {
                when (seleccionClase) {
                    "Mago" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.elfoadolescentemago)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.elfomagoadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.elfomagoanciano)
                            }
                        }
                    }

                    "Brujo" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.elfobrujoadolescente2)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.elfobrujoadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.elfobrujoanciano)
                            }
                        }
                    }

                    "Guerrero" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.elfoguerreroadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.elfoguerreroanciano)
                            }
                        }
                    }
                }
            }

            "Enano" -> {
                when (seleccionClase) {
                    "Mago" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.enanomagoadolescente2)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.enanomagoanciano)
                            }
                        }
                    }

                    "Brujo" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.enanobrujoadolescente)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.enanobrujoanciano)
                            }
                        }
                    }

                    "Guerrero" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.enanoguerreroadolescente)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.enanoguerreroadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }
                        }
                    }
                }
            }

            "Maldito" -> {
                when (seleccionClase) {
                    "Mago" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.malditomagoadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.malditomagoanciano)
                            }
                        }
                    }

                    "Brujo" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.malditobrujoadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }
                        }
                    }

                    "Guerrero" -> {
                        when (seleccionEstadoVital) {
                            "Adolescente" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }

                            "Adulto" -> {
                                foto.setImageResource(R.drawable.malditoguerreroadulto)
                            }

                            "Anciano" -> {
                                foto.setImageResource(R.drawable.comodin)
                            }
                        }
                    }
                }
            }

        }
    }
}

        //sC.onItemSelectedListener = object




