package pe.edu.idat.ec2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import pe.edu.idat.ec2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("MensajeInfo", "App EC2 Inicializada")
        binding.btnform.setOnClickListener(this)
        binding.btnlist.setOnClickListener(this)
        binding.btnreg.setOnClickListener(this)
    }

    override fun onClick(vista: View) {
        when(vista.id){
            R.id.btnform -> startActivity(Intent(applicationContext, FormularioActivity::class.java))
            R.id.btnreg -> startActivity(Intent(applicationContext, RegistroActivity::class.java))
            R.id.btnlist -> startActivity(Intent(applicationContext, ListadoActivity::class.java))
        }
    }
}