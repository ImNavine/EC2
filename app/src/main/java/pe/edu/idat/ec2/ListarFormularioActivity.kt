package pe.edu.idat.ec2

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import pe.edu.idat.ec2.databinding.ActivityListarFormularioBinding

class ListarFormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListarFormularioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListarFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaCuestionario=intent.getSerializableExtra("listacuestionario") as ArrayList<String>

        val adapter = ArrayAdapter(applicationContext, R.layout.simple_list_item_1, listaCuestionario )

        binding.lvpersonasF.adapter=adapter
    }
}