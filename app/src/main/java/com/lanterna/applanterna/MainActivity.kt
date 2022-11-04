package com.lanterna.applanterna

import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.lanterna.applanterna.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var estado = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.lanternaDesligada.setOnClickListener {
            if (!estado){
                binding.lanternaDesligada.setImageResource(R.drawable.ic_lanterna_ligada)
                estado = true
                luzLanterna(estado)
            } else{
                binding.lanternaDesligada.setImageResource(R.drawable.ic_lanterna_desligada)
                estado = false
                luzLanterna(estado)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun luzLanterna(estado: Boolean){
     val cameraManager: CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
     val cameraId: String?

     try {
         cameraId = cameraManager.cameraIdList[0]
         cameraManager.setTorchMode(cameraId, estado)
     }catch (e: Exception){
     }
    }
}