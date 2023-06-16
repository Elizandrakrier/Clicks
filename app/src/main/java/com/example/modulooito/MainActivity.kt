package com.example.modulooito

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import com.example.modulooito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var numClicks = 0

        val textoEditado: TextView = binding.txtNameEdit
        textoEditado.text = ""

        val botaoClick: Button = binding.btnTrocarImagem

        val nameEdited: EditText = binding.iptNameUser

        val tela: ImageView = binding.imgSelection

        botaoClick.setOnClickListener {
            textoEditado.text = "Nome: Click: $numClicks"

            tela.background = getDrawable(R.drawable.laranja)

            numClicks++

            when {
                numClicks % 3 == 0 -> tela.background = getDrawable(R.drawable.laranja)
                numClicks % 2 == 0 -> tela.background = getDrawable(R.drawable.maca)
                else -> tela.background = null
            }
        }

        nameEdited.addTextChangedListener {
            textoEditado.text = it.toString()
        }
    }
}