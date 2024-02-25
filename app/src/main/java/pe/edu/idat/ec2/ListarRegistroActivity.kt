package pe.edu.idat.ec2

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import pe.edu.idat.ec2.databinding.ActivityListarRegistroBinding

class ListarRegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListarRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListarRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPersonas=intent.getSerializableExtra("listapersonas") as ArrayList<String>

        val adapter = ArrayAdapter(applicationContext, R.layout.simple_list_item_1, listaPersonas )

        binding.lvpersonas.adapter=adapter
    }
}