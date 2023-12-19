package com.kaylr.chat.animalesAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaylr.chat.R
import com.kaylr.chat.databinding.ActivityAnimalesMainBinding
import com.kaylr.chat.databinding.ActivitySuperHeroBinding
import com.kaylr.chat.superHeroApp.ApiService
import com.kaylr.chat.superHeroApp.SuperHeroActivity
import com.kaylr.chat.superHeroApp.SuperHeroAdapter
import com.kaylr.chat.superHeroApp.SuperHeroDataResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimalesMainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
        const val MY_TOKEN = "w6m3yoEbDzJw4VFIuRbD/w==iaxKrWOXbIG4g3Mu"
    }
    private lateinit var binding: ActivityAnimalesMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?) = false
        })
        //adapter = AnimalsAdapter{animalsId -> navigateToDetail(animalsId)}
        binding.rvAnimals.setHasFixedSize(true)
        binding.rvAnimals.layoutManager = LinearLayoutManager(this)
        binding.rvAnimals.adapter = adapter
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true

        //.IO es para hilos secundarios
        //.MAIN es para el hilo principal
        CoroutineScope(Dispatchers.IO).launch {
            //usamos corrutinas para que use otro hilo y que no se atasque el programa principal
            val myResponse: Response<AnimalsDataResponse> =
                retrofit.create(ApiService::class.java).getAnimals(query)
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
                val response: AnimalsDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.animals)
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("Consulta", "No funciona :(")
            }


        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.api-ninjas.com/v1/animals?/${AnimalesMainActivity.MY_TOKEN}/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}