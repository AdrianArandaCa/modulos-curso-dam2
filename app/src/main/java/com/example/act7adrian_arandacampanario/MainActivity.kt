package com.example.act7adrian_arandacampanario

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.act7adrian_arandacampanario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val usuari = intent.getStringExtra("usuari").toString()
        val password = intent.getStringExtra("password").toString()

        if(!password.equals("a") || usuari.equals("")){
            if(usuari.equals(""))
            Toast.makeText(this,"L'usuari no pot estar buit",Toast.LENGTH_SHORT).show()
            else if(!password.equals("1234")){
                Toast.makeText(this,"Contrasenya incorrecte",Toast.LENGTH_SHORT).show()
            }
            finish()
        }

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Toast.makeText(this,"Enviar email", Toast.LENGTH_SHORT).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.fM6uf1, R.id.fM6uf2,R.id.fM6uf3,R.id.fM6uf4,R.id.fM7uf1,R.id.fM7uf2,R.id.fM8uf1,R.id.fM8uf2,R.id.fM8uf3
                ,R.id.fM9uf1,R.id.fM9uf2,R.id.fM9uf3,R.id.fM10uf1,R.id.fM10uf2,R.id.fM13uf1
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val header = navView.getHeaderView(0)
        val img = header.findViewById<ImageView>(R.id.imageView)
        val text = header.findViewById<TextView>(R.id.textView)
        text.setText(usuari)
        Glide.with(this)
            .load("https://aecarlesvallbona.cat/wp-content/uploads/2015/12/logo-horitzontal.gif")
            .into(img)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.moodle -> linkUrl("https://moodle.iescarlesvallbona.cat/login/index.php")
            R.id.email -> emailUrl()

        }
        return super.onOptionsItemSelected(item)
    }

    fun emailUrl(){
        val intent = Intent(Intent.ACTION_SENDTO).apply{
            data = Uri.parse("mailto:")
        }
        if(intent.resolveActivity(packageManager)!=null){
            startActivity(intent)
        }
    }

    fun linkUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}