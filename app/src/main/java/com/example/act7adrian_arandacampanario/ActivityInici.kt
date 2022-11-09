package com.example.act7adrian_arandacampanario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.act7adrian_arandacampanario.databinding.ActivityIniciBinding

class ActivityInici : AppCompatActivity() {
    private lateinit var binding: ActivityIniciBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIniciBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btmEntrar.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("usuari", binding.usuari.text.toString())
            intent.putExtra("password", binding.password.text.toString())
            startActivity(intent)
        }
    }
}