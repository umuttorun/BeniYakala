package com.umut.beniyakala

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.umut.beniyakala.databinding.ActivityMain2Binding
import com.umut.beniyakala.databinding.ActivityMainBinding
import kotlinx.coroutines.Runnable
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextUInt
import kotlin.reflect.KMutableProperty0
import kotlin.Int.Companion as Int1

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    var score = 0
   val fotoArray= ArrayList<ImageView>()
    var runnable = Runnable {  }
    var handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        fotoArray.add(binding.f1)
        fotoArray.add(binding.f2)
        fotoArray.add(binding.f3)
        fotoArray.add(binding.f4)
        fotoArray.add(binding.f5)
        fotoArray.add(binding.f6)
        fotoArray.add(binding.f7)
        fotoArray.add(binding.f8)
        fotoArray.add(binding.f9)


        gizliResim()
       object : CountDownTimer(20500, 1000){
           override fun onTick(p0: Long) {
binding.zaman.text= "ZAMAN: ${p0/1000}"
           }

           override fun onFinish() {

               handler.removeCallbacks(runnable)
               for(foto in fotoArray){
                   foto.visibility = View.INVISIBLE
               }
               val bildirim = AlertDialog.Builder(this@MainActivity2)
               bildirim.setTitle("OYUN BİTTİ DELİKANLI")
               bildirim.setMessage("güzel denemeydi ama yine de arkadaşından az yakaladın yine oynamak ister misin? O zaman şu soruya cevap ver en güzel şehir neresidir?")
               bildirim.setPositiveButton("BAYBURT",{dialogInterface,i->
                   val intentFromMain = intent
                   finish()
                   startActivity(intentFromMain) })


               bildirim.setNegativeButton("HERHANGİ BİR ŞEHİR",{dialogInterface,i->})
               Toast.makeText(this@MainActivity2,"BİLEMEDİN DEFOL", Toast.LENGTH_SHORT).show()
bildirim.show()
           }

       } .start()

    }
    fun puan(view: View){
        score = score +1
        binding.skor.text = "SKOR : ${score}"
    }

    fun gizliResim() {

        runnable = object : Runnable {
            override fun run() {
                for (image in fotoArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random
                val randomIndex = random.nextInt(9)
                fotoArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }

        handler.post(runnable)

    }

}
