package pe.edu.idat.ec2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.idat.ec2.databinding.ActivityFormularioBinding


class FormularioActivity : AppCompatActivity(), OnClickListener{


    private lateinit var binding: ActivityFormularioBinding
    private val listaHabilidades = ArrayList<String>()
    private val listaValTrabajo = ArrayList<String>()
    private val listaValPago = ArrayList<String>()
    private val listaCantPresion = ArrayList<String>()
    private val listaOporCrecimiento = ArrayList<String>()
    private val listaCuestionario = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("MensajeInformacion", "Formulario Activity Iniciado")

        binding.btnEnviar.setOnClickListener(this)
        binding.btnListarF.setOnClickListener(this)

        binding.cbAutoconocimiento.setOnClickListener(this)
        binding.cbEmpatia.setOnClickListener(this)
        binding.cbComunicacionA.setOnClickListener(this)
        binding.cbNinguno.setOnClickListener(this)
        binding.cbPensamientoC.setOnClickListener(this)
        binding.cbTomaDecisiones.setOnClickListener(this)
    }

    override fun onClick(vista: View) {
        if (vista is CheckBox){
            agregarQuitarHabilidades(vista)
        }else{
            when(vista.id){
                R.id.btnEnviar->registrarCuestionario()
                R.id.btnListarF -> startActivity(
                    Intent(
                        applicationContext,
                        ListarFormularioActivity::class.java).apply {
                        putExtra("listacuestionario", listaCuestionario)
                    })
            }
        }
    }

    fun registrarCuestionario() {
        if (validarCuestionario()){
            val infoCuestionario =obtenerHabilidades() + "//" + obtenerValTrabajo() + "//" +
                                    obtenerValPago() + "//" + obtenerPresion() + "//" +
                                    obtenerOportunidadC()

            listaCuestionario.add(infoCuestionario)

            Toast.makeText(this, "Registro realizado correctamente", Toast.LENGTH_SHORT).show()

            setearControles()
        }

    }

    fun obtenerHabilidades():String{
        var habilidades= ""
        for (habi in listaHabilidades){
            habilidades += "$habi -"
        }
        return habilidades
    }

    fun obtenerValTrabajo():String{
        var valtrabajo=""
        when(binding.rgTrabajo.checkedRadioButtonId){
            R.id.rbMucho->{
                valtrabajo=binding.rbMucho.text.toString()
            }
            R.id.rbMaso-> {
                valtrabajo = binding.rbMaso.text.toString()
            }
            R.id.rbPoco-> {
                valtrabajo = binding.rbPoco.text.toString()
            }

        }
        return valtrabajo
    }

    fun obtenerValPago():String{
        var ValPago=""
        when(binding.rgPago.checkedRadioButtonId){
            R.id.rbBien->{
                ValPago=binding.rbBien.text.toString()
            }
            R.id.rbRegular-> {
                ValPago = binding.rbRegular.text.toString()
            }
            R.id.rbMal-> {
                ValPago = binding.rbMal.text.toString()
            }

        }
        return ValPago
    }

    fun obtenerPresion():String{
        var Presion=""
        when(binding.rgPresion.checkedRadioButtonId){
            R.id.rbSiPre->{
                Presion=binding.rbSiPre.text.toString()
            }
            R.id.rbNoPre-> {
                Presion = binding.rbNoPre.text.toString()
            }

        }
        return Presion
    }


    fun obtenerOportunidadC():String{
        var OportunidadC=""
        when(binding.rgOpor.checkedRadioButtonId){
            R.id.rbSiOpor->{
                OportunidadC=binding.rbSiOpor.text.toString()
            }
            R.id.rbNoOpor-> {
                OportunidadC = binding.rbNoOpor.text.toString()
            }

        }
        return OportunidadC
    }





    private fun setearControles(){
        binding.rgTrabajo.clearCheck()
        binding.rgPago.clearCheck()
        binding.rgPresion.clearCheck()
        binding.rgOpor.clearCheck()

        binding.cbAutoconocimiento.isChecked=false
        binding.cbPensamientoC.isChecked=false
        binding.cbNinguno.isChecked=false
        binding.cbEmpatia.isChecked=false
        binding.cbTomaDecisiones.isChecked=false
        binding.cbComunicacionA.isChecked=false
    }



    fun validarHabilidades():Boolean{
        var respuesta= false
        if (binding.cbEmpatia.isChecked || binding.cbAutoconocimiento.isChecked ||
            binding.cbNinguno.isChecked || binding.cbPensamientoC.isChecked ||
            binding.cbComunicacionA.isChecked || binding.cbTomaDecisiones.isChecked){
            respuesta=true
        }
        return respuesta
    }


    fun validarValTrabajo():Boolean{
        var respuesta = true
        if(binding.rgTrabajo.checkedRadioButtonId==-1){
            respuesta=false
        }
        return respuesta
    }

    fun validarValPago():Boolean{
        var respuesta = true
        if(binding.rgPago.checkedRadioButtonId==-1){
            respuesta=false
        }
        return respuesta
    }

    fun validarPresion():Boolean{
        var respuesta = true
        if(binding.rgPresion.checkedRadioButtonId==-1){
            respuesta=false
        }
        return respuesta
    }

    fun validarOportunidadC():Boolean{
        var respuesta = true
        if(binding.rgOpor.checkedRadioButtonId==-1){
            respuesta=false
        }
        return respuesta
    }


    fun validarCuestionario():Boolean{
        var respuesta=false
        if (!validarHabilidades()){
            Toast.makeText(this, "Selecciona al menos una habilidad", Toast.LENGTH_SHORT).show()
        }else if (!validarValTrabajo()){
            Toast.makeText(this, "Seleccione al menos un valor", Toast.LENGTH_SHORT).show()
        }else if (!validarValPago()){
            Toast.makeText(this, "Seleccione pago estimado", Toast.LENGTH_SHORT).show()
        }else if (!validarPresion()){
            Toast.makeText(this, "Ingrese si esta bajo presion", Toast.LENGTH_SHORT).show()
        }else if (!validarOportunidadC()){
            Toast.makeText(this, "Ingrese si puede obtener oportunidad de crecimiento", Toast.LENGTH_SHORT).show()
        } else respuesta=true
        return respuesta
    }

    private fun agregarQuitarHabilidades(vista: CheckBox){
        if (vista.isChecked){
            when (vista.id){
                R.id.cbAutoconocimiento->listaHabilidades.add(vista.text.toString())
                R.id.cbEmpatia->listaHabilidades.add(vista.text.toString())
                R.id.cbComunicacionA->listaHabilidades.add(vista.text.toString())
                R.id.cbTomaDecisiones->listaHabilidades.add(vista.text.toString())
                R.id.cbPensamientoC->listaHabilidades.add(vista.text.toString())
                R.id.cbNinguno->listaHabilidades.add(vista.text.toString())
            }
        }else{
            when (vista.id){
                R.id.cbAutoconocimiento->listaHabilidades.remove(vista.text.toString())
                R.id.cbEmpatia->listaHabilidades.remove(vista.text.toString())
                R.id.cbComunicacionA->listaHabilidades.remove(vista.text.toString())
                R.id.cbTomaDecisiones->listaHabilidades.remove(vista.text.toString())
                R.id.cbPensamientoC->listaHabilidades.remove(vista.text.toString())
                R.id.cbNinguno->listaHabilidades.remove(vista.text.toString())
            }
        }
    }


}