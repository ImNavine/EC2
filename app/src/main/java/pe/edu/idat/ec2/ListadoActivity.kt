package pe.edu.idat.ec2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.ec2.databinding.ActivityListadoBinding
import pe.edu.idat.ec2.databinding.ItemListaBinding

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvlista.layoutManager = LinearLayoutManager(
            applicationContext)
        binding.rvlista.adapter = AdapterLista(listado())

    }
    private fun listado(): List<String>{
        val lista = ArrayList<String>()
        var i = 1
        while (i < 2){
            lista.add("GRUPO 5 \n El querido Grupo 5 dará un concierto \n 26/02/2024 ")
            i++
        }
        while (i < 3){
            lista.add("HABLANDO HUEVADAS CHILE  \n El show de HABLANDO HUEVADAS se dará en chile \n 27/02/2024")
            i++
        }
        while (i < 4){
            lista.add("FRANCO ESCAMILLA EN PERÚ \nEl popular comediante FRANCO ESCAMILLA actuará en el teatro canout\n 28/02/2024")
            i++
        }
        while (i < 5){
            lista.add("ESTUDIO DE PYTHON FREE \n Clases de PYTHON gratis \n 29/02/2024 ")
            i++
        }
        while (i < 6){
            lista.add("FRANCO ESCAMILLA SHOW 1995 \n Se dará en el teatro canout\n 01/03/2024 ")
            i++
        }
        while (i < 7){
            lista.add("Tribujo a BRUNO MARS\n Se dará en Argentina \n 02/03/2024 ")
            i++
        }
        while (i < 8){
            lista.add("CHAPA TU MONEY HH\n Ricardo Mendoza y jorge Luna Chapa tu Money\n 02/03/2024 ")
            i++
        }
        while (i < 9){
            lista.add("PXNDX EN LIMA\n PXNDX SE PRESENTARÁ EN EL ESTADIO NACIONAL\n 03/03/2024 ")
            i++
        }
        while (i < 10){
            lista.add("LIKIN PARK\n LIKIN PARK SE PRESENTARÁ EN EL ESTADIO NACIONAL\n 04/03/2024 ")
            i++
        }
        while (i < 11){
            lista.add("EVENTO DE COSPLAY EN CHILE\n PARTICIPA POR UN CARRO 0KILOMENTROS\n 05/03/2024 ")
            i++
        }
        while (i < 12){
            lista.add("COLAPSO, EL REENCUENTRO DE CAMILO Y ARIANA\n TRÁS VOLVER A HABLAR.... HABRÁ SURGIDO EL AMOR DENUEVO¿\n 05/03/2024 ")
            i++
        }

        return lista
    }

}