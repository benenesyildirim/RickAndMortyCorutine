package com.rickmorty.coroutine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rickmorty.coroutine.CharacterListAdapter.ViewHolder
import com.rickmorty.corutine.R
import com.rickmorty.corutine.databinding.CharactersListDesignBinding
import com.rickmorty.coroutine.models.CharacterModel

class CharacterListAdapter(
    private val characters: List<CharacterModel>, val listener: (CharacterModel) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharactersListDesignBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(characters[position])

    override fun getItemCount(): Int = characters.size

    inner class ViewHolder(private val binding: CharactersListDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterModel) {
            binding.character = character
            binding.executePendingBindings()

            setCharacterImage(character)

            binding.root.setOnClickListener { listener(character) }
        }

        private fun setCharacterImage(character: CharacterModel) {
            Glide.with(itemView)
                .load(character.image)
                .placeholder(R.drawable.coming_soon)
                .circleCrop()
                .into(binding.characterImage)
        }
    }
}