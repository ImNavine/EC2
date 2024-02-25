package pe.edu.idat.ec2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.CheckBox
import pe.edu.idat.ec2.comunes.AppMensaje
import pe.edu.idat.ec2.comunes.TipoMensaje
import pe.edu.idat.ec2.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityRegistroBinding
    private var listaCualidades = ArrayList<String>()
    private var listaPersonas= ArrayList<String>()
    private var listaEstadoCivil= ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("MensajeInformacion", "RegistroActivity Iniciado")
        binding.btnacceder.setOnClickListener(this)
        binding.cbotro.setOnClickListener(this)
        binding.cbrespetuoso.setOnClickListener(this)
        binding.cbresponsable.setOnClickListener(this)
        binding.cbpuntual.setOnClickListener(this)
    }

    override fun onClick(vista: View) {
        if (vista is CheckBox){
            agregarQuitarCualidades(vista)
        }else{
            when(vista.id){
                R.id.btnacceder->registrarPersona()
            }
        }
    }

    fun registrarPersona() {
        if (validarFormulario()){
            val infoPersona = binding.etnombre.text.toString() + " " +
                    binding.etapellidos.text.toString() + " " +
                    binding.etdni.text.toString() + " " +
                    binding.etcelular.text.toString() + " " +
                    binding.etemail.text.toString() + " " +
                    obtenerCualidades() + " " +
                    binding.etcualidad.toString() + " " +
                    obtenerEstadoCivil()
            listaPersonas.add(infoPersona)
            AppMensaje.enviarMensaje(
                binding.root,
                getString(R.string.mensajeRegistroCorrecto),
                TipoMensaje.SUCCESSFULL
            )

            setearControles()
        }

    }

    private fun obtenerCualidades():String{
        var cualidades= ""
        for (cuali in listaCualidades){
            cualidades += "$cuali"
        }
        return cualidades
    }

    fun obtenerEstadoCivil():String{
        var estadocivil=""
        for(est in listaEstadoCivil){
            estadocivil+= "$est "
        }
        return estadocivil
    }

    private fun setearControles(){
        listaEstadoCivil.clear()
        listaCualidades.clear()
        binding.etnombre.setText("")
        binding.etapellidos.setText("")
        binding.etdni.setText("")
        binding.etcelular.setText("")
        binding.etemail.setText("")
        binding.cbpuntual.isChecked=false
        binding.cbrespetuoso.isChecked=false
        binding.cbresponsable.isChecked=false
        binding.cbotro.isChecked=false
        binding.etcualidad.setText("")
        binding.rgestadocivil.clearCheck()
        binding.etnombre.isFocusableInTouchMode=true
        binding.etnombre.requestFocus()
    }

    fun validarPersona():Boolean{
        var respuesta=true
        if (binding.etnombre.text.toString().trim().isEmpty()){
            binding.etnombre.isFocusableInTouchMode=true
            binding.etnombre.requestFocus()
            respuesta=false
        }else if (binding.etapellidos.text.toString().trim().isEmpty()){
            binding.etapellidos.isFocusableInTouchMode=true
            binding.etapellidos.requestFocus()
            respuesta=false
        }else if (binding.etdni.text.toString().trim().isEmpty()){
            binding.etdni.isFocusableInTouchMode=true
            binding.etdni.requestFocus()
            respuesta=false
        }else if (binding.etcelular.text.toString().trim().isEmpty()) {
            binding.etcelular.isFocusableInTouchMode = true
            binding.etcelular.requestFocus()
            respuesta = false
        }else if (binding.etemail.text.toString().trim().isEmpty()) {
            binding.etemail.isFocusableInTouchMode = true
            binding.etemail.requestFocus()
            respuesta = false
        }else if (binding.etcualidad.text.toString().trim().isEmpty()) {
            binding.etcualidad.isFocusableInTouchMode = true
            binding.etcualidad.requestFocus()
            respuesta = false
        }
        return respuesta
    }

    fun validarCualidades():Boolean{
        var respuesta= false
        if (binding.cbpuntual.isChecked || binding.cbrespetuoso.isChecked ||
            binding.cbresponsable.isChecked || binding.cbotro.isChecked){
            respuesta=true
        }
        return respuesta
    }

    fun validarEstadiCivil():Boolean{
        var respuesta = true
        if(binding.rgestadocivil.checkedRadioButtonId==-1){
            respuesta=false
        }
        return respuesta
    }
    fun validarFormulario():Boolean{
        var respuesta=false
        if (!validarPersona()){
            AppMensaje.enviarMensaje(binding.root, "Ingrese sus datos", TipoMensaje.ERROR)
        }else if (!validarCualidades()){
            AppMensaje.enviarMensaje(binding.root, "Seleccione al menos una cualidad", TipoMensaje.ERROR)
        }else if (!validarEstadiCivil()){
            AppMensaje.enviarMensaje(binding.root, "Seleccione su estado civil", TipoMensaje.ERROR)
        } else respuesta=true
        return respuesta
    }

    private fun agregarQuitarCualidades(vista: CheckBox){
        if (vista.isChecked){
            when (vista.id){
                R.id.cbpuntual->listaCualidades.add(vista.text.toString())
                R.id.cbrespetuoso->listaCualidades.add(vista.text.toString())
                R.id.cbrespetuoso->listaCualidades.add(vista.text.toString())
                R.id.cbotro->listaCualidades.add(vista.text.toString())
            }
        }else{
            when (vista.id){
                R.id.cbpuntual->listaCualidades.remove(vista.text.toString())
                R.id.cbrespetuoso->listaCualidades.remove(vista.text.toString())
                R.id.cbrespetuoso->listaCualidades.remove(vista.text.toString())
                R.id.cbotro->listaCualidades.remove(vista.text.toString())
            }
        }
    }


}