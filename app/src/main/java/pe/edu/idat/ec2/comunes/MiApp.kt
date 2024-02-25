package pe.edu.idat.ec2.comunes

import android.app.Application

class MiApp:Application(){
    companion object{
        lateinit var instance:MiApp
    }
    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}