package com.kaylr.chat.videogamesAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaylr.chat.databinding.ActivityVideogamesMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideogamesMainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
        const val MY_TOKEN = "bb19e1f42e3b48ed9b4be59e0aad0b17" //API KEY rawg
    }
    private lateinit var binding: ActivityVideogamesMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: VideogamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideogamesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchViewVideogames.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = VideogamesAdapter(emptyList())
        /*animalsId -> navigateToDetail(animalsId)*/
        binding.rvVideogames.setHasFixedSize(true)
        binding.rvVideogames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvVideogames.adapter = adapter
    }

    private fun searchByName(query: String) {
        binding.progressBarVideogames.isVisible = true

        //.IO es para hilos secundarios
        //.MAIN es para el hilo principal
        CoroutineScope(Dispatchers.IO).launch {
            //usamos corrutinas para que use otro hilo y que no se atasque el programa principal
            val myResponse: Response<VideogamesDataResponse> =
                retrofit.create(ApiService::class.java).getVideogames(query)
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
                val response: VideogamesDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.videogames)
                        binding.progressBarVideogames.isVisible = false
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
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}