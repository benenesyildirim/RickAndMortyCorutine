package com.rickmorty.corutine.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.rickmorty.corutine.CharacterListAdapter
import com.rickmorty.corutine.api.RetrofitController
import com.rickmorty.corutine.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        lifecycleScope.launch(Dispatchers.IO) {
            val response = RetrofitController.getRetrofit().getCharacters()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    binding.characterListRv.adapter =
                        CharacterListAdapter(response.body()!!.results, this@MainActivity) {
                            val intent =
                                Intent(this@MainActivity, CharacterDetailActivity::class.java)
                            intent.putExtra("characterDetail",Gson().toJson(it))
                            this@MainActivity.startActivity(intent)
                        }
                    delay(3000L)
                    binding.rickLoadingGif.visibility = GONE
                }
            }
        }
    }
}