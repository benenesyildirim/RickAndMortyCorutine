package com.rickmorty.coroutine.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.rickmorty.corutine.R
import com.rickmorty.corutine.databinding.ActivityCharacterDetailBinding
import com.rickmorty.coroutine.models.CharacterModel

class CharacterDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterDetailBinding
    private lateinit var character: CharacterModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        bindCharacter()
        setCharacterImage()
    }

    private fun bindCharacter() {
        val characterJson = intent.getStringExtra("characterDetail")
        character = Gson().fromJson(characterJson, CharacterModel::class.java)
        binding.character = character
    }

    private fun setCharacterImage() {
        Glide.with(binding.characterImageDetail)
            .load(character.image)
            .placeholder(R.drawable.coming_soon)
            .circleCrop()
            .into(binding.characterImageDetail)
    }
}